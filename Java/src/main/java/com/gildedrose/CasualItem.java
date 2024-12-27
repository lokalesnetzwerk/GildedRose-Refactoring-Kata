package com.gildedrose;

public class CasualItem extends Item implements Updateable {
    public CasualItem(String name, SellIn sellIn, Quality quality) {
        super(name, sellIn.value, quality.value);
    }

    @Override
    public void updateQuality() {
        decreaseSellIn();
        decreaseQuality();
    }

    private void decreaseSellIn() {
        this.sellIn = this.sellIn - 1;
    }

    private void decreaseQuality() {
        Quality quality = new Quality(this.quality);
        if (this.sellIn < 0) {
            quality.decrease(2);
        } else {
            quality.decrease(1);
        }
        this.quality = quality.value;
    }
}
