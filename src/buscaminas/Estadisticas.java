package buscaminas;

public class Estadisticas {
    
    private int numeroPartida;
    private int jugadas;
    private int ganadas;
    private int perdidas;
    private int minas_a_favor;
    private int minas_en_contra;

    public Estadisticas(int numeroPartida, int jugadas, int ganadas, int perdidas, int minas_a_favor, int minas_en_contra) {
        this.numeroPartida = numeroPartida;
        this.jugadas = jugadas;
        this.ganadas = ganadas;
        this.perdidas = perdidas;
        this.minas_a_favor = minas_a_favor;
        this.minas_en_contra = minas_en_contra;
    } 
    
    public Estadisticas() {
        this.numeroPartida = 0;
        this.jugadas = 0;
        this.ganadas = 0;
        this.perdidas = 0;
        this.minas_a_favor = 0;
        this.minas_en_contra = 0;
    } 

    public int getNumeroPartida() {
        return numeroPartida;
    }

    public void setNumeroPartida(int numeroPartida) {
        this.numeroPartida = numeroPartida;
    }

    public int getJugadas() {
        return jugadas;
    }

    public void setJugadas(int jugadas) {
        this.jugadas = jugadas;
    }

    public int getGanadas() {
        return ganadas;
    }

    public void setGanadas(int ganadas) {
        this.ganadas = ganadas;
    }

    public int getPerdidas() {
        return perdidas;
    }

    public void setPerdidas(int perdidas) {
        this.perdidas = perdidas;
    }

    public int getMinas_a_favor() {
        return minas_a_favor;
    }

    public void setMinas_a_favor(int minas_a_favor) {
        this.minas_a_favor = minas_a_favor;
    }

    public int getMinas_en_contra() {
        return minas_en_contra;
    }

    public void setMinas_en_contra(int minas_en_contra) {
        this.minas_en_contra = minas_en_contra;
    }
    
    public void sumaEstadisticas(Estadisticas sumaEstadisticas) {
        numeroPartida += sumaEstadisticas.getNumeroPartida();
        jugadas += sumaEstadisticas.getJugadas();
        ganadas += sumaEstadisticas.getGanadas();
        perdidas += sumaEstadisticas.getPerdidas();
        minas_a_favor += sumaEstadisticas.getMinas_a_favor();
        minas_en_contra += sumaEstadisticas.getMinas_en_contra();
    }

    @Override
    public String toString() {
        return numeroPartida + "#" + jugadas + "#" + ganadas + "#" + perdidas + "#" + minas_a_favor + "#" + minas_en_contra;
    }
}