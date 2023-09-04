package org.fcyt;

import org.fcyt.model.conexion;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        conexion conexionManager = new conexion();
        Connection conected = conexionManager.getConexion();
        System.out.println("Hello world!");
    }
}