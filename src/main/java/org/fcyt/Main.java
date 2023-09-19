package org.fcyt;
//
//import org.fcyt.controller.EmpresaController;
//import org.fcyt.model.DAO.EmpresaDAOImplementacion;
//import org.fcyt.view.GUIEmpresa;


import org.fcyt.controller.MarcaController;
import org.fcyt.model.DAO.MarcaDAOImplementacion;
import org.fcyt.view.GUIMarca;

public class Main {
    public static void main(String[] args) {
//        EmpresaDAOImplementacion dao = new EmpresaDAOImplementacion();
//        GUIEmpresa view = new GUIEmpresa(null,true);
//        EmpresaController controller = new EmpresaController(view,dao);
//        controller.showEmpresaGUI();
        MarcaDAOImplementacion dao = new MarcaDAOImplementacion();
        GUIMarca view = new GUIMarca(null,true);
        MarcaController controller = new MarcaController(view,dao);
        controller.showMarcaGUI();
    }
}