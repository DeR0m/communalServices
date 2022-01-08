package domain;

import java.util.List;

public class Team {
    private List<Members> members;

    public List<Members> getMembers() {
        return members;
    }

    public void setMembers(List<Members> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "members=" + members +
                '}';
    }
}
