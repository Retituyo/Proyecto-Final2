/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Forms;

import CRUD_PRODUCTOS.Productos;
import CRUD_USUARIOS.Usuarios;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Restituyo
 */
//********************SE ESTA UTILIZANDO EL PATRON DE DISEÑO UTILIZANDO JAVA SWING*************//
public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
    }
    //ESTABLECEMOS LA CONEXION A NUESTRA BASE DE DATOS:
    public Connection Conexion(){
    Connection var = null;
    try{
      var = DriverManager.getConnection("jdbc:mysql://localhost:3306/logeo","root","");
    } catch (SQLException e){
        System.err.print(e.toString());
        JOptionPane.showMessageDialog(this, "Ha ocurrido un error inesperado. Contactar con Soporte.");
    }
    return var;
    }
    
    private JFrame getFrame(){
    return this;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BtnCerrarS = new javax.swing.JLabel();
        BtnUsuarios = new javax.swing.JLabel();
        BtnProductos = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnCerrarS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar-sesion.png"))); // NOI18N
        BtnCerrarS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnCerrarS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnCerrarSMouseClicked(evt);
            }
        });
        jPanel1.add(BtnCerrarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        BtnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuario 2.png"))); // NOI18N
        BtnUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnUsuariosMouseClicked(evt);
            }
        });
        jPanel1.add(BtnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 250, 260));

        BtnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/producto.png"))); // NOI18N
        BtnProductos.setText("jLabel3");
        BtnProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnProductosMouseClicked(evt);
            }
        });
        jPanel1.add(BtnProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 250, 260));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 30, 240));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCerrarSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCerrarSMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new FormLogin().setVisible(true);
    }//GEN-LAST:event_BtnCerrarSMouseClicked

    private void BtnUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnUsuariosMouseClicked
        // TODO add your handling code here:
            Usuarios vNueva = new Usuarios(){
            //cuando llamemos a dispose de vNueva abrimos la principal            
            @Override
            public void dispose(){
                //Hacemos visible la principal
                getFrame().setVisible(true);
                //Cerramos vNueva
                super.dispose();
            }
    };
        //Hacemos visible a vNueva
        vNueva.setVisible(true);
        //Cerramos la principal
        dispose();
    }//GEN-LAST:event_BtnUsuariosMouseClicked

    private void BtnProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnProductosMouseClicked
        // TODO add your handling code here:
         Productos vNueva = new Productos(){
            //Con esto cuando llamemos a dispose de vNueva abrimos la principal
            @Override
            public void dispose(){
                //Hacemos visible la principal
                getFrame().setVisible(true);
                //Cerramos vNueva
                super.dispose();
            }
        };

        //Hacemos visible a vNueva
        vNueva.setVisible(true);
        //Cerramos la principal
        dispose();
    }//GEN-LAST:event_BtnProductosMouseClicked

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BtnCerrarS;
    private javax.swing.JLabel BtnProductos;
    private javax.swing.JLabel BtnUsuarios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    static class setVisible {

        public setVisible(boolean b) {
        }
    }
}
