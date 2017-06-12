package Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 08.06.2017.
 */
public class Lesson {
    private Long lessonId;
    private String lessonName;
    private Date dateBeg;
    private Date dateEnd;
    private String auditoryNumber;
    private String description;
    private Long subjectId;
    private String lector;
    private List<Long> groupList;

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public Date getDateBeg() {
        return dateBeg;
    }

    public void setDateBeg(Date dateBeg) {
        this.dateBeg = dateBeg;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getAuditoryNumber() {
        return auditoryNumber;
    }

    public void setAuditoryNumber(String auditoryNumber) {
        this.auditoryNumber = auditoryNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getLector() {
        return lector;
    }

    public void setLector(String lector) {
        this.lector = lector;
    }

    public Lesson(Long lessonId, String lessonName, Date dateBeg, Date dateEnd,
                  String auditoryNumber, String description, Long subjectId, String lector) {
        this.lessonId = lessonId;
        this.lessonName = lessonName;
        this.dateBeg = dateBeg;
        this.dateEnd = dateEnd;
        this.auditoryNumber = auditoryNumber;
        this.description = description;
        this.subjectId = subjectId;
        this.lector = lector;
        this.groupList = new ArrayList<>();
    }

    @Override
    public int hashCode() {
        return (int) (21 + lessonId * 42);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Lesson)) return false;
        if (this.lessonId == ((Lesson)obj).lessonId) return true;
        return super.equals(obj);
    }
}


