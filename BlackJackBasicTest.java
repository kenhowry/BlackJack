package HWII;

public class BlackJackBasicTest {
	//basic test for the new implementations
	public static void main(String[] args) {
		//create deck and shuffle
		Deck d = new Deck();
		d.shuffle();
		
		//create a player and have them play
		Player p1 = new Player(17, true);
		
		p1.play(d);
		
		System.out.println(p1);
	}
}
