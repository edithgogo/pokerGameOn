package blackjackgame;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	
	// OPTION 1
	//Card[] deck2 = new Card[52];
	
	//OPTION 2
	ArrayList<Card> deck = new ArrayList<Card>();
	
	public Deck() {
		String[] suits = {"S", "H", "C", "D"};
		String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

		for (int i = 0; i < suits.length; i+=1) {
			for (int j=0; j < values.length; j += 1) {
				Card newCard = new Card( suits[i], values[j]);
				deck.add( newCard);
			}
		}
	}

	public Deck shuffle () {
		Collections.shuffle(deck);
		return this;
	}

	public Card deal() {
		return deck.remove(0);
	}

}
