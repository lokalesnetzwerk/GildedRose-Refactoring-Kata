package com.gildedrose;

public class ConcertTicket extends Item implements Updateable {
	
	public ConcertTicket(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void updateQuality() {
		
	}
}
