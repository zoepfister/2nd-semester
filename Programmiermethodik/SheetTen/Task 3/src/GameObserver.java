

/**
 * Created by clemenspfister on 16/06/2017.
 */
class GameObserver extends CustomObserver {

    private int p1Wins;
    private int p2Wins;
    private int draws;

    public GameObserver(Game game) {
        this.game = game;
        this.game.add(this);
        this.p1Wins = game.getP1Wins();
        this.p2Wins = game.getP2Wins();
        this.draws = Player.getDraws();
    }

    public void setValue(){
        this.p1Wins = game.getP1Wins();
        this.p2Wins = game.getP2Wins();
        this.draws = Player.getDraws();
    }

    public void update() {
        System.out.println(p1Wins + p2Wins + draws);
    }
}
