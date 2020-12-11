<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib  prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
              integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    </head>
    <body>
        <div id="container mt-4">
            <h2 class="text-center">Sensores Enviados</h2>

            <table class="table table-dark" id="tabla">
                <tr class="bg-danger">
                    <th>id</th>
                    <th>marca</th>
                    <th>humedad</th>
                    <th>temperatura</th>
                </tr>              
            </table>
        </div>

        <script>
            /**
             * Metodo que imprime los datos de un objeto Json
             * Enviado por metodo post
             * */
            var data = {
                sensores:${json}
            };
            var jsonPretty = JSON.stringify(data, null, 2);

            const table = document.querySelector('table');

            for (const sensor of data.sensores) {
                const row = table.insertRow();
                for (const value of Object.values(sensor)) {
                    const cell = row.insertCell();
                    cell.innerHTML = value;
                }
            }
        </script>
        <style>
            table tr {
                text-align: center;  
            }
        </style>
        <a href="http://localhost:8080/Sistema_de_Monitoreo_de_Invernadero_Sensores/Controlador?accion=listar" type="button" class="btn btn-secondary">Atras</a>      

    </body>
</html>
