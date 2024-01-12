package buscaminas;

public class Jugador extends Usuario {
    
    //Creamos el constructor Jugador que extiende de Usuario
    public Jugador(String nombre, String password) {
        super(nombre, password);
    }
    
    //Metodo para mostrar y comprobar Jugadores
    public void mostrarJugador() {
        System.out.println(super.getNombre() + "#" + super.getPassword());
    }       
}