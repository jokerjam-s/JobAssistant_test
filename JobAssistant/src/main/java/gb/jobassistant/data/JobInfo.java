package gb.jobassistant.data;

/**
 * Описание рабочей вакансии
 */
public class JobInfo {
    private String name;
    private String skills;
    private String text;
    private Double summa;
    private JobKind jobKind;


    public JobInfo(String name, String skills, String text, Double summa, JobKind jobKind) {
        this.name = name;
        this.skills = skills;
        this.text = text;
        this.summa = summa;
        this.jobKind = jobKind;
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
