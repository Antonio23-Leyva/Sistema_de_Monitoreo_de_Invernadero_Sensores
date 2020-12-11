<%@page import="com.sensores.modelo.Sensor"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.sensores.config.Conexion"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Date"%>
<%@page import="com.sensores.controlador.Controlador" %>
<%@page import="com.sensores.modeloDAO.SensorDAO" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comportamiento de medidas (humedad y temperatura)</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
              integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    </head>
    <body>
        <div class="container my-4">
            <div class="col-md-6 mb-4">
                <h1></h1>

                <h4 class="my-4 h4 secondary-heading">Seleccionar fecha</h4>
                <select name="fechas" class="custom-select">
                    <%                String consulta = "SELECT * FROM sensores.sensor";
                        try {
                            PreparedStatement qe = Conexion.Conectar().prepareCall(consulta);
                            ResultSet de = qe.executeQuery();

                            while (de.next()) {
                                out.println("<option>" + de.getDate(7) + "</option>");
                            }
                        } catch (SQLException e) {
                            System.out.println("Error en enviar " + e);
                        }
                    %>
                </select>
                <hr>
                <div class="input-group-append" id="button-addon4">
                    <input type="submit" value="seleccionar" name="inpFecha" class="btn btn-success">
                </div>
                <hr>
                <a href="http://localhost:8080/Sistema_de_Monitoreo_de_Invernadero_Sensores/" type="button" class="btn btn-secondary" >Atras</a>      
                <button onclick="graficaParametros()" type="button" class="btn btn-primary" >Graficar datos</button>      
            </div>  
        </div>
        <canvas id="myChart" width="200" height="100"></canvas>
        <script>
            
             async function graficaParametros() {
                var ctx = document.getElementById('myChart').getContext('2d');
                var myChart = new Chart(ctx, {
                    type: 'bar',
                    data: {
                        labels: ['Temperatura', 'Humedad'],
                        datasets: [{
                                label: 'Comportamiento de humedad y temperatura',
                                data: [12, 19],
                                backgroundColor: [
                                    '#FF5733',
                                    '#008080'
                                ],
                                borderWidth: 1
                            }]
                    },
                    options: {
                        scales: {
                            yAxes: [{
                                    ticks: {
                                        beginAtZero: true
                                    }
                                }]
                        }
                    }
                });
            }

        </script>

        <script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"></script>
        <style>
                body{
                background-color:#1F618D;
                }
        </style>
    </body>
</html>
