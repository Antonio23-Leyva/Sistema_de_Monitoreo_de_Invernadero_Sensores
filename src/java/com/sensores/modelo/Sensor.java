package com.sensores.modelo;


import javax.persistence.*;
import java.sql.Date;
public class Sensor {

    private int id;
    private String nombre;
    private String modelo;
    private String descripcion;
    private String humedad;
    private String temperatura;
    private Date fecha;

     
  
    public Sensor(){

    }

    public Sensor(int id, String nombre, String modelo, String descripcion, String humedad, String temperatura,Date fecha) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.humedad = humedad;
        this.temperatura = temperatura;
        this.fecha = fecha;
    }
    
    public Sensor(int id, String nombre, String modelo, String descripcion, String humedad, String temperatura) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.humedad = humedad;
        this.temperatura = temperatura;
        this.fecha = fecha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setHumedad(String humedad) {
        this.humedad = humedad;
    }

    public String getHumedad() {
        return humedad;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getTemperatura() {
        return temperatura;
    }
    
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }
    
    public Date getFecha(){
        return fecha;
    }
    
    @Override
    public String toString() {
        return "Sensor{" + "id=" + id + ", nombre=" + nombre + ", modelo=" + modelo + ", descripcion=" + descripcion + ", humedad=" + humedad + ", temperatura=" + temperatura + ", fecha" + fecha + '}';
    }
 
    
    
}
