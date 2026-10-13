package Software.ulpgc.kata2;

import java.io.*;
import java.util.List;

public class Main {
    public  static void main(String[] args)  {

        try {
            InputStream inputInfo = new FileInputStream("C:\\Users\\User\\Desktop\\InPutKata2.csv");

            OutputStream outputInfo = new FileOutputStream("C:\\Users\\User\\Desktop\\OutPutKata2.txt");


            CsvStudentLoader converter = new CsvStudentLoader();

            List<Student> ClassList = converter.load(inputInfo);

            ClassMean classMeanCalculator = new ClassMean();

            int mean = classMeanCalculator.mean(ClassList);

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputInfo));
            writer.write("la nota media de las notas de la clase es " + mean);
            System.out.println("la nota media de las notas de la clase es " + mean);

            writer.flush();
            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println("Salio el error: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
