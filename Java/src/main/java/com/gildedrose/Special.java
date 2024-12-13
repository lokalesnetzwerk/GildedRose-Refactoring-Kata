package com.gildedrose;

public class Special extends Item implements Updateable {
	
	public Special(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void updateQuality() {
	}
}
