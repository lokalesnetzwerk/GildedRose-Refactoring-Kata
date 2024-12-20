package com.gildedrose.items;

import com.gildedrose.attributes.Quality;
import com.gildedrose.attributes.SellIn;

public class ConcertTicket extends Item {
	
	public ConcertTicket(String name, SellIn sellIn, Quality quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void dailyUpdate() {
		reduceSellInBy1();
		reduceQualityDependingOnSellIn();
	}

	private void reduceQualityDependingOnSellIn() {
		if (this.sellIn.getValue() > 10) {
			this.quality = quality.increase(1);
		} else if (this.sellIn.getValue() > 5) {
			this.quality = quality.increase(2);
		} else if (this.sellIn.getValue() > -1) {
			this.quality = quality.increase(3);
		} else {
			this.quality = new Quality(0);
		}
	}
}
