package com.luciuss4.tema1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio10 {

    public void concat(String directorio, String archivo1, String archivo2, String archivoDestino) {
        File fichero1 = new File(directorio, archivo1);
        File fichero2 = new File(directorio, archivo2);
        File destino = new File(directorio, archivoDestino);

        try (FileReader lector1 = new FileReader(fichero1);
             FileReader lector2 = new FileReader(fichero2);
             FileWriter escritor = new FileWriter(destino)) {

            int caracter = lector1.read();
            while (caracter != -1) {
                escritor.write(caracter);
                caracter = lector1.read();
            }

            caracter = lector2.read();
            while (caracter != -1) {
                escritor.write(caracter);
                caracter = lector2.read();
            }

        } catch (IOException e) {
            IO.println("Error al concatenar archivos: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ejercicio10 gestor = new Ejercicio10();

        IO.println("Introduce el directorio:");
        String directorio = sc.nextLine();

        IO.println("Introduce el nombre del primer archivo:");
        String archivo1 = sc.nextLine();

        IO.println("Introduce el nombre del segundo archivo:");
        String archivo2 = sc.nextLine();

        IO.println("Introduce el nombre del archivo de destino:");
        String destino = sc.nextLine();

        gestor.concat(directorio, archivo1, archivo2, destino);

        IO.println("Archivo concatenado creado correctamente.");

        sc.close();
    }
}