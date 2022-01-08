package domain;

public class Members {
    private String name;

    public Members() {
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
        return "name='" + name + '\'' +
                '}';
    }
}
