/**
 * Created by clemenspfister on 31/03/2017.
 */

public class Main {

    public static void main(String[] args) {
        Professor professor1 = new Professor("John", "Doe");
        Professor professor2 = new Professor(5430.0, "Richard", "Wagner");

        Room room1 = new Room(365, 25);
        Course course1 = new Course(1, room1, professor1);

        for (int i = 0; i < 30; i++) {
            course1.addStudent(new Student(i));
        }

        // If John Doe teaches a course give him an unfair amount of money
        if (professor1.isTeaching) {
            professor1.currentSalary *= 1.252;
        }

        // 25 = Magic number
        if ((course1.professor.equals(professor1)) && (course1.students.size() > 25)) {
            professor1.currentSalary *= 1.11;
        }

        // Add three more students
        Student sameIdStudent1 = new Student(100, "Mat", "Hematik");
        Student sameIdStudent2 = new Student(100, "Ham", "Burger");
        Student sameNameStudent3 = new Student(101, "Mat", "Hematik");

        // Print number of students in course
        System.out.println(course1.students.size());

        course1.addStudent(sameIdStudent1);

        // Print NoS again
        System.out.println(course1.students.size());

        // TODO: figure out how to toString double
        // professor1.toString(professor1.currentSalary);

        // Test if sameId students are the same (use devtools)
        System.out.println(sameIdStudent1.equals(sameIdStudent2));

        System.out.println(sameIdStudent1);
    }
}
