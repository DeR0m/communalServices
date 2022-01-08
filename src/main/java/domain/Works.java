package domain;

public class Works{
    private String type;
    private String size;
    private String preferCompleteDate;
    private Reported reporter;
    private Team team;

    public Works() {
    }

    public Works(String type, String size, String preferCompleteDate) {
        this.type = type;
        this.size = size;
        this.preferCompleteDate = preferCompleteDate;
    }

    public String getType() {
        return type;
    }

    public String setType(String type) {
        this.type = type;
        return type;
    }

    public String getSize() {
        return size;
    }

    public String setSize(String size) {
        this.size = size;
        return size;
    }

    public String getPreferCompleteDate() {
        return preferCompleteDate;
    }

    public String setPreferCompleteDate(String preferCompleteDate) {
        this.preferCompleteDate = preferCompleteDate;
        return preferCompleteDate;
    }

    public Reported getReporter() {
        return reporter;
    }

    public void setReporter(Reported reporter) {
        this.reporter = reporter;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "works{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", preferCompleteDate='" + preferCompleteDate + '\'' +
                ", reporter=" + reporter +
                ", team=" + team +
                '}';
    }
}
