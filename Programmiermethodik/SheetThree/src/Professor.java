/**
 * Created by clemenspfister on 31/03/2017.
 */
public class Professor {
    double minSalary;
    double maxSalary;
    double currentSalary;
    String firstname;
    String lastname;
    // For implementing the `get's more when teaching`
    boolean isTeaching;

    public Professor() {
        System.out.println("Professor created successfully.");
        isTeaching = true;
    }

    // If this constructor is called, salary should be set to the minSalary
    public Professor(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        currentSalary = minSalary;
        isTeaching = true;
    }

    // First-, lastname & currentSalary
    public Professor(double salary, String firstname, String lastname) {
        this.currentSalary = salary;
        this.firstname = firstname;
        this.lastname = lastname;
        isTeaching = true;
    }

    // Getter / Setter
    public double getCurrentSalary() {
        return currentSalary;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    // Start of Task 2

    public void raisePayout(int parameter) {
        currentSalary = (100 * currentSalary) / parameter;
        // If currentSalary is bigger then maxSalary, set the currentSalary to maxSalary, else do nothing
        currentSalary = currentSalary > maxSalary ? maxSalary : currentSalary;
    }

    public void raisePayout(double parameter) {
        currentSalary = (100 * currentSalary) / parameter;
        currentSalary = currentSalary > maxSalary ? maxSalary : currentSalary;
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
