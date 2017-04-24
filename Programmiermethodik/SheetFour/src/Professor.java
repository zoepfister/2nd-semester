/**
 * Created by clemenspfister on 31/03/2017.
 */
public class Professor extends Employee {

    public Professor() {
        System.out.println("Created a Professor!");
    }

    public Professor(String firstname, String lastname) {
        super(firstname, lastname);
    }

    public Professor(String firstname, String lastname, double salary) {
        super(firstname, lastname, salary);
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        // In case we need to print it out directly here:
        /// System.out.println(firstname + " " + lastname);
        return firstname + " " + lastname;
    }
}
