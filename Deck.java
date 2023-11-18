package HWII;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	//instance variable
	private ArrayList<Card> deck;
	
	//default constructor
	Deck(){
		deck = new ArrayList<Card>();
		
		char[] deckSuits = {'d', 's', 'c', 'h'};
		
		for (int i = 2; i <= 14; i ++) {
			for (int j = 0; j <= deckSuits.length - 1; j++) {
				Card c = new Card(i, deckSuits[j]);
				deck.add(c);
			}
		}
	}
	
	//string format: "Deck: [Card: 2s, Card: 2d]"
	public String toString() {
		//creating the string
	    StringBuilder sb = new StringBuilder("Deck: [");
	    
	    //iterating through the ArrayList
	    for (int i = 0; i < deck.size(); i++) {
	        sb.append(deck.get(i).toString());

	        if (i < deck.size() - 1) {
	            sb.append(", ");
	        }
	    }

	    sb.append("]");

	    return sb.toString();
	}
	
	//removes and returns the card at the top of the deck
	public Card deal() {
		return deck.remove(0);
	}
	
	//shuffles the deck; returns nothing
	public void shuffle() {
		for (int i = 0; i <= 101; i++) {
		int j = (int) Math.round(Math.random()* 51);
		int k = (int) Math.round(Math.random()* 51);
		Collections.swap(deck, j, k);
		}
	}
	
	//finds and moves the Aces to the first 4 indexes
	public void stack() {
		int j = 0;
		for (int i = 0; i <= deck.size() - 1; i++) {
			if (deck.get(i).toString().contains("A")){
				Collections.swap(deck, i, j);
				j++;
			}
		}
	}
}
