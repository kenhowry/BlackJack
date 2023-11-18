package HWII;

public class Player {
	//instance variables
	Hand player = new Hand();
	int standValue = 0;
	boolean isHardStand = true;
	
	//constructor
	Player(int standValue, boolean isHardStand){
		this.standValue = standValue;
		this.player = new Hand();
		this.isHardStand = isHardStand;
	}
	
	//overrides the toString method
	public String toString() {
		return player.toString();
	}
	
	//plays depending on Hard or Soft stand and Stand Value
	public void play(Deck d) {
		//if the player is Soft Standing
		if (this.isHardStand == false) {
			 while (player.getScore() < standValue){
				 player.addCard(d.deal());
			 }
		}
		//if the player is Hard Standing
		else {
			//if the player is Hard Standing and the hand is Hard
			if (player.getIsHard() == true) {
				 while (player.getScore() < standValue){
					 player.addCard(d.deal());
				 }
			}
			//if the player is Hard Standing and the hand is Soft
			else {
				player.addCard(d.deal());
			}
		}
	}
	
	//returns a boolean depending on if the hand is a bust or not
	public boolean isBust(){
		if (player.getScore() > 21) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//compares the scores of the player vs another player
	//returns an int
	public int compareScores(Player that){
		return this.player.getScore() - that.player.getScore();
	}

}
