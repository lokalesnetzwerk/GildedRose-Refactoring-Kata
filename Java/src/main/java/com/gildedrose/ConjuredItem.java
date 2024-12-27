package com.gildedrose;

public class ConjuredItem extends Item implements Updateable {
    public ConjuredItem(String name, SellIn sellIn, Quality quality) {
        super(name, sellIn.value, quality.value);
    }

    @Override
    public void updateQuality() {
        this.sellIn = this.sellIn - 1;
        if (sellIn < 0) {
            this.quality = this.quality - 2;
        }
    }
}
