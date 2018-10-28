package com.nikola.baccarat;

import java.util.ArrayList;
import java.util.Random;

/***
 * @author Nikola Missoni
 * 
 * Class that represents a deck of cards; It consists of
 * 52 cards created and added to deck in constructor.
 * 
 * Shuffle method returns shuffled cards in the array (pseudo random)
 */
public class Deck {
	
	private static final int NUM_CARDS_DECK = 52;
	private static final int CARDS_PER_COLOR = 13;
	private ArrayList<Card> cards;
	
	public Deck() {
		cards = new ArrayList<>();
		for(CardColor color : CardColor.values()) {
			for(int i = 1; i <= CARDS_PER_COLOR; i++) {
				Card c = new Card(color, i);
				cards.add(c);
			}
		}
	}
	
//	public Deck Shuffle(Deck deck) {
	public Deck Shuffle() {
		Random rn = new Random();
		for(int i = 0; i < NUM_CARDS_DECK; i++) {
			//Get random card
			//TODO: check if last card is used in random; max = 51
			int current = rn.nextInt(51 - 1 + 1) + 1;
			Card temp = cards.get(current);
			cards.set(current, cards.get(i));
			cards.set(i, temp);
		}
		return this;
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
}
