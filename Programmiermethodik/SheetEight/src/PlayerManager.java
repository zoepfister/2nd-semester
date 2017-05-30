import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Created by clemenspfister on 29/05/2017.
 */


public class PlayerManager {
    public List<Player> players;

    List<Player> readPlayers(){
        File file = new File("/Volumes/Macintosh–HHD/GitHub Programming/2nd-semester/Programmiermethodik/SheetEight/Resources/players.txt");
        ArrayList<Player> playerArrayList = new ArrayList<>();
        try {
            // Create a new Scanner object which will read the data
            // from the file passed in. To check if there are more
            // line to read from it we check by calling the
            // scanner.hasNextLine() method. We then read line one
            // by one till all lines is read.
            Scanner scanner = new Scanner(file).useDelimiter("\t");
            while (scanner.hasNextLine()) {
                Player player = new Player();
                player.id = scanner.nextInt();
                player.firstName = scanner.next();
                player.lastName = scanner.next();
                String line = scanner.nextLine();
                player.strength = Character.getNumericValue(line.charAt(1));
                playerArrayList.add(player);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find specified file! Exiting..");
        }
        return playerArrayList;
    }

    void increaseStrength7(){
        for (int i = 0; i < players.size(); i++) {
            players.get(i).strength += 1;
        }
    }

    void increaseStrength8(){
        for (Player player : players) {
            player.strength += 1;
        }
    }

    static void printPlayers(PlayerManager players){
        for (Player player: players.players) {
            System.out.println(player);
        }
    }

    /* Just to test some */
    public static void main(String[] args) {
        PlayerManager playerManager = new PlayerManager();
        playerManager.players = playerManager.readPlayers();
        printPlayers(playerManager);
        playerManager.increaseStrength8();
        printPlayers(playerManager);
    }

}
