package com.gildedrose;

public class Legendary extends Item implements Updateable {

	public Legendary(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void updateQuality() {
	}
}
