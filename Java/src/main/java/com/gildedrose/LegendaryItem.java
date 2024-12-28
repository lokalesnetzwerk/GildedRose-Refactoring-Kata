package com.gildedrose;

public class LegendaryItem extends Item implements Updateable {

    public LegendaryItem(String name, SellIn sellIn, Quality quality) {
        super(name, sellIn.getValue(), quality.getValue());
    }

    @Override
    public void dailyUpdate() {
        // Legendary items do not change their stats
    }
}
