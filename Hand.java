package HWII;

import java.util.ArrayList;

public class Hand {
	//Instance variable
	private ArrayList<Card> hand;
	private int score = 0;
	private boolean isHard = true;
	
	//default constructor
	Hand(){
		this.hand = new ArrayList<>();
		this.isHard = true;
	}
	
	//string format: "Hand: [Card: 9s, Card: 2d]"
	public String toString() {
		//creating the string
	    StringBuilder sb = new StringBuilder("Hand: [");
	    
	    //iterating through the ArrayList
	    for (int i = 0; i < hand.size(); i++) {
	        sb.append(hand.get(i));

	        if (i < hand.size() - 1) {
	            sb.append(", ");
	        }
	    }

	    //adding the Score and isHard values
	    sb.append("] Score: ");
	    sb.append(getScore());
	    sb.append(" isHard: ");
	    sb.append(getIsHard());
	    
	    return sb.toString();
	}
	
	//updates the score according to isHard for Aces or regularly for non-Aces
	private void updateScore(Card c){
		//if the card is an Ace add 1 or 11 according to the score after adding
		if (c.toString().contains("A")) {
			if (this.score + c.getScore() <= 21) {
				this.score += c.getScore();
				isHard = false;
			}
			else {
				this.score ++;
			}
		}
		//if the card is not an Ace
		else {
			this.score += c.getScore();
		}
		
		//if the score is a bust but the hand is soft
		if (this.score > 21 && isHard == false) {
			this.score = 0;
			for(Card card : hand) {
				if (card.toString().contains("A")) {
					this.score ++;
				}
				else {
					this.score += card.getScore();
				}
			}
			isHard = true;
		}
	}
	
	//adding to Hand
	public void addCard(Card c) {
		hand.add(c);
		updateScore(c);
	}
	
//	//removing Hand
//	public void removeCard(Card c) {
//		hand.remove(c);
//	}
	
	//getter method for score
	public int getScore(){
		return this.score;
	}
	
	//getter method for isHard
	public boolean getIsHard(){
		return this.isHard;
	}
}