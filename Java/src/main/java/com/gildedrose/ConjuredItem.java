package com.gildedrose;

public class ConjuredItem extends Item implements Updateable {
    public ConjuredItem(String name, SellIn sellIn, Quality quality) {
        super(name, sellIn.getValue(), quality.getValue());
    }

    @Override
    public void dailyUpdate() {
        this.sellIn = this.sellIn - 1;
        if (this.sellIn < 0) {
            if (this.quality > 0) {
                this.quality = this.quality - 4;
            }
        } else {
            if (this.quality > 0) {
                this.quality = this.quality - 2;
            }
        }
        if (this.quality < 0) {
            this.quality = 0;
        }
    }
}
