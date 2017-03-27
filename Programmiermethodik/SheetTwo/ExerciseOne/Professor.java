/**
 * Created by clemenspfister on 23/03/2017.
 */
public class Professor {

    String firstName;
    String lastName;
    double yearlyRevenue;

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

    public double getYearlyRevenue() {
        return yearlyRevenue;
    }

    public void setYearlyRevenue(double yearlyRevenue) {
        this.yearlyRevenue = yearlyRevenue;
    }

    /**
     * ======= Exercise 1c ========
     */

    // Empty constructor
    public Professor() {
        System.out.println("Successfully created a new Professor object!");
    }

    // Full constructor
    public Professor(String firstName, String lastName, double yearlyRevenue) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearlyRevenue = yearlyRevenue;
    }

    public void printName() {
        System.out.println(this.firstName + " " + this.lastName);
    }

    public double calculateRevenueOfMonth(int month) {
        double monthlyRevenue = this.yearlyRevenue / 14;
        monthlyRevenue = Math.round(monthlyRevenue * 100.0) / 100.0;
        if ((month == 3) || (month == 6) || (month == 9) || (month == 12)) {
            // if 1.5-Month, then return 1.5*monthlyRevenue (rounded to 2 Decimals for readability)
            // TODO: create better double formatting (maybe return string...)
            return monthlyRevenue * 1.5;
        } else {
            return monthlyRevenue;
        }

    }

    public static void main(String[] args) {

        Professor professor1 = new Professor("Erika", "Akire", 1500);
        Professor professor2 = new Professor();

        professor2.setFirstName("Max");
        professor2.setLastName("Milkman");
        professor2.setYearlyRevenue(1300);

        double revenueOfMonth = professor1.calculateRevenueOfMonth(2);

        professor2.printName();
        // System.out.println(professor2.firstName + " " + professor2.lastName);
        System.out.println(String.format("%1$,.2f", professor2.calculateRevenueOfMonth(12)));


        // We need this for special cases like 1000
        System.out.println(String.format("%1$,.2f", revenueOfMonth));

    }

}
