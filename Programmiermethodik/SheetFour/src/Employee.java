/**
 * Created by clemenspfister on 06/04/2017.
 */
// Employee is an abstract form of e.g.
// Professor or Secretary
abstract public class Employee extends Person {
    double salary;
    protected double minSalary = 500.0;
    protected double maxSalary = 5000.0;

    protected Employee() {
        System.out.println("Created Employee Object!");
    }

    protected Employee(String firstname, String lastname) {
        super(firstname, lastname);
        salary = minSalary;
    }

    protected Employee(String firstname, String lastname, double salary) {
        super(firstname, lastname);
        this.salary = salary;
    }

    // TODO: Rename parameter to something useful
    protected void raisePayOut(double parameter) {
        if (parameter <= 0) {
            System.err.println("You entered a smaller or equal value than 0 - no changes have been made.");
            return;
        }
        // actual percent increase
        double tempSalary = salary + ((parameter * salary) / 100);
        // If tempSalary is greater than maxSalary, set salary to maxSalary,
        // tempSalary else.
        salary = tempSalary >= maxSalary ? maxSalary : tempSalary;

    }

}
