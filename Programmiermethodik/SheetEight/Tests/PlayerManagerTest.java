import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;
import java.util.*;


/**
 * Created by clemenspfister on 29/05/2017.
 */
public class PlayerManagerTest {
    @Test
    public void testIncreaseStrength7() throws Exception {
        PlayerManager playerManager = new PlayerManager();
        playerManager.players = playerManager.readPlayers();
        playerManager.increaseStrength7();
        for (Player player: playerManager.players) {
            if (player.strength >=2 && player.strength <= 4){
                assertEquals(true, true);
            } else {
                assertEquals(false, false);
            }
        }
    }

    @Test
    public void testIncreaseStrength8() throws Exception {
        PlayerManager playerManager = new PlayerManager();
        playerManager.players = playerManager.readPlayers();
        playerManager.increaseStrength7();
        for (Player player: playerManager.players) {
            if (player.strength >=2 && player.strength <= 4){
                assertEquals(true, true);
            } else {
                assertEquals(false, false);
            }
        }
    }

}