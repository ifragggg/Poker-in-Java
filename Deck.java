/*
David Bai
db3818 
Deck.java - Deck
*/

public class Deck {
	
	private Card[] cards;
	private int top; // the index of the top of the deck

	// add more instance variables if needed
	
	public Deck(){
		// make a 52 card deck here
		cards = new Card[52];
		top = 0;

		int index = 0;
		for (int s = 1; s <= 4; s++) 
		{
			for (int r = 1; r <= 13; r++)
			{
				cards[index] = new Card(s, r);
				index++;
			}
		}
	}
	
	public void shuffle(){
		// shuffle the deck here
		for (int i = 0; i < cards.length; i++)
		{
		int randomPosition = (int) (Math.random() * cards.length); // random position b/t 1-52 just a number
		

		Card temp = cards[i];
		cards[i] = cards[randomPosition];
		cards[randomPosition] = temp;
		}
		
		top = 0;

	}
	
	public Card deal(){
		// deal the top card in the deck
		Card dealtCard = cards[top];
		top++;
		return dealtCard;
	}
	
	// add more methods here if needed

}
