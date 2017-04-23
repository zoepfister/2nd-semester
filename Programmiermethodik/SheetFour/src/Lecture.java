import java.util.List;

/**
 * Created by clemenspfister on 06/04/2017.
 */
public interface Lecture {
    Employee getEmployee();

    List<Student> getStudents();

    void addStudent(Student s);
}
