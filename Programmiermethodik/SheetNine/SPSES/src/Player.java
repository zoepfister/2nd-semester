import java.util.Scanner;

public class Player extends PlayerOptions {

    static int playerNumber = 0;
    Scanner playerInputScanner;
    String name = "Player" + ++playerNumber;
    int wins = 0;
    int loses = 0;
    int draw = 0;

    Player() {
        super();
        playerInputScanner = new Scanner(System.in);
    }

    private void clearScreen(){
        for (int i = 0; i < 5; i++) {
            System.out.println("\b");
        }
    }

    public choices getChoise() {
        clearScreen();
        System.out.println(this.name + ": enter your choise: R=Rock, P=Paper, S=Scissors, L=Lizard, C or K=Spock");
        switch (playerInputScanner.nextLine().toUpperCase().charAt(0)) {
            case 'R':
                return choices.rock;
            case 'P':
                return choices.paper;
            case 'S':
                return choices.scissors;
            case 'L':
                return choices.lizard;
            case 'C':
            case 'K':
                return choices.spock;
        }
        System.out.println("Invalid input!");
        return getChoise();
    }

    void addWin(){
        ++wins;
    }
}
