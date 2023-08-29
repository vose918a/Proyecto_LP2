package org.fcyt.model;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class connection {
     String URL = "jdbc:postgresql://localhost:5433/Proyecto_LP2";
     String user = "postgres";
     String pass = "0304";

     public connection(){}

    public connection GetConnection() {
        connection connect = null;
        try {
            Class.forName("org.postgresql.Driver");
            connect = (connection) DriverManager.getConnection(URL,user,pass);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"Error al conectar: "+e);
        }
        return connect;
    }
}
