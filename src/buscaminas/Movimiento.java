package buscaminas;

import java.io.Serializable;

public class Movimiento implements Serializable {
    
    private String nombreJugador;
    private int coordenadaX;
    private int coordenadaY;

    public Movimiento(String nombreJugador, int coordenadaX, int coordenadaY) {
        this.nombreJugador = nombreJugador;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    @Override
    public String toString() {
        return nombreJugador + " " + coordenadaX + " " + coordenadaY;
    }
}