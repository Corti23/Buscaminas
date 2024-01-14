package interfaces;

import buscaminas.*;
import java.awt.Color;
import java.util.ArrayList;

public class InterfazPerfilRival extends javax.swing.JFrame {

    Almacen_Usuarios almacen_Usuarios;
    Almacen_ComprobarRival almacen_ComprobarRival;
    private String nombre1, password1, nombre2, password2;
    
    public InterfazPerfilRival() {
        initComponents();
        this.setLocationRelativeTo(this);
        
        almacen_Usuarios = new Almacen_Usuarios("ficheros\\listadoJugadores.ser");
        almacen_ComprobarRival = new Almacen_ComprobarRival("ficheros\\listadoEstadisticasRivales.ser");
    }
    
    public void escribirJugador1(String nombre, String password) {
        this.nombre1 = nombre;
        this.password1 = password;
        
        nombreJugador1.setText(nombre1);
        nombreJugador1.setForeground(new Color(0, 204, 204));
    }
    
    public void escribirJugador2(String nombre, String password) {
        this.nombre2 = nombre;
        this.password2 = password;
        
        nombreJugador2.setText(nombre2);
        nombreJugador2.setForeground(new Color(255, 102, 102));
        
        insertarJugador1();
        insertarJugador2();
        cambiarFondos();
    }
    
    public void insertarJugador1() {
        ArrayList<Estadisticas> listaEstadisticas = almacen_ComprobarRival.getDatos();
        
        String nombre = nombre1 + nombre2;
            
        for (Estadisticas estadisticas : listaEstadisticas) {
            if (estadisticas.getNombreJugador().equals(nombre)) {
                jugadasJ1.setText(String.valueOf(estadisticas.getJugadas()));
                ganadasJ1.setText(String.valueOf(estadisticas.getGanadas()));
                perdidasJ1.setText(String.valueOf(estadisticas.getPerdidas()));
                minas_encontradasJ1.setText(String.valueOf(estadisticas.getMinas_a_favor()));
                minas_rivalJ1.setText(String.valueOf(estadisticas.getMinas_en_contra()));
            }
        }
    }
    
    public void insertarJugador2() {
        ArrayList<Estadisticas> listaEstadisticas = almacen_ComprobarRival.getDatos();
            
        String nombre = nombre2 + nombre1;
               
        for (Estadisticas estadisticas : listaEstadisticas) {
            if (estadisticas.getNombreJugador().equals(nombre)) {
                jugadasJ2.setText(String.valueOf(estadisticas.getJugadas()));
                ganadasJ2.setText(String.valueOf(estadisticas.getGanadas()));
                perdidasJ2.setText(String.valueOf(estadisticas.getPerdidas()));
                minas_encontradasJ2.setText(String.valueOf(estadisticas.getMinas_a_favor()));
                minas_rivalJ2.setText(String.valueOf(estadisticas.getMinas_en_contra()));
            }
        }
    }
    
    public void cambiarFondos() {
        jugadasJ1.setBackground(new Color(0, 204, 204));
        ganadasJ1.setBackground(new Color(0, 204, 204));
        perdidasJ1.setBackground(new Color(0, 204, 204));
        minas_encontradasJ1.setBackground(new Color(0, 204, 204));
        minas_rivalJ1.setBackground(new Color(0, 204, 204));
        
        jugadasJ2.setBackground(new Color(255, 102, 102));
        ganadasJ2.setBackground(new Color(255, 102, 102));
        perdidasJ2.setBackground(new Color(255, 102, 102));
        minas_encontradasJ2.setBackground(new Color(255, 102, 102));
        minas_rivalJ2.setBackground(new Color(255, 102, 102));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nombreJugador1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombreJugador2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jugadasJ1 = new javax.swing.JLabel();
        ganadasJ1 = new javax.swing.JLabel();
        perdidasJ1 = new javax.swing.JLabel();
        minas_encontradasJ1 = new javax.swing.JLabel();
        minas_rivalJ1 = new javax.swing.JLabel();
        jugadasJ2 = new javax.swing.JLabel();
        ganadasJ2 = new javax.swing.JLabel();
        perdidasJ2 = new javax.swing.JLabel();
        minas_encontradasJ2 = new javax.swing.JLabel();
        minas_rivalJ2 = new javax.swing.JLabel();
        volver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(868, 487));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombreJugador1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        nombreJugador1.setForeground(new java.awt.Color(255, 255, 255));
        nombreJugador1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreJugador1.setText("JUGADOR1");
        jPanel1.add(nombreJugador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 210, 100));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("VS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 100, 100));

        nombreJugador2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        nombreJugador2.setForeground(new java.awt.Color(255, 255, 255));
        nombreJugador2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreJugador2.setText("JUGADOR2");
        jPanel1.add(nombreJugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 240, 100));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PARTIDAS JUGADAS:");
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 390, 40));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("PARTIDAS GANADAS:");
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 390, 40));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("PARTIDAS PERDIDAS:");
        jLabel5.setOpaque(true);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 390, 40));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("MINAS ENCONTRADAS:");
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 390, 40));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("MINAS ENCONTRADAS POR RIVALES:");
        jLabel7.setOpaque(true);
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 390, 40));

        jugadasJ1.setBackground(new java.awt.Color(0, 0, 0));
        jugadasJ1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jugadasJ1.setForeground(new java.awt.Color(255, 255, 255));
        jugadasJ1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jugadasJ1.setText("0");
        jugadasJ1.setOpaque(true);
        jPanel1.add(jugadasJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 200, 40));

        ganadasJ1.setBackground(new java.awt.Color(0, 0, 0));
        ganadasJ1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ganadasJ1.setForeground(new java.awt.Color(255, 255, 255));
        ganadasJ1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ganadasJ1.setText("0");
        ganadasJ1.setOpaque(true);
        jPanel1.add(ganadasJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 200, 40));

        perdidasJ1.setBackground(new java.awt.Color(0, 0, 0));
        perdidasJ1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        perdidasJ1.setForeground(new java.awt.Color(255, 255, 255));
        perdidasJ1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        perdidasJ1.setText("0");
        perdidasJ1.setOpaque(true);
        jPanel1.add(perdidasJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 200, 40));

        minas_encontradasJ1.setBackground(new java.awt.Color(0, 0, 0));
        minas_encontradasJ1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        minas_encontradasJ1.setForeground(new java.awt.Color(255, 255, 255));
        minas_encontradasJ1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minas_encontradasJ1.setText("0");
        minas_encontradasJ1.setOpaque(true);
        jPanel1.add(minas_encontradasJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, 200, 40));

        minas_rivalJ1.setBackground(new java.awt.Color(0, 0, 0));
        minas_rivalJ1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        minas_rivalJ1.setForeground(new java.awt.Color(255, 255, 255));
        minas_rivalJ1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minas_rivalJ1.setText("0");
        minas_rivalJ1.setOpaque(true);
        jPanel1.add(minas_rivalJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 310, 200, 40));

        jugadasJ2.setBackground(new java.awt.Color(0, 0, 0));
        jugadasJ2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jugadasJ2.setForeground(new java.awt.Color(255, 255, 255));
        jugadasJ2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jugadasJ2.setText("0");
        jugadasJ2.setOpaque(true);
        jPanel1.add(jugadasJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 150, 200, 40));

        ganadasJ2.setBackground(new java.awt.Color(0, 0, 0));
        ganadasJ2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ganadasJ2.setForeground(new java.awt.Color(255, 255, 255));
        ganadasJ2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ganadasJ2.setText("0");
        ganadasJ2.setOpaque(true);
        jPanel1.add(ganadasJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 190, 200, 40));

        perdidasJ2.setBackground(new java.awt.Color(0, 0, 0));
        perdidasJ2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        perdidasJ2.setForeground(new java.awt.Color(255, 255, 255));
        perdidasJ2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        perdidasJ2.setText("0");
        perdidasJ2.setOpaque(true);
        jPanel1.add(perdidasJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 230, 200, 40));

        minas_encontradasJ2.setBackground(new java.awt.Color(0, 0, 0));
        minas_encontradasJ2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        minas_encontradasJ2.setForeground(new java.awt.Color(255, 255, 255));
        minas_encontradasJ2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minas_encontradasJ2.setText("0");
        minas_encontradasJ2.setOpaque(true);
        jPanel1.add(minas_encontradasJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 270, 200, 40));

        minas_rivalJ2.setBackground(new java.awt.Color(0, 0, 0));
        minas_rivalJ2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        minas_rivalJ2.setForeground(new java.awt.Color(255, 255, 255));
        minas_rivalJ2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minas_rivalJ2.setText("0");
        minas_rivalJ2.setOpaque(true);
        jPanel1.add(minas_rivalJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 310, 200, 40));

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
        jPanel1.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, 250, 60));

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

    private void volverMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverMouseEntered
        volver.setBackground(new Color(255, 102, 102));
    }//GEN-LAST:event_volverMouseEntered

    private void volverMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverMouseExited
        volver.setBackground(new Color(255, 0, 51));
    }//GEN-LAST:event_volverMouseExited

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        InterfazPerfil interfazPerfil = new InterfazPerfil();
        interfazPerfil.setVisible(true);
        interfazPerfil.insertarJugador1(nombre1, password1);

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
            java.util.logging.Logger.getLogger(InterfazPerfilRival.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazPerfilRival.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazPerfilRival.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazPerfilRival.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazPerfilRival().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ganadasJ1;
    private javax.swing.JLabel ganadasJ2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jugadasJ1;
    private javax.swing.JLabel jugadasJ2;
    private javax.swing.JLabel minas_encontradasJ1;
    private javax.swing.JLabel minas_encontradasJ2;
    private javax.swing.JLabel minas_rivalJ1;
    private javax.swing.JLabel minas_rivalJ2;
    private javax.swing.JLabel nombreJugador1;
    private javax.swing.JLabel nombreJugador2;
    private javax.swing.JLabel perdidasJ1;
    private javax.swing.JLabel perdidasJ2;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}