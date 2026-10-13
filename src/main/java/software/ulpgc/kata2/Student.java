package software.ulpgc.kata2;

public record Student(String name, int note) {
    @Override
    public int note() {
        return note;
    }

    @Override
    public String name() {
        return name;
    }
}
