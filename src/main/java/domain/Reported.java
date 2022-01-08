package domain;

public class Reported {
    private String name;

    public Reported() {
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                '}';
    }
}
