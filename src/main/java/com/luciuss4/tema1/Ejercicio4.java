package com.luciuss4.tema1;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ejercicio4 {
    public static void main(String[] args) {
        File archivo = new File("src/main/resources/ficheros/prueba1.txt");

        IO.println("Nombre: " + archivo.getName());
        IO.println("Ruta absoluta: " + archivo.getAbsolutePath());
        IO.println("¿Oculto?: " + archivo.isHidden());
        IO.println("¿Se puede leer?: " + archivo.canRead());
        IO.println("¿Se puede escribir?: " + archivo.canWrite());

        // Paso 1: cogemos el número de milisegundos de la última modificación
        long milisegundos = archivo.lastModified();

        // Paso 2: lo convertimos en un objeto Date
        Date fecha = new Date(milisegundos);

        // Paso 3: definimos el formato en que queremos verla
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        // Paso 4: formateamos la fecha a texto
        String fechaTexto = formato.format(fecha);
        IO.println("Última modificación: " + fechaTexto);

        long ahora = System.currentTimeMillis();
        archivo.setLastModified(ahora);

        long nuevosMilisegundos = archivo.lastModified();
        Date nuevaFecha = new Date(nuevosMilisegundos);
        String nuevaFechaTexto = formato.format(nuevaFecha);
        IO.println("Nueva modificación: " + nuevaFechaTexto);

        long bytes = archivo.length();
        IO.println("Tamaño: " + bytes + " bytes");
        IO.println("Tamaño: " + (bytes / 1024.0) + " KB");
        IO.println("Tamaño: " + (bytes / (1024.0 * 1024.0)) + " MB");
    }
}