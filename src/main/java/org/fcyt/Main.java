package org.fcyt;

import org.fcyt.model.Conexion;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Conexion conexionManager = new Conexion();
        Connection conected = conexionManager.getConexion();
        System.out.println("Hello world!");
    }
}