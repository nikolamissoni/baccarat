package com.nikola.baccarat;

import java.util.Optional;

public class Banker extends Participants {

	public Optional<Card> takeCard(DealingShoe shoe){
		return shoe.drawCard();
	}
}
