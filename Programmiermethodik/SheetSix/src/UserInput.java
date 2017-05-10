import java.util.Scanner;

public class UserInput {


    public static int parseStringToInt() {
        // Bool to check if we got though try
        boolean success = false;

        Scanner scanner = new Scanner(System.in);

        do {
            try {

                System.out.print("Please input a number: ");
                String input = scanner.nextLine();

                // Might throw an exception
                int number = Integer.parseInt(input);

                // if it didn't:
                success = true;
                scanner.close();
                return number;

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid option!");
            }
        } while (!success);
        // For the compiler
        return 0;
    }

    public static void main(String[] args) {

        int number = parseStringToInt();

        System.out.println("x = " + number);
        System.out.println("x² = " + (number * number));

    }

}
