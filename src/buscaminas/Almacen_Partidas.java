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
        if (fichero.exists() && fichero.length() > 0) {
            try {
                MiObjectOutputStream miObjectOutputStream = new MiObjectOutputStream(new FileOutputStream(fichero, true));

                miObjectOutputStream.writeObject(partida);
                datos.add(partida);
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\vcald\\Documents\\Buscaminas\\src\\ficheros\\listadoPartidas.txt");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

                objectOutputStream.writeObject(partida);
                datos.add(partida);
                objectOutputStream.close();
            }  catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    
    //Con este metodo leemos el fichero de almacen Partidas
    public void leerDatos() {
        if (fichero.exists()) {
            InfoPartidas partida;
            
            try {
                FileInputStream fileInputStream = new FileInputStream(fichero);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                while (true) {
                    partida = (InfoPartidas) objectInputStream.readObject();
                    datos.add(partida);
                }
            } catch (EOFException e) {
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (ClassNotFoundException e) {
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
    public void mostrarTableroYMovimientos() throws IOException {
        Desktop.getDesktop().open(fichero);
    }
}