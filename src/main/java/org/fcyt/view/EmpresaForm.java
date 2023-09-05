package org.fcyt.view;

import java.awt.*;
import javax.swing.*;
import com.intellij.uiDesigner.core.*;

public class EmpresaForm extends JInternalFrame{

    public EmpresaForm(){
        initComponents();
        initComponents();
        initComponents();
        setContentPane(table1);
        setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Cesar medina
        var panel1 = new JPanel();
        var panel2 = new JPanel();
        Table = new JScrollPane();
        table1 = new JTable();
        txtNombre = new JTextField();
        txtDireccion = new JTextField();
        txtTelefono = new JTextField();
        txtRUC = new JTextField();
        cancelarButton = new JButton();
        var label1 = new JLabel();
        var label2 = new JLabel();
        var label3 = new JLabel();
        guardarButton = new JButton();
        var label4 = new JLabel();
        var label5 = new JLabel();

        //======== panel1 ========
        {
            panel1.putClientProperty("html.disable", false);
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
            . border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax. swing. border. TitledBorder
            . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dialo\u0067" ,java .
            awt .Font .BOLD ,12 ), java. awt. Color. red) ,panel1. getBorder( )) )
            ; panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
            ) {if ("borde\u0072" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
            ;
            panel1.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));

            //======== panel2 ========
            {
                panel2.setMaximumSize(new Dimension(200, 200));

                //======== Table ========
                {
                    Table.setViewportView(table1);
                }

                //---- cancelarButton ----
                cancelarButton.setText("Cancelar");

                //---- label1 ----
                label1.setText("Nombre");

                //---- label2 ----
                label2.setText("RUC");

                //---- label3 ----
                label3.setText("Telefono");

                //---- guardarButton ----
                guardarButton.setEnabled(true);
                guardarButton.setHideActionText(false);
                guardarButton.setText("Guardar");
                guardarButton.setVerticalAlignment(SwingConstants.CENTER);
                guardarButton.setVerticalTextPosition(SwingConstants.TOP);

                //---- label4 ----
                label4.setText("CREAR EMPRESA");

                //---- label5 ----
                label5.setText("Direccion");

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGap(85, 85, 85)
                            .addComponent(label4)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGroup(panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(19, 19, 19)
                                    .addComponent(label1))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(16, 16, 16)
                                    .addComponent(label5))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(16, 16, 16)
                                    .addComponent(label3))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(27, 27, 27)
                                    .addComponent(label2))
                                .addComponent(cancelarButton))
                            .addGap(33, 33, 33)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtRUC, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(42, 42, 42)
                                    .addComponent(guardarButton))
                                .addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Table, GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(label4)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(24, 24, 24)
                                    .addComponent(label1)
                                    .addGap(36, 36, 36)
                                    .addComponent(label5)
                                    .addGap(33, 33, 33)
                                    .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label3)
                                        .addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGap(33, 33, 33)
                                    .addComponent(label2))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(21, 21, 21)
                                    .addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(80, 80, 80)
                                    .addComponent(txtRUC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(guardarButton)
                                        .addComponent(cancelarButton)))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addComponent(Table, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap())
                );
            }
            panel1.add(panel2, new GridConstraints(0, 0, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Cesar medina
    private JScrollPane Table;
    public JTable table1;
    private JTextField txtNombre;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtRUC;
    private JButton cancelarButton;
    private JButton guardarButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
