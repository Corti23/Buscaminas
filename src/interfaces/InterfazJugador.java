package interfaces;

import java.awt.Color;

public class InterfazJugador extends javax.swing.JFrame {
    
    public static InterfazPartida interfazPartida;
    public static InterfazElegirRival interfazElegirRival;
    public static InterfazInicio interfazInicio;
    public static InterfazPerfil interfazPerfil;
    public static InterfazClasificacion interfazClasificacion;
    
    private String nombre;
    private String password;

    public InterfazJugador() {
        initComponents();
        this.setLocationRelativeTo(this);
    }
    
    public void insertarJugador(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
        
        nombreJugador.setText(nombre);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nombreJugador = new javax.swing.JLabel();
        iniciar_partida = new javax.swing.JButton();
        perfil = new javax.swing.JButton();
        clasificacion = new javax.swing.JButton();
        cerrar_sesion = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombreJugador.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        nombreJugador.setForeground(new java.awt.Color(255, 255, 255));
        nombreJugador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreJugador.setText("JUGADOR");
        jPanel1.add(nombreJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 250, 70));

        iniciar_partida.setBackground(new java.awt.Color(0, 0, 0));
        iniciar_partida.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        iniciar_partida.setForeground(new java.awt.Color(255, 255, 255));
        iniciar_partida.setText("INICIAR PARTIDA");
        iniciar_partida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iniciar_partida.setFocusPainted(false);
        iniciar_partida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                iniciar_partidaMousePressed(evt);
            }
        });
        iniciar_partida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciar_partidaActionPerformed(evt);
            }
        });
        jPanel1.add(iniciar_partida, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 250, 60));

        perfil.setBackground(new java.awt.Color(0, 0, 0));
        perfil.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        perfil.setForeground(new java.awt.Color(255, 255, 255));
        perfil.setText("PERFIL");
        perfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        perfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfilActionPerformed(evt);
            }
        });
        jPanel1.add(perfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 250, 60));

        clasificacion.setBackground(new java.awt.Color(0, 0, 0));
        clasificacion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        clasificacion.setForeground(new java.awt.Color(255, 255, 255));
        clasificacion.setText("CLASIFICACIÓN");
        clasificacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clasificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clasificacionActionPerformed(evt);
            }
        });
        jPanel1.add(clasificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 250, 60));

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
        jPanel1.add(cerrar_sesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 250, 60));

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

    private void iniciar_partidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciar_partidaActionPerformed
        interfazElegirRival = new InterfazElegirRival();
        interfazElegirRival.setVisible(true);
        interfazElegirRival.insertarJugador1(nombre, password);
        
        this.setVisible(false);
    }//GEN-LAST:event_iniciar_partidaActionPerformed

    private void perfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfilActionPerformed
        interfazPerfil = new InterfazPerfil();
        interfazPerfil.setVisible(true);
        interfazPerfil.insertarJugador1(nombre, password);
        
        this.setVisible(false);
    }//GEN-LAST:event_perfilActionPerformed

    private void clasificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clasificacionActionPerformed
        interfazClasificacion = new InterfazClasificacion();
        interfazClasificacion.setVisible(true);
        interfazClasificacion.insertarJugador1(nombre, password);
        
        this.setVisible(false);
    }//GEN-LAST:event_clasificacionActionPerformed

    private void cerrar_sesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrar_sesionActionPerformed
        interfazInicio = new InterfazInicio();
        interfazInicio.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_cerrar_sesionActionPerformed

    private void cerrar_sesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrar_sesionMouseEntered
        cerrar_sesion.setBackground(new Color(255, 102, 102));
    }//GEN-LAST:event_cerrar_sesionMouseEntered

    private void cerrar_sesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrar_sesionMouseExited
        cerrar_sesion.setBackground(new Color(255, 0, 51));
    }//GEN-LAST:event_cerrar_sesionMouseExited

    private void iniciar_partidaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iniciar_partidaMousePressed
        
    }//GEN-LAST:event_iniciar_partidaMousePressed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazJugador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cerrar_sesion;
    private javax.swing.JButton clasificacion;
    private javax.swing.JButton iniciar_partida;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nombreJugador;
    private javax.swing.JButton perfil;
    // End of variables declaration//GEN-END:variables
}
