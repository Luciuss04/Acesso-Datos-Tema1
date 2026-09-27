package com.luciuss4.tema1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio6 {

    public boolean crearArchivo(String directorio, String archivo) {
        File fichero = new File(directorio, archivo);
        try {
            return fichero.createNewFile();
        } catch (IOException e) {
            IO.println("Error al crear el archivo: " + e.getMessage());
            return false;
        }
    }

    public void listarDirectorio(String directorio) {
        File carpeta = new File(directorio);
        File[] elementos = carpeta.listFiles();

        if (elementos != null) {
            for (int x = 0; x < elementos.length; x++) {
                File elemento = elementos[x];

                String tipo;
                if (elemento.isDirectory()) {
                    tipo = "directorio";
                } else {
                    tipo = "fichero";
                }

                String permisos = "";
                if (elemento.canRead()) {
                    permisos = permisos + "r";
                } else {
                    permisos = permisos + "-";
                }

                if (elemento.canWrite()) {
                    permisos = permisos + "w";
                } else {
                    permisos = permisos + "-";
                }

                IO.println(elemento.getName() + " " + tipo + " " + elemento.length() + " bytes " + permisos);
            }
        } else {
            IO.println("La ruta no es un directorio válido.");
        }
    }

    public void verInfo(String directorio, String archivo) {
        File fichero = new File(directorio, archivo);

        IO.println("Nombre: " + fichero.getName());
        IO.println("Ruta absoluta: " + fichero.getAbsolutePath());
        IO.println("¿Se puede escribir?: " + fichero.canWrite());
        IO.println("¿Se puede leer?: " + fichero.canRead());
        IO.println("Tamaño: " + fichero.length() + " bytes");
        IO.println("¿Es directorio?: " + fichero.isDirectory());
        IO.println("¿Es archivo?: " + fichero.isFile());
    }

    public void leerArchivo(String directorio, String archivo) {
        File fichero = new File(directorio, archivo);

        try (FileReader lector = new FileReader(fichero);
             BufferedReader buffferLector = new BufferedReader(lector)) {

            String linea = buffferLector.readLine();
            while (linea != null) {
                IO.println(linea);
                linea = buffferLector.readLine();
            }

        } catch (IOException e) {
            IO.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ejercicio6 gestor = new Ejercicio6();

        IO.println("Introduce el directorio:");
        String directorio = sc.nextLine();

        IO.println("Introduce el nombre del archivo:");
        String archivo = sc.nextLine();

        gestor.crearArchivo(directorio, archivo);
        gestor.listarDirectorio(directorio);
        gestor.verInfo(directorio, archivo);
        gestor.leerArchivo(directorio, archivo);

        sc.close();
    }
}