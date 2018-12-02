package com.nikola.baccarat;

import java.util.Optional;

public class Player extends Participants {

	//TODO: add amount of won money
	
	public Optional<Card> takeCard(DealingShoe shoe){
		
		return shoe.drawCard();
	}
}
