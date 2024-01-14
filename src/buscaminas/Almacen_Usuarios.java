package buscaminas;

import java.io.*;
import java.util.*;

public class Almacen_Usuarios {
    
    private File fichero;
    private ArrayList<Jugador> datos;
    
    Almacen_Estadisticas almacen_Estadisticas = new Almacen_Estadisticas("C:\\Users\\vcald\\Documents\\Buscaminas\\src\\ficheros\\listadoEstadisticas.ser");
    
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

    public ArrayList<Jugador> getDatos() {
        return datos;
    }
    
    //Con este metodo damos de alta a un jugador y lo añadimos al fichero correspondiente de almacen Jugadores
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
    
    //Con este metodo damos de baja a un jugador y lo eliminamos del fichero correspondiente de almacen Jugadores
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
    
    //Con este metodo leemos el fichero de almacen Jugadores
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
    
    //Con este metodo comprobamos si un jugador existe en el sistema
    public boolean existe(Jugador jugador) {
        for (Jugador dato : datos) {
            if (dato.getNombre().equals(jugador.getNombre())) {
                return true;
            }
        }
        
        return false;
    }
    
    //Con este metodo comprobamos si un jugador existe en el sistema para validarlo al iniciar sesion
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
    
    //Con este metodo cargamos un fichero TXT paraa dar de alta a multiples jugadores al mismo tiempo
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
            
            if (!almacen_Estadisticas.existe(new Estadisticas(jugadorPassword[0], 0, 0, 0, 0, 0))) {
                alta(new Jugador(jugadorPassword[0], jugadorPassword[1]));
                almacen_Estadisticas.crearEstadisticas(new Estadisticas(jugadorPassword[0], 0, 0, 0, 0, 0));
            }
            
            numeroJugadores--;
        }
        
        bufferedReader.close();
    }
    
    //Con este metodo ordenamos la clasificacion por orden alfabetico
    public ArrayList<Estadisticas> clasificacionPorNombre() {
        ArrayList<Estadisticas> listaOrdenada = new ArrayList<>();
        ArrayList<Estadisticas> listaEstadisticas = almacen_Estadisticas.getDatos();
        
        Collections.sort(listaEstadisticas, new Comparator<Estadisticas>() {
            @Override
            public int compare(Estadisticas jugador1, Estadisticas jugador2) {
                return jugador1.getNombreJugador().compareTo(jugador2.getNombreJugador());
            }            
        });
        
        for (Estadisticas jugador : listaEstadisticas) {
            listaOrdenada.add(jugador);
        }
        
        return listaOrdenada;
    }
    
    //Con este metodo ordenamos la clasificacion por partidas ganadas
    public ArrayList<Estadisticas> clasificacionPorVictorias() {
        ArrayList<Estadisticas> listaOrdenada = new ArrayList<>();
        ArrayList<Estadisticas> listaEstadisticas = almacen_Estadisticas.getDatos();
        
        Collections.sort(listaEstadisticas, new Comparator<Estadisticas>() {
            @Override
            public int compare(Estadisticas estadisticas1, Estadisticas estadisticas2) {
                return new Integer(estadisticas2.getGanadas()).compareTo(new Integer(estadisticas1.getGanadas()));
            }            
        });
        
        for (Estadisticas estadisticas : listaEstadisticas) {
            listaOrdenada.add(estadisticas);
        }
        
        return listaOrdenada;
    }
}