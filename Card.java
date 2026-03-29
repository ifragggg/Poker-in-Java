public class Card implements Comparable<Card>{
	
	private int suit; // use integers 1-4 to encode the suit
	private int rank; // use integers 1-13 to encode the rank
	
	public Card(int s, int r){
		//make a card with suit s and value v
		suit = s;  //assign variable to instance variable
		rank = r;
	}
	
	public int compareTo(Card c){
		// use this method to compare cards so they 
		// may be easily sorted

		// returns 1 or -1 depending on larger or smaller

		if (this.rank > c.rank) 
		{
			return 1;
		} 
		if (this.rank < c.rank) 
		{
			return -1;
		} 
		else 
		{
			if (this.suit > c.suit)
			{
				return 1; 
			}
			else if (this.suit < c.suit) 
			{
				return -1;
			} 
		else 
		{
			return 0;
		}
		}

	}
	
	public String toString(){
		// use this method to easily print a Card object
		String[] suitName = {null, "Spades", "Hearts", "Diamonds", "Clubs"}; // null b/c starts at 1
		String[] rankName = {null, "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};

		return rankName[rank] + " of " + suitName[suit];

	}
	// add some more methods here if needed

    public int getSuit() {
        return suit;
        
    }

    public int getRank() {
        return rank;
    }

}
