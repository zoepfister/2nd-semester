/**
 * Created by clemenspfister on 06/04/2017.
 */
public class Secretary extends Employee {
    private static double minSalary = 100.0;
    private double salary;


    public Secretary() {
        System.out.println("Created new Secretary Object!");
    }

    public Secretary(String firstname, String lastname) {
        super(firstname, lastname);
        salary = minSalary;
    }

    public Secretary(String firstname, String lastname, double salary) {
        super(firstname, lastname);
        if (salary <= 0) {
            System.err.println("Please enter a salary above 0!");
            this.salary = minSalary;
        } else {
            this.salary = salary;
        }
    }

    public void raisePayOut(float parameter) {
        if (parameter <= 0) {
            System.err.println("You entered a smaller or equal value than 0 - no changes have been made.");
            return;
        }
        double tempSalary = ((salary * 100) / parameter);
        // If tempSalary is greater than maxSalary, set salary to maxSalary,
        // tempSalary else.
        salary = tempSalary >= maxSalary ? maxSalary : tempSalary;
    }
}
