package domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.Member;
import java.util.ArrayList;
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
