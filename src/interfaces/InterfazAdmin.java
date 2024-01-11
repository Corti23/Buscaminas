package interfaces;

import buscaminas.*;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class InterfazAdmin extends javax.swing.JFrame {
    
    public static InterfazInicio interfazInicio;
    
    Almacen_Usuarios almacen_Usuarios;
    private String nombre;
    private String password;

    public InterfazAdmin() {
        initComponents();
        this.setLocationRelativeTo(this);
        
        almacen_Usuarios = new Almacen_Usuarios("C:\\Users\\vcald\\Documents\\Buscaminas\\src\\ficheros\\listadoJugadores.ser");
    }
    
    public void insertarAdmin(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
        
        nombreAdmin.setText(nombre);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nombreAdmin = new javax.swing.JLabel();
        alta = new javax.swing.JButton();
        altaFichero = new javax.swing.JButton();
        baja = new javax.swing.JButton();
        info_partidas = new javax.swing.JButton();
        cerrar_sesion = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombreAdmin.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        nombreAdmin.setForeground(new java.awt.Color(255, 255, 255));
        nombreAdmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreAdmin.setText("ADMIN");
        jPanel1.add(nombreAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 250, 70));

        alta.setBackground(new java.awt.Color(0, 0, 0));
        alta.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        alta.setForeground(new java.awt.Color(255, 255, 255));
        alta.setText("DAR DE ALTA");
        alta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        alta.setFocusPainted(false);
        alta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                altaMousePressed(evt);
            }
        });
        alta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altaActionPerformed(evt);
            }
        });
        jPanel1.add(alta, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 290, 60));

        altaFichero.setBackground(new java.awt.Color(0, 0, 0));
        altaFichero.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        altaFichero.setForeground(new java.awt.Color(255, 255, 255));
        altaFichero.setText("DAR DE ALTA CON FICHERO");
        altaFichero.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        altaFichero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                altaFicheroMousePressed(evt);
            }
        });
        altaFichero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altaFicheroActionPerformed(evt);
            }
        });
        jPanel1.add(altaFichero, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 290, 60));

        baja.setBackground(new java.awt.Color(0, 0, 0));
        baja.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        baja.setForeground(new java.awt.Color(255, 255, 255));
        baja.setText("DAR DE BAJA");
        baja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        baja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bajaActionPerformed(evt);
            }
        });
        jPanel1.add(baja, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 290, 60));

        info_partidas.setBackground(new java.awt.Color(0, 0, 0));
        info_partidas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        info_partidas.setForeground(new java.awt.Color(255, 255, 255));
        info_partidas.setText("INFO PARTIDAS");
        info_partidas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        info_partidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                info_partidasActionPerformed(evt);
            }
        });
        jPanel1.add(info_partidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 290, 60));

        cerrar_sesion.setBackground(new java.awt.Color(255, 0, 51));
        cerrar_sesion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cerrar_sesion.setForeground(new java.awt.Color(255, 255, 255));
        cerrar_sesion.setText("CERRAR SESIÓN");
        cerrar_sesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrar_sesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cerrar_sesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cerrar_sesionMouseExited(evt);
            }
        });
        cerrar_sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrar_sesionActionPerformed(evt);
            }
        });
        jPanel1.add(cerrar_sesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, 290, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void altaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_altaMousePressed

    }//GEN-LAST:event_altaMousePressed

    private void altaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altaActionPerformed
        String nombre, password;
   
        nombre = JOptionPane.showInputDialog("Introduce el nombre del jugador:");
        password = JOptionPane.showInputDialog("Introduce la contraseña del jugador:");

        try {            
            if (!almacen_Usuarios.existe(new Jugador(nombre, password)) && nombre != null && password != null) {
                almacen_Usuarios.alta(new Jugador(nombre, password));
                JOptionPane.showMessageDialog(null, "El jugador se ha registrado con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "ERROR, el jugador ya estaba registrado, prueba con otro.");
            }
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_altaActionPerformed

    private void altaFicheroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altaFicheroActionPerformed

    }//GEN-LAST:event_altaFicheroActionPerformed

    private void bajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bajaActionPerformed
        String nombre, password;
   
        nombre = JOptionPane.showInputDialog("Introduce el nombre del jugador:");

        Jugador jugador = new Jugador(nombre, "");
        
        try {            
            if (almacen_Usuarios.existe(jugador) && nombre != null) {                
                almacen_Usuarios.baja(jugador);
                JOptionPane.showMessageDialog(null, "El jugador se ha eliminado con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "ERROR, el jugador no estaba registrado, prueba con otro.");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_bajaActionPerformed

    private void cerrar_sesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrar_sesionMouseEntered
        cerrar_sesion.setBackground(new Color(255, 102, 102));
    }//GEN-LAST:event_cerrar_sesionMouseEntered

    private void cerrar_sesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrar_sesionMouseExited
        cerrar_sesion.setBackground(new Color(255, 0, 51));
    }//GEN-LAST:event_cerrar_sesionMouseExited

    private void cerrar_sesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrar_sesionActionPerformed
        interfazInicio = new InterfazInicio();
        interfazInicio.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_cerrar_sesionActionPerformed

    private void info_partidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_info_partidasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_info_partidasActionPerformed

    private void altaFicheroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_altaFicheroMousePressed
        JFileChooser seleccionarFichero = new JFileChooser();
        seleccionarFichero.showOpenDialog(seleccionarFichero);
        
        String fichero = seleccionarFichero.getSelectedFile().getAbsolutePath();
        
        try {
            almacen_Usuarios.cargarListado(new File(fichero));
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }//GEN-LAST:event_altaFicheroMousePressed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alta;
    private javax.swing.JButton altaFichero;
    private javax.swing.JButton baja;
    private javax.swing.JButton cerrar_sesion;
    private javax.swing.JButton info_partidas;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nombreAdmin;
    // End of variables declaration//GEN-END:variables
}