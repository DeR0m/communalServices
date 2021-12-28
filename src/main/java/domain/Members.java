package domain;

import java.util.List;

public class Members {
    private String name;

    public Members() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                '}';
    }
}
