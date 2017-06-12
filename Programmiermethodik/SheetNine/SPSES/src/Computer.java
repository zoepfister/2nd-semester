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
        int randBetween0and2 = random.nextInt(3);

        switch (randBetween0and2){
            case 0: return choices.rock;
            case 1: return choices.paper;
            case 2: return choices.scissors;
            default: return choices.paper;
        }
    }

}
