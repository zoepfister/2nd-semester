/**
 * Created by clemenspfister on 31/03/2017.
 */
public class Professor extends Employee {
    // For implementing the `get's more when teaching

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

    // Shameless copy of student equals method
    public boolean equals(Professor professor) {

        if (this == professor) {
            return true;
        }

        if (professor == null) {
            return false;
        }

        if (!(professor instanceof Professor)) {
            return false;
        }

        // Professor class has no id -> don't need to check that
        return false;
    }

    @Override
    public String toString() {
        // In case we need to print it out directly here:
        /// System.out.println(firstname + " " + lastname);
        return firstname + " " + lastname;
    }
}
