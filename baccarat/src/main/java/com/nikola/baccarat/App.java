package com.nikola.baccarat;

/***
 * @author Nikola Missoni
 * 
 *         Simulation of baccarat game
 *
 */
public class App {

	private static int NUMBER_OF_DECKS = 1;

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
//			System.out.println("Value = " + c.getValue());
			shoe.burnCards(c);
		}

		/**
		 * 3. Start the game
		 */
		Player player = new Player();
		Banker banker = new Banker();
		
		//TODO: What if player draw last card?? Banker has nothing to draw?!
		while (shoe.getDealingShoe().get(0).hasCards()) {
			var playerCard = player.takeCard(shoe);
			System.out.println("Player draw: " + playerCard.get().toString());
			var bankerCard = banker.takeCard(shoe);
			System.out.println("Banker draw: " + bankerCard.get().toString());
			System.out.println("/////////////");
		}

		System.out.println("Game ended");
	}
}
