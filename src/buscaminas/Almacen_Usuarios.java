package buscaminas;

import java.io.*;
import java.util.*;

public class Almacen_Usuarios {
    
    private File fichero;
    private ArrayList<Jugador> datos;
    
    public Almacen_Usuarios(String fichero) {
        this.fichero = new File(fichero);
        this.datos = new ArrayList<>();
        leerDatos();
    }
    
    public Almacen_Usuarios(File fichero) {
        this.fichero = fichero;
        this.datos = new ArrayList<>();
        leerDatos();
    }

    public File getFichero() {
        return fichero;
    }

    public ArrayList<Jugador> getDatos() {
        return datos;
    }
    
    public void alta(Jugador jugador) throws IOException {
        if (fichero.exists() && fichero.length() > 0) {
            try {
                MiObjectOutputStream miObjectOutputStream = new MiObjectOutputStream(new FileOutputStream(fichero, true));

                miObjectOutputStream.writeObject(jugador);
                datos.add(jugador);
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\vcald\\Documents\\Buscaminas\\src\\ficheros\\listadoJugadores.ser");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

                objectOutputStream.writeObject(jugador);
                datos.add(jugador);
                objectOutputStream.close();
            }  catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    
    public void baja(Jugador jugador) throws IOException, ClassNotFoundException { 
        ArrayList<Jugador> copiaDatos = new ArrayList<>();
        
        for (Jugador dato : datos) {
            if (!dato.getNombre().equals(jugador.getNombre())) {
                copiaDatos.add(dato);
            }
        }
        
        datos = new ArrayList<>();      
        
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fichero));
        objectOutputStream.writeBytes("");
        
        for (Jugador j : copiaDatos) {
            alta(j);
        }
    }
    
    public void leerDatos() {
        if (fichero.exists()) {
            Jugador jugador;
            
            try {
                FileInputStream fileInputStream = new FileInputStream(fichero);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                while (true) {
                    jugador = (Jugador) objectInputStream.readObject();
                    datos.add(jugador);
                }
            } catch (EOFException e) {
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            } 
        }
    }
    
    public boolean existe(Jugador jugador) {
        for (Jugador dato : datos) {
            if (dato.getNombre().equals(jugador.getNombre())) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean autenticar(Usuario usuario) {
        String nombre = usuario.getNombre();
        String password = usuario.getPassword();
        
        for (Jugador jugador : datos) {
            if (jugador.getNombre().equals(nombre) && jugador.getPassword().equals(password)) {
                return true;
            }
        }
        
        return false;
    }
    
    public void cargarListado(File fichero) throws IOException {
        FileReader fileReader = new FileReader(fichero);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        
        String jugador = new String();
        String listadoJugadores;
        
        while ((listadoJugadores = bufferedReader.readLine()) != null) {
            jugador = jugador + listadoJugadores + "\n";
        }
        
        String[] altaJugador = jugador.split("\n");
        int numeroJugadores = Integer.valueOf(altaJugador[0]);
        
        while (numeroJugadores > 0) {
            String[] jugadorPassword = altaJugador[numeroJugadores].split("#");
            
            alta(new Jugador(jugadorPassword[0], jugadorPassword[1]));
            
            numeroJugadores--;
        }
        
        bufferedReader.close();
    }
}