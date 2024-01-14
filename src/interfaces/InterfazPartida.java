package interfaces;

import buscaminas.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Consumer;
import javax.swing.*;

public class InterfazPartida extends javax.swing.JFrame {
    
    public static InterfazElegirRival interfazElegirRival;
    public static InterfazJugador interfazJugador;
    InterfazPartida interfazPartida = this;
    
    private Jugador jugador_actual;
    private Jugador jugador_esperando;

    Tablero tablero;
    JButton[][] casillas;
    
    Partida partida;
    Marcador marcador;
    Movimiento movimiento;
    
    String tableroDescubierto = "";
    String movimientosPartida = "";
    
    Almacen_Partidas almacen_Partidas;
    Almacen_Estadisticas almacen_Estadisticas;
    Almacen_ComprobarRival almacen_ComprobarRival;
  
    private int contadorPartidas = 1;
    int contador = 0;
    
    public InterfazPartida() {
        initComponents();
        this.setLocationRelativeTo(this);
        
        almacen_Partidas = new Almacen_Partidas("listadoPartidas.txt");
        almacen_Estadisticas = new Almacen_Estadisticas("listadoEstadisticas.ser");
        almacen_ComprobarRival = new Almacen_ComprobarRival("listadoEstadisticasRivales.ser");
        
        crearCasillas();
        crearTablero();
        
        ArrayList<InfoPartidas> listaPartidas = almacen_Partidas.getDatos();
        
        for (InfoPartidas p : listaPartidas) {
            if (p.getIdPartida() >= 1) {
                contadorPartidas = p.getIdPartida() + 1;
            }
        }
        
        partida = new Partida(jugador_actual, jugador_esperando);
        marcador = new Marcador(0, 0);
        partida.jugar();
        
        if (partida.getTurno()) {
            jugador1.setForeground(new Color(0, 204, 204));
        }
    }
    
    public void ponerDatosJugador1(Jugador jugador) {
        this.jugador_actual = jugador;
        jugador1.setText(jugador.getNombre());
    }
    
    public void ponerDatosJugador2(Jugador jugador) {
        this.jugador_esperando = jugador;
        jugador2.setText(jugador.getNombre());
    }
    
    public void crearTablero() {
        tablero = new Tablero();
        tableroDescubierto = tablero.mostrarTablero();
        
        tablero.setCasillaMinaSeleccionada(new Consumer<Casilla>() {
            @Override
            public void accept(Casilla t) {
                casillas[t.getCoordenadaX()][t.getCoordenadaY()].setEnabled(false);
                casillas[t.getCoordenadaX()][t.getCoordenadaY()].setForeground(Color.black);
                casillas[t.getCoordenadaX()][t.getCoordenadaY()].setText("*");
                 
                if (partida.getTurno()) {
                    int marcador1 = marcador.getPuntos_J1();
                    marcador1++;
                    marcador.setPuntos_J1(marcador1);
                    marcador_J1.setText(String.valueOf(marcador.getPuntos_J1()));
                    
                    movimientosPartida = movimientosPartida + jugador1.getText() + " " + t.getCoordenadaX() + " " + t.getCoordenadaY() + " / ";
                    movimientosJ1.append(jugador1.getText() + " " + t.getCoordenadaX() + " " + t.getCoordenadaY() + "\n");
                    
                    if (marcador.getPuntos_J1() == 26) {
                        JOptionPane.showMessageDialog(null, "¡ENHORABUENA!, " + jugador1.getText() + " has ganado la partida.");
                        
                        try {
                            almacen_Estadisticas.actualizar(new Estadisticas(jugador_actual.getNombre(), 1, 1, 0, marcador.getPuntos_J1(), marcador.getPuntos_J2()));
                            almacen_Estadisticas.actualizar(new Estadisticas(jugador_esperando.getNombre(), 1, 0, 1, marcador.getPuntos_J2(), marcador.getPuntos_J1()));
                        } catch (IOException e) {
                            System.out.println("ERROR, " + e.getMessage());
                        } catch (ClassNotFoundException e) {
                            System.out.println("ERROR, " + e.getMessage());
                        }
                        
                        try {
                            if (almacen_ComprobarRival.existe(new Estadisticas(jugador_actual.getNombre() + jugador_esperando.getNombre(), 0, 0, 0, 0, 0)) && almacen_ComprobarRival.existe(new Estadisticas(jugador_esperando.getNombre() + jugador_actual.getNombre(), 0, 0, 0, 0, 0))) {
                                almacen_ComprobarRival.actualizar(new Estadisticas(jugador_actual.getNombre() + jugador_esperando.getNombre(), 1, 1, 0, marcador.getPuntos_J1(), marcador.getPuntos_J2()));
                                almacen_ComprobarRival.actualizar(new Estadisticas(jugador_esperando.getNombre() + jugador_actual.getNombre(), 1, 0, 1, marcador.getPuntos_J2(), marcador.getPuntos_J1()));
                            } else {
                                almacen_ComprobarRival.crearEstadisticasRival(new Estadisticas(jugador_actual.getNombre() + jugador_esperando.getNombre(), 1, 1, 0, marcador.getPuntos_J1(), marcador.getPuntos_J2()));
                                almacen_ComprobarRival.crearEstadisticasRival(new Estadisticas(jugador_esperando.getNombre() + jugador_actual.getNombre(), 1, 0, 1, marcador.getPuntos_J2(), marcador.getPuntos_J1()));
                            }                            
                        } catch (IOException e) {
                            System.out.println("ERROR, " + e.getMessage());
                        } catch (ClassNotFoundException e) {
                            System.out.println("ERROR, " + e.getMessage());
                        }
                        
                        try {
                            String nombreJugadorActual = jugador_actual.getNombre();
                            String nombreJugadorEsperando = jugador_esperando.getNombre();
                            int marcadorJugadorActual = marcador.getPuntos_J1();
                            int marcadorJugadorEsperando = marcador.getPuntos_J2();
                            
                            almacen_Partidas.almacenarPartida(new InfoPartidas(nombreJugadorActual, nombreJugadorEsperando, contadorPartidas, marcadorJugadorActual, marcadorJugadorEsperando, tableroDescubierto, movimientosPartida));
                        } catch (IOException e) {
                            System.out.println("ERROR, " + e.getMessage());
                        }
                        
                        interfazJugador = new InterfazJugador();
                        interfazJugador.setVisible(true);
                        interfazJugador.insertarJugador(jugador_actual.getNombre(), jugador_actual.getPassword());
                        
                        interfazPartida.setVisible(false);
                    }
                } else {
                    int marcador2 = marcador.getPuntos_J2();
                    marcador2++;
                    marcador.setPuntos_J2(marcador2);
                    marcador_J2.setText(String.valueOf(marcador.getPuntos_J2()));
                    
                    movimientosPartida = movimientosPartida + jugador2.getText() + " " + t.getCoordenadaX() + " " + t.getCoordenadaY() + " / ";
                    movimientosJ2.append(jugador2.getText() + " " + t.getCoordenadaX() + " " + t.getCoordenadaY() + "\n");
                    
                    if (marcador.getPuntos_J2() == 26) {
                        JOptionPane.showMessageDialog(null, "¡ENHORABUENA!, " + jugador2.getText() + " has ganado la partida.");
                        
                        try {
                            almacen_Estadisticas.actualizar(new Estadisticas(jugador_actual.getNombre(), 1, 0, 1, marcador.getPuntos_J1(), marcador.getPuntos_J2()));
                            almacen_Estadisticas.actualizar(new Estadisticas(jugador_esperando.getNombre(), 1, 1, 0, marcador.getPuntos_J2(), marcador.getPuntos_J1()));
                        } catch (IOException e) {
                            System.out.println("ERROR, " + e.getMessage());
                        } catch (ClassNotFoundException e) {
                            System.out.println("ERROR, " + e.getMessage());
                        }
                        
                        try {
                            if (almacen_ComprobarRival.existe(new Estadisticas(jugador_actual.getNombre() + jugador_esperando.getNombre(), 0, 0, 0, 0, 0)) && almacen_ComprobarRival.existe(new Estadisticas(jugador_esperando.getNombre() + jugador_actual.getNombre(), 0, 0, 0, 0, 0))) {
                                almacen_ComprobarRival.actualizar(new Estadisticas(jugador_esperando.getNombre() + jugador_actual.getNombre(), 1, 1, 0, marcador.getPuntos_J2(), marcador.getPuntos_J1()));
                                almacen_ComprobarRival.actualizar(new Estadisticas(jugador_actual.getNombre() + jugador_esperando.getNombre(), 1, 0, 1, marcador.getPuntos_J1(), marcador.getPuntos_J2()));
                            } else {
                                almacen_ComprobarRival.crearEstadisticasRival(new Estadisticas(jugador_esperando.getNombre() + jugador_actual.getNombre(), 1, 1, 0, marcador.getPuntos_J2(), marcador.getPuntos_J1()));
                                almacen_ComprobarRival.crearEstadisticasRival(new Estadisticas(jugador_actual.getNombre() + jugador_esperando.getNombre(), 1, 0, 1, marcador.getPuntos_J1(), marcador.getPuntos_J2()));
                            }                            
                        } catch (IOException e) {
                            System.out.println("ERROR, " + e.getMessage());
                        } catch (ClassNotFoundException e) {
                            System.out.println("ERROR, " + e.getMessage());
                        }
                        
                        try {
                            String nombreJugadorActual = jugador_actual.getNombre();
                            String nombreJugadorEsperando = jugador_esperando.getNombre();
                            int marcadorJugadorActual = marcador.getPuntos_J1();
                            int marcadorJugadorEsperando = marcador.getPuntos_J2();
                            
                            almacen_Partidas.almacenarPartida(new InfoPartidas(nombreJugadorActual, nombreJugadorEsperando, contadorPartidas, marcadorJugadorActual, marcadorJugadorEsperando, tableroDescubierto, movimientosPartida));                        } catch (IOException e) {
                            System.out.println("ERROR, " + e.getMessage());
                        }
                        
                        interfazJugador = new InterfazJugador();
                        interfazJugador.setVisible(true);
                        interfazJugador.insertarJugador(jugador_actual.getNombre(), jugador_actual.getPassword());
                        
                        interfazPartida.setVisible(false);
                    }
                }
            }
        });
        
        tablero.setCasillaEnBlancoSeleccionada(new Consumer<Casilla>() {
            @Override
            public void accept(Casilla t) {
                casillas[t.getCoordenadaX()][t.getCoordenadaY()].setEnabled(false);                
                if (t.getNumeroMinasAdyacentes() == 0 && t.getSimbolo_oculto() != "*") {
                    casillas[t.getCoordenadaX()][t.getCoordenadaY()].setText(" ");
                    t.setSimbolo_oculto("B");
                    
                    if ((t.getSimbolo_oculto()).equals("B") && contador == 0) {
                        if (partida.getTurno()) {
                            movimientosPartida = movimientosPartida + jugador1.getText() + " " + t.getCoordenadaX() + " " + t.getCoordenadaY() + " / ";
                        } else {
                            movimientosPartida = movimientosPartida + jugador2.getText() + " " + t.getCoordenadaX() + " " + t.getCoordenadaY() + " / ";
                        }
                        
                        contador++;
                        partida.cambiarTurno();
                        
                        if (partida.getTurno()) {
                            jugador1.setForeground(new Color(0, 204, 204));
                            jugador2.setForeground(new Color(255, 255, 255));
                        } else {
                            jugador2.setForeground(new Color(255, 102, 102));
                            jugador1.setForeground(new Color(255, 255, 255));
                        }
                    }
                } else {                    
                    if (t.getNumeroMinasAdyacentes() == 1 && t.getSimbolo_oculto() != "*") {
                        casillas[t.getCoordenadaX()][t.getCoordenadaY()].setForeground(Color.blue);
                        casillas[t.getCoordenadaX()][t.getCoordenadaY()].setText(t.getNumeroMinasAdyacentes() + "");
                        t.setSimbolo_oculto("N");
                    } else if (t.getNumeroMinasAdyacentes() == 2 && t.getSimbolo_oculto() != "*") {
                        casillas[t.getCoordenadaX()][t.getCoordenadaY()].setForeground(Color.magenta);
                        casillas[t.getCoordenadaX()][t.getCoordenadaY()].setText(t.getNumeroMinasAdyacentes() + "");
                        t.setSimbolo_oculto("N");
                    } else if (t.getNumeroMinasAdyacentes() == 3 && t.getSimbolo_oculto() != "*") {
                        casillas[t.getCoordenadaX()][t.getCoordenadaY()].setForeground(Color.red);
                        casillas[t.getCoordenadaX()][t.getCoordenadaY()].setText(t.getNumeroMinasAdyacentes() + "");
                        t.setSimbolo_oculto("N");
                    } else if (t.getNumeroMinasAdyacentes() == 4 && t.getSimbolo_oculto() != "*") {
                        casillas[t.getCoordenadaX()][t.getCoordenadaY()].setForeground(Color.yellow);
                        casillas[t.getCoordenadaX()][t.getCoordenadaY()].setText(t.getNumeroMinasAdyacentes() + "");
                        t.setSimbolo_oculto("N");
                    } else if (t.getNumeroMinasAdyacentes() > 4 && t.getSimbolo_oculto() != "*") {
                        casillas[t.getCoordenadaX()][t.getCoordenadaY()].setForeground(Color.darkGray);
                        casillas[t.getCoordenadaX()][t.getCoordenadaY()].setText(t.getNumeroMinasAdyacentes() + "");
                        t.setSimbolo_oculto("N");
                    }
                                      
                    if ((t.getSimbolo_oculto()).equals("N") && contador == 0) {
                        if (partida.getTurno()) {
                            movimientosPartida = movimientosPartida + jugador1.getText() + " " + t.getCoordenadaX() + " " + t.getCoordenadaY() + " / ";
                        } else {
                            movimientosPartida = movimientosPartida + jugador2.getText() + " " + t.getCoordenadaX() + " " + t.getCoordenadaY() + " / ";
                        }
                        
                        partida.cambiarTurno();
                        
                        if (partida.getTurno()) {
                            jugador1.setForeground(new Color(0, 204, 204));
                            jugador2.setForeground(new Color(255, 255, 255));
                        } else {
                            jugador2.setForeground(new Color(255, 102, 102));
                            jugador1.setForeground(new Color(255, 255, 255));
                        }
                    }
                }                
            }
        });
    }
    
    public void crearCasillas() {
        int anchoCasilla = 22;
        int altoCasilla = 22;
        int xCasilla = 1;
        int yCasilla = 1;
        
        casillas = new JButton[16][16];
        
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                casillas[i][j] = new JButton();
                casillas[i][j].setBorder(null);
                casillas[i][j].setFocusPainted(false);
                casillas[i][j].setBackground(new Color(20, 150, 20));
                casillas[i][j].setName(i + " " + j);
                
                if (i == 0 && j == 0) {
                    casillas[i][j].setBounds(xCasilla, yCasilla, anchoCasilla, altoCasilla);
                } else if (i == 0 && j != 0) {
                    casillas[i][j].setBounds(casillas[i][j - 1].getX() + casillas[i][j - 1].getWidth(), yCasilla, anchoCasilla, altoCasilla);
                } else {
                    casillas[i][j].setBounds(casillas[i - 1][j].getX(), casillas[i - 1][j].getY() + casillas[i - 1][j].getHeight(), anchoCasilla, altoCasilla);
                }
                casillas[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mostrarCasilla(e);
                    }                    
                });
                panelTablero.add(casillas[i][j]);
            }
        }
    }
    
    public void mostrarCasilla(ActionEvent e) {
        JButton casilla = (JButton) e.getSource();
        String[] coordenada = casilla.getName().split(" ");
        
        int posicionFila = Integer.parseInt(coordenada[0]);
        int posicionColumna = Integer.parseInt(coordenada[1]);
        
        tablero.seleccionarCasilla(posicionFila, posicionColumna);
        contador = 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelTablero = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jugador1 = new javax.swing.JLabel();
        marcador_J1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        movimientosJ2 = new javax.swing.JTextArea();
        jugador2 = new javax.swing.JLabel();
        marcador_J2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        movimientosJ1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelTablero.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout panelTableroLayout = new javax.swing.GroupLayout(panelTablero);
        panelTablero.setLayout(panelTableroLayout);
        panelTableroLayout.setHorizontalGroup(
            panelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 353, Short.MAX_VALUE)
        );
        panelTableroLayout.setVerticalGroup(
            panelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 353, Short.MAX_VALUE)
        );

        jPanel1.add(panelTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 353, 353));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("-");
        jLabel1.setAlignmentY(2.0F);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 50, 80));

        jugador1.setBackground(new java.awt.Color(0, 0, 0));
        jugador1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jugador1.setForeground(new java.awt.Color(255, 255, 255));
        jugador1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jugador1.setText("Jugador 1");
        jugador1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 204), 3, true));
        jPanel1.add(jugador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 190, 80));

        marcador_J1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        marcador_J1.setForeground(new java.awt.Color(255, 255, 255));
        marcador_J1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        marcador_J1.setText("0");
        jPanel1.add(marcador_J1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 90, -1));

        movimientosJ2.setEditable(false);
        movimientosJ2.setBackground(new java.awt.Color(204, 255, 204));
        movimientosJ2.setColumns(3);
        movimientosJ2.setRows(1);
        movimientosJ2.setTabSize(1);
        movimientosJ2.setAutoscrolls(false);
        jScrollPane1.setViewportView(movimientosJ2);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, 190, 350));

        jugador2.setBackground(new java.awt.Color(0, 0, 0));
        jugador2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jugador2.setForeground(new java.awt.Color(255, 255, 255));
        jugador2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jugador2.setText("Jugador 2");
        jugador2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 3, true));
        jPanel1.add(jugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, 190, 80));

        marcador_J2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        marcador_J2.setForeground(new java.awt.Color(255, 255, 255));
        marcador_J2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        marcador_J2.setText("0");
        jPanel1.add(marcador_J2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 90, -1));

        movimientosJ1.setEditable(false);
        movimientosJ1.setBackground(new java.awt.Color(204, 255, 204));
        movimientosJ1.setColumns(3);
        movimientosJ1.setRows(1);
        movimientosJ1.setTabSize(1);
        movimientosJ1.setAutoscrolls(false);
        movimientosJ1.setBorder(null);
        jScrollPane2.setViewportView(movimientosJ1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 190, 350));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 490));

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

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazPartida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jugador1;
    private javax.swing.JLabel jugador2;
    private javax.swing.JLabel marcador_J1;
    private javax.swing.JLabel marcador_J2;
    private javax.swing.JTextArea movimientosJ1;
    private javax.swing.JTextArea movimientosJ2;
    private javax.swing.JPanel panelTablero;
    // End of variables declaration//GEN-END:variables
}