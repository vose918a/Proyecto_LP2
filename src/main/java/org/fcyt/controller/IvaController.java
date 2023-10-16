package org.fcyt.controller;

import org.fcyt.model.DAO.IvaDAOImplementacion;
import org.fcyt.model.Iva;
import org.fcyt.model.Marca;
import org.fcyt.model.Tabla.IvaTableModel;
import org.fcyt.model.Tabla.MarcaTableModel;
import org.fcyt.view.GUIIva;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class IvaController implements ActionListener {
    private IvaDAOImplementacion dao;
    private GUIIva view;

    IvaTableModel modelo = new IvaTableModel();

    String op = "";

    public IvaController(GUIIva view ,IvaDAOImplementacion dao) {
        this.dao = dao;
        this.view = view;

        this.Listar();

        this.view.btnNuevo.addActionListener(this);
        this.view.btnGuardar.addActionListener(this);
        this.view.btnEditar.addActionListener(this);
        this.view.btnEliminar.addActionListener(this);
        this.view.btnCancelar.addActionListener(this);

        view.Table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTable table = (JTable) e.getSource();
                int row = table.rowAtPoint(e.getPoint());
                IvaTableModel model = (IvaTableModel) table.getModel();

                setIvaForm(model.getEntityByRow(row));

            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.btnNuevo) {
            op = "N";
            habilitarCampos(true);
            clean();
            Listar();
        }
        if(e.getSource() == view.btnEditar) {
            int row = view.Table.getSelectedRow();
            if(row >= 0){
                op = "E";
                habilitarCampos(true);
                clean();
                Listar();
            }else{
                JOptionPane.showMessageDialog(view,"Debe seleccionar una fila");
            }
        }
        if(e.getSource() == view.btnCancelar) {
            clean();
            Listar();
            habilitarCampos(false);
        }
        if (e.getSource() == view.btnGuardar) {
            boolean valido = validar();
            if (valido == true) {
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                return;
            }
            switch (op) {
                case "N":
                    dao.insertar(getIvaForm());
                    break;
                case "E":
                    dao.actualizar(getIvaForm());
                    break;
            }
            clean();
            Listar();
            habilitarCampos(false);
        }
        if (e.getSource() == view.btnEliminar){
            int row = view.Table.getSelectedRow();
            if(row >= 0){
                int ok = JOptionPane.showConfirmDialog(view,"Esta seguro de eliminar este registro?","Confirmar",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if(ok == 0){
                    dao.eliminar(getIvaForm());
                    Listar();
                    clean();
                }
            }else {JOptionPane.showMessageDialog(view,"Debe selecionar una fila");}
        }
    }

    public void showIvaGUI(){
        view.setLocationRelativeTo(view);
        view.setVisible(true);
    }

    public Iva getIvaForm(){
        Iva iva = new Iva();
        iva.setId(Integer.parseInt(view.txtID.getText()));
        iva.setDescripcion(view.txtDescripcion.getText());
        return iva;
    }

    public void setIvaForm(Iva iva){
        view.txtID.setText(String.valueOf(iva.getId()));
        view.txtDescripcion.setText(iva.getDescripcion());
    }

    private void clean(){
        view.txtID.setText("0");
        view.txtDescripcion.setText("");
    }
    private boolean validar(){
        int valid = 0;
        if(view.txtDescripcion.getText().isEmpty()) valid++;
        if(view.txtID.getText().isEmpty()) valid++;
        if(valid > 0){return true;} else{return false;}
    }

    private void llenarTabla(JTable table){
        view.Table.setModel(modelo);
        view.Table.updateUI();
    }

    private void Listar(){
        List<Iva> lista;
        lista = this.dao.listar();
        modelo.setLista(lista);
        llenarTabla(view.Table);
    }
    private void habilitarCampos(boolean x){
        view.txtDescripcion.setEnabled(x);
    }
}
