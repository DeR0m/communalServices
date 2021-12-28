package domain;

import java.util.List;

public class CommunalServices {
    private String description;
    private List<Works> works;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Works> getWorks() {
        return works;
    }

    public void setWorks(List<Works> works) {
        this.works = works;
    }
}
