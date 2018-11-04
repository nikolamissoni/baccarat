package com.nikola.baccarat;

import java.util.ArrayList;

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

	public void AddDeck(Deck deck) {
		this.dealingShoe.add(deck);
	}

	public Card DrawCard() {
		if (getNumberRemainingDecks() > 0) {
		// Get first card from the deck
		Card card = this.getDealingShoe().get(0).getCards().get(0);
		this.getDealingShoe().get(0).getCards().remove(0);

		// If current deck is spent, remove it
			if (this.getDealingShoe().get(0).getCards().size() == 0) {
				this.getDealingShoe().remove(0);
			}
			return card;
		}
		//TODO: This is not the best way to handle this
		return null;
	}

	public int getNumberRemainingDecks() {
		return this.getDealingShoe().size();
	}
	
	public void burnCards() {
		var burnCard = this.getDealingShoe().get(0).getCards().get(0);
		var numberOfBurnCards = burnCard.getValue() == 0 ? 10 : burnCard.getValue();
		
		for(int i = 0; i < numberOfBurnCards; i++) {
			//TODO: remove this many cards from the shoe
		}
	}
}
