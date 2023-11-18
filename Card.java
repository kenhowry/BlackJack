package HWII;

public class Card {
	//Instance variables
	private int rank;
	private char suit;
	
	//parameterized constructor
	Card(int rank, char suit){
		this.rank = rank;
		this.suit = suit;
	}
	
	//prints the Card Object in the format: "Card: 5c" (5 of Clubs)
	public String toString() {
		//if the card rank is not J, Q, K, A
		if (rank < 11){
			return String.format("Card: %d%s", rank, suit);
		}
		
		//if the rank is J, Q, K, A
		String strRank = null;
		
		if (rank == 11){
			strRank = "J";
		}
		else if (rank == 12){
			strRank = "Q";
		}
		else if (rank == 13){
			strRank = "K";
		}
		else if (rank == 14){
			strRank = "A";
		}
		
		return String.format("Card: %s%s", strRank, suit);
	}
	
	//copy constructor
	public Card(Card that) {
		this.rank = that.rank;
		this.suit = that.suit;
	}
	
	//equals constructor
	public boolean equals(Object obj) {
		//if they are the same object
		if (this == obj) {
			return true;
		}
		
		//checking if it is an instance of Card
		if (!(obj instanceof Card)) {
			return false;
		}
		
		Card that = (Card)obj;
		
		return this.rank == that.rank && this.suit == that.suit;
	}
	
	//returns the score for the card
	public int getScore(){
		int score = 0;
		
		if (this.rank <= 10 && this.rank >= 2) {
			return this.rank;
		}
		if (this.rank < 14 && this.rank >= 11) {
			score = 10;
		}
		if (this.rank == 14) {
			score = 11;
		}
		
		return score;
	}
}
