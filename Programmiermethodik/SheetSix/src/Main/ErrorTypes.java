import java.io.File;
import java.util.ArrayList;

/**
 * Created by clemenspfister on 10/05/2017.
 */
public class ErrorTypes {
    public static void main(String[] args) {
        // Unchecked Exception
        // java.lang.IndexOutOfBoundsException: Index: 5, Size: 0
        // String a = new ArrayList<String>().get(5);

        // Error Error Error:(12, 42) java: unreported exception
        // java.io.IOException; must be caught or declared to be thrown
        // new File("foo bar").createNewFile();

        // Actually, no error get's thown but it's an ininite Loop, so
        // Checked Exception because it could be user-defined
        while (true) {
            System.out.println("foo bar");
            break;
        }
    }
}
