package buscaminas;

import java.io.*;
import java.util.ArrayList;

public class Prueba {
    
    public static void main(String[] args) {        
        try {
            Almacen_Usuarios almacen_Usuarios = new Almacen_Usuarios("C:\\Users\\vcald\\Documents\\Buscaminas\\src\\ficheros\\listadoJugadores.ser");
            
            ArrayList<Jugador> listaJugadores = almacen_Usuarios.getDatos();
            
            for (Jugador jugador : listaJugadores) {
                jugador.mostrarJugador();
            }
            
            /*Usuario usuario = new Usuario("Pepe", "12345");
            System.out.println(almacen_Usuarios.autenticar(usuario));
            
            Usuario usuario2 = new Usuario("Fernan", "12345");
            System.out.println(almacen_Usuarios.autenticar(usuario2));
            
            Usuario usuario3 = new Usuario("Victor", "12345");
            System.out.println(almacen_Usuarios.autenticar(usuario3));*/
            
            /*Jugador jugador1 = new Jugador("Pepe", "1234");
            
            almacen_Usuarios.alta(jugador1);
            
            ArrayList<Jugador> listaJugadores = almacen_Usuarios.getDatos();
            
            for (Jugador jugador : listaJugadores) {
                //System.out.println(jugador.getNombre() + "#" + jugador.getPassword());
                jugador.mostrarJugador();
            }*/
            
            /*Jugador jugador2 = new Jugador("Fernan", "12345");
            //Jugador jugador3 = new Jugador("Marta", "123456");
            //Jugador jugador4 = new Jugador("Nieves", "1234567");
            
            almacen_Usuarios.alta(jugador1);
            almacen_Usuarios.alta(jugador2);
            //almacen_Usuarios.alta(jugador3);
            //almacen_Usuarios.alta(jugador4);
            
            System.out.println("¡Guardado con extito!");
            
            ArrayList<Jugador> listaJugadores = almacen_Usuarios.getDatos();
            
            for (Jugador jugador : listaJugadores) {
                //System.out.println(jugador.getNombre() + "#" + jugador.getPassword());
                jugador.mostrarJugador();
            }
            
            System.out.println("-----------------------------------------------------");
            
            Usuario usuario = new Usuario("Pepe", "12345");
            System.out.println(almacen_Usuarios.autenticar(usuario));
            
            System.out.println("-----------------------------------------------------");
            
            Jugador jugador2 = new Jugador("Adrian", "1234");
            almacen_Usuarios.baja(jugador2);
            
            listaJugadores = almacen_Usuarios.getDatos();
            
            for (Jugador jugador : listaJugadores) {
                //System.out.println(jugador.getNombre() + "#" + jugador.getPassword());
                jugador.mostrarJugador();
            }
            
            System.out.println("-----------------------------------------------------");  
            
            Jugador jugador3 = new Jugador("Nieves", "1234567");
            almacen_Usuarios.alta(jugador3);
            
            listaJugadores = almacen_Usuarios.getDatos();
            
            for (Jugador jugador : listaJugadores) {
                //System.out.println(jugador.getNombre() + "#" + jugador.getPassword());
                jugador.mostrarJugador();
            }
            
            /*almacen_Usuarios.cargarListado(new File("C:\\Users\\vcald\\Documents\\Buscaminas\\src\\ficheros\\altaJugadores.txt"));
            
            ArrayList<Jugador> listaJugadores = almacen_Usuarios.getDatos();
            
            for (Jugador jugador : listaJugadores) {
                //System.out.println(jugador.getNombre() + "#" + jugador.getPassword());
                jugador.mostrarJugador();
            }*/
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("Se ha producido un error al dar de alta al los jugadores: " + e.getMessage());
        }
    }
}