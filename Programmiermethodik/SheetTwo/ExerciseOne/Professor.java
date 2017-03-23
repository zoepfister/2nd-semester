/**
 * Created by clemenspfister on 23/03/2017.
 */
public class Professor {

    String firstName;
    String lastName;
    double jearlyRevenue;

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

    public double getJearlyRevenue() {
        return jearlyRevenue;
    }

    public void setJearlyRevenue(double jearlyRevenue) {
        this.jearlyRevenue = jearlyRevenue;
    }

    /**
     * ======= Exercise 1c ========
     */

    // Empty constructor
    public Professor() {
        System.out.println("Successfully created a new Professor object!");
    }

    // Full constructor
    public Professor(String firstName, String lastName, double jearlyRevenue) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jearlyRevenue = jearlyRevenue;
    }

    public void printName() {
        System.out.println(this.firstName + " " + this.lastName);
    }

    public double calculateRevenueOfMonth(int month) {
        double monthlyRevenue = this.jearlyRevenue / 14;
        monthlyRevenue = Math.round(monthlyRevenue * 100.0) / 100.0;
        if ((month == 3) || (month == 6) || (month == 9) || (month == 12)) {
            // if 1.5-Month, then return 1.5*monthlyRevenue (rounded to 2 Decimals for readability)
            // TODO: create better double formatting (maybe return string...)
            return monthlyRevenue * 1.5;
        } else {
            return monthlyRevenue;
        }

    }


}
