package org.fcyt.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public String URL = "jdbc:postgresql://localhost:5432/Proyecto_LP2";
    public String user = "postgres";
    public String pass = "0304";
    public Conexion(){};

    public Connection getConexion(){
        Connection conect = null;
        try {
            conect = DriverManager.getConnection(URL,user,pass);
        } catch (Exception e){
            System.out.println("Error al conectar: " + e);
        }
        return conect;
    }
}
