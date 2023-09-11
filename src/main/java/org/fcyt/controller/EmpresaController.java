package org.fcyt.controller;

import org.fcyt.model.DAO.EmpresaDAOImplementacion;
import org.fcyt.model.Empresa;
import org.fcyt.view.EmpresaFormApache;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//TODO: Falta que la vista se muestre

public class EmpresaController implements ActionListener {

    EmpresaDAOImplementacion DAO = new EmpresaDAOImplementacion();
    Empresa e = new Empresa();
    EmpresaFormApache view = new EmpresaFormApache();


    public EmpresaController(EmpresaFormApache view, EmpresaDAOImplementacion DAO) {
        this.view = view;
        this.DAO = DAO;

        this.view.btnGuardar.addActionListener((ActionListener) this);

//        List<Empresa> Lista = DAO.listar();
//        for (Empresa empresa : Lista){
//            System.out.println(empresa.getNombre());
//        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Hello class");
        DAO.insertar(getEmpresaForm());
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
