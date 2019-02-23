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
		var burnCard = shoe.getBurnCard();

		/**
		 * 2. burn cards
		 */
		if (burnCard.isPresent()) {
			shoe.burnCards(burnCard.get());
		}

		/**
		 * 3. Start the game
		 */
		Player player = new Player();
		Banker banker = new Banker();

		// TODO: What if player draw last card?? Banker has nothing to draw?!
		int cardsDrawnInHand = 0;

		int x = 0;

		while (shoe.getDealingShoe().get(0).hasCards()) {

			// TODO: Hack to avoid getting last card
			if (shoe.getNumberRemainingDecks() == 1 && shoe.getDealingShoe().get(0).getCards().size() == 1)
				break;

			var playerCard = player.takeCard(shoe);
			System.out.println("Player draw: " + playerCard.get().toString());
			player.addCardToCurrentHand(playerCard);

			var bankerCard = banker.takeCard(shoe);
			System.out.println("Banker draw: " + bankerCard.get().toString());
			banker.addCardToCurrentHand(bankerCard);

			cardsDrawnInHand++;
			if (cardsDrawnInHand == 2) {
				System.out.println("Player's hand: " + player.calculateCurrentScore());
				System.out.println("Banker's hand: " + banker.calculateCurrentScore());
				cardsDrawnInHand = 0;
				if(player.calculateCurrentScore() > banker.calculateCurrentScore())
					player.addWinningHand();
				else
					banker.addWinningHand();
			}
			System.out.println("/////////////");
		}

		System.out.println("Game ended");
//		player.getWinninghands() > banker.getWinninghands() ? player : banker
		System.out.println("Winner is: " + (player.getWinninghands() > banker.getWinninghands() ? "player" : "banker"));
		System.out.println("Player had " + player.getWinninghands() + " winning hands");
		System.out.println("Banker had " + banker.getWinninghands() + " winning hands");
	}
}
