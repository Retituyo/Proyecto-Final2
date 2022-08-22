/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Forms;

import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.LinkedList;
import SEGURIDAD.UsuarioRegistrado1;

/**
 *
 * @author Restituyo
 */
//********************SE ESTA UTILIZANDO EL PATRON DE DISEÑO UTILIZANDO JAVA SWING*************//
public class FormRegister extends javax.swing.JFrame {
    //Atributos

    private String username;
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private String password;
    private String confirmacion;

    public static LinkedList contenedor = new LinkedList();

    public FormRegister() {
        initComponents();
    }

    //ESTABLECEMOS LA CONEXION A NUESTRA BASE DE DATOS:
    public Connection Conexion() {
        Connection var = null;
        try {
            var = DriverManager.getConnection("jdbc:mysql://localhost:3306/logeo", "root", "");
        } catch (SQLException e) {
            System.err.print(e.toString());
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error inesperado. Contactar con Soporte.");
        }
        return var;
    }

    /*¡REQUERIMIENTO IMPORTANTE! APLICAMOS --ENCAPSULAMIENTO-- PARA EL REGISTRO DE NUESTRA TABLA DE USUARIOS*/
    public FormRegister(String username, String nombre, String apellidos, String email, String telefono, String password, String confirmacion) {
        this.username = username;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.password = password;
        this.confirmacion = confirmacion;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(String confirmacion) {
        this.confirmacion = confirmacion;
    }

    //NUEVO METODO PARA ESTABLECER EL REGISTRO DE NUESTRA TABLA
    public void Registrar() {
        //VARIABLES DE CONEXION  A LA BASE DE DATOS
        Connection var2 = null;
        PreparedStatement consulta;
        ResultSet result = null;
        //NUEVO OBJETO PARA APLICAR Polimorfismo:
        UsuarioRegistrado1 usuario = new UsuarioRegistrado1();
        //INSERTANDO LOS DATOS DE MI JTEXTFIELD EN VARIABLES STRING
        String username = TxtUsername.getText();
        String nombre = TxtName.getText();
        String apellidos = TxtApellido.getText();
        String email = TxtEmail.getText();
        String telefono = TxtPhone.getText();
        String password = TxtPassword.getText();
        String confirmacion = TxtPasswordC.getText();
        try {
            //CONDICIONES REQUERIDAS
            if (username.equals("") || nombre.equals("") || apellidos.equals("") || email.equals("") || telefono.equals("") || password.equals("") || confirmacion.equals("")) {
                JOptionPane.showMessageDialog(this, "Ningun campo debe estar vacio.");
                //CONDICIONES
            } else if (password.equals(confirmacion) == false) {
                JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.");
            } else {
                // INTRODUCIENDO VALORES A LA BASE DE DATOS
                var2 = Conexion();
                consulta = var2.prepareStatement("INSERT INTO usuarios VALUES (?,?,?,?,?,?,?)");
                consulta.setString(1, null);
                consulta.setString(2, username);
                consulta.setString(3, nombre);
                consulta.setString(4, apellidos);
                consulta.setString(5, email);
                consulta.setString(6, telefono);
                consulta.setString(7, password);
                consulta.execute();
                /*¡REQUERIMIENTO IMPORTANTE! APLICAMOS --ABSTRACCION-- PARA EL LLAMADO DE MI MENSAJE "USUARIO REGISTRADO"*/
                usuario.Registrado();
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////
                TxtUsername.setText("");
                TxtName.setText("");
                TxtApellido.setText("");
                TxtEmail.setText("");
                TxtPhone.setText("");
                TxtPassword.setText("");
                TxtPasswordC.setText("");
            }
        } catch (SQLException e) {
            System.err.print(e.toString());
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error inesperado. Contactar con Soporte.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Separador = new javax.swing.JPanel();
        imgLogo = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        TxtUsername = new javax.swing.JTextField();
        Separador1 = new javax.swing.JSeparator();
        Separador2 = new javax.swing.JSeparator();
        TxtName = new javax.swing.JTextField();
        Separador3 = new javax.swing.JSeparator();
        TxtApellido = new javax.swing.JTextField();
        Separador4 = new javax.swing.JSeparator();
        TxtPhone = new javax.swing.JTextField();
        TxtEmail = new javax.swing.JTextField();
        Separador5 = new javax.swing.JSeparator();
        Separador6 = new javax.swing.JSeparator();
        Separador7 = new javax.swing.JSeparator();
        TxtPassword = new javax.swing.JPasswordField();
        TxtPasswordC = new javax.swing.JPasswordField();
        BtnRegistrarse = new javax.swing.JButton();
        BtnEntrar = new javax.swing.JLabel();

        jLabel2.setFont(new java.awt.Font("Segoe UI Historic", 2, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Bienvenido al Sistema de Logeo");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Separador.setBackground(new java.awt.Color(0, 0, 0));

        imgLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Registrar.png"))); // NOI18N

        lblTitulo.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(102, 102, 102));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("REGISTRO");

        jSeparator1.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator1.setAlignmentX(0.9F);

        jSeparator2.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));
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
                .addGap(66, 66, 66)
                .addComponent(imgLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        jPanel2.add(Separador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 400));

        TxtUsername.setBackground(new java.awt.Color(102, 102, 102));
        TxtUsername.setFont(new java.awt.Font("Roboto Lt", 0, 12)); // NOI18N
        TxtUsername.setForeground(new java.awt.Color(255, 255, 255));
        TxtUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtUsername.setText("NOMBRE  DE USUARIO");
        TxtUsername.setBorder(null);
        TxtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtUsernameActionPerformed(evt);
            }
        });
        jPanel2.add(TxtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 130, 30));
        jPanel2.add(Separador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 180, 10));
        jPanel2.add(Separador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 180, 10));

        TxtName.setBackground(new java.awt.Color(102, 102, 102));
        TxtName.setFont(new java.awt.Font("Roboto Lt", 0, 12)); // NOI18N
        TxtName.setForeground(new java.awt.Color(255, 255, 255));
        TxtName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtName.setText("NOMBRE");
        TxtName.setBorder(null);
        TxtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNameActionPerformed(evt);
            }
        });
        jPanel2.add(TxtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 130, 30));
        jPanel2.add(Separador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 180, 10));

        TxtApellido.setBackground(new java.awt.Color(102, 102, 102));
        TxtApellido.setFont(new java.awt.Font("Roboto Lt", 0, 12)); // NOI18N
        TxtApellido.setForeground(new java.awt.Color(255, 255, 255));
        TxtApellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtApellido.setText("APELLIDO");
        TxtApellido.setBorder(null);
        TxtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtApellidoActionPerformed(evt);
            }
        });
        jPanel2.add(TxtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 130, 30));
        jPanel2.add(Separador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 180, 10));

        TxtPhone.setBackground(new java.awt.Color(102, 102, 102));
        TxtPhone.setFont(new java.awt.Font("Roboto Lt", 0, 12)); // NOI18N
        TxtPhone.setForeground(new java.awt.Color(255, 255, 255));
        TxtPhone.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtPhone.setText("TELEFONO");
        TxtPhone.setBorder(null);
        TxtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtPhoneActionPerformed(evt);
            }
        });
        jPanel2.add(TxtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, 130, 30));

        TxtEmail.setBackground(new java.awt.Color(102, 102, 102));
        TxtEmail.setFont(new java.awt.Font("Roboto Lt", 0, 12)); // NOI18N
        TxtEmail.setForeground(new java.awt.Color(255, 255, 255));
        TxtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtEmail.setText("EMAIL");
        TxtEmail.setBorder(null);
        TxtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtEmailActionPerformed(evt);
            }
        });
        jPanel2.add(TxtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 130, 30));
        jPanel2.add(Separador5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 180, 10));
        jPanel2.add(Separador6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, 180, 10));
        jPanel2.add(Separador7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 180, 10));

        TxtPassword.setBackground(new java.awt.Color(102, 102, 102));
        TxtPassword.setForeground(new java.awt.Color(255, 255, 255));
        TxtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtPassword.setText("jPasswordField1");
        TxtPassword.setBorder(null);
        TxtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtPasswordActionPerformed(evt);
            }
        });
        jPanel2.add(TxtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, 130, 30));

        TxtPasswordC.setBackground(new java.awt.Color(102, 102, 102));
        TxtPasswordC.setForeground(new java.awt.Color(255, 255, 255));
        TxtPasswordC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtPasswordC.setText("jPasswordField1");
        TxtPasswordC.setBorder(null);
        TxtPasswordC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtPasswordCActionPerformed(evt);
            }
        });
        jPanel2.add(TxtPasswordC, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 130, 30));

        BtnRegistrarse.setBackground(new java.awt.Color(0, 102, 255));
        BtnRegistrarse.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        BtnRegistrarse.setForeground(new java.awt.Color(255, 255, 255));
        BtnRegistrarse.setText("REGISTRARSE");
        BtnRegistrarse.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BtnRegistrarse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnRegistrarse.setFocusPainted(false);
        BtnRegistrarse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnRegistrarseMouseClicked(evt);
            }
        });
        BtnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarseActionPerformed(evt);
            }
        });
        jPanel2.add(BtnRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 310, 200, 40));

        BtnEntrar.setFont(new java.awt.Font("Roboto", 2, 12)); // NOI18N
        BtnEntrar.setText("¿YA TIENES CUENTA? INICIA SESION");
        BtnEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnEntrarMouseClicked(evt);
            }
        });
        jPanel2.add(BtnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 360, 210, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtUsernameActionPerformed

    private void TxtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNameActionPerformed

    private void TxtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtApellidoActionPerformed

    private void TxtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtPhoneActionPerformed

    private void TxtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtEmailActionPerformed

    private void TxtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtPasswordActionPerformed

    private void TxtPasswordCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtPasswordCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtPasswordCActionPerformed

    private void BtnRegistrarseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnRegistrarseMouseClicked
        //CONDICION PARA FUNCIONAR SOLO CLIC IZQUIERDO
        if (MouseEvent.BUTTON1 == evt.getButton()) {
            Registrar();
        }
    }//GEN-LAST:event_BtnRegistrarseMouseClicked

    private void BtnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnRegistrarseActionPerformed

    private void BtnEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnEntrarMouseClicked
        this.dispose();
        new FormLogin().setVisible(true);
    }//GEN-LAST:event_BtnEntrarMouseClicked

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
            java.util.logging.Logger.getLogger(FormRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BtnEntrar;
    private javax.swing.JButton BtnRegistrarse;
    private javax.swing.JPanel Separador;
    private javax.swing.JSeparator Separador1;
    private javax.swing.JSeparator Separador2;
    private javax.swing.JSeparator Separador3;
    private javax.swing.JSeparator Separador4;
    private javax.swing.JSeparator Separador5;
    private javax.swing.JSeparator Separador6;
    private javax.swing.JSeparator Separador7;
    private javax.swing.JTextField TxtApellido;
    private javax.swing.JTextField TxtEmail;
    private javax.swing.JTextField TxtName;
    private javax.swing.JPasswordField TxtPassword;
    private javax.swing.JPasswordField TxtPasswordC;
    private javax.swing.JTextField TxtPhone;
    private javax.swing.JTextField TxtUsername;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables

}
