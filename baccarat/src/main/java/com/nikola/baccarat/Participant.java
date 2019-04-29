package com.nikola.baccarat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Participant {

	private int currentScore;

	//****************************************
	private static final int MAX_NUMBER_OF_CARDS_IN_HAND = 2;
	// TODO: add amount of won money

	private List<Card> currentHand = new ArrayList<Card>();

	private int winningHands = 0;

	public Optional<Card> takeCard(DealingShoe shoe) {
		return shoe.drawCard();
	}

	public void addCardToCurrentHand(Optional<Card> card) {
		if(!card.isPresent()) return;
		if (this.currentHand.size() == MAX_NUMBER_OF_CARDS_IN_HAND) {
			this.currentHand.clear();
		}
		this.currentHand.add(card.get());
	}

	public int calculateCurrentScore() {
		int tmpCurrentScore = 0;

		for (Card card : currentHand) {
			tmpCurrentScore += card.getValue();
		}

		// Get rightmost digit
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

	public List<Card> getCurrentHand() {
		return currentHand;
	}
	//****************************************
	
	public int getCurrentScore() {
		return currentScore;
	}

	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}
}
