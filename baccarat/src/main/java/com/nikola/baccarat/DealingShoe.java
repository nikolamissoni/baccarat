package com.nikola.baccarat;

import java.util.Deque;
import java.util.LinkedList;
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

	private Deque<Deck> dealingShoe = new LinkedList<Deck>();

	public Deque<Deck> getDealingShoe() {
		return dealingShoe;
	}

	public void setDealingShoe(Deque<Deck> dealingShoe) {
		this.dealingShoe = dealingShoe;
	}

	public void addDeck(Deck deck) {
		this.dealingShoe.push(deck);
	}

	public Optional<Card> drawCard() {
		if (getNumberRemainingDecks() > 0) {
			// Get first card from the deck
			Optional<Card> card = this.getDealingShoe().peek().getCards().pop();

			// If current deck is spent, remove it
			if (this.getDealingShoe().peek().getCards().size() == 0) {
				this.getDealingShoe().remove();
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
		
		System.out.println(String.format("Value of burn card is %d", numberOfBurnCards));
		
		//TODO: This is hack, avoid IndexOutOfBounds by burning even number of cards
		if(numberOfBurnCards % 2 != 0) {
			numberOfBurnCards++;
		}

		System.out.println(String.format("Burning %d cards %s", numberOfBurnCards, System.lineSeparator()));
		
		for (int i = 0; i < numberOfBurnCards; i++) {
			//TODO: Think about if only pop is needed here
//			drawCard();
			this.getDealingShoe().peek().getCards().pop();
		}
	}
}
