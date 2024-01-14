package interfaces;

import buscaminas.*;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class InterfazAdminInfoPartidas extends javax.swing.JFrame {

    Almacen_Partidas almacen_Partidas;
    private String nombre, password;
    
    DefaultTableModel modeloPartidas;
    
    public InterfazAdminInfoPartidas() {
        initComponents();
        this.setLocationRelativeTo(this);
        
        almacen_Partidas = new Almacen_Partidas("C:\\Users\\vcald\\Documents\\Buscaminas\\src\\ficheros\\listadoPartidas.txt");
        
        jScrollPane.getViewport().setBackground(Color.black);
        
        centrar();
        
        modeloPartidas = (DefaultTableModel) tablaPartidas.getModel();        
        
        insertarPartidas();
    }
    
    public void insertarAdmin(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
        
        nombreAdmin.setText(nombre);
    }
    
    public void insertarPartidas() {
        ArrayList<InfoPartidas> listaPartidas = almacen_Partidas.getDatos();
        
        for (InfoPartidas partida : listaPartidas) {
            modeloPartidas.addRow(new Object[]{partida.getIdPartida(), partida.getJugador_actual(), partida.getJugador_esperando(), partida.getMarcadorJ1(), partida.getMarcadorJ2()});
        }
    }
    
    public void centrar(){
        DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
        alinear.setHorizontalAlignment(SwingConstants.LEFT);
        
        tablaPartidas.getColumnModel().getColumn(0).setCellRenderer(alinear);
        tablaPartidas.getColumnModel().getColumn(1).setCellRenderer(alinear);
        tablaPartidas.getColumnModel().getColumn(2).setCellRenderer(alinear);
        tablaPartidas.getColumnModel().getColumn(3).setCellRenderer(alinear);
        tablaPartidas.getColumnModel().getColumn(4).setCellRenderer(alinear);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nombreAdmin = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        tablaPartidas = new javax.swing.JTable();
        mostrarTablero_Movimientos = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombreAdmin.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        nombreAdmin.setForeground(new java.awt.Color(255, 255, 255));
        nombreAdmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreAdmin.setText("ADMIN");
        jPanel1.add(nombreAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 250, 60));

        jScrollPane.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane.setForeground(new java.awt.Color(255, 255, 255));

        tablaPartidas.setBackground(new java.awt.Color(0, 0, 0));
        tablaPartidas.setForeground(new java.awt.Color(255, 255, 255));
        tablaPartidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Partida", "Jugador 1", "Jugador 2", "Marcador J1", "Marcador J2"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPartidas.getTableHeader().setResizingAllowed(false);
        jScrollPane.setViewportView(tablaPartidas);

        jPanel1.add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 87, 730, 320));

        mostrarTablero_Movimientos.setBackground(new java.awt.Color(0, 0, 0));
        mostrarTablero_Movimientos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mostrarTablero_Movimientos.setForeground(new java.awt.Color(255, 255, 255));
        mostrarTablero_Movimientos.setText("Mostrar Tablero y Movimientos");
        mostrarTablero_Movimientos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mostrarTablero_Movimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarTablero_MovimientosActionPerformed(evt);
            }
        });
        jPanel1.add(mostrarTablero_Movimientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 430, 320, 40));

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
        jPanel1.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, 140, 40));

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
        InterfazAdmin interfazAdmin= new InterfazAdmin();
        interfazAdmin.setVisible(true);
        interfazAdmin.insertarAdmin(nombre, password);

        this.setVisible(false);
    }//GEN-LAST:event_volverActionPerformed

    private void mostrarTablero_MovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarTablero_MovimientosActionPerformed
        try {
            almacen_Partidas.mostrarTableroYMovimientos();
        } catch (IOException e) {
            System.out.println("ERROR, " + e.getMessage());
        }
    }//GEN-LAST:event_mostrarTablero_MovimientosActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazAdminInfoPartidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazAdminInfoPartidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazAdminInfoPartidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazAdminInfoPartidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazAdminInfoPartidas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JButton mostrarTablero_Movimientos;
    private javax.swing.JLabel nombreAdmin;
    private javax.swing.JTable tablaPartidas;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}