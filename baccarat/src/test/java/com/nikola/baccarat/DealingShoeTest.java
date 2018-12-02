package com.nikola.baccarat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;

public class DealingShoeTest {

	private static final int CARDS_IN_DECK = 52;
	private static final int TWO_DECKS = 2;
	private static final int SIX_DECKS = 6;

	/***
	 * Add one deck to a dealing shoe
	 */
	@Test
	void DealingShoeAddOneDeckTest() {
		Deck deck1 = new Deck();
		DealingShoe shoe = new DealingShoe();
		shoe.addDeck(deck1);
		
		assertEquals(1, shoe.getDealingShoe().size());
		assertEquals(CARDS_IN_DECK, shoe.getDealingShoe().get(0).getCards().size());
	}
	
	/***
	 * Add 6 decks to a dealing shoe
	 * Assert proper number of decks and
	 * proper number of cards
	 */
	@Test
	void DealingShoeAddSixDecksTest() {
		DealingShoe shoe = new DealingShoe();
		
		for(int i = 0; i < SIX_DECKS; i++) {
			Deck d = new Deck();
//			d=d.Shuffle(d);
			d=d.shuffle();
			shoe.addDeck(d);
		}
		assertEquals(SIX_DECKS, shoe.getDealingShoe().size());
		
		int numberOfCards = 0;
		for (Deck d : shoe.getDealingShoe()) {
			numberOfCards += d.getCards().size();
		}
		assertEquals(SIX_DECKS*CARDS_IN_DECK, numberOfCards);
	}
	
	/***
	 * Add two decks to a dealing shoe
	 * Draw TWO_DECKS * CARDS_IN_DECK (2 * 52) cards
	 * Assert that all decks are removed from the shoe
	 */
	@Test 
	void DealingShoeDrawCardTest(){
		DealingShoe shoe = new DealingShoe();
		
		for(int i = 0; i < TWO_DECKS; i++) {
			Deck deck = new Deck();
//			deck = deck.Shuffle(deck);
			deck = deck.shuffle();
			shoe.addDeck(deck);
		}
		
		assertEquals(TWO_DECKS,  shoe.getDealingShoe().size());
		
		for(int i = 0; i < TWO_DECKS * CARDS_IN_DECK; i++) {
			Optional<Card> c = shoe.drawCard();
			System.out.println(c.get().getColor() + " " + c.get().getValue());
		}
		
		assertEquals(0, shoe.getDealingShoe().size());
	}
	
	/***
	 * Add six decks to a dealing shoe
	 * Draw TWO_DECKS * CARDS_IN_DECK (2 * 52) cards from the shoe
	 * Assert that correct number of decks remain in shoe
	 */
	@Test
	void DealingShoeGetNumberOfRemainingDecks() {
		DealingShoe shoe = new DealingShoe();
		
		for(int i = 0; i < SIX_DECKS; i++) {
			Deck deck = new Deck();
			deck = deck.shuffle();
			shoe.addDeck(deck);
		}
		
		assertEquals(6, shoe.getNumberRemainingDecks());
		
		for(int i = 0; i < TWO_DECKS * CARDS_IN_DECK; i++) {
			shoe.drawCard();
		}
		
		assertEquals(4, shoe.getNumberRemainingDecks());
	}
	
	@Test
	void DealingShoeGetMoreDecksThanAvailable() {
		var shoe = new DealingShoe();
		
		for(int i = 0; i < TWO_DECKS; i++) {
			var deck = new Deck();
			deck = deck.shuffle();
			shoe.addDeck(deck);
		}
		
		//Initialize card so it is not NULL
		Optional<Card> card =Optional.of(new Card(CardColor.clubs, 1));
		//Try to get one card more than there is
		for(int i = 0; i < TWO_DECKS * CARDS_IN_DECK + 1; i++) {
			card = shoe.drawCard();
		}
		
		assertFalse(card.isPresent());
	}
	
	/***
	 * Add one deck to a dealing shoe
	 * Burn 10 cards
	 * Assert that 42 cards are left
	 */
	@Test
	void DealingShoeBurnCards() {
		DealingShoe shoe = new DealingShoe();
		Deck deck = new Deck();
		deck = deck.shuffle();
		shoe.addDeck(deck);
		
		//tens, jacks, queens and kings have value 0
		Card burnCard = new Card(CardColor.clubs, 0);
		shoe.burnCards(burnCard);
		
		assertEquals(42, deck.getCards().size());
		
		DealingShoe shoe2 = new DealingShoe();
		Deck deck2 = new Deck();
		deck2 = deck2.shuffle();
		shoe2.addDeck(deck2);
		
		Card burnCard2 = new Card(CardColor.hearts, 6);
		shoe2.burnCards(burnCard2);
		
		assertEquals(46, deck2.getCards().size());
		
	}
	
}
