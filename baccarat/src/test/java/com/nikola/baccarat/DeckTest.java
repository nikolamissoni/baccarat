package com.nikola.baccarat;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DeckTest {
	
	private static final int NUM_CARDS_DECK = 52;

	@Test
	void DeckShuffleTest() {
		Deck deck = new Deck();
		
		Deck shuffledDeck = new Deck();
//		shuffledDeck = shuffledDeck.Shuffle(shuffledDeck);
		shuffledDeck = shuffledDeck.Shuffle();
		
		//Assert that there is a proper number of cards
		assertEquals(NUM_CARDS_DECK, deck.getCards().size());
		
		//Assert that lists are not equal due to ordering
		assertFalse(deck.equals(shuffledDeck));
	}
}
