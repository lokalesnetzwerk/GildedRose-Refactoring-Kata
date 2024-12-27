package com.gildedrose;

public class CheeseItem extends Item implements Updateable {
    public CheeseItem(String name, SellIn sellIn, Quality quality) {
        super(name, sellIn.value, quality.value);
    }

    @Override
    public void updateQuality() {
        decreaseSellIn();
        increaseQuality();
    }

    private void decreaseSellIn() {
        this.sellIn = this.sellIn - 1;
    }

    private void increaseQuality() {
        Quality quality = new Quality(this.quality);
        if (this.sellIn < 0) {
            quality.increase(2);
        } else {
            quality.increase(1);
        }
        this.quality = quality.value;
    }

}
