package com.nikola.baccarat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.NoSuchElementException;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class BankerTest {

	private DealingShoe dealingShoe;
	private Banker banker;
	
	@BeforeEach
	private final void getDealingShoe() {
		Deck deck = new Deck();
		dealingShoe = new DealingShoe();
		dealingShoe.addDeck(deck);
		
		banker = new Banker();
	}
	@Test
	final void testTakeCard() {
		assertNotNull(banker.takeCard(dealingShoe).get());
		
		dealingShoe.getDealingShoe().clear();		
		assertThrows(NoSuchElementException.class, () -> banker.takeCard(dealingShoe).get());
	}

	@Test
	final void testAddCardToCurrentHand() {
		banker.addCardToCurrentHand(banker.takeCard(dealingShoe));
		assertEquals(1, banker.getCurrentHand().size());
		
		banker.addCardToCurrentHand(banker.takeCard(dealingShoe));
		assertEquals(2, banker.getCurrentHand().size());
		
		banker.addCardToCurrentHand(banker.takeCard(dealingShoe));
		assertEquals(1, banker.getCurrentHand().size());
		
	}

	@Test
	final void testCalculateCurrentScore() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testAddWinningHand() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testGetWinninghands() {
		fail("Not yet implemented"); // TODO
	}

}
