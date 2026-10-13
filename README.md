# Kata 2: Entrada, salida y carga de datos

## Objetivo de la entrega
El objetivo principal de esta kata es practicar la lectura de datos mediante `InputStream`, su transformación en objetos de dominio, y la escritura de un resumen estadístico utilizando `OutputStream`. Se ha diseñado el programa para separar claramente la lógica de negocio de los orígenes y destinos concretos de los datos, evitando acoplar la lectura y escritura a archivos físicos específicos.

## Dependencias y Entorno
* **Lenguaje:** Java
* **Versión de JDK:** OpenJDK-27 
* **Gestor de dependencias:** Maven (pom.xml)
* **Bibliotecas externas:** Ninguna (uso exclusivo de las clases estándar de Java I/O).

## Estructura de la entrega y Clases principales
El diseño respeta la separación de responsabilidades
* `Student`: Entidad de dominio que representa una fila del dataset (nombre y nota).
* `StudentLoader`: Interfaz que define el contrato de carga recibiendo un genérico `InputStream`.
* `CsvStudentLoader`: Implementación (adaptador) que procesa texto separado por comas, descartando cabeceras y líneas mal formadas.
* `ClassMean`: Clase encargada de la transformación y cálculo (nota media de la clase).
* `Main`: Actúa como ensamblador. Conecta las tuberías de entrada (`FileInputStream`) y salida (`FileOutputStream` / `System.out`), y coordina el flujo de datos sin conocer los detalles del parseo.

## Compilación y Ejecución
Para ejecutar el proyecto:
1. Clona este repositorio.
2. Abre una terminal en la raíz del proyecto.
3. Asegúrate de tener el archivo `InPutKata2.csv` en el directorio principal.
4. Compila y ejecuta la clase `Main` desde tu IDE (IntelliJ IDEA) o usando Maven.

   En este link puedes ver el video explicativo: 
   https://drive.google.com/file/d/1b_mJuGfk45gvBPXrU8BlKqDWB5fabbhW/view?usp=sharing
