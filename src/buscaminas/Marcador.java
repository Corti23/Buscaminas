package buscaminas;

public class Marcador {
    
    private int puntos_J1;
    private int puntos_J2;

    public Marcador(int puntos_J1, int puntos_J2) {
        this.puntos_J1 = puntos_J1;
        this.puntos_J2 = puntos_J2;
    }

    public int getPuntos_J1() {
        return puntos_J1;
    }

    public void setPuntos_J1(int puntos_J1) {
        this.puntos_J1 = puntos_J1;
    }

    public int getPuntos_J2() {
        return puntos_J2;
    }

    public void setPuntos_J2(int puntos_J2) {
        this.puntos_J2 = puntos_J2;
    }
}