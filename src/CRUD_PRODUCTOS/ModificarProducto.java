/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CRUD_PRODUCTOS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import CRUD_PRODUCTOS.Productos;

/**
 *
 * @author Restituyo
 */
//********************SE ESTA UTILIZANDO EL PATRON DE DISEÑO UTILIZANDO JAVA SWING*************//
public class ModificarProducto extends javax.swing.JFrame {

    public ModificarProducto() {
        initComponents();
    }

    public Connection Conexion(){
    Connection var = null;
    try{
      var = DriverManager.getConnection("jdbc:mysql://localhost/logeo","root","");
    } catch (SQLException e){
        System.err.print(e.toString());
        JOptionPane.showMessageDialog(this, "Ha ocurrido un error inesperado. Contactar con Soporte.");
    }
    return var;
    }
    
    public void actualizarDatos(){
    //VARIABLES DE CONEXION  A LA BASE DE DATOS
       Connection var2 = null;
       java.sql.PreparedStatement consulta;
       //INSERTANDO DATOS EN VARIABLES
       String nombre = TxtNombre.getText();
       String marca = TxtMarca.getText();
       String categoria = TxtCategoria.getText();
       String precio = TxtPrecio.getText();
       String stock = TxtStock.getText();
       int filaSeleccionada = Productos.TablaProductos.getSelectedRow();
       String dao = (String) Productos.TablaProductos.getValueAt(filaSeleccionada,0);
       // INTRODUCIENDO VALORES A LA BASE DE DATOS
       try{
       
       var2 = Conexion();
       consulta = var2.prepareStatement("UPDATE productos SET  Nombre = ?,Marca = ?,Categoria = ?,Precio = ?, Stock = ? WHERE IdProducto = ?");
       consulta.setString(1, nombre);
       consulta.setString(2, marca);
       consulta.setString(3, categoria);
       consulta.setString(4, precio);
       consulta.setString(5, stock);
       consulta.setString(6, dao);
       consulta.execute();
       JOptionPane.showMessageDialog(this, "Se ha actualizado correctamente.");
       } catch (SQLException e){
       System.err.print(e.toString());
       JOptionPane.showMessageDialog(this, "Ha ocurrido un error inesperado. Contactar con Soporte." + e.getMessage());
       }
    }
    public void eliminarDatos(){
        
    int filaSeleccionada = Productos.TablaProductos.getSelectedRow();
    try{
        
       Connection var2 = null;
       java.sql.PreparedStatement consulta;
       
       var2 = Conexion();
       consulta = var2.prepareStatement("Delete FROM productos where IdProducto="+Productos.TablaProductos.getValueAt(filaSeleccionada,0));
       int n = consulta.executeUpdate();
       if (n > -1 ){
       JOptionPane.showMessageDialog(this, "Se ha eliminado correctamente.");
       }
       } catch (SQLException e){
       System.err.print(e.toString());
       JOptionPane.showMessageDialog(this, "Ha ocurrido un error inesperado. Contactar con Soporte." + e.getMessage());
       }    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TxtNombre = new javax.swing.JTextField();
        TxtMarca = new javax.swing.JTextField();
        TxtCategoria = new javax.swing.JTextField();
        TxtPrecio = new javax.swing.JTextField();
        TxtStock = new javax.swing.JTextField();
        BtnGuardar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));

        TxtNombre.setText("Nombre");
        TxtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNombreActionPerformed(evt);
            }
        });

        TxtMarca.setText("Marca");
        TxtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtMarcaActionPerformed(evt);
            }
        });

        TxtCategoria.setText("Categoria");
        TxtCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtCategoriaActionPerformed(evt);
            }
        });

        TxtPrecio.setText("Precio");
        TxtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtPrecioActionPerformed(evt);
            }
        });

        TxtStock.setText("Cantidad Disponible");
        TxtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtStockActionPerformed(evt);
            }
        });

        BtnGuardar.setText("GUARDAR");
        BtnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnGuardarMouseClicked(evt);
            }
        });
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });

        BtnEliminar.setText("ELIMINAR");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TxtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(TxtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TxtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TxtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNombreActionPerformed

    private void TxtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtMarcaActionPerformed

    private void TxtCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtCategoriaActionPerformed

    private void TxtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtPrecioActionPerformed

    private void TxtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtStockActionPerformed

    private void BtnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnGuardarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnGuardarMouseClicked

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        actualizarDatos();
        new Productos().setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        // TODO add your handling code here:
        eliminarDatos();
        new Productos().setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnEliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ModificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnGuardar;
    public static javax.swing.JTextField TxtCategoria;
    public static javax.swing.JTextField TxtMarca;
    public static javax.swing.JTextField TxtNombre;
    public static javax.swing.JTextField TxtPrecio;
    public static javax.swing.JTextField TxtStock;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
