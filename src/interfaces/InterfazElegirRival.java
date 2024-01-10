package interfaces;

import buscaminas.*;
import java.awt.Color;
import javax.swing.JOptionPane;

public class InterfazElegirRival extends javax.swing.JFrame {
    
    public static InterfazJugador interfazJugador;
    
    Almacen_Usuarios almacen_Usuarios;
    private String nombre1, password1;
    
    public InterfazElegirRival() {
        initComponents();
        this.setLocationRelativeTo(this);
        
        almacen_Usuarios = new Almacen_Usuarios("C:\\Users\\vcald\\Documents\\Buscaminas\\src\\ficheros\\listadoJugadores.ser");
    }
    
    public void insertarJugador1(String nombre, String password) {
        this.nombre1 = nombre;
        this.password1 = password;
    }
    
    public void iniciarPartida() {
        char[] arrayPassword = password_rival.getPassword();
        String password2 = new String(arrayPassword);
        
        Usuario jugador = new Usuario(nombre_rival.getText(), password2);
        
        if (almacen_Usuarios.autenticar(jugador)) {
            InterfazPartida interfazPartida = new InterfazPartida();
            interfazPartida.ponerDatosJugador1(new Jugador(nombre1, password1));
            interfazPartida.ponerDatosJugador2(new Jugador(nombre_rival.getText(), password2));
            interfazPartida.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "!Usuario y/o Contraseña rival incorrectos¡");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        salir = new javax.swing.JLabel();
        jlabel1 = new javax.swing.JLabel();
        nombre_rival = new javax.swing.JTextField();
        separador = new javax.swing.JSeparator();
        jlabel3 = new javax.swing.JLabel();
        password_rival = new javax.swing.JPasswordField();
        separador1 = new javax.swing.JSeparator();
        jlabel2 = new javax.swing.JLabel();
        jugar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setEnabled(false);
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        salir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        salir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        salir.setText("X");
        salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                salirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                salirMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                salirMousePressed(evt);
            }
        });
        panel.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        jlabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlabel1.setText("INTRODUCE EL NOMBRE DEL RIVAL:");
        panel.add(jlabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 240, 30));

        nombre_rival.setBorder(null);
        nombre_rival.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_rivalActionPerformed(evt);
            }
        });
        panel.add(nombre_rival, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 230, 30));

        separador.setForeground(new java.awt.Color(0, 0, 0));
        panel.add(separador, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 230, 20));

        jlabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlabel3.setText("INTRODUCE LA CONTRASEÑA DEL RIVAL:");
        panel.add(jlabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 240, 30));

        password_rival.setBorder(null);
        panel.add(password_rival, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 230, 30));

        separador1.setForeground(new java.awt.Color(0, 0, 0));
        panel.add(separador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 230, 40));

        jlabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.jpg"))); // NOI18N
        panel.add(jlabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 190, 250));

        jugar.setBackground(new java.awt.Color(0, 255, 0));
        jugar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jugar.setForeground(new java.awt.Color(255, 255, 255));
        jugar.setText("JUGAR");
        jugar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jugar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jugarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jugarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jugarMousePressed(evt);
            }
        });
        panel.add(jugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 100, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseEntered
        salir.setForeground(new Color(255, 0, 51));
    }//GEN-LAST:event_salirMouseEntered

    private void salirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseExited
        salir.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_salirMouseExited

    private void salirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMousePressed
        interfazJugador = new InterfazJugador();
        interfazJugador.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_salirMousePressed

    private void nombre_rivalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_rivalActionPerformed

    }//GEN-LAST:event_nombre_rivalActionPerformed

    private void jugarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jugarMouseEntered
        jugar.setBackground(new Color(20, 150, 20));
    }//GEN-LAST:event_jugarMouseEntered

    private void jugarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jugarMouseExited
        jugar.setBackground(new Color(0, 255, 0));
    }//GEN-LAST:event_jugarMouseExited

    private void jugarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jugarMousePressed
//        interfazPartida = new InterfazPartida();
//        interfazPartida.setVisible(true);
//        this.setVisible(false);
        
        iniciarPartida();
    }//GEN-LAST:event_jugarMousePressed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazElegirRival.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazElegirRival.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazElegirRival.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazElegirRival.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazElegirRival().setVisible(true);
            }
        });
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlabel1;
    private javax.swing.JLabel jlabel2;
    private javax.swing.JLabel jlabel3;
    private javax.swing.JButton jugar;
    private javax.swing.JTextField nombre_rival;
    private javax.swing.JPanel panel;
    private javax.swing.JPasswordField password_rival;
    private javax.swing.JLabel salir;
    private javax.swing.JSeparator separador;
    private javax.swing.JSeparator separador1;
    // End of variables declaration//GEN-END:variables
}