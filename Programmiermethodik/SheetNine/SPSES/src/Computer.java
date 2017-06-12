/**
 * Created by clemenspfister on 10/06/2017.
 */

import java.util.Random;

public class Computer extends Player {
    private Random random;

    public Computer() {
        super();
        this.random    = new Random();
    }

    public choices getChoise(){
        int randBetween0and2 = random.nextInt(choices.values().length); // I don't know how efficient this thing is
        switch (randBetween0and2){
            case 0: System.out.println("Computer chose rock");return choices.rock;
            case 1: System.out.println("Computer chose paper");return choices.paper;
            case 2: System.out.println("Computer chose scissors"); return choices.scissors;
            case 3: System.out.println("Computer chose lizard");return choices.lizard;
            case 4: System.out.println("Computer chose spock");return choices.spock;
            default:System.out.println("I am Error");return choices.paper;
        }
    }

}
