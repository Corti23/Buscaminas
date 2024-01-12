package buscaminas;

import java.util.ArrayList;

public class Partida {
    
    private Jugador jugador_actual;
    private Jugador jugador_esperando;
    private boolean turno;
    

    public Partida(Jugador jugador_actual, Jugador jugador_esperando) {
        this.jugador_actual = jugador_actual;
        this.jugador_esperando = jugador_esperando;
    }

    public Jugador getJugador_actual() {
        return jugador_actual;
    }

    public void setJugador_actual(Jugador jugador_actual) {
        this.jugador_actual = jugador_actual;
    }

    public Jugador getJugador_esperando() {
        return jugador_esperando;
    }

    public void setJugador_esperando(Jugador jugador_esperando) {
        this.jugador_esperando = jugador_esperando;
    }

    public boolean getTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }
    
    public void info_partida(Marcador marcador) {        
        int marcadorJugador1 = marcador.getPuntos_J1();               
        int marcadorJugador2 = marcador.getPuntos_J2();
    }
    
    public void jugar() {
        Marcador marcador = new Marcador(0, 0);
        
        marcador.setPuntos_J1(0);
        marcador.setPuntos_J2(0);
        
        turno = true;
    }
    
    public void cambiarTurno() {
        this.turno = !(this.turno);
    }
}