import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Game {
	
	private Player p;
	private Deck cards;
		
	
	public Game(String[] testHand){ // ?
		// This constructor is to help test your code.
		// use the contents of testHand to
		// make a hand for the player
		// use the following encoding for cards
		// c = clubs
		// d = diamonds
		// h = hearts
		// s = spades
		// 1-13 correspond to ace-king
		// example: s1 = ace of spades
		// example: testhand = {s1, s13, s12, s11, s10} = royal flush

		p = new Player();
		cards = new Deck();
		new Scanner(System.in);

		for (String s : testHand) 
		{
			char suitChar = s.charAt(0);
			int suit;

			if (suitChar == 's')
			{
				suit = 1;
			}
			else if (suitChar == 'h')
			{
				suit = 2;
			}	
			else if (suitChar == 'd')
			{
				suit = 3;
			}
			else if (suitChar == 'c')
			{
				suit = 4;
			}

			int rank = Integer.parseInt(s.substring(1));

			
		}
		
	}
	
	public Game(){
		// This no-argument constructor is to actually play a normal game
		p = new Player();		// get a player and shuffle a deck
		cards = new Deck();
		cards.shuffle();
	
	}
	
	public void play(){
		// this method should play the game	
		Scanner s = new Scanner(System.in);
		System.out.println("Welcome to Video Poker!");
		System.out.println("YOUR TOKENS: " + p.getBankroll()); 
		System.out.print("Would you like to play a round? (y/n) ");
		String answer = s.next();
		if (!answer.equals("y"))
		{
			return;
		}
		
	while (answer.equals("y")) {
		System.out.println("How many tokens to bet this hand? (1 to 5): ");
		int bet = s.nextInt();

		while (bet < 1 || bet > 5)
		{
			System.out.println("Enter 1-5: ");
			bet = s.nextInt();
		}
		p.bets(bet);

		// deal cards
		p.getHand().clear();
		for (int i = 0; i < 5; i++)
		{
			p.addCard(cards.deal());
		}

		System.out.println("The hand is: ");
		printHand(p.getHand());  // fix formatting


		System.out.println("How many cards (0-5) would you like the exchange? ");
		int numbEx = s.nextInt();
		for (int i = 0; i < numbEx; i++)
		{
			System.out.println("Which card (1-5) would you like to exchange? ");
			int cardEx = s.nextInt();
			p.getHand().set(cardEx - 1, cards.deal());
		}

		System.out.println("The hand is: ");
		printHand(p.getHand());

		String result = checkHand(p.getHand());

		int multiplier;
		if (result.equals("Royal Flush!"))
		{
			multiplier = 250;
		}
		else if (result.equals("Straight Flush!"))
		{
			multiplier = 50;
		}
		else if (result.equals("Four of a kind!"))
		{
			multiplier = 25;
		}
		else if (result.equals("Full House!"))
		{
			multiplier = 6;
		}
		else if (result.equals("Flush!"))
		{
			multiplier = 5;
		}
		else if (result.equals("Straight!"))
		{
			multiplier = 4;
		}
		else if (result.equals("Three of a kind!"))
		{
			multiplier  = 3;
		}
		else if (result.equals("Two Pairs!"))
		{
			multiplier = 2;
		}
		else if (result.equals("One Pair!"))
		{
			multiplier = 1;
		}
		else 
		{
			multiplier = 0;
		}

		p.winnings(multiplier);
		System.out.println("You got a " + result);

		System.out.println("PAYOUT: " + (bet * multiplier) + " tokens.");

		System.out.println("YOUR TOKENS: " +  p.getBankroll());

		System.out.print("Would you like to play a round? (y/n): ");
		answer = s.next();

	}
		System.out.println("Thank you for playing Video Poker!");
	}
	
	public String checkHand(ArrayList<Card> hand){
		// this method should take an ArrayList of cards
		// as input and then determine what evaluates to and
		// return that as a String

		Collections.sort(hand); // sort from smallest to largest, very helpful

		// flush (the same suit)
		boolean flush = true; 
		for (int i = 0; i < 4; i++) 
		{
			if (hand.get(i).getSuit() != hand.get(i + 1).getSuit())
			{
				flush = false;
			}
		}
		

		// straight (5 of same rank)
		boolean straight = true;
		for (int i = 0; i < 4; i++)
		{
			if (hand.get(i).getRank() + 1 != hand.get(i + 1).getRank())
			{
				straight = false;
			}
		}
		
		// case of if ace is after king
		boolean aceCase = false;
		if (hand.get(0).getRank() == 1 && hand.get(1).getRank() == 10 && 
			hand.get(2).getRank() == 11 && hand.get(3).getRank() == 12 && 
			hand.get(4).getRank() == 13)
		{
			aceCase = true;
		}
		// royal flush (same suit, ace, 10-king)
		if (flush && aceCase)
		{
			return "Royal Flush!";
		}

		//straight Flush
		if (flush && straight)
		{
			return "Straight Flush!";
		}

		// four of a kind (4 same rank)
		if (hand.get(0).getRank() == hand.get(3).getRank() || hand.get(1).getRank() == hand.get(4).getRank())
		{
			return "Four of a kind!";
		}

		// three of a kind(3 same rank)
		boolean threeKind = false;
		if (hand.get(0).getRank() == hand.get(2).getRank() || hand.get(1).getRank() == hand.get(3).getRank() || 
			hand.get(2).getRank() == hand.get(4).getRank())
			{
				threeKind = true;
			}
		if(hand.get(0).getRank() == hand.get(1).getRank() && hand.get(2).getRank() == hand.get(3).getRank() 
				|| hand.get(0).getRank() == hand.get(1).getRank() && hand.get(3).getRank() == hand.get(4).getRank()
				|| hand.get(1).getRank() == hand.get(2).getRank() && hand.get(3).getRank() == hand.get(4).getRank())
			{
				return "Two Pairs!";
			}
		// pair (2 same rank)
		boolean pair = false;
		if (hand.get(0).getRank() == hand.get(1).getRank() || hand.get(1).getRank() == hand.get(2).getRank() || 
			hand.get(2).getRank() == hand.get(3).getRank() || hand.get(3).getRank() == hand.get(4).getRank())
			{
				pair = true;
			}

		if (pair && threeKind) 
		{
			return "Full House!";
		}
		if (flush)
		{
			return "Flush!";
		}
		if (straight)
		{
			return "Straight!";
		}
		if (threeKind)
		{
			return "Three of a kind!";
		}
		if (pair)
		{
			return "One Pair!";
		}


		return "No Pair"; // :(

		
	}
	

	public void printHand(ArrayList<Card> hand) {
		for (int i = 0; i < hand.size(); i++)
		{
			System.out.println(i + 1 + ": " + hand.get(i));
		}
	}
}
