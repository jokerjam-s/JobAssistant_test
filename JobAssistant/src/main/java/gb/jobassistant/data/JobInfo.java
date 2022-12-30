package gb.jobassistant.data;

/**
 * Описание рабочей вакансии
 */
public class JobInfo {
    private Integer id;
    private String name;
    private String skills;
    private String text;
    private Double summa;
    private JobKind jobKind;

    public JobInfo() {
    }

    public JobInfo(String name, String skills, String text, Double summa, JobKind jobKind) {
        this.id = 0;
        this.name = name;
        this.skills = skills;
        this.text = text;
        this.summa = summa;
        this.jobKind = jobKind;
    }

    @Override
    public String toString() {
        String kind;

        switch (jobKind){
            case REMOTE -> kind = "удаленно";
            case OFFICE -> kind = "офис";
            default -> kind = "смешанный";
        }

        return String.format(
                "%5d | %10s | %20s | %20s | %8.2f | %s",
                id, name, skills, text, summa, kind
        );
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Double getSumma() {
        return summa;
    }

    public void setSumma(Double summa) {
        this.summa = summa;
    }

    public JobKind getJobKind() {
        return jobKind;
    }

    public void setJobKind(JobKind jobKind) {
        this.jobKind = jobKind;
    }
}
