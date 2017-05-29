/**
 * Created by clemenspfister on 29/05/2017.
 */
public class Player {
    int id;
    String firstName;
    String lastName;
    int strength;

    @Override
    public String toString() {
        return id + ": " + firstName + " " + lastName + " " + strength + ".";
    }
}
