package interfaces;

import buscaminas.*;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class InterfazPerfil extends javax.swing.JFrame {
    
    Almacen_Usuarios almacen_Usuarios;
    Almacen_Estadisticas almacen_Estadisticas;
    private String nombre1, password1;
    
    public InterfazPerfil() {
        initComponents();
        this.setLocationRelativeTo(this);
        
        almacen_Usuarios = new Almacen_Usuarios("C:\\Users\\vcald\\Documents\\Buscaminas\\src\\ficheros\\listadoJugadores.ser");
        almacen_Estadisticas = new Almacen_Estadisticas("C:\\Users\\vcald\\Documents\\Buscaminas\\src\\ficheros\\listadoEstadisticas.ser");
    }
    
    public void insertarJugador1(String nombre, String password) {
        this.nombre1 = nombre;
        this.password1 = password;
        
        nombreJugador.setText("Perfil de " + nombre1);
        
        ArrayList<Estadisticas> listaEstadisticas = almacen_Estadisticas.getDatos();
            
        for (Estadisticas estadisticas : listaEstadisticas) {
            if (estadisticas.getNombreJugador().equals(nombre1)) {
                jugadas.setText(String.valueOf(estadisticas.getJugadas()));
                ganadas.setText(String.valueOf(estadisticas.getGanadas()));
                perdidas.setText(String.valueOf(estadisticas.getPerdidas()));
                minas_encontradas.setText(String.valueOf(estadisticas.getMinas_a_favor()));
                minas_rival.setText(String.valueOf(estadisticas.getMinas_en_contra()));
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nombreJugador = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jugadas = new javax.swing.JLabel();
        ganadas = new javax.swing.JLabel();
        perdidas = new javax.swing.JLabel();
        minas_encontradas = new javax.swing.JLabel();
        minas_rival = new javax.swing.JLabel();
        comparar_rival = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setMinimumSize(new java.awt.Dimension(868, 478));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombreJugador.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        nombreJugador.setForeground(new java.awt.Color(255, 255, 255));
        nombreJugador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreJugador.setText("PERFIL DE JUGADOR");
        jPanel1.add(nombreJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 300, 70));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PARTIDAS JUGADAS:");
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 390, 40));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PARTIDAS GANADAS:");
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 390, 40));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("PARTIDAS PERDIDAS:");
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 390, 40));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("MINAS ENCONTRADAS:");
        jLabel5.setOpaque(true);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 390, 40));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("MINAS ENCONTRADAS POR RIVALES:");
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 390, 40));

        jugadas.setBackground(new java.awt.Color(0, 0, 0));
        jugadas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jugadas.setForeground(new java.awt.Color(255, 255, 255));
        jugadas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jugadas.setText("0");
        jugadas.setOpaque(true);
        jPanel1.add(jugadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 390, 40));

        ganadas.setBackground(new java.awt.Color(0, 0, 0));
        ganadas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ganadas.setForeground(new java.awt.Color(255, 255, 255));
        ganadas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ganadas.setText("0");
        ganadas.setOpaque(true);
        jPanel1.add(ganadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 390, 40));

        perdidas.setBackground(new java.awt.Color(0, 0, 0));
        perdidas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        perdidas.setForeground(new java.awt.Color(255, 255, 255));
        perdidas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        perdidas.setText("0");
        perdidas.setOpaque(true);
        jPanel1.add(perdidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 390, 40));

        minas_encontradas.setBackground(new java.awt.Color(0, 0, 0));
        minas_encontradas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        minas_encontradas.setForeground(new java.awt.Color(255, 255, 255));
        minas_encontradas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minas_encontradas.setText("0");
        minas_encontradas.setOpaque(true);
        jPanel1.add(minas_encontradas, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, 390, 40));

        minas_rival.setBackground(new java.awt.Color(0, 0, 0));
        minas_rival.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        minas_rival.setForeground(new java.awt.Color(255, 255, 255));
        minas_rival.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minas_rival.setText("0");
        minas_rival.setOpaque(true);
        jPanel1.add(minas_rival, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 310, 390, 40));

        comparar_rival.setBackground(new java.awt.Color(0, 0, 0));
        comparar_rival.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        comparar_rival.setForeground(new java.awt.Color(255, 255, 255));
        comparar_rival.setText("COMPARAR CON RIVAL");
        comparar_rival.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comparar_rival.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comparar_rivalActionPerformed(evt);
            }
        });
        jPanel1.add(comparar_rival, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, 250, 60));

        volver.setBackground(new java.awt.Color(255, 0, 51));
        volver.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        volver.setForeground(new java.awt.Color(255, 255, 255));
        volver.setText("VOLVER");
        volver.setBorderPainted(false);
        volver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        volver.setFocusPainted(false);
        volver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                volverMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                volverMouseExited(evt);
            }
        });
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        jPanel1.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 250, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 490));

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

    private void comparar_rivalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comparar_rivalActionPerformed
        String nombre = JOptionPane.showInputDialog("Introduce el nombre del jugador:");
        
        if (almacen_Estadisticas.existe(new Estadisticas(nombre, 0, 0, 0, 0, 0)) && nombre != null && !nombre1.equals(nombre)) {
            InterfazPerfilRival interfazPerfilRival = new InterfazPerfilRival();
            interfazPerfilRival.setVisible(true);
            interfazPerfilRival.escribirJugador1(nombre1, password1);
            interfazPerfilRival.escribirJugador2(nombre, "");
            
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "ERROR, el jugador no está registrado, prueba con otro.");
        }
    }//GEN-LAST:event_comparar_rivalActionPerformed

    private void volverMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverMouseEntered
        volver.setBackground(new Color(255, 102, 102));
    }//GEN-LAST:event_volverMouseEntered

    private void volverMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverMouseExited
        volver.setBackground(new Color(255, 0, 51));
    }//GEN-LAST:event_volverMouseExited

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        InterfazJugador interfazJugador= new InterfazJugador();
        interfazJugador.setVisible(true);
        interfazJugador.insertarJugador(nombre1, password1);
        
        this.setVisible(false);
    }//GEN-LAST:event_volverActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazPerfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton comparar_rival;
    private javax.swing.JLabel ganadas;
    private javax.swing.JButton iniciar_sesion;
    private javax.swing.JButton iniciar_sesion1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jugadas;
    private javax.swing.JLabel minas_encontradas;
    private javax.swing.JLabel minas_rival;
    private javax.swing.JLabel nombreJugador;
    private javax.swing.JLabel perdidas;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}