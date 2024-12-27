package com.gildedrose;

public class CasualItem extends Item implements Updateable {
    public CasualItem(String name, SellIn sellIn, Quality quality) {
        super(name, sellIn.value, quality.value);
    }

    @Override
    public void updateQuality() {
        if (this.quality > 0) {
            this.quality = this.quality - 1;
        }
        this.sellIn = this.sellIn - 1;
        if (this.sellIn < 0) {
            if (this.quality > 0) {
                this.quality = this.quality - 1;
            }
        }
    }
}
