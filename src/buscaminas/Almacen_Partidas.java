package buscaminas;

import java.awt.Desktop;
import java.io.*;
import java.util.*;

public class Almacen_Partidas {
    
    private File fichero;
    private ArrayList<InfoPartidas> datos;
    
    public Almacen_Partidas(String fichero) {
        this.fichero = new File(fichero);
        this.datos = new ArrayList<>();
        leerDatos();
    }
    
    public Almacen_Partidas(File fichero) {
        this.fichero = fichero;
        this.datos = new ArrayList<>();
        leerDatos();
    }

    public ArrayList<InfoPartidas> getDatos() {
        return datos;
    }
    
    //Con este metodo almacenamos la informacion de una partida y la añadimos al fichero correspondiente de almacen Partidas
    public void almacenarPartida(InfoPartidas partida) throws IOException {
        String id = String.valueOf(partida.getIdPartida());
        String jugador1 = partida.getJugador_actual();
        String jugador2 = partida.getJugador_esperando();
        String marcadorJ1 = String.valueOf(partida.getMarcadorJ1());
        String marcadorJ2 = String.valueOf(partida.getMarcadorJ2());
        String tablero = partida.getTablero();
        String movimientos = partida.getMovimientos();
        
        if (fichero.exists() && fichero.length() > 0) {
            try {
                FileWriter fileWriter = new FileWriter(fichero, true);

                fileWriter.write(id + "#");
                fileWriter.write(jugador1 + "#");
                fileWriter.write(jugador2 + "#");
                fileWriter.write(marcadorJ1 + "#");
                fileWriter.write(marcadorJ2 + "#");
                fileWriter.write(tablero + "#");
                fileWriter.write(movimientos + "#\n");                
                datos.add(partida);
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            try {
                FileWriter fileWriter = new FileWriter(fichero);

                fileWriter.write(id + "#");
                fileWriter.write(jugador1 + "#");
                fileWriter.write(jugador2 + "#");
                fileWriter.write(marcadorJ1 + "#");
                fileWriter.write(marcadorJ2 + "#");
                fileWriter.write(tablero + "#");
                fileWriter.write(movimientos + "#\n");
                datos.add(partida);
                fileWriter.close();
            }  catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    
    //Con este metodo leemos el fichero de almacen Partidas
    public void leerDatos() {
        if (fichero.exists()) {
            try {
                FileReader fileReader = new FileReader(fichero);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                
                String texto = new String();
                int idPartida;
                String jugador1;
                String jugador2;
                int marcador1;
                int marcador2;
                String tablero;
                String movimientos;
                
                while ((texto = bufferedReader.readLine()) != null) {
                    String[] contenidoTXT = texto.split("#");
                    idPartida = Integer.parseInt(contenidoTXT[0]);
                    jugador1 = contenidoTXT[1];
                    jugador2 = contenidoTXT[2];
                    marcador1 = Integer.parseInt(contenidoTXT[3]);
                    marcador2 = Integer.parseInt(contenidoTXT[4]);
                    tablero = contenidoTXT[5];
                    movimientos = contenidoTXT[6];
                    InfoPartidas infoPartidas = new InfoPartidas(jugador1, jugador2, idPartida, marcador1, marcador2, tablero, movimientos);
                    datos.add(infoPartidas);
                }
                
                bufferedReader.close();
            } catch (EOFException e) {
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    
    //Con este metodo comprobamos si una partida existe en el sistema
    public boolean existe(InfoPartidas partida) {
        for (InfoPartidas dato : datos) {
            if (dato.getIdPartida() == partida.getIdPartida()) {
                return true;
            }
        }
        
        return false;
    }    
    
    //Con este metodo abrimos un el fichero donde se almacenan todos los datos de las partidas
    public void mostrarTableroYMovimientos(ArrayList<InfoPartidas> info) throws IOException {
        FileWriter fileWriter = new FileWriter("listadoTablerosMovimientos.txt");
            
        for (InfoPartidas partidas : info) {
            fileWriter.write("PARTIDA " + String.valueOf(partidas.getIdPartida()) + "\n");
            
            fileWriter.write("TABLERO\n");
            
            String[] tableroCompleto = partidas.getTablero().split(" ");
            
            for (String tablero :  tableroCompleto) {
                fileWriter.write(tablero + "\n");
            }
            
            fileWriter.write("MOVIMIENTOS\n");
            
            String[] movimientosCompletos = partidas.getMovimientos().split(" / ");
            
            for (String movimientos :  movimientosCompletos) {
                fileWriter.write(movimientos + "\n");
            }
            
            fileWriter.write("\n");
        }
        
        fileWriter.close();
        
        Desktop.getDesktop().open(new File("listadoTablerosMovimientos.txt"));
    }
}