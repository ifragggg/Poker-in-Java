Card.java - the typical stuff, created suits ranging from 1-4 and ranks from 1-13; whenever the suit/rank greater/smaller it 
returns +/- 1 or 0 if the suit/rank is the same. Added the method getSuit and getRank to make life easier.


Deck.java - Created a array for a classic deck of cards with 4 suits and 13 ranks. just a for loop at first so it's not 
sorted, but thats what shuffle is for anyways. For shuffle I used a for loop that generated a random number between 1-52 and 
put cards[i] into the random location. For the Deal method, I just returned the top card and incremented the top integer by 1. 


Player.java - Most of this was just setting things equal to each other, such as bankroll = 50 and initial bet = 0. I did add another method called getHand() 
that just returns the current hand.


Game.java - Phewwww. So for testHand, I just incorporated it along whatever my suitName[] and rankName[] indexes were in Card.java.
For game(), I created a player, a deck, and shuffled the deck. For play(), I modeled most of it off of the final output; for the exchange option,
I created a for loop based on how many cards they wanted to change (0 would mean the loop would skip entirely) and replaced said index in their hand with 
a dealt card from the shuffled deck. To get the correct multiplier, I used what I returned in checkHand() (which I will discuss later) to set the multiplier
integer. I multiplied the bet by multiplier to get the payout. All of this was incorporated into a while loop, which stated that as long as the 
decision to play was y, it would ask again to keep playing until the user indicated otherwise. 

Now, for checkHand, the first thing I did was sort the hand from least to greatest rank to make it easier to sort through and decide what score to give the 
hand. Many of them were relatively simple, such as checking if index 0 and index 4 of the hand were the same rank to indicate a straight. Through some 
simple visualization and trial and error I was able to get the rest and sort them in the right order so that one wouldn't trigger the other, like One Pair 
being returned before Full House. I used booleans for many of them because I was able to merge some to achieve the stipulations required for other 
scores (flush and aceCase (straight case when it's ace, 10, jack, queen, king) for Royal Flush). Finally, I added the printHand method just for some formatting of the hand in 
the testing. I don't know how well this will hold up against the edge test cases but I tried my best.