package Models;

/**
 * Created by admin on 08.06.2017.
 */
public class Subject {
    private Long subjectId;
    private String subjectName;

    public Subject(Long subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public int hashCode() {
        return (int) (21 + subjectId * 42);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Subject)) return false;
        if (this.subjectId == ((Subject)obj).subjectId) return true;
        return super.equals(obj);
    }
}
