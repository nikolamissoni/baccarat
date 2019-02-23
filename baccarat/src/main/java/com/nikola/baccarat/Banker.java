package com.nikola.baccarat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Banker extends Participants {

	private static final int MAX_NUMBER_OF_CARDS_IN_HAND = 2;
	// TODO: add amount of won money

	private List<Card> currentHand = new ArrayList<Card>();

	private int winningHands = 0;

	public Optional<Card> takeCard(DealingShoe shoe) {
		return shoe.drawCard();
	}

	public void addCardToCurrentHand(Optional<Card> card) {
		if (this.currentHand.size() == MAX_NUMBER_OF_CARDS_IN_HAND)
			this.currentHand.clear();
		this.currentHand.add(card.get());
	}

	public int calculateCurrentScore() {
		int tmpCurrentScore = 0;

		for (Card card : currentHand) {
			tmpCurrentScore += card.getValue();
		}

		this.setCurrentScore(tmpCurrentScore % 10);
		// Get rightmost digit
		return this.getCurrentScore();
	}

	public void addWinningHand() {
		this.winningHands++;
	}

	public int getWinninghands() {
		return this.winningHands;
	}
}
