package com.luciuss4.tema1;

import java.io.File;
import java.io.FileNotFoundException;

public class Ejercicio1 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/ficheros");
        if (!file.exists()) {
            throw new FileNotFoundException("El fichero " + file + " no existe");
        } else if (file.isDirectory()) {
            System.out.println("Existe y es un directorio");
        } else {
            System.out.println("Existe, pero no es un directorio (es un archivo)");
        }
    }
}