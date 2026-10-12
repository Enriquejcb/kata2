package Software.ulpgc.kata2;

import software.ulpgc.kata2.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvStudentLoader implements StudentLoader {
    @Override
    public List<Student> load(InputStream is) {



        BufferedReader csv = new BufferedReader(new InputStreamReader(is));
        List<Student> allStudents = new ArrayList<>();

        String line = "";
        boolean firstsLine = true;
        while(true){

            try {
                if ((line = csv.readLine()) == null) break;
            } catch (IOException e) {
                System.out.println("Error tipo: " + e.getLocalizedMessage());
            }
            if (firstsLine){ firstsLine=false; continue;}
            String[] attributes = line.split(",");
            Student newStudent = new Student(attributes[0], Integer.parseInt(attributes[1]));
            allStudents.add(newStudent);
        }
        return allStudents;
