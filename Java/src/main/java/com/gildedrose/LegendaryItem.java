package com.gildedrose;

public class LegendaryItem extends Item implements Updateable {

    public LegendaryItem(String name, SellIn sellIn, Quality quality) {
        super(name, sellIn.value, quality.value);
    }

    @Override
    public void updateQuality() {
        System.out.println("SULFURAS DOES NOT CHANGE QUALITY!");
    }
}
