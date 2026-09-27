# Tema 1 — Acceso a ficheros

Proyecto Java con la resolución del **Boletín 1** de la Unidad 1 (Acceso a ficheros), del módulo *Acceso a datos*.

- **Package base:** `com.luciuss4.tema1`
- **Versión de Java:** 25
- **Carpeta de pruebas:** `src/main/resources/ficheros`

## Preparación

Todos los ejercicios trabajan sobre la carpeta `src/main/resources/ficheros`, que contiene archivos y subcarpetas de ejemplo:

```
ficheros/
├── prueba1.txt
├── prueba2.txt
├── ejemplo1.bin
├── ejemplo2.bin
├── programa.exe
├── documentos/
│   ├── subcarpeta1/
│   │   └── nota.txt
│   └── subcarpeta2/
│       └── apuntes.txt
└── imagenes/
```


## Ejercicios

### Ejercicio 1 — `Ejercicio1.java`
Comprueba con la clase `File` si la carpeta de ejercicios existe y si es un directorio, usando `exists()` e `isDirectory()`. Si no existe, lanza `FileNotFoundException`; si existe pero no es un directorio, lo indica por separado.

### Ejercicio 2 — `Ejercicio2.java`
Lista el contenido de primer nivel (no recursivo) de la carpeta con `listFiles()`, recorriendo el array `File[]` con un `for` y mostrando el nombre de cada elemento con `getName()`.

### Ejercicio 3 — `Ejercicio3.java`
Muestra las propiedades de la carpeta: nombre (`getName()`), ruta absoluta (`getAbsolutePath()`), si se puede leer (`canRead()`) y si se puede escribir (`canWrite()`).

### Ejercicio 4 — `Ejercicio4.java`
Muestra las propiedades de un archivo: nombre, ruta absoluta, si está oculto (`isHidden()`), permisos de lectura/escritura, fecha de última modificación (formateada con `SimpleDateFormat`), cambio de la fecha a la actual (`setLastModified()`) y tamaño en bytes, KB y MB (`length()`).

### Ejercicio 5 — `Ejercicio5.java`
Clase con tres métodos:
- `crearArchivo(directorio, archivo)`: crea un archivo vacío con `createNewFile()`.
- `listarDirectorio(directorio)`: lista cada elemento mostrando tipo (fichero/directorio), tamaño y permisos.
- `verInfo(directorio, archivo)`: muestra nombre, ruta absoluta, permisos, tamaño y si es fichero o directorio.

Los parámetros se piden al usuario por teclado con `Scanner`.

### Ejercicio 6 — `Ejercicio6.java`
Añade `leerArchivoTexto(directorio, archivo)`, que lee y muestra el contenido de un archivo de texto línea a línea con `FileReader` + `BufferedReader` (`readLine()` hasta `null`).

### Ejercicio 7 — `Ejercicio7.java`
Añade `verBinarioHex(directorio, archivo)`, que muestra el contenido de un archivo binario en hexadecimal, leyendo de dos en dos bytes con `FileInputStream` y formateando cada byte con `String.format("%02x", byte & 0xFF)` (la máscara `& 0xFF` evita el problema de la extensión de signo de los `byte` en Java).

### Ejercicio 8 — `Ejercicio8.java`
Programa que recibe la ruta de un archivo como parámetro (`String[] args`) y muestra su contenido de texto, comprobando antes que `args.length > 0`.

### Ejercicio 9 — `Ejercicio9.java`
Método `compararArchivos(directorio, archivo1, archivo2)` que compara byte a byte el contenido de dos archivos con `FileInputStream`, devolviendo `true` solo si todos los bytes coinciden **y** ambos archivos terminan a la vez (mismo tamaño).

### Ejercicio 10 — `Ejercicio10.java`
Método `concat(directorio, archivo1, archivo2, destino)` que crea un tercer archivo de texto uniendo primero todo el contenido del archivo 1 y a continuación todo el contenido del archivo 2, usando `FileReader`/`FileWriter` carácter a carácter.

### Ejercicio 11 — `Ejercicio11.java`
Método `concatLines(directorio, archivo1, archivo2, destino)` que crea un tercer archivo uniendo línea a línea el contenido de los dos archivos (línea N de archivo1 + línea N de archivo2), usando `BufferedReader`/`BufferedWriter`. Si un archivo tiene más líneas que el otro, sigue escribiendo las líneas restantes del que no ha terminado.

## Conceptos clave usados

| Necesidad | Clases usadas |
|---|---|
| Propiedades de archivos/directorios, crear, listar | `File` |
| Leer/escribir texto línea a línea | `FileReader` / `FileWriter`, `BufferedReader` / `BufferedWriter` |
| Leer/escribir binarios byte a byte | `FileInputStream` / `FileOutputStream` |
| Formatear fechas | `SimpleDateFormat` |

Todos los flujos (`Reader`, `Writer`, `InputStream`, `OutputStream`) se abren dentro de bloques `try (...)` con recursos (*try-with-resources*), para que se cierren automáticamente aunque se produzca una excepción.
