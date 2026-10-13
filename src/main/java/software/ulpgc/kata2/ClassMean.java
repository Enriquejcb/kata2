package software.ulpgc.kata2;

import java.util.List;

public class ClassMean {
    public int mean(List<Student> allStudents){
        int sum = 0;
        for (Student note : allStudents) {
            sum += note.note();
        }
        return sum / allStudents.size();
    }
}
