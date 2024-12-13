package com.gildedrose;

public class Cheese extends Item implements Updateable {
	
	public Cheese(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void updateQuality() {
		
	}
}
