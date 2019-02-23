package com.nikola.baccarat;

/***
 * @author Nikola Missoni
 * 
 *         Class that represents a card; Each card has a color(hearts, spades,
 *         diamonds, clubs) and value (1 - 13).
 * 
 *         In baccarat values are: ace:1 2-9:face value tens, jacks, queens and
 *         kings:0
 */
public class Card {
	private CardColor color;
	private int value;

	public Card(CardColor color, int value) {
		this.color = color;
		this.value = value < 10 ? value : 0;
	}

	public CardColor getColor() {
		return color;
	}

	public void setColor(CardColor color) {
		this.color = color;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.color + " " + this.value;
	}
}
