/**
 * Created by clemenspfister on 31/03/2017.
 */

public class Main {

    public static void main(String[] args) {
        // Two professor objects
        Professor professor1 = new Professor("John", "Doe");
        Professor professor2 = new Professor(5430.0, "Richard", "Wagner");

        // room1 with capacity of 25
        Room room1 = new Room(365, 25);
        Course course1 = new Course(1, room1, professor1);

        // Add 30 students to this room
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
        System.out.println("There are " + course1.students.size() + " students in this course.");

        // Add one more student
        course1.addStudent(sameIdStudent1);

        // Print NoS again
        System.out.println("There are " + course1.students.size() + " students in this course.");

        // Print professor with currentSalary using toString
        // If we want to print out n professors, we need a datastructure like an array or a list.
        System.out.println("Current salary of " + professor1.toString() + ": " + professor1.currentSalary);
        System.out.println("Current salary of " + professor2.toString() + ": " + professor2.currentSalary);

        // Test if sameId students are the same (use devtools)
        // This returns true because in the equals method, we specified that if
        // two IDs are identical, the students are, too.
        System.out.println(sameIdStudent1.equals(sameIdStudent2));

        // Are two students without same IDs equal?
        // returns false because neither are these student objects the same
        // (e.g. have the same internal value) nor do they have the same IDs.
        System.out.println(sameIdStudent1.equals(sameNameStudent3));

        // Print a student without toString();
        // prints Student@5cad8086 on my machine (this is
        // the internal identifier for this student object).
        System.out.println(sameIdStudent1);
    }
}
