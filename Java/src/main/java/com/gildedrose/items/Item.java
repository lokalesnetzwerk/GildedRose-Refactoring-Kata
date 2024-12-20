package com.gildedrose.items;

import com.gildedrose.attributes.Quality;
import com.gildedrose.attributes.SellIn;

public class Item implements Updateable {

	public String name;
	public SellIn sellIn;
	public Quality quality;

	public Item(String name, SellIn sellIn, Quality quality) {
		this.name = name;
		this.sellIn = sellIn;
		this.quality = quality;
	}

	@Override
	public String toString() {
		return this.name + ", " + this.sellIn + ", " + this.quality;
	}

	@Override
	public void dailyUpdate() {
		reduceSellInBy1();
		reduceQualityDependingOnSellIn();
	}

	private void reduceQualityDependingOnSellIn() {
		if (this.sellIn.getValue() >= 0) {
			this.quality = quality.decrease(1);
		} else {
			this.quality = quality.decrease(2);
		}
	}

	public void reduceSellInBy1() {
		this.sellIn = sellIn.decrease(1);
	}
}
