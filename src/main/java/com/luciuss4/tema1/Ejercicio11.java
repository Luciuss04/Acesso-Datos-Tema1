package com.luciuss4.tema1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio11 {

    public void concatLines(String directorio, String archivo1, String archivo2, String archivoDestino) {
        File fichero1 = new File(directorio, archivo1);
        File fichero2 = new File(directorio, archivo2);
        File destino = new File(directorio, archivoDestino);

        try (BufferedReader lector1 = new BufferedReader(new FileReader(fichero1));
             BufferedReader lector2 = new BufferedReader(new FileReader(fichero2));
             BufferedWriter escritor = new BufferedWriter(new FileWriter(destino))) {

            String linea1 = lector1.readLine();
            String linea2 = lector2.readLine();

            while (linea1 != null || linea2 != null) {
                String textoLinea1;
                if (linea1 != null) {
                    textoLinea1 = linea1;
                } else {
                    textoLinea1 = "";
                }

                String textoLinea2;
                if (linea2 != null) {
                    textoLinea2 = linea2;
                } else {
                    textoLinea2 = "";
                }

                escritor.write(textoLinea1 + textoLinea2);
                escritor.newLine();

                linea1 = lector1.readLine();
                linea2 = lector2.readLine();
            }

        } catch (IOException e) {
            IO.println("Error al concatenar líneas: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ejercicio11 gestor = new Ejercicio11();

        IO.println("Introduce el directorio:");
        String directorio = sc.nextLine();

        IO.println("Introduce el nombre del primer archivo:");
        String archivo1 = sc.nextLine();

        IO.println("Introduce el nombre del segundo archivo:");
        String archivo2 = sc.nextLine();

        IO.println("Introduce el nombre del archivo de destino:");
        String destino = sc.nextLine();

        gestor.concatLines(directorio, archivo1, archivo2, destino);

        IO.println("Archivo con líneas concatenadas creado correctamente.");

        sc.close();
    }
}