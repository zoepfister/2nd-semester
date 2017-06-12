import java.util.Scanner;

public class Game extends PlayerOptions{
	Player player1 = new Player();
	Player player2;

	public Game() {
		super();
		Scanner playerScanner = new Scanner(System.in);
			System.out.println("Möchten Sie gegen einen anderen Menschen=M oder gegen einen Computer=C spielen?");
			switch (playerScanner.nextLine().toUpperCase().charAt(0)) {
				case 'M':
					player2 = new Player();
					break;
				case 'C':
					player2 = new Computer();
					break;
				default:
					player2 = new Computer();
					System.out.println("Es wurde ein PC erstellt!"); // only info
			}
			playGame();
	}

	private void playGame(){
		while ((player1.wins < 3) && (player2.wins < 3)){
			result result = evaluate(player1.getChoise(), player2.getChoise());
			switch (result){
				case player1: player1.addWin();
					System.out.println("Player1 won!"); break;
				case player2: player2.addWin();
					System.out.println("Player2 won!"); break;
				case draw:
					System.out.println("Draw!");break;
			}
			whoWon(player1.wins, player2.wins);
		}
	}

	private void whoWon(int player1Wins, int player2Wins){
		if (player1Wins == 3){
			printWhoWon(result.player1);
		} else if (player2Wins == 3){
			printWhoWon(result.player2);
		}
	}

	private void printWhoWon(Player.result playerResult){
		System.out.println("Congratulations " + playerResult.toString().toUpperCase() + "!");
	}

	private result evaluate(choices player1Choice, choices player2Choice){
		if (player1Choice == player2Choice){
			return result.draw;
		}
		switch (player1Choice){
			case paper: return player2Choice == choices.rock ? result.player1 : player2Choice == choices.spock ? result.player1 : result.player2;
			case rock: return player2Choice == choices.scissors ? result.player1 : player2Choice == choices.lizard ? result.player1 : result.player2;
			case scissors: return player2Choice == choices.paper ? result.player1 : player2Choice == choices.lizard ? result.player1 : result.player2;
			case lizard: return player2Choice == choices.paper ? result.player1 : player2Choice == choices.spock ? result.player1 : result.player2;
			case spock: return player2Choice == choices.scissors ? result.player1 : player2Choice == choices.rock ? result.player1 : result.player2;
		}
		return null;
	}

	public static void main(String[] args) {
		Game game = new Game();
	}
}
