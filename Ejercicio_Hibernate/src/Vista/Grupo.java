package Vista;

import java.util.Iterator;
import java.util.List;
import modelo.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Grupo extends javax.swing.JFrame {

    public Grupo() {
        initComponents();
        setLocationRelativeTo(null);
        listarGrupos();
        btn_Eliminar.setEnabled(false);
        btn_Modificar.setEnabled(false);
    }
    
        public void limpiar() {
        this.txt_NomGru.setText("");
        this.txt_CveGru.setText("");
    }
    
    public void listarGrupos() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            tblGrupos.setModel(modelo);

            modelo.addColumn("Clave");
            modelo.addColumn("Nombre");

            Operaciones operacion = new Operaciones();
            List datos = operacion.ListaGrupo();
            Iterator it = datos.iterator();

            if (datos.size() > 0) {
                while (it.hasNext()) {
                    modelo.Grupo g = (modelo.Grupo) it.next();

                    Object[] fila = new Object[2];

                    fila[0] = g.getCveGru();
                    fila[1] = g.getNomGru();

                    modelo.addRow(fila);
                }
            }else {
                JOptionPane.showMessageDialog(this, "No Existen Grupos!");
            }
        } catch (Exception e) {
    }
}
        
    public void modificarGrupos() {
       String cveGru;

        cveGru = txt_CveGru.getText();
        txtCveGru.setEnabled(true);
        Operaciones operacion = new Operaciones();
        modelo.Grupo grupo = null;
        grupo = operacion.obtenerGrupo(cveGru);

        String nomGru;

        nomGru = txt_NomGru.getText();

        grupo.setNomGru(nomGru);
        operacion.actualizarGrupo(grupo);
        JOptionPane.showMessageDialog(null, "Se actualizo a:" + cveGru + " Con el nombre: " + nomGru, "Se Actualizo Correctamente ", JOptionPane.INFORMATION_MESSAGE);

        limpiar();
        listarGrupos();
        btn_Agregar.setEnabled(true);
        btn_Eliminar.setEnabled(false);
        btn_Modificar.setEnabled(false);
    }
            
    public void eliminarGrupos() {
        JOptionPane.showMessageDialog(null, "¿Borrar Grupo?", "Advertencia!", JOptionPane.WARNING_MESSAGE);
        txtCveGru.setEnabled(true);
        String cveGru;
        cveGru = txt_CveGru.getText();
        Operaciones operacion = new Operaciones();
        modelo.Grupo grupo = null;
        grupo = operacion.obtenerGrupo(cveGru);
        operacion.eliminarGrupo(cveGru);
        JOptionPane.showMessageDialog(null, "Se elimino a:" + cveGru, "Se elimino Correctamente", JOptionPane.INFORMATION_MESSAGE);

        limpiar();
        listarGrupos();
        btn_Agregar.setEnabled(true);
        btn_Eliminar.setEnabled(false);
        btn_Modificar.setEnabled(false);
    }
            
    public void insertarGrupos() {
        String cveGru;
        String nomGru;

        cveGru = txt_CveGru.getText();
        nomGru = txt_NomGru.getText();
        
        modelo.Grupo grupo = new modelo.Grupo(cveGru, nomGru);

        Operaciones operacion = new Operaciones();
        operacion.guardarGrupo(grupo);
        JOptionPane.showMessageDialog(null, "Se guardo a:" + " '" + cveGru + "' " + " Con el nombre: " + " '" + nomGru + "' ", "Se inserto Correctamente", JOptionPane.INFORMATION_MESSAGE);
        txt_CveGru.setText("");
        txt_NomGru.setText("");

        limpiar();
        listarGrupos();
    }

    public void buscarGrupos() {
        String cveGru;
        cveGru = txt_CveBusGrup.getText();
        txtCveGru.setEnabled(false);
        Operaciones operacion = new Operaciones();
        modelo.Grupo grupo = null;
        grupo = operacion.obtenerGrupo(cveGru);

        txt_CveBusGrup.setText(grupo.getCveGru());
        txt_CveGru.setText(grupo.getCveGru());
        txt_NomGru.setText(grupo.getNomGru());
        txt_CveBusGrup.setText("");

        btn_Agregar.setEnabled(false);
        btn_Eliminar.setEnabled(true);
        btn_Modificar.setEnabled(true);
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCveGru = new javax.swing.JScrollPane();
        txt_CveGru = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_NomGru = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt_CveBusGrup = new javax.swing.JTextPane();
        btn_Buscar = new javax.swing.JButton();
        btn_Agregar = new javax.swing.JButton();
        btn_Modificar = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblGrupos = new javax.swing.JTable();
        btn_Eliminar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btn_Salir = new javax.swing.JButton();
        btn_Regresar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jTextPane1);

        jButton6.setText("jButton6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GRUPO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        jLabel2.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CLAVE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Perpetua", 1, 40)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText(" AGREGAR GRUPO  ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        txtCveGru.setViewportView(txt_CveGru);

        getContentPane().add(txtCveGru, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 220, -1));

        jScrollPane3.setViewportView(txt_NomGru);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 220, -1));

        jScrollPane4.setViewportView(txt_CveBusGrup);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 140, -1));

        btn_Buscar.setText("BUSCAR");
        btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));

        btn_Agregar.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        btn_Agregar.setText("AGREGAR");
        btn_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        btn_Modificar.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        btn_Modificar.setText("MODIFICAR");
        btn_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, -1, -1));

        tblGrupos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Clave", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblGrupos);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 320, 110));

        btn_Eliminar.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        btn_Eliminar.setText("ELIMINAR");
        btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, -1, -1));

        jLabel4.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NOMBRE");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        btn_Salir.setBackground(new java.awt.Color(153, 0, 0));
        btn_Salir.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        btn_Salir.setForeground(new java.awt.Color(255, 255, 255));
        btn_Salir.setText("SALIR");
        btn_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SalirActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, -1, -1));

        btn_Regresar.setBackground(new java.awt.Color(153, 0, 0));
        btn_Regresar.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        btn_Regresar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Regresar.setText("REGRESAR");
        btn_Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iMAGENES/fondoo.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AgregarActionPerformed
        try {
            boolean AgClave = true;
            boolean AgNombre = true;

            if (!txt_CveGru.getText().isEmpty()) {
                if (txt_CveGru.getText().length() != 10) {
                    JOptionPane.showMessageDialog(this, "La clave debe tener 10 carácteres");
                    AgClave = false;
                }
            } else {
                JOptionPane.showMessageDialog(this, "La clave no puede quedar vacía!");
                AgClave = false;
            }

            if (!txt_NomGru.getText().isEmpty()) {
                if (!txt_NomGru.getText().matches("^[A-Za-z ]*$")) {
                    JOptionPane.showMessageDialog(this, "El nombre no debe de tener números");
                    AgNombre = false;
                }
            } else {
                JOptionPane.showMessageDialog(this, "El nombre no puede quedar vacío");
                AgNombre = false;
            }
            if (AgClave && AgNombre) {
                insertarGrupos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
        }
    }//GEN-LAST:event_btn_AgregarActionPerformed

    private void btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarActionPerformed
 try {
            boolean BusClave = true;
            
            if (!txt_CveBusGrup.getText().isEmpty()) {
                if (txt_CveBusGrup.getText().length() != 10) {
                    JOptionPane.showMessageDialog(this, "La clave debe tener 10 Digitos");
                    BusClave = false;
                }
            } else {
        
                JOptionPane.showMessageDialog(this, "La clave no puede quedar vacia!");
                BusClave = false;
            }
            if (BusClave) {
                buscarGrupos();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error" + ex.getMessage());
        }
    }//GEN-LAST:event_btn_BuscarActionPerformed

    private void btn_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModificarActionPerformed

      try {
            boolean banClave = true;
            boolean banNombre = true;

            if (!txt_CveGru.getText().isEmpty()) {
                if (txt_CveGru.getText().length() != 10) {
                    JOptionPane.showMessageDialog(this, "La clave debe tener 10 Digitos ");
                    banClave = false;
                }
            } else {
                JOptionPane.showMessageDialog(this, "La clave no puede quedar vacía!");
                banClave = false;
            }

            if (!txt_NomGru.getText().isEmpty()) {
                if (!txt_NomGru.getText().matches("^[A-Za-z ]*$")) {
                    JOptionPane.showMessageDialog(this, "El nombre no debe llevar números! ");
                    banNombre = false;
                }
            } else {
                JOptionPane.showMessageDialog(this, "El nombre no puede quedar vacío!");
                banNombre = false;
            }
            if (banClave && banNombre) {
                modificarGrupos();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error" + ex.getMessage());
        }        
    }//GEN-LAST:event_btn_ModificarActionPerformed

    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarActionPerformed
       try {
            boolean banClave = true;

            if (!txt_CveGru.getText().isEmpty()) {
                if (txt_CveGru.getText().length() != 10) {
                    JOptionPane.showMessageDialog(this, "La clave debe tener 10 Digitos");
                    banClave = false;
                }
            } else {
                JOptionPane.showMessageDialog(this, "La clave no debe quedar vacía!");
                banClave = false;
            }
            if (banClave) {
              eliminarGrupos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
        }
    }//GEN-LAST:event_btn_EliminarActionPerformed

    private void btn_RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegresarActionPerformed

        Menu men=new Menu();
        men.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_RegresarActionPerformed

    private void btn_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btn_SalirActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Grupo().setVisible(true);   
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Agregar;
    private javax.swing.JButton btn_Buscar;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_Modificar;
    private javax.swing.JButton btn_Regresar;
    private javax.swing.JButton btn_Salir;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTable tblGrupos;
    private javax.swing.JScrollPane txtCveGru;
    private javax.swing.JTextPane txt_CveBusGrup;
    private javax.swing.JTextPane txt_CveGru;
    private javax.swing.JTextPane txt_NomGru;
    // End of variables declaration//GEN-END:variables
}
