/**
 * Created by clemenspfister on 23/03/2017.
 */

public class Exercise1C {
    public static void main(String[] args) {

        Professor professor1 = new Professor("Erika", "Akire", 1500);
        Professor professor2 = new Professor();

        professor2.setFirstName("Max");
        professor2.setLastName("Milkman");
        professor2.setJearlyRevenue(2000);

        double revenueOfMonth = professor1.calculateRevenueOfMonth(2);

        professor2.printName();
        // System.out.println(professor2.firstName + " " + professor2.lastName);
        System.out.println(String.format("%1$,.2f", professor2.calculateRevenueOfMonth(12)));


        // We need this for special cases like 1000
        System.out.println(String.format("%1$,.2f", revenueOfMonth));

    }
}
