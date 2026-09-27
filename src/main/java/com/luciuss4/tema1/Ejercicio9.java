package com.luciuss4.tema1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio9 {

    public boolean compararArchivos(String directorio, String archivo1, String archivo2) {
        File fichero1 = new File(directorio, archivo1);
        File fichero2 = new File(directorio, archivo2);

        try (FileInputStream binario1 = new FileInputStream(fichero1);
             FileInputStream binario2 = new FileInputStream(fichero2)) {

            int byte1 = binario1.read();
            int byte2 = binario2.read();

            while (byte1 != -1 && byte2 != -1) {
                if (byte1 != byte2) {
                    return false;
                }
                byte1 = binario1.read();
                byte2 = binario2.read();
            }

            if (byte1 == -1 && byte2 == -1) {
                return true;
            } else {
                return false;
            }

        } catch (IOException e) {
            IO.println("Error al comparar archivos: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ejercicio9 gestor = new Ejercicio9();

        IO.println("Introduce el directorio:");
        String directorio = sc.nextLine();

        IO.println("Introduce el nombre del primer archivo:");
        String archivo1 = sc.nextLine();

        IO.println("Introduce el nombre del segundo archivo:");
        String archivo2 = sc.nextLine();

        boolean iguales = gestor.compararArchivos(directorio, archivo1, archivo2);

        if (iguales) {
            IO.println("Los archivos son iguales.");
        } else {
            IO.println("Los archivos son diferentes.");
        }

        sc.close();
    }
}