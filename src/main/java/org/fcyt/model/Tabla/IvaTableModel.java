package org.fcyt.model.Tabla;

import org.fcyt.model.Iva;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class IvaTableModel extends AbstractTableModel {

    List<Iva> lista;

    private String[] columNames = new String[]{"ID", "DESCRPCION"};

    private String[] getColumnNames() {
        return columNames;
    }

    public void setColumnNames(String[] columNames) {
        this.columNames = columNames;
    }

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
        Iva iva = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return iva.getId();
            case 1:
                return iva.getDescripcion();
        }
        return "";
    }

    public List<Iva> getLista() {
        return lista;
    }

    public void setLista(List<Iva> lista) {
        this.lista = lista;
    }

    public Iva getEntityByRow(int index) {
        return lista.get(index);
    }
};
