package com.nikola.baccarat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class BankerTest {

	private DealingShoe dealingShoe;
	private Participant banker;
	
	@BeforeEach
	private final void getDealingShoe() {
		Deck deck = new Deck();
		dealingShoe = new DealingShoe();
		dealingShoe.addDeck(deck);
		
		banker = new Participant();
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
	final void testAddEmptyOptionalToCurrentHand() {
		Optional<Card> nullCard = Optional.empty();
		banker.addCardToCurrentHand(nullCard);
		
		assertEquals(0, banker.getCurrentHand().size());
	}

	@Test
	final void testCalculateCurrentScoreSingleDigitValue() {
		Optional<Card> card = Optional.of(new Card(CardColor.clubs, 2));
		
		banker.addCardToCurrentHand(card);
		assertEquals(1, banker.getCurrentHand().size());
		
		card = Optional.empty();
		card = Optional.of(new Card(CardColor.diamonds, 2));
		banker.addCardToCurrentHand(card);
		assertEquals(2, banker.getCurrentHand().size());
		
		assertEquals(4, banker.calculateCurrentScore());
	}
	
	@Test
	final void testCalculateCurrentScoreDoubleDigitValue() {
		Optional<Card> card = Optional.of(new Card(CardColor.clubs, 6));
		banker.addCardToCurrentHand(card);
		
		card = Optional.empty();
		card = Optional.of(new Card(CardColor.hearts, 7));
		banker.addCardToCurrentHand(card);
		
		assertEquals(3, banker.calculateCurrentScore());
	}

	@Test
	final void testAddWinningHand() {
		banker.addWinningHand();
		assertEquals(1, banker.getWinninghands());
	}

	@Disabled
	@Test
	final void testGetWinninghands() {
		fail("Not yet implemented"); // TODO
	}

}
