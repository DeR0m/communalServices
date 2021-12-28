package domain;

import java.util.List;

public class Reported {
    private String name;

    public Reported() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                '}';
    }
}
