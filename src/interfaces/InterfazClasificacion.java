package interfaces;

import buscaminas.*;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class InterfazClasificacion extends javax.swing.JFrame {

    Almacen_Usuarios almacen_Usuarios;
    Almacen_Estadisticas almacen_Estadisticas;
    private String nombre1, password1;
    
    DefaultTableModel modeloNombre;
    DefaultTableModel modeloVictorias;
            
    public InterfazClasificacion() {
        initComponents();
        this.setLocationRelativeTo(this);
        
        almacen_Usuarios = new Almacen_Usuarios("ficheros\\listadoJugadores.ser");
        almacen_Estadisticas = new Almacen_Estadisticas("ficheros\\listadoEstadisticas.ser");
        
        jScrollPane1.getViewport().setBackground(Color.black);
        jScrollPane2.getViewport().setBackground(Color.black);
        
        centrar();
        
        modeloNombre = (DefaultTableModel) tablaNombres.getModel();
        modeloVictorias = (DefaultTableModel) tablaVictorias.getModel();
        
        insertarClasificacionNombre();
        insertarClasificacionVictorias();
    }
    
    public void insertarJugador1(String nombre, String password) {
        this.nombre1 = nombre;
        this.password1 = password;
    }
    
    public void insertarClasificacionNombre() {
        ArrayList<Estadisticas> listaOrdenadaNombre = almacen_Usuarios.clasificacionPorNombre();
        ArrayList<Estadisticas> listaEstadisticas = almacen_Estadisticas.getDatos();
        
        for (Estadisticas jugador : listaOrdenadaNombre) {
            for (Estadisticas estadistica : listaEstadisticas) {
                if (estadistica.getNombreJugador().equals(jugador.getNombreJugador())) {
                    modeloNombre.addRow(new Object[]{jugador.getNombreJugador(), estadistica.getJugadas(), estadistica.getGanadas(), estadistica.getPerdidas(), estadistica.getMinas_a_favor(), estadistica.getMinas_en_contra()});
                }
            }
        }
    }
    
    public void insertarClasificacionVictorias() {
        ArrayList<Estadisticas> listaOrdenadaVictorias = almacen_Usuarios.clasificacionPorVictorias();
        ArrayList<Estadisticas> listaEstadisticas = almacen_Estadisticas.getDatos();
        
        for (Estadisticas estadistica : listaOrdenadaVictorias) {
            for (Estadisticas jugador : listaEstadisticas) {
                if (jugador.getNombreJugador().equals(estadistica.getNombreJugador())) {
                    modeloVictorias.addRow(new Object[]{jugador.getNombreJugador(), estadistica.getJugadas(), estadistica.getGanadas(), estadistica.getPerdidas(), estadistica.getMinas_a_favor(), estadistica.getMinas_en_contra()});
                }
            }
        }
    }
    
    public void centrar(){
        DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
        alinear.setHorizontalAlignment(SwingConstants.LEFT);
        
        tablaVictorias.getColumnModel().getColumn(0).setCellRenderer(alinear);
        tablaVictorias.getColumnModel().getColumn(1).setCellRenderer(alinear);
        tablaVictorias.getColumnModel().getColumn(2).setCellRenderer(alinear);
        tablaVictorias.getColumnModel().getColumn(3).setCellRenderer(alinear);
        tablaVictorias.getColumnModel().getColumn(4).setCellRenderer(alinear);
        tablaVictorias.getColumnModel().getColumn(5).setCellRenderer(alinear);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        clasificacion = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaVictorias = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaNombres = new javax.swing.JTable();
        volver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        clasificacion.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        clasificacion.setForeground(new java.awt.Color(255, 255, 255));
        clasificacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clasificacion.setText("CLASIFICACIÓN");
        jPanel1.add(clasificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 210, 40));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));

        tablaVictorias.setBackground(new java.awt.Color(0, 0, 0));
        tablaVictorias.setForeground(new java.awt.Color(255, 255, 255));
        tablaVictorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jugador", "Jugadas", "Ganadas", "Perdidas", "Minas encontradas", "Minas rival"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaVictorias.getTableHeader().setResizingAllowed(false);
        jScrollPane2.setViewportView(tablaVictorias);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("VICTORIAS", jPanel3);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        tablaNombres.setBackground(new java.awt.Color(0, 0, 0));
        tablaNombres.setForeground(new java.awt.Color(255, 255, 255));
        tablaNombres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jugador", "Jugadas", "Ganadas", "Perdidas", "Minas encontradas", "Minas rival"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaNombres.getTableHeader().setResizingAllowed(false);
        jScrollPane1.setViewportView(tablaNombres);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("NOMBRE", jPanel2);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 630, 340));

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
        jPanel1.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 430, 150, 40));

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
        InterfazJugador interfazJugador = new InterfazJugador();
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
            java.util.logging.Logger.getLogger(InterfazClasificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazClasificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazClasificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazClasificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazClasificacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel clasificacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tablaNombres;
    private javax.swing.JTable tablaVictorias;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}