package org.fcyt.controller;

import org.fcyt.model.DAO.EmpresaDAOImplementacion;
import org.fcyt.model.Empresa;
import org.fcyt.view.EmpresaForm;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmpresaController implements ActionListener {

    EmpresaDAOImplementacion EAO = new EmpresaDAOImplementacion();
    Empresa e = new Empresa();
    EmpresaForm vista = new EmpresaForm();
    DefaultTableModel model = new DefaultTableModel();

    public EmpresaController() {

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
