package Models;

/**
 * Created by admin on 08.06.2017.
 */
public class Journal {
    private Long id;
    private Long studentId;
    private Long lessonId;
    private boolean presence;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    public boolean isPresence() {
        return presence;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }

    @Override
    public int hashCode() {
        return (int) (21 + id * 42);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Journal)) return false;
        if (this.id == ((Journal)obj).id) return true;
        return super.equals(obj);
    }
}
