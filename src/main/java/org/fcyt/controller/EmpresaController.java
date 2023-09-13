package org.fcyt.controller;

import org.fcyt.model.DAO.EmpresaDAOImplementacion;
import org.fcyt.model.Empresa;
import org.fcyt.view.GUIEmpresa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//TODO: Falta que la vista se muestre

public class EmpresaController implements ActionListener {

    private EmpresaDAOImplementacion dao;
    private GUIEmpresa view;


    public EmpresaController(GUIEmpresa view, EmpresaDAOImplementacion DAO) {
        this.view = view;
        this.dao = DAO;

        this.view.btnGuardar.addActionListener((ActionListener) this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Hello class");
        dao.insertar(getEmpresaForm());
        Limpiar();
    }

    public void showEmpresaGUI(){
        view.setVisible(true);
    }

    private Empresa getEmpresaForm(){
        Empresa empresa = new Empresa();
        empresa.setRuc(view.txtRUC.getText());
        empresa.setNombre(view.txtNombre.getText());
        empresa.setDireccion(view.txtDireccion.getText());
        empresa.setTelefono(view.txtTelefono.getText());
        return empresa;
    }

    private void Limpiar(){
        view.txtRUC.setText(null);
        view.txtNombre.setText(null);
        view.txtDireccion.setText(null);
        view.txtTelefono.setText(null);
    }
}
