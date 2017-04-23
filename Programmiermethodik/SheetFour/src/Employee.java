/**
 * Created by clemenspfister on 06/04/2017.
 */
abstract public class Employee extends Person {
    protected static double salary;
    protected static double minSalary = 500.0;
    protected static double maxSalary = 5000.0;

    public Employee() {
        System.out.println("Created Employee Object!");
    }

    public Employee(String firstname, String lastname) {
        super(firstname, lastname);
        // FIXME: How to do static stuff in Java
        // Hier soll eine lokale Gehalt-Variable auf einen statischen
        // Minimumgehalt gesetzt werden.
        salary = minSalary;
    }

    public Employee(String firstname, String lastname, double salary) {
        super(firstname, lastname);
        Employee.salary = salary;
    }

    // TODO: Rename parameter to something useful
    public void raisePayOut(double parameter) {
        if (parameter <= 0) {
            System.err.println("You entered a smaller or equal value than 0 - no changes have been made.");
            return;
        }
        double tempSalary = ((salary * 100) / parameter);
        // If tempSalary is greater than maxSalary, set salary to maxSalary,
        // tempSalary else.
        salary = tempSalary >= maxSalary ? maxSalary : tempSalary;

    }

    // TODO: Set all attributes to protected
}
