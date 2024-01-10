package buscaminas;

public class Jugador extends Usuario {
    
    public Jugador(String nombre, String password) {
        super(nombre, password);
    }
    
    public void mostrarJugador() {
        System.out.println(super.getNombre() + "#" + super.getPassword());
    }       
}