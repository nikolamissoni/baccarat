package com.nikola.baccarat;

/***
 * @author Nikola Missoni
 * 
 *         Simulation of baccarat game
 *
 */
public class App {

	private static int NUMBER_OF_DECKS = 6;

	public static void main(String[] args) {

		DealingShoe shoe = new DealingShoe();

		for (int i = 0; i < NUMBER_OF_DECKS; i++) {
			Deck deck = new Deck();
			deck = deck.shuffle();
			shoe.addDeck(deck);
		}

		/**
		 * 1. get burn card
		 */
		var card = shoe.getBurnCard();

		/**
		 * 2. burn cards
		 */
		if (card.isPresent()) {
			var c = card.get();
			System.out.println("Value = " + c.getValue());
			shoe.burnCards(c);
		}
		
		
	}
}
