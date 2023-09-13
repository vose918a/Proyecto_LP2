package org.fcyt;

import org.fcyt.controller.EmpresaController;
import org.fcyt.model.DAO.EmpresaDAOImplementacion;
import org.fcyt.view.GUIEmpresa;


public class Main {
    public static void main(String[] args) {
        EmpresaDAOImplementacion dao = new EmpresaDAOImplementacion();
        GUIEmpresa view = new GUIEmpresa(null,true);
        EmpresaController controller = new EmpresaController(view,dao);
        controller.showEmpresaGUI();
    }
}