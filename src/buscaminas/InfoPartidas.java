package buscaminas;

import java.io.Serializable;

public class InfoPartidas implements Serializable {
    
    private String jugador_actual;
    private String jugador_esperando;
    private int idPartida;
    private int marcadorJ1;
    private int marcadorJ2;
    private String tablero;    
    private String movimientos;    

    public InfoPartidas(String jugador_actual, String jugador_esperando, int idPartida, int marcadorJ1, int marcadorJ2, String tablero, String movimientos) {
        this.jugador_actual = jugador_actual;
        this.jugador_esperando = jugador_esperando;
        this.idPartida = idPartida;
        this.marcadorJ1 = marcadorJ1;
        this.marcadorJ2 = marcadorJ2;
        this.tablero = tablero;
        this.movimientos = movimientos;
    }

    public String getJugador_actual() {
        return jugador_actual;
    }

    public void setJugador_actual(String jugador_actual) {
        this.jugador_actual = jugador_actual;
    }

    public String getJugador_esperando() {
        return jugador_esperando;
    }

    public void setJugador_esperando(String jugador_esperando) {
        this.jugador_esperando = jugador_esperando;
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public int getMarcadorJ1() {
        return marcadorJ1;
    }

    public void setMarcadorJ1(int marcadorJ1) {
        this.marcadorJ1 = marcadorJ1;
    }

    public int getMarcadorJ2() {
        return marcadorJ2;
    }

    public void setMarcadorJ2(int marcadorJ2) {
        this.marcadorJ2 = marcadorJ2;
    }

    public String getTablero() {
        return tablero;
    }

    public void setTablero(String tablero) {
        this.tablero = tablero;
    }

    public String getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(String movimientos) {
        this.movimientos = movimientos;
    }    
    
    public void mostrarEstadisticas() {
        System.out.println(jugador_actual + "#" + jugador_esperando + "#" + idPartida + "#" + marcadorJ1 + "#" + marcadorJ2 + "#" + tablero + "#" + "#" + movimientos);
    }
}