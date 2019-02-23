package com.nikola.baccarat;

import java.util.Arrays;
import java.util.Optional;

/***
 * @author Nikola Missoni
 * 
 *         Enum representing card colors (suites)
 *
 *         Added method for getting card color based on the ordinal value
 *         provided
 */
public enum CardColor {
	hearts(1), spades(2), diamonds(3), clubs(4);

	private final int value;

	CardColor(int value) {
		this.value = value;
	}

	public static Optional<CardColor> valueOf(int value) {
		return Arrays.stream(values()).filter(color -> color.value == value).findFirst();
	}
}
