package com.nikola.baccarat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DealingShoeTest {

	private static final int CARDS_IN_DECK = 52;
	private static final int TWO_DECKS = 2;
	private static final int SIX_DECKS = 6;

	@Test
	void DealingShoeAddOneDeckTest() {
		Deck deck1 = new Deck();
		DealingShoe shoe = new DealingShoe();
		shoe.AddDeck(deck1);
		
		assertEquals(1, shoe.getDealingShoe().size());
		assertEquals(CARDS_IN_DECK, shoe.getDealingShoe().get(0).getCards().size());
	}
	
	@Test
	void DealingShoeAddSixDecksTest() {
		DealingShoe shoe = new DealingShoe();
		
		for(int i = 0; i < SIX_DECKS; i++) {
			Deck d = new Deck();
//			d=d.Shuffle(d);
			d=d.Shuffle();
			shoe.AddDeck(d);
		}
		assertEquals(SIX_DECKS, shoe.getDealingShoe().size());
		
		int numberOfCards = 0;
		for (Deck d : shoe.getDealingShoe()) {
			numberOfCards += d.getCards().size();
		}
		assertEquals(SIX_DECKS*CARDS_IN_DECK, numberOfCards);
	}
	
	@Test 
	void DealingShoeDrawCardTest(){
		DealingShoe shoe = new DealingShoe();
		
		for(int i = 0; i < TWO_DECKS; i++) {
			Deck deck = new Deck();
//			deck = deck.Shuffle(deck);
			deck = deck.Shuffle();
			shoe.AddDeck(deck);
		}
		
		assertEquals(TWO_DECKS,  shoe.getDealingShoe().size());
		
		for(int i = 0; i < TWO_DECKS * CARDS_IN_DECK; i++) {
			Card c = shoe.DrawCard();
			System.out.println(c.getColor() + " " + c.getValue());
		}
		
		assertEquals(0, shoe.getDealingShoe().size());
	}
}
