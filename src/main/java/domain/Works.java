package domain;

public class Works {
    private String type;
    private String size;
    private String preferCompleteDate;
    private Reported reporter;
    private Team team;

    public Works() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPreferCompleteDate() {
        return preferCompleteDate;
    }

    public void setPreferCompleteDate(String preferCompleteDate) {
        this.preferCompleteDate = preferCompleteDate;
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
