package com.nikola.baccarat;

import java.util.ArrayList;
import java.util.Optional;

/***
 * @author Nikola Missoni
 * 
 *         Class that represents dealingshoe; Dealing shoe contains multiple
 *         decks (e.g. 6)
 * 
 *         Dealing shoe is used to draw cards from
 *
 */
public class DealingShoe {

	private ArrayList<Deck> dealingShoe = new ArrayList<>();

	public ArrayList<Deck> getDealingShoe() {
		return dealingShoe;
	}

	public void setDealingShoe(ArrayList<Deck> dealingShoe) {
		this.dealingShoe = dealingShoe;
	}

	public void addDeck(Deck deck) {
		this.dealingShoe.add(deck);
	}

	public Optional<Card> drawCard() {
		if (getNumberRemainingDecks() > 0) {
			// Get first card from the deck
			Optional<Card> card = this.getDealingShoe().get(0).getCards().get(0);
			this.getDealingShoe().get(0).getCards().remove(0);

			// If current deck is spent, remove it
			if (this.getDealingShoe().get(0).getCards().size() == 0) {
				this.getDealingShoe().remove(0);
			}
			return card;
		}
		return Optional.empty();
	}

	public int getNumberRemainingDecks() {
		return this.getDealingShoe().size();
	}
	
	public Optional<Card> getBurnCard() {
		return drawCard();
	}

	public void burnCards(Card burnCard) {
		
		var burnCardValue = burnCard.getValue();

		int numberOfBurnCards = burnCardValue == 0 ? 10 : burnCardValue;

		System.out.println(String.format("Burning %d cards %s", numberOfBurnCards, System.lineSeparator()));
		
		for (int i = 0; i < numberOfBurnCards; i++) {
			drawCard();
		}
	}
}
