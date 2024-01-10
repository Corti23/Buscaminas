package buscaminas;

public class Casilla {
    
    private int coordenadaX;
    private int coordenadaY;
    private String simbolo_oculto;
    private int numeroMinas;
    private int numeroMinasAdyacentes;
    private boolean seleccionada;

    public Casilla(int coordenadaX, int coordenadaY, String simbolo_oculto) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.simbolo_oculto = simbolo_oculto;
        this.numeroMinas = 0;
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

    public String getSimbolo_oculto() {
        return simbolo_oculto;
    }

    public void setSimbolo_oculto(String simbolo_oculto) {
        this.simbolo_oculto = simbolo_oculto;
    }

    public int getNumeroMinas() {
        return numeroMinas;
    }

    public void setNumeroMinas(int numeroMinas) {
        this.numeroMinas = numeroMinas;
    }

    public void aumentarNumeroMinasAdyacentes() {
        this.numeroMinasAdyacentes++;
    }

    public int getNumeroMinasAdyacentes() {
        return numeroMinasAdyacentes;
    }

    public void setNumeroMinasAdyacentes(int numeroMinasAdyacentes) {
        this.numeroMinasAdyacentes = numeroMinasAdyacentes;
    }

    public boolean getSeleccionada() {
        return seleccionada;
    }

    public void setSeleccionada(boolean seleccionada) {
        this.seleccionada = seleccionada;
    }
}