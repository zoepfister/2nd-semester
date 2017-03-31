/**
 * Created by clemenspfister on 23/03/2017.
 */
public class MainClass {
    public static void main(String[] args) {

        Student student1 = new Student(05, "Jack", "Nition");
        Student student2 = new Student(06, "Mat", "Hematik");
        Student student3 = new Student(07, "John", "Revolver");
        Student student4 = new Student(07, "Ned", "Bigbee");

        Professor professor1 = new Professor("James", "Bond");
        System.out.println(professor1.toString());

        Course course1 = new Course();
        course1.setCourseName("Programmiermethodik");
        course1.room = new Room(001, 3);
        System.out.println("There are " + course1.getStudentAmount() + " students in this course.");
        course1.printStudents();

        System.out.println("\n----------------------------------------\n");

        course1.addStudent(student1);
        course1.addStudent(student2);
        System.out.println("There are " + course1.getStudentAmount() + " students in this course.");
        course1.printStudents();

        System.out.println("\n----------------------------------------\n");

        course1.removeStudent(student2);
        System.out.println("There are " + course1.getStudentAmount() + " student(s) in this course.");
        course1.printStudents();

        System.out.println("\n-----------------2d---------------------\n");

        course1.removeStudent(student1);
        System.out.println("There are " + course1.getStudentAmount() + " student(s) in this course.");
        course1.addStudent(student1);
        course1.addStudent(student1);
        course1.addStudent(student2);
        System.out.println("There are " + course1.getStudentAmount() + " student(s) in this course.");
        course1.printStudents();


        // A few more tests

        System.out.println("\n----------------------------------------\n");

        course1.removeStudent(student1);
        course1.removeStudent(student3);

        System.out.println(student1.equals(student2));

        course1.addStudent(student1);
        // Student 2 already in course
        course1.addStudent(student4);
        course1.addStudent(student1);

        course1.setMaxStudents(-1);

    }
}
