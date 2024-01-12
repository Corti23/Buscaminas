package buscaminas;

import java.io.*;

//Con esta clase lo que conseguimos es añadir datos a ficheros sin sobreescribirlos, añadiendo los datos a continuacion de los anteriores
public class MiObjectOutputStream extends ObjectOutputStream {
    
    public MiObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    public MiObjectOutputStream() throws IOException, SecurityException {
        super();
    }

    @Override
    protected void writeStreamHeader() throws IOException {
    }   
}