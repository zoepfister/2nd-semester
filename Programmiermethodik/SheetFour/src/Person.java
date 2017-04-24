/**
 * Created by clemenspfister on 06/04/2017.
 */
public class Person {
    protected String firstname;
    public String lastname;
    private int age;

    public Person() {
        System.out.println("Created Person Object!");
    }

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Person(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Firstname: " + firstname + "; Lastname: " + lastname;
    }
}
