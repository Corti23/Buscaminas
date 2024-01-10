package interfaces;

import java.awt.*;
import javax.swing.*;
import buscaminas.*;

public class InterfazIniciarSesion extends javax.swing.JFrame {
    
    public static InterfazInicio inicio;
    
    Almacen_Usuarios almacen_Usuarios;

    public InterfazIniciarSesion() {
        initComponents();
        this.setLocationRelativeTo(this);
        
        almacen_Usuarios = new Almacen_Usuarios("C:\\Users\\vcald\\Documents\\Buscaminas\\src\\ficheros\\listadoJugadores.ser");
        
        ajustarImagen(jLabel2, "src/img/usuario.png");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        atrasBoton = new javax.swing.JPanel();
        atras = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        entrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, 290, 250));

        atrasBoton.setBackground(new java.awt.Color(255, 255, 255));
        atrasBoton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        atrasBoton.setPreferredSize(new java.awt.Dimension(40, 40));
        atrasBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                atrasBotonMousePressed(evt);
            }
        });

        atras.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        atras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        atras.setText("<<");
        atras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        atras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atrasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                atrasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                atrasMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                atrasMousePressed(evt);
            }
        });

        javax.swing.GroupLayout atrasBotonLayout = new javax.swing.GroupLayout(atrasBoton);
        atrasBoton.setLayout(atrasBotonLayout);
        atrasBotonLayout.setHorizontalGroup(
            atrasBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(atras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        atrasBotonLayout.setVerticalGroup(
            atrasBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(atras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(atrasBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 70, 50));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("INICIAR SESIÓN");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 320, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("USUARIO:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 110, 30));

        usuario.setForeground(new java.awt.Color(153, 153, 153));
        usuario.setText("Introduzca su nombre de usuario");
        usuario.setToolTipText("");
        usuario.setBorder(null);
        usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                usuarioMousePressed(evt);
            }
        });
        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });
        jPanel2.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 330, 40));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 330, 10));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("CONTRASEÑA:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 160, 30));

        password.setForeground(new java.awt.Color(153, 153, 153));
        password.setText("jPasswordField1");
        password.setBorder(null);
        password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passwordMousePressed(evt);
            }
        });
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        jPanel2.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 330, 40));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 330, 10));

        entrar.setBackground(new java.awt.Color(0, 255, 0));
        entrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        entrar.setForeground(new java.awt.Color(255, 255, 255));
        entrar.setText("ENTRAR");
        entrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        entrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                entrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                entrarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                entrarMousePressed(evt);
            }
        });
        jPanel2.add(entrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 120, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.jpg"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 400, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioActionPerformed

    private void atrasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atrasMouseEntered
        atras.setForeground(new Color(20, 150, 20));
    }//GEN-LAST:event_atrasMouseEntered

    private void atrasBotonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atrasBotonMousePressed
        
    }//GEN-LAST:event_atrasBotonMousePressed

    private void atrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atrasMouseClicked
        
    }//GEN-LAST:event_atrasMouseClicked

    private void atrasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atrasMouseExited
       atras.setForeground(Color.black);
    }//GEN-LAST:event_atrasMouseExited

    private void entrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_entrarMouseEntered
        entrar.setBackground(new Color(20, 150, 20));
    }//GEN-LAST:event_entrarMouseEntered

    private void entrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_entrarMouseExited
        entrar.setBackground(new Color(0, 255, 0));
    }//GEN-LAST:event_entrarMouseExited

    private void usuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuarioMousePressed
        if (usuario.getText().equals("Introduzca su nombre de usuario")) {
            usuario.setText("");
            usuario.setForeground(Color.black);
        }
        
        if (String.valueOf(password.getPassword()).isEmpty()) {
            password.setText("jPasswordField1");
            password.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_usuarioMousePressed

    private void passwordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordMousePressed
        if (usuario.getText().isEmpty()) {
            usuario.setText("Introduzca su nombre de usuario");
            usuario.setForeground(new Color(153, 153, 153));
        }
        
        if (String.valueOf(password.getPassword()).equals("jPasswordField1")) {
            password.setText("");
            password.setForeground(Color.black);
        }
    }//GEN-LAST:event_passwordMousePressed

    private void atrasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atrasMousePressed
        inicio = new InterfazInicio();
        inicio.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_atrasMousePressed

    private void entrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_entrarMousePressed
        char[] arrayPassword = password.getPassword();
        String pass = new String(arrayPassword);
        
        Usuario jugador = new Usuario(usuario.getText(), pass);
        
        if (almacen_Usuarios.autenticar(jugador)) {
            InterfazJugador interfazJugador = new InterfazJugador();
            interfazJugador.setVisible(true);
            
            interfazJugador.insertarJugador(jugador.getNombre(), jugador.getPassword());
            
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "!Usuario y/o Contraseña incorrectos¡");
        }        
    }//GEN-LAST:event_entrarMousePressed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazIniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazIniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazIniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazIniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazIniciarSesion().setVisible(true);
            }
        });
    }
    
    public void ajustarImagen(JLabel label, String ruta) {
        ImageIcon imagen = new ImageIcon(ruta);
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
        
        label.setIcon(icono);
        this.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel atras;
    private javax.swing.JPanel atrasBoton;
    private javax.swing.JButton entrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}