package com.gildedrose.items;

import com.gildedrose.attributes.Quality;
import com.gildedrose.attributes.SellIn;

public class Legendary extends Item {

	public Legendary(String name, SellIn sellIn, Quality quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void dailyUpdate() {
		System.out.println("SULFURAS DOES NOT LOOSE SELLIN NOR QUALITY!");// Do nothing
	}
}
