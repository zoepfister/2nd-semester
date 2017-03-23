/**
 * Created by clemenspfister on 23/03/2017.
 */
public class Student {
    int id;
    String firstName;
    String lastName;

    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student() {
        System.out.println("A new Student object has been created!");
    }

    public void printStudent() {
        System.out.println("Name: " + this.firstName + " " + this.lastName + ", ID: " + this.id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
