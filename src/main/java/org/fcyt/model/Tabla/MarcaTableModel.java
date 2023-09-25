package org.fcyt.model.Tabla;

import org.fcyt.model.Marca;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class MarcaTableModel extends AbstractTableModel {

    List<Marca> lista;

    private String[] columNames = new String[] { "ID", "DESCRIPCION"};

    public String[] getColumNames() {return columNames;}

    public void setColumNames(String[] columNames) {this.columNames = columNames;}
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return columNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Marca marca = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return marca.getId();
            case 1:
                return marca.getDescripcion();
        }
        return "";
    }
    public List<Marca> getLista() {return lista;}
    public void setLista(List<Marca> lista) {
        this.lista = lista;
    }
    public Marca getEntityByRow(int index) {return lista.get(index);}
}
