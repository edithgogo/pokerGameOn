package blackjackgame;

import java.util.ArrayList;

public class SmartPlayer {
	String name;
	ArrayList<Card>  hand;

	public SmartPlayer(String name) {
		this.name = name;
		this.hand = new ArrayList<Card>();
	}

	public void addHand(Card a, Card b) {
		hand.add(a);
		hand.add(b);
	}
	
	public void addHand(Card c) {
		hand.add(c);
	}
	
	
	public int getHandValue () {
		int total = 0;
		int acesSeen = 0;
		
		for (Card c: hand) { // FOR EACH CARD c in my HAND
			if (c == null) 
				return 0; // something is wrong
			
			if (c.value.equals("A")) {
				acesSeen +=1;
			}
			
			total += c.getValue();
		}
		
		
		if (total > 21 && acesSeen >= 1)
			return total - acesSeen * 10;	
		else
			return total;
	}

	public String getCard(int index) {
		if (index >=0 && index < hand.size())
			return hand.get(index).suit + hand.get(index).value;
		else
			return "NO CARD";
	}

	public int getNumberCards() {
		return hand.size();
	}

	

}
