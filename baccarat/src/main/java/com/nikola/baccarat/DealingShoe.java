package com.nikola.baccarat;

import java.util.ArrayList;

/***
 * @author Nikola Missoni
 * 
 * Class that represents dealingshoe;
 * Dealing shoe contains multiple decks (e.g. 6)
 * 
 * Dealing shoe is used to draw cards from
 *
 */
public class DealingShoe {

	private ArrayList<Deck> dealingShoe = new ArrayList<>();

	public ArrayList<Deck> getDealingShoe() {
		return dealingShoe;
	}

	public void setDealingShoe(ArrayList<Deck> dealingShoe) {
		this.dealingShoe = dealingShoe;
	}
	
	public void AddDeck(Deck deck) {
		this.dealingShoe.add(deck);
	}
	
	public Card DrawCard() {
		Card card = this.getDealingShoe().get(0).getCards().get(0);
		this.getDealingShoe().get(0).getCards().remove(0);
//		System.out.println(this.dealingShoe.get(0).getCards().size());
		if(this.getDealingShoe().get(0).getCards().size()==0) {
			this.getDealingShoe().remove(0);
		}
		return card;
	}
}
