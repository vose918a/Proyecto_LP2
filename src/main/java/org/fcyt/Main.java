package org.fcyt;

import org.fcyt.model.Conexion;
import org.fcyt.model.DAO.EmpresaDAOImplementacion;
import org.fcyt.model.Empresa;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Conexion conexionManager = new Conexion();
        Connection conected = conexionManager.getConexion();
        System.out.println("Hello world!");
//
//        EmpresaDAOImplementacion dao = new EmpresaDAOImplementacion();
//        List<Empresa> lista = dao.listar();
//        for(Empresa empresa : lista){
//            System.out.println(empresa.getNombre());
//        }
    }
}