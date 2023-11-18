package HWII;

public class BlackJackOdds {
	
	//creating a class to simulate different games
	/*
	 * variables:
	 * dealerStand: int; the stand value for the dealer
	 * playerStand: int; the stand value for the dealer
	 * dealerIsHardStand: boolean; whether the dealer is standing hard or soft
	 * playerIsHardStand: boolean; whether the dealer is standing hard or soft
	 */
	public static void stimulateGame(int dealerStand, int playerStand, boolean dealerIsHardStand, boolean playerIsHardStand) {
		//variable assignment
		int dealerWin = 0;
		int playerWin = 0;
		int noWin = 0;
		
		//simulating the game 5000 times
		for(int i = 0; i < 5000; i++){
			//creating a new deck
			Deck d = new Deck();
			d.shuffle();
			
			//creating the dealer and player
			Player dealer = new Player(dealerStand, dealerIsHardStand);
			Player player = new Player(playerStand, playerIsHardStand);
			
			//the player plays first; then the dealer
			player.play(d);
			dealer.play(d);
			
			//determining the winner or 
			if (player.isBust()){
				dealerWin ++;
			}
			else if (!player.isBust() && dealer.isBust()) {
				playerWin ++;
			}
			else {
				int scoreComparison = player.compareScores(dealer);
				
				if (scoreComparison < 0) {
					dealerWin ++;
				}
				else if(scoreComparison > 0){
					playerWin ++;
				}
				else {
					noWin ++;
				}
			}
		}
		
		//determining the percentages
		int total = dealerWin + playerWin + noWin;
		
        double dealerWinPercentage = (double) dealerWin / total * 100;
        double playerWinPercentage = (double) playerWin / total * 100;
        double noWinPercentage = (double) noWin / total * 100;
        
        //print statements
        String dealerStandType = dealerIsHardStand ? "Hard" : "Soft";
        String playerStandType = playerIsHardStand ? "Hard" : "Soft";

        System.out.println("Dealer " + dealerStand + " (" + dealerStandType + ") vs Player " + playerStand + " (" + playerStandType + ")");
        System.out.printf("Dealer Won: %.2f%%\n", dealerWinPercentage);
        System.out.printf("Player Won: %.2f%%\n", playerWinPercentage);
        System.out.printf("No Winner: %.2f%%\n", noWinPercentage);
	}
	
	public static void main(String[] args) {
		//first section (9 total combinations)
		stimulateGame(16, 16, true, true);
		stimulateGame(17, 16, true, true);
		stimulateGame(18, 16, true, true);
		
		stimulateGame(16, 17, true, true);
		stimulateGame(17, 17, true, true);
		stimulateGame(18, 17, true, true);
		
		stimulateGame(16, 18, true, true);
		stimulateGame(17, 18, true, true);
		stimulateGame(18, 18, true, true);
		
		System.out.print ( "\n\n\n");
		
		//second section (18 total combinations)
		stimulateGame(16, 16, true, false);
		stimulateGame(17, 16, true, false);
		stimulateGame(18, 16, true, false);
		
		stimulateGame(16, 17, true, false);
		stimulateGame(17, 17, true, false);
		stimulateGame(18, 17, true, false);
		
		stimulateGame(16, 18, true, false);
		stimulateGame(17, 18, true, false);
		stimulateGame(18, 18, true, false);
		
		System.out.print ( "\n\n\n");
		
		//third section (27 total combinations)
		stimulateGame(16, 16, false, true);
		stimulateGame(17, 16, false, true);
		stimulateGame(18, 16, false, true);
		
		stimulateGame(16, 17, false, true);
		stimulateGame(17, 17, false, true);
		stimulateGame(18, 17, false, true);
		
		stimulateGame(16, 18, false, true);
		stimulateGame(17, 18, false, true);
		stimulateGame(18, 18, false, true);
		
		System.out.print ( "\n\n\n");
				
		//fourth section (36 total combinations)
		stimulateGame(16, 16, false, false);
		stimulateGame(17, 16, false, false);
		stimulateGame(18, 16, false, false);
		
		stimulateGame(16, 17, false, false);
		stimulateGame(17, 17, false, false);
		stimulateGame(18, 17, false, false);
		
		stimulateGame(16, 18, false, false);
		stimulateGame(17, 18, false, false);
		stimulateGame(18, 18, false, false);
	}

}
