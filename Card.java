package blackjackgame;

public class Card {
	String suit; // S, H, C, D
	String value; // 2-10, J, K, Q, A

	public Card(String suit, String value) {
		this.suit = suit;
		this.value = value;
	}

	public int getValue () {
		// convert String to int
		if (value.equals("A")) 
			return 11;
		if (value.equals("K") || value.equals("Q") || value.equals("J") ) 
			return 10;
		return Integer.parseInt(value); // you should catch exception
	}

}
