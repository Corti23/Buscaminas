package buscaminas;

import java.io.Serializable;

public class Partida implements Serializable {
    
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
    
    //Con este metodo se inicializa la partida y asigna el turno al juador local
    public void jugar() {        
        turno = true;
    }
    
    //Con este metodo cambiamos el turno del jugador en cada partida
    public void cambiarTurno() {
        this.turno = !(this.turno);
    }
}