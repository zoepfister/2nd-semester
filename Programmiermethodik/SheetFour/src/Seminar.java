/**
 * Created by clemenspfister on 06/04/2017.
 */
public class Seminar extends Course {
    // Can't do anything if this is final
    private static int seminarID = 0;

    public Seminar(int courseID, Room room, int seminarID) {
        super(courseID, room);
        Seminar.seminarID = seminarID;
        // according to sheet, this must be value of 30
        room.capacity = 30;
    }

    public Seminar(int courseID, Room room, Employee employee, int seminarID) {
        super(courseID, room, employee);
        Seminar.seminarID = seminarID;
        room.capacity = 30;
    }

    @Override
    public void addStudent(Student student) {
        // Compare student amount with roomCapacity
        if (students.size() >= room.capacity) {
            roomIsFull = true;
            System.out.println("Room capacity has been reached.");
            // This would allow us to not be able to add any more students
            return;
        } else {
            roomIsFull = false;
        }
        // Check if student is already in course
        if (students.contains(student)) {
            System.out.println("This student is already visiting this course!");
            return;
        }
        // Appends the specified element to the end of this list.
        this.students.add(student);

        // To beautify, added two print cases
        if ((student.firstname == null) || (student.lastname == null)) {
            System.out.println("Student with id " + student.studentId + " has been added.");
        } else {
            System.out.println("Student " + student.getFirstname() + " " + student.getLastname() + " has been added.");
        }
    }
}
