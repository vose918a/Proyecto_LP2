package org.fcyt.controller;

import org.fcyt.model.DAO.MarcaDAOImplementacion;
import org.fcyt.model.Marca;
import org.fcyt.model.Tabla.MarcaTableModel;
import org.fcyt.view.GUIMarca;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class MarcaController implements ActionListener {
    private MarcaDAOImplementacion dao;
    private GUIMarca view;

    MarcaTableModel modelo = new MarcaTableModel();

    String op = "";


    public MarcaController(GUIMarca view, MarcaDAOImplementacion dao){
        this.view = view;
        this.dao = dao;

        this.Listar();

        this.view.btnNuevo.addActionListener(this);
        this.view.btnEditar.addActionListener(this);
        this.view.btnEliminar.addActionListener(this);
        this.view.btnCancelar.addActionListener(this);
        this.view.btnGuardar.addActionListener(this);

        view.Table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTable table = (JTable) e.getSource();
                int row = table.rowAtPoint(e.getPoint());
                MarcaTableModel model = (MarcaTableModel) table.getModel();

                SetMarcaForm(model.getEntityByRow(row));

            }
        });
    }
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
                    dao.insertar(getMarcaForm());
                    break;
                case "E":
                    dao.actualizar(getMarcaForm());
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
                    dao.eliminar(getMarcaForm());
                    Listar();
                    clean();
                }
            }else {JOptionPane.showMessageDialog(view,"Debe selecionar una fila");}
        }
    }

    public void showMarcaGUI(){view.setVisible(true);}

    private Marca getMarcaForm(){
        Marca marca = new Marca();
        marca.setId(Integer.parseInt(view.txtID.getText()));
        marca.setDescripcion(view.txtDescripcion.getText());
        return marca;
    }

    private void SetMarcaForm(Marca marca){
        view.txtID.setText(String.valueOf(marca.getId()));
        view.txtDescripcion.setText(marca.getDescripcion());
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
        List<Marca> lista;
        lista = this.dao.listar();
        modelo.setLista(lista);
        llenarTabla(view.Table);
//        for (int i = 0; i < lista.size(); i++) {
//            System.out.println(lista.get(i).getDescripcion());
//        }
    }

    private void habilitarCampos(boolean x){
        view.txtDescripcion.setEnabled(x);
    }
}
