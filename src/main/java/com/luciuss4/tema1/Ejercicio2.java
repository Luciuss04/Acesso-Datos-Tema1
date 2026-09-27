package com.luciuss4.tema1;

import java.io.File;

public class Ejercicio2 {
    public static void main(String[] args) {
        File carpeta = new File("src/main/resources/ficheros");

        File[] elementos = carpeta.listFiles();

        if (elementos != null) {
            for (int x = 0; x < elementos.length; x++) {
                File elemento = elementos[x];
                System.out.println(elemento.getName());
            }
        } else {
            System.out.println("La ruta no existe o no es un directorio.");
        }
    }
}