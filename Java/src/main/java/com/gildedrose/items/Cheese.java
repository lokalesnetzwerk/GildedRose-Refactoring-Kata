package com.gildedrose.items;

import com.gildedrose.attributes.Quality;
import com.gildedrose.attributes.SellIn;

public class Cheese extends Item {
	
	public Cheese(String name, SellIn sellIn, Quality quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void dailyUpdate() {
		reduceSellInBy1();
		raiseQualityDependingOnSellIn();
	}

	private void raiseQualityDependingOnSellIn() {
		if (this.sellIn.getValue() > -1) {
			this.quality = quality.increase(1);
		} else {
			this.quality = quality.increase(2);
		}
	}

	private void reduceSellInBy1() {
		this.sellIn = sellIn.decrease(1);
	}
}
