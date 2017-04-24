import java.util.List;

/**
 * Created by clemenspfister on 06/04/2017.
 */
public interface Lecture {
    Employee getEmployee();

    List<Student> getStudents();

    void addStudent(Student s);

    // Will throw an error
    // void addTeacher(Employee employee);
    /*
    *
    Error:(80, 18) java: addTeacher(Employee) in Course cannot implement addTeacher(Employee) in Lecture
    attempting to assign weaker access privileges; was public

    Error:(22, 18) java: addTeacher(Employee) in Seminar cannot implement addTeacher(Employee) in Lecture
    attempting to assign weaker access privileges; was public
    *
    * */

}
