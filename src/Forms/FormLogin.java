
package Forms;

import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.JOptionPane;

public class FormLogin extends javax.swing.JFrame {
//********************SE ESTA UTILIZANDO EL PATRON DE DISEÑO UTILIZANDO JAVA SWING*************//
    public FormLogin() {
        initComponents();
    }
    //ESTABLECEMOS LA CONEXION A NUESTRA BASE DE DATOS:
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
    //CREAMOS NUEVO METODO PARA INGRESAR AL SISTEMA
    public void Ingreso(){
        Connection var2 = null;
        PreparedStatement consulta = null;
        ResultSet result = null;
        String Usuario = TxtUsuario.getText();
        String Password = TxtPassword.getText();
        //CONDICIONES REQUERIDAS:
       if (Usuario.equals("") || Password.equals("")){
           JOptionPane.showMessageDialog(this, "Debe ingresar su usuario y contraseña.\nSi no está registrado debe registrarse.");
       }else {
        //try catch por si ocurre algun problema con mi consulta//
       try{
       var2 = Conexion();
       consulta = var2.prepareStatement("select Username, Password from Usuarios where Username='"+Usuario+ "'and Password = '" + Password + "'");
       result = consulta.executeQuery();
       if (result.next()){
       new Principal().setVisible(true);
       this.dispose();
       }else{
       JOptionPane.showMessageDialog(this, "El usuario o contraseña son incorrectos. Intentelo denuevo.");
       }
       } catch (SQLException e){
       System.err.print(e.toString());
       JOptionPane.showMessageDialog(this, "Ha ocurrido un error inesperado. Contactar con Soporte.");
       }
       }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Separador = new javax.swing.JPanel();
        imgLogo = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        TxtUsuario = new javax.swing.JTextField();
        Separador1 = new javax.swing.JSeparator();
        Separador2 = new javax.swing.JSeparator();
        TxtPassword = new javax.swing.JPasswordField();
        BtnEntrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        BtnRegistrarse = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("VENTANA DE LOGEO");
        setLocationByPlatform(true);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Separador.setBackground(new java.awt.Color(102, 102, 102));

        imgLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo.png"))); // NOI18N

        lblTitulo.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("INICIAR SESION");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setAlignmentX(0.9F);

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setAlignmentX(0.9F);

        javax.swing.GroupLayout SeparadorLayout = new javax.swing.GroupLayout(Separador);
        Separador.setLayout(SeparadorLayout);
        SeparadorLayout.setHorizontalGroup(
            SeparadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SeparadorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        SeparadorLayout.setVerticalGroup(
            SeparadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SeparadorLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(imgLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        jPanel2.add(Separador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 400));

        TxtUsuario.setBackground(new java.awt.Color(0, 0, 0));
        TxtUsuario.setFont(new java.awt.Font("Roboto Lt", 0, 12)); // NOI18N
        TxtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        TxtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtUsuario.setText("NOMBRE  DE USUARIO");
        TxtUsuario.setBorder(null);
        TxtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtUsuarioActionPerformed(evt);
            }
        });
        jPanel2.add(TxtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 280, 30));
        jPanel2.add(Separador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 350, 10));
        jPanel2.add(Separador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 350, 10));

        TxtPassword.setBackground(new java.awt.Color(0, 0, 0));
        TxtPassword.setForeground(new java.awt.Color(255, 255, 255));
        TxtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtPassword.setText("jPasswordField1");
        TxtPassword.setBorder(null);
        TxtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtPasswordActionPerformed(evt);
            }
        });
        jPanel2.add(TxtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 280, 30));

        BtnEntrar.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        BtnEntrar.setText("INICIAR SESION");
        BtnEntrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BtnEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnEntrar.setFocusPainted(false);
        BtnEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnEntrarMouseClicked(evt);
            }
        });
        BtnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEntrarActionPerformed(evt);
            }
        });
        jPanel2.add(BtnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 170, 40));

        jLabel2.setText("jLabel2");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 330, 40, 20));

        BtnRegistrarse.setFont(new java.awt.Font("Roboto", 2, 12)); // NOI18N
        BtnRegistrarse.setForeground(new java.awt.Color(0, 153, 204));
        BtnRegistrarse.setText("¿NO TIENES CUENTA? REGISTRATE AQUI");
        BtnRegistrarse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnRegistrarse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnRegistrarseMouseClicked(evt);
            }
        });
        jPanel2.add(BtnRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 240, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtUsuarioActionPerformed

    private void BtnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEntrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnEntrarActionPerformed

    private void BtnEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnEntrarMouseClicked
    //CONDICION PARA FUNCIONAR SOLO CLIC IZQUIERDO
        if (MouseEvent.BUTTON1 == evt.getButton()) {
            Ingreso();
        }   
    }//GEN-LAST:event_BtnEntrarMouseClicked

    private void TxtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtPasswordActionPerformed

    private void BtnRegistrarseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnRegistrarseMouseClicked

        this.dispose();
        new FormRegister().setVisible(true);
    }//GEN-LAST:event_BtnRegistrarseMouseClicked

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
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEntrar;
    private javax.swing.JLabel BtnRegistrarse;
    private javax.swing.JPanel Separador;
    private javax.swing.JSeparator Separador1;
    private javax.swing.JSeparator Separador2;
    private javax.swing.JPasswordField TxtPassword;
    private javax.swing.JTextField TxtUsuario;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
