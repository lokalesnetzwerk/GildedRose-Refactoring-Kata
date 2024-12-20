package com.gildedrose.items;

import com.gildedrose.attributes.Quality;
import com.gildedrose.attributes.SellIn;

public class ItemFactory {
	
	private ItemFactory() {}

	public static Item createItem(String name, Integer sellIn, Integer quality) {
		return switch (name) {
			case "Aged Brie" -> new Cheese(name, new SellIn(sellIn), new Quality(quality));
			case "Backstage passes to a TAFKAL80ETC concert" -> new ConcertTicket(name, new SellIn(sellIn), new Quality(quality));
			case "Sulfuras, Hand of Ragnaros" -> new Legendary(name, new SellIn(sellIn), new Quality(quality));
			default -> new Item(name, new SellIn(sellIn), new Quality(quality));
		};
	}
}
