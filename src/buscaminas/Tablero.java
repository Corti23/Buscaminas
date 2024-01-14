package buscaminas;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;

public class Tablero implements Serializable {
    
    private static final int MINAS = 51;
    private Casilla[][] casillas;
    
    //Usamos Consumer para cada seleecion de casilla porque es una expresión que acepta un solo valor y no devuelve ninguno
    Consumer<Casilla> casillaMinaSeleccionada;
    Consumer<Casilla> casillaEnBlancoSeleccionada;
    

    public Tablero() {
        casillas = new Casilla[16][16];
      
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                Casilla nuevaCasilla = new Casilla(i, j, " ");
                casillas[i][j] = nuevaCasilla;
            }
        }

        calcularMinas();
    }

    //Con este metodo generas aleatoriamente las minas en el mapa
    public void calcularMinas() {
        Random random = new Random();
        int minas = 0;

        do {
            int fila = random.nextInt(casillas.length);
            int columna = random.nextInt(casillas[0].length);

            if (!(casillas[fila][columna].getSimbolo_oculto() == "*")) {
                casillas[fila][columna].setSimbolo_oculto("*");
                minas++;

                casillas[fila][columna].setNumeroMinas(minas);
            }
        } while (minas < MINAS);

        calcularNumeros();
    }

    //Con este metodo generas los numeros en el mapa basandonos en las minas que tengas en las casillas adyacentes
    public void calcularNumeros() {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (casillas[i][j].getSimbolo_oculto() == "*") {
                    ArrayList<Casilla> casillasAdyacentes = casillasAdyacentes(casillas[i][j]);
                    
                    for (Casilla casilla : casillasAdyacentes) {
                        casilla.aumentarNumeroMinasAdyacentes();
                    }
                }
            }
        }
    }

    //Con este metodo generas las casillas adyacentes con los numeros dependiendo de las minas
    public ArrayList<Casilla> casillasAdyacentes(Casilla c) {
        ArrayList<Casilla> adyacentes = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            int posicionFila = c.getCoordenadaX();
            int posicionColumna = c.getCoordenadaY();

            switch (i) {
                case 0:
                    posicionFila--;
                    break;
                case 1:
                    posicionFila--;
                    posicionColumna++;
                    break;
                case 2:
                    posicionColumna++;
                    break;
                case 3:
                    posicionFila++;
                    posicionColumna++;
                    break;
                case 4:
                    posicionFila++;
                    break;
                case 5:
                    posicionFila++;
                    posicionColumna--;
                    break;
                case 6:
                    posicionColumna--;
                    break;
                case 7:
                    posicionFila--;
                    posicionColumna--;
                    break;
            }

            if (posicionFila >= 0 && posicionFila < this.casillas.length && posicionColumna >= 0 && posicionColumna < this.casillas[0].length) {
                adyacentes.add(this.casillas[posicionFila][posicionColumna]);
            }
        }

        return adyacentes;
    }
    
    //Con este metodo seleccionamos la casilla que es seleccionada en la interfaz y mostramos las casillas en blanco de forma recursiva
    public void seleccionarCasilla(int posicionFila, int posicionColumna) {
        casillaEnBlancoSeleccionada.accept(this.casillas[posicionFila][posicionColumna]);
        
        if (this.casillas[posicionFila][posicionColumna].getSimbolo_oculto() == "*") {
            casillaMinaSeleccionada.accept(casillas[posicionFila][posicionColumna]);            
        } else if (this.casillas[posicionFila][posicionColumna].getNumeroMinasAdyacentes() == 0) {
            ArrayList<Casilla> casillasAdyacentes = casillasAdyacentes(casillas[posicionFila][posicionColumna]);
            
            for (Casilla casilla : casillasAdyacentes) {
                if (!casilla.getSeleccionada()) {
                    casilla.setSeleccionada(true);
                    seleccionarCasilla(casilla.getCoordenadaX(), casilla.getCoordenadaY());
                }
            }
        }
    }

    //Con este metodo mostramos el tablero en formato texto y asi poderlo insertar en el fichero txt de la info Partidas
    public String mostrarTablero() {
        String tablero = "";
        
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (casillas[i][j].getSimbolo_oculto() == "*") {
                    tablero = tablero + "*";
                } else { 
                    if (casillas[i][j].getNumeroMinasAdyacentes() == 0) {
                        tablero = tablero + "B";
                    } else {
                        tablero = tablero + String.valueOf(casillas[i][j].getNumeroMinasAdyacentes());
                    }
                }
            }
            tablero = tablero + " ";
        }
        
        return tablero;
    }
    
    //Setter del Consumer de minas
    public void setCasillaMinaSeleccionada(Consumer<Casilla> casillaMinaSeleccionada) {
        this.casillaMinaSeleccionada = casillaMinaSeleccionada;
        
    }
    
    //Setter del Consumer de espacios en blanco
    public void setCasillaEnBlancoSeleccionada(Consumer<Casilla> casillaEnBlancoSeleccionada) {
        this.casillaEnBlancoSeleccionada = casillaEnBlancoSeleccionada;
    }
}