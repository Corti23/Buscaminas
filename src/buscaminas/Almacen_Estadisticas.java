package buscaminas;

import java.io.*;
import java.util.*;

public class Almacen_Estadisticas {
    
    private File fichero;
    private ArrayList<Estadisticas> datos;
    
    public Almacen_Estadisticas(String fichero) {
        this.fichero = new File(fichero);
        this.datos = new ArrayList<>();
        leerDatos();
    }
    
    public Almacen_Estadisticas(File fichero) {
        this.fichero = fichero;
        this.datos = new ArrayList<>();
        leerDatos();
    }

    public ArrayList<Estadisticas> getDatos() {
        return datos;
    }
    
    //Con este metodo creamos las estadisticas de un jugador y lo añadimos al fichero correspondiente de almacen Estadisticas
    public void crearEstadisticas(Estadisticas estadisticas) throws IOException {
        if (fichero.exists() && fichero.length() > 0) {
            try {
                MiObjectOutputStream miObjectOutputStream = new MiObjectOutputStream(new FileOutputStream(fichero, true));

                miObjectOutputStream.writeObject(estadisticas);
                datos.add(estadisticas);
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\vcald\\Documents\\Buscaminas\\src\\ficheros\\listadoEstadisticas.ser");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

                objectOutputStream.writeObject(estadisticas);
                datos.add(estadisticas);
                objectOutputStream.close();
            }  catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    
    //Con este metodo leemos el fichero de almacen Estadisticas
    public void leerDatos() {
        if (fichero.exists()) {
            Estadisticas estadisticas;
            
            try {
                FileInputStream fileInputStream = new FileInputStream(fichero);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                while (true) {
                    estadisticas = (Estadisticas) objectInputStream.readObject();
                    datos.add(estadisticas);
                }
            } catch (EOFException e) {
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            } 
        }
    }
    
    //Con este metodo comprobamos si las estadisticas de un jugador existen en el sistema
    public boolean existe(Estadisticas estadisticas) {
        for (Estadisticas dato : datos) {
            if (dato.getNombreJugador().equals(estadisticas.getNombreJugador())) {
                return true;
            }
        }
        
        return false;
    }
    
    //Con este metodo actualizamos las estadisticas de los jugadores al terminar una partida
    public void actualizar(Estadisticas estadisticas) throws IOException, ClassNotFoundException { 
        ArrayList<Estadisticas> copiaDatos = new ArrayList<>();
        
        for (Estadisticas dato : datos) {
            if (!dato.getNombreJugador().equals(estadisticas.getNombreJugador())) {
                copiaDatos.add(dato);
            } else {
                int jugadas = dato.getJugadas() + estadisticas.getJugadas();
                int ganadas = dato.getGanadas() + estadisticas.getGanadas();
                int perdidas = dato.getPerdidas() + estadisticas.getPerdidas();
                int minas_a_favor = dato.getMinas_a_favor() + estadisticas.getMinas_a_favor();
                int minas_en_contra = dato.getMinas_en_contra() + estadisticas.getMinas_en_contra();
        
                Estadisticas estadisticasActualizadas = new Estadisticas(estadisticas.getNombreJugador(), jugadas, ganadas, perdidas, minas_a_favor, minas_en_contra);
                copiaDatos.add(estadisticasActualizadas);
            }
        }
        
        datos = new ArrayList<>();      
        
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fichero));
        objectOutputStream.writeBytes("");
        
        for (Estadisticas j : copiaDatos) {
            crearEstadisticas(j);
        }
    }
}