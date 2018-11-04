package com.nikola.baccarat;

/***
 * @author Nikola Missoni
 * 
 * Simulation of baccarat game
 *
 */
public class App {
	public static void main(String[] args) {
		
		DealingShoe shoe = new DealingShoe();
		
		for(int i = 0; i < 6; i++) {
			Deck d = new Deck();
//			d=d.Shuffle(d);
			d=d.Shuffle();
			shoe.AddDeck(d);
		}
		
		for (Deck deck : shoe.getDealingShoe()) {
			for(Card c : deck.getCards()) {
				System.out.println(c.getColor() + " " + c.getValue());
			}
		}
	}
}
