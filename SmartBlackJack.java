package blackjackgame;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class SmartBlackJack extends JFrame{
	
	public SmartPlayer playerA;
	public SmartPlayer playerB;
	public Deck deck;
	
	public JButton newGame;
	public JTextPane playerAText;
	public JTextPane playerBText;
	public JTextPane playerAHandValue;
	public JTextPane playerBHandValue;
	public JTextPane result;
	
	public ArrayList<JPanel> playerAcards;
	public JPanel playerAcard1; // playerA cards should be an arraylist of JPanels
	public JPanel playerAcard2;
	
	public JPanel playerBcard1;
	public JPanel playerBcard2;
	
	public JButton playerAHitButton;
	public JButton playerAStayButton;

	public static void main(String[] args) {
		
		SmartBlackJack bj = new SmartBlackJack();
		
	}
	
	private void playGame() {
		
		for (JPanel jcp: playerAcards) {
			this.remove(jcp); // remove all the newly added cards
		}
		
		
		this.playerA = new SmartPlayer("Tom");
		this.playerB = new SmartPlayer("Mary");
		//setLayout(null);
		
		this.deck = new Deck();
		//to check if a deck is created:
		for (Card c: this.deck.deck){
			System.out.println(c + " "); //must work with the toString() in Card.java
		}


		this.deck.shuffle();
		this.dealCards();
		playerAHandValue.setText("Value:"+playerA.getHandValue());
		playerBHandValue.setText("Value:"+playerB.getHandValue());
		
		playerAcard1.removeAll();
		playerAcard1.add(new JLabel(playerA.getCard(0)));
		
		playerAcard2.removeAll();
		playerAcard2.add(new JLabel(playerA.getCard(1)));
		
		playerBcard1.removeAll();
		playerBcard1.add(new JLabel(playerB.getCard(0)));
		
		playerBcard2.removeAll();
		playerBcard2.add(new JLabel(playerB.getCard(1)));
		
	
		playerAHitButton.setEnabled(true);
		playerAStayButton.setEnabled(true);
		
		result.setText("Player A - Hit or Stay?");
		repaint();//it is needed to redraw the whole panel
		
		
	}

	public SmartBlackJack () {
		// draw the board game
		newGame = new JButton("New Game");
		newGame.setBounds(300, 100, 200, 30);
		add(newGame);
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playGame();
				
			}
		});
		
		setUpGame(); //call the setUpGame() into the constructor
		
	}
	
	
	private void setUpGame() {
		this.playerA = new SmartPlayer("Tom");
		this.playerB = new SmartPlayer("Mary");
		
		playerAText = new JTextPane();
		playerAText.setText("Player A");
		playerAText.setBounds(20, 150, 100, 30);
		add(playerAText);
		
		playerBText = new JTextPane();
		playerBText.setText("Player B");
		playerBText.setBounds(600, 150, 100, 20);
		add(playerBText);
		
		playerAHandValue = new JTextPane();
		playerAHandValue.setText("Value:"+playerA.getHandValue());
		playerAHandValue.setBounds(20, 200, 100, 20);
		add(playerAHandValue);
		
		playerBHandValue = new JTextPane();
		playerBHandValue.setText("Value:"+playerB.getHandValue());
		playerBHandValue.setBounds(600, 200, 100, 20);
		add(playerBHandValue);
		
		result = new JTextPane();
		result.setText("Press New Game to Begin");
		result.setBounds(300, 200, 250, 20);
		add(result);
		
		// draw the 2 cards for each player
		playerAcard1 = new JPanel();
		playerAcard1.setBounds(20, 300, 50, 100);
		playerAcard1.add(new JLabel(playerA.getCard(0)));
		playerAcard1.setBorder(BorderFactory.createLineBorder(Color.black));
		playerAcard1.setForeground(Color.blue);//change of color of text
		playerAcard1.setBackground(Color.pink); //change the background of the card
		add(playerAcard1);
		
		playerAcard2 = new JPanel();
		playerAcard2.setBounds(80, 300, 50, 100);
		playerAcard2.add(new JLabel(playerA.getCard(1)));
		playerAcard2.setBorder(BorderFactory.createLineBorder(Color.black));
		playerAcard2.setBackground(Color.pink); //change the background of the card

		add(playerAcard2);
	
		playerAcards = new ArrayList<JPanel>();
		
		
		playerBcard1 = new JPanel();
		playerBcard1.setBounds(600, 300, 50, 100);
		playerBcard1.add(new JLabel(playerB.getCard(0)));
		playerBcard1.setBorder(BorderFactory.createLineBorder(Color.black));
		playerBcard1.setBackground(Color.pink); //change the background of the card

		add(playerBcard1);
		
		playerBcard2 = new JPanel();
		playerBcard2.setBounds(680, 300, 50, 100);
		playerBcard2.add(new JLabel(playerB.getCard(1)));
		playerBcard2.setBorder(BorderFactory.createLineBorder(Color.black));
		playerBcard2.setBackground(Color.pink); //change the background of the card

		add(playerBcard2);
		
		playerAHitButton = new JButton("Hit");
		playerAHitButton.setBounds(100, 450, 200, 30);
		add(playerAHitButton);
		playerAHitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerAHit();
			}
		});
		
		playerAStayButton = new JButton("Stay");
		playerAStayButton.setBounds(100, 500, 200, 30);
		add(playerAStayButton);
		playerAStayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerAStop();
			}
		});
		playerAHitButton.setEnabled(false);
		playerAStayButton.setEnabled(false);
		
		setSize(800,600); // set JFrame size
		this.getContentPane().setBackground(Color.green) //set a default color to the background
		setLayout(null);
		setVisible(true);
	}

	public void playerAHit() {
		playerA.addHand(deck.deal()); //get another card into the hand
		int xoffset = playerA.getNumberCards()*60- 40; //calculating the x-axis where the new card is to appear on the panel
		
		JPanel jpc = new JPanel();
		jpc.setBounds(xoffset, 300, 50, 100); //draw the rectangle that display the newly delt card
		String lastCard = playerA.getCard( playerA.getNumberCards()-1);
		//System.out.println("lastcard:"+lastCard);
		jpc.add(new JLabel(lastCard));
		jpc.setBorder(BorderFactory.createLineBorder(Color.black));
		jpc.setBackground(Color.pink); //change the color of the card background
		jpc.set
		add(jpc);
		playerAcards.add(jpc);//without drawing the entire game
		
		// update the value text
		playerAHandValue.setText("Value:"+playerA.getHandValue());
		
		// check for BUST
		if (playerA.getHandValue() > 21) {
			gameEnd();
		}
	
		
	}
	
	private void gameEnd() {
		// playerA lost
		result.setText(this.printWinner());
		// grey out the Hit and Stay buttons
		playerAHitButton.setEnabled(false);
		playerAStayButton.setEnabled(false);
		//setVisible(true);
		//repaint();
	}

	public void playerAStop() {
		//Lab #5: Give player B a chance
		if (playerB.getHandValue() >= 16) {
			gameEnd();
		}
		else {
			playerB.addHand(deck.deal()); //the following precedure is like a recursion
			playerB.getHandValue();
			playerAstop(); //a recursion of the code
		}	
	}

	public void dealCards () {
		playerA.addHand( deck.deal(), deck.deal());
		playerB.addHand( deck.deal(), deck.deal());
	}

	public String printWinner() { 
		String result;
		
		if (playerA.getHandValue() > playerB.getHandValue() && playerA.getHandValue() <= 21) {
			result = "Player A Wins!";
		} else if (playerA.getHandValue() == playerB.getHandValue()) {
			result ="Player A and Player B Tie!";
		} else {
			result ="Player B Wins!";
		}
		return result;
	}
}
