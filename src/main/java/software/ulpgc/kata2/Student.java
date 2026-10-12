package software.ulpgc.kata2;

public class Student {
    private final String name;
    private final int note;

    public Student(String name, int note) {
        this.name = name;
        this.note = note;
    }

    public int getNote() {
        return note;
    }

    public String getName() {
        return name;
    }
}
