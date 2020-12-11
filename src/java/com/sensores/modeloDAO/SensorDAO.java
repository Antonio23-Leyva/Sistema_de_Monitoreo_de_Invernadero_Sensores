package com.sensores.modeloDAO;

import com.sensores.config.Conexion;
import com.sensores.modelo.Sensor;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class SensorDAO implements InterfazSensorDAO {

    public SensorDAO() {
    }

    @Override
    public List<Sensor> listar() {
        List<Sensor> sensores = new ArrayList<>();
        String sql = "select * from sensores.sensor";

        try {
            PreparedStatement ps = Conexion.Conectar().prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sensor s = new Sensor();
                s.setId(rs.getInt(1));
                s.setDescripcion(rs.getString(2));
                s.setHumedad(rs.getString(3));
                s.setModelo(rs.getString(4));
                s.setNombre(rs.getString(5));
                s.setTemperatura(rs.getString(6));
                sensores.add(s);
            }
        } catch (Exception e) {
            System.out.println("Error en sensorDAO" + e);
        }

        return sensores;
    }

    @Override
    public Sensor getId(int id) {
        String sql = "SELECT * FROM sensores.sensor WHERE id = " + id;
        Sensor sensor = new Sensor();
        try {
            PreparedStatement ps = Conexion.Conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sensor.setId(rs.getInt(1));
                sensor.setDescripcion(rs.getString(2));
                sensor.setHumedad(rs.getString(3));
                sensor.setModelo(rs.getString(4));
                sensor.setNombre(rs.getString(5));
                sensor.setTemperatura(rs.getString(6));
            }
        } catch (SQLException e) {
            System.out.println("Error en sensorDAO" + e);
        }
        return sensor;
    }

    @Override
    public int add(Sensor s) {
        int resultado = 0;
        String sql = "insert into sensores.sensor(id,descripcion,humedad,modelo,nombre,temperatura,fecha)values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = Conexion.Conectar().prepareStatement(sql);
            ps.setString(1, String.valueOf(s.getId()));
            ps.setString(2, s.getDescripcion());
            ps.setString(3, s.getHumedad());
            ps.setString(4, s.getModelo());
            ps.setString(5, s.getNombre());
            ps.setString(6, s.getTemperatura());
            ps.setString(7, s.getFecha().toString());
            resultado = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en agregar" + e);
        }
        return resultado;

    }

    @Override
    public int update(Sensor s) {
        int respuesta = 0;
        String sql = "update sensores.sensor set descripcion=?,humedad=?,modelo=?,nombre=?,temperatura=? where id=?";
        try {
            PreparedStatement ps = Conexion.Conectar().prepareStatement(sql);
            ps.setString(1, s.getDescripcion());
            ps.setString(2, s.getHumedad());
            ps.setString(3, s.getModelo());
            ps.setString(4, s.getNombre());
            ps.setString(5, s.getTemperatura());
            ps.setInt(6, s.getId());
            respuesta = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en UPDATE" + e);
        }
        return respuesta;
    }

    @Override
    public int delete(int id) {
        int resultado = 0;
        String sql = "delete from sensores.sensor where id = " + id;
        try {
            PreparedStatement ps = Conexion.Conectar().prepareCall(sql);
            resultado = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error en eliminar" + e);
        }
        return resultado;

    }

    @Override
    public List<Sensor> sendRequeriments() {
        List<Sensor> sensores = new ArrayList<>();
        String consulta = "SELECT * FROM sensores.sensor";
        try {
            PreparedStatement qe = Conexion.Conectar().prepareCall(consulta);
            ResultSet de = qe.executeQuery();
            while (de.next()) {
                Sensor s = new Sensor();
                s.setId(de.getInt(1));  
                s.setHumedad(de.getString(3)); 
                s.setModelo(de.getString(4)); 
                s.setTemperatura(de.getString(6)); 
                sensores.add(s);
            }
        } catch (SQLException e) {
            System.out.println("Error en enviar " + e);
        }
        return sensores;

    }

    @Override
    public List<Sensor> ParametrosFecha(Date pr) {
        List<Sensor> sensores = new ArrayList<>();
        String query = "SELECT * FROM sensores.sensor WHERE fecha ="+pr;
        try {
            PreparedStatement qe = Conexion.Conectar().prepareCall(query);
            ResultSet de = qe.executeQuery();
            while (de.next()) {
                Sensor s = new Sensor();
                s.setId(de.getInt(1)); 
                s.setHumedad(de.getString(3)); 
                s.setModelo(de.getString(4)); 
                s.setTemperatura(de.getString(6)); 
                sensores.add(s);
            }
        } catch (SQLException e) {
            System.out.println("Error en enviar " + e);
        }
        return sensores;
    }

 
    @Override
    public List<Date> ListaFechas() {
        List<Date> fechas = new ArrayList<>();
        String query = "SELECT * FROM sensores.sensor";
        try {
            PreparedStatement qe = Conexion.Conectar().prepareCall(query);
            ResultSet de = qe.executeQuery();
            while (de.next()) {
                Sensor s = new Sensor();
                s.setFecha(de.getDate(7));
                fechas.add(s.getFecha());
            }
        } catch (SQLException e) {
            System.out.println("Error en enviar " + e);
        }

        return fechas;
    }

}
