package org.fcyt;

import org.fcyt.controller.EmpresaController;
import org.fcyt.model.Conexion;
import org.fcyt.model.DAO.EmpresaDAOImplementacion;
import org.fcyt.view.EmpresaFormApache;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Conexion conexionManager = new Conexion();
        Connection conected = conexionManager.getConexion();
//        System.out.println("Hello world!");
        EmpresaDAOImplementacion dao = new EmpresaDAOImplementacion();
        EmpresaFormApache view = new EmpresaFormApache();
        EmpresaController controller = new EmpresaController(view,dao);
        controller.showEmpresaGUI();
    }
}