package com.gildedrose;

public class TicketItem extends Item implements Updateable {

	public TicketItem(String name, SellIn sellIn, Quality quality) {
		super(name, sellIn.value, quality.value);
	}

	@Override
	public void updateQuality() {
		if (this.quality < 50) {
			this.quality = this.quality + 1;
			if (this.sellIn < 11 && this.quality < 50) {
				this.quality = this.quality + 1;
			}
			if (this.sellIn < 6 && this.quality < 50) {
				this.quality = this.quality + 1;
			}
		}
		this.sellIn = this.sellIn - 1;
		if (this.sellIn < 0) {
			this.quality = 0;
		}
	}
}
