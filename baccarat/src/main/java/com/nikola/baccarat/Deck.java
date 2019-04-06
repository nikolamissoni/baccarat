package com.nikola.baccarat;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/***
 * @author Nikola Missoni
 * 
 *         Class that represents a deck of cards; It consists of 52 cards
 *         created and added to deck in constructor.
 * 
 *         Shuffle method returns shuffled cards in the array (pseudo random)
 */
public class Deck {

	private static final int CARDS_PER_COLOR = 13;
	private Deque<Optional<Card>> cards;

	public Deck() {
		cards = new LinkedList<Optional<Card>>();
		for (CardColor color : CardColor.values()) {
			for (int i = 1; i <= CARDS_PER_COLOR; i++) {
				Optional<Card> c = Optional.of(new Card(color, i));
				cards.push(c);
			}
		}
	}

	public Deck shuffle() {
		Collections.shuffle((List<?>) cards);
		return this;
	}

	public Deque<Optional<Card>> getCards() {
		return cards;
	}

	public void setCards(Deque<Optional<Card>> cards) {
		this.cards = cards;
	}

	public boolean hasCards() {
		return this.cards.size() >= 1;
	}
}
