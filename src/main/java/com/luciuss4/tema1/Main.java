package com.luciuss4.tema1;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/java/com/luciuss4/tema1");
        System.out.println("Ruta absoluta comprobada: " + file.getAbsolutePath());

        if (!file.exists()) {
            throw new FileNotFoundException("El fichero " + file + " no existe");
        }
        boolean isDirectory = file.isDirectory();
        System.out.println("Es directorio: " + isDirectory);
    }
}