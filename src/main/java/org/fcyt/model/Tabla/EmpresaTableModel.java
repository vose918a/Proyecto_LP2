package org.fcyt.model.Tabla;

import org.fcyt.model.Empresa;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class EmpresaTableModel extends AbstractTableModel {

    List<Empresa> lista;
    private String[] columNames = new String []{"ID", "NOMBRE", "DIRECCION", "TELEFONO"};

    public String getColumnName(int i) {
        return columNames[i];
    }

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
        Empresa empresa = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return empresa.getId();
            case 1:
                return empresa.getNombre();
            case 2:
                return empresa.getDireccion();
            case 3:
                return empresa.getTelefono();
        }
        return "";
    }

    public List<Empresa> getLista(){return lista;}
    public void setLista(List<Empresa> lista){this.lista = lista;}

    public Empresa getEntityByRow( int index){
        return lista.get(index);
    }
}
