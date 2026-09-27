package com.luciuss4.tema1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio7 {

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

    public void leerArchivoTexto(String directorio, String archivo) {
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

    public void verBinario(String directorio, String archivo) {
        File fichero = new File(directorio, archivo);

        try (FileInputStream binario = new FileInputStream(fichero)) {

            int byte1 = binario.read();
            int contador = 0;

            while (byte1 != -1) {
                int byte2 = binario.read();
                // se pone el & 0xFF por si el int es negativo para poderlo expresar en hexadecimal
                IO.println(String.format("%02x", byte1 & 0xFF));

                if (byte2 != -1) {
                    IO.println(String.format("%02x", byte2 & 0xFF));
                }

                contador = contador + 1;
                byte1 = binario.read();
            }

        } catch (IOException e) {
            IO.println("Error al leer el archivo binario: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ejercicio7 gestor = new Ejercicio7();

        IO.println("Introduce el directorio:");
        String directorio = sc.nextLine();

        IO.println("Introduce el nombre del archivo binario:");
        String archivo = sc.nextLine();

        gestor.verBinario(directorio, archivo);

        sc.close();
    }
}