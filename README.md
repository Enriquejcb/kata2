# Kata 2: Input, Output and Data Loading

## Purpose of the Assignment
The main goal of this kata is to practice reading data through `InputStream`, transforming it into domain objects, and writing a statistical summary using `OutputStream`. The program is designed to clearly separate the business logic from the concrete sources and destinations of the data, avoiding coupling reading and writing to specific physical files.

## Dependencies and Environment
* **Language:** Java
* **JDK version:** OpenJDK-26
* **Dependency manager:** Maven (pom.xml)
* **External libraries:** None (only standard Java I/O classes).

## Project Structure and Main Classes
The design follows the separation of responsibilities principle.
* `Student`: Domain entity that represents a row of the dataset (name and grade).
* `StudentLoader`: Interface that defines the loading contract, receiving a generic `InputStream`.
* `CsvStudentLoader`: Implementation (adapter) that processes comma-separated text, discarding headers and malformed lines.
* `ClassMean`: Class responsible for the transformation and calculation (class average grade).
* `Main`: Acts as the assembler. It connects the input pipes (`FileInputStream`) and output pipes (`FileOutputStream` / `System.out`), and coordinates the data flow without knowing the parsing details.

## Build and Run
To run the project:
1. Clone this repository.
2. Open a terminal in the project root.
3. Make sure the file `InPutKata2.csv` is in the main directory.
4. Compile and run the `Main` class from your IDE (IntelliJ IDEA) or using Maven.

   You can watch the explanatory video here:
   https://drive.google.com/file/d/1b_mJuGfk45gvBPXrU8BlKqDWB5fabbhW/view?usp=sharing
