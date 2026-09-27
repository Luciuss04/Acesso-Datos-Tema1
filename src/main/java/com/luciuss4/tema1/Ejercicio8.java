package com.luciuss4.tema1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio8 {

    public static void main(String[] args) {
        if (args.length == 0) {
            IO.println("Debes indicar la ruta del archivo como parámetro.");
            return;
        }

        File fichero = new File(args[0]);

        try (FileReader lector = new FileReader(fichero);
             BufferedReader bufLector = new BufferedReader(lector)) {

            String linea = bufLector.readLine();
            while (linea != null) {
                IO.println(linea);
                linea = bufLector.readLine();
            }

        } catch (IOException e) {
            IO.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}