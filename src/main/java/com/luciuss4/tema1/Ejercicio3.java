package com.luciuss4.tema1;

import java.io.File;

public class Ejercicio3 {
    public static void main(String[] args) {
        File carpeta = new File("src/main/resources/ficheros");

        IO.println("El nombre es " + carpeta.getName());
        IO.println("La ruta absoluta es " + carpeta.getAbsolutePath());
        IO.println("Se puede leer ? " + carpeta.canRead());
        IO.println("Se puede escribir ? " + carpeta.canWrite());

    }
}
