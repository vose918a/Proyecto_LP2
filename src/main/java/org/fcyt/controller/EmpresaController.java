package org.fcyt.controller;

import org.fcyt.model.DAO.EmpresaDAOImplementacion;
import org.fcyt.model.Empresa;
import org.fcyt.model.Tabla.EmpresaTableModel;
import org.fcyt.view.GUIEmpresa;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;


public class EmpresaController implements ActionListener {

    private EmpresaDAOImplementacion dao;
    private GUIEmpresa view;

    EmpresaTableModel modelo = new EmpresaTableModel();

    String op = "";


    public EmpresaController(GUIEmpresa view, EmpresaDAOImplementacion DAO) {
        this.view = view;
        this.dao = DAO;

        this.listar();

        this.view.btnGuardar.addActionListener(this);
        this.view.btnCancelar.addActionListener(this);
        this.view.btnEditar.addActionListener(this);
        this.view.btnEliminar.addActionListener(this);
        this.view.btnNuevo.addActionListener(this);

        view.Table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTable table = (JTable) e.getSource();
                int row = table.rowAtPoint(e.getPoint());
                EmpresaTableModel model = (EmpresaTableModel) table.getModel();

                setEmpresaForm(model.getEntityByRow(row));

            }
        });

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnNuevo){
            op = "N";
            habilitarCampos(true);
            Limpiar();
        }
        if (e.getSource() == view.btnEditar){
            op = "E";
            habilitarCampos(true);
            Limpiar();
        }
        if (e.getSource() == view.btnGuardar){
            boolean validade = validar();
            if (validade == true){
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                return;
            }
            switch (op){
                case "N":
                    dao.insertar(getEmpresaForm());
                    break;
                case "E":
                    dao.actualizar(getEmpresaForm());
                    break;
            }
            Limpiar();
            listar();
        }
        if (e.getSource() == view.btnCancelar){
            Limpiar();
            listar();
            habilitarCampos(false);
        }
        if (e.getSource() == view.btnEliminar){
            int row = view.Table.getSelectedRow();
            if (row >= 0){
                int ok = JOptionPane.showConfirmDialog(view,"Esta seguro de eliminar este registro?","Confirmar",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if (ok == 0 ){
                    dao.eliminar(modelo.getEntityByRow(row));
                    listar();
                }
            }
        }else {JOptionPane.showMessageDialog(view,"Debe selecionar una fila");}
    }

    public void showEmpresaGUI(){
        view.setVisible(true);
    }

    private Empresa getEmpresaForm(){
        Empresa empresa = new Empresa();
        empresa.setId(Integer.parseInt(view.txtID.getText()));
        empresa.setRuc(view.txtRUC.getText());
        empresa.setNombre(view.txtNombre.getText());
        empresa.setDireccion(view.txtDireccion.getText());
        empresa.setTelefono(view.txtTelefono.getText());
        return empresa;
    }

    private void setEmpresaForm(Empresa empresa){
        empresa.setId(Integer.valueOf(view.txtID.getText()));
        empresa.setRuc(view.txtRUC.getText());
        empresa.setNombre(view.txtNombre.getText());
        empresa.setDireccion(view.txtDireccion.getText());
        empresa.setTelefono(view.txtTelefono.getText());
    }

    private void Limpiar(){
        view.txtID.setText("0");
        view.txtRUC.setText(null);
        view.txtNombre.setText(null);
        view.txtDireccion.setText(null);
        view.txtTelefono.setText(null);
    }

    private void habilitarCampos(boolean x){
        view.txtNombre.setEnabled(x);
        view.txtRUC.setEnabled(x);
        view.txtDireccion.setEnabled(x);
        view.txtTelefono.setEnabled(x);
    }

    private boolean validar(){
        boolean valid = false;
        if (view.txtNombre.getText().isEmpty()) valid = true;
        if (view.txtRUC.getText().isEmpty()) valid = true;
        if (view.txtDireccion.getText().isEmpty()) valid = true;
        if (view.txtTelefono.getText().isEmpty()) {valid = true;}
        return valid;
    }

    private void llenarTabla(JTable table){
        view.Table.setModel(modelo);
        view.Table.updateUI();
    }

    public void listar(){
        List<Empresa> lista = this.dao.listar();
        modelo.setLista(lista);
        llenarTabla(view.Table);
    }
}
