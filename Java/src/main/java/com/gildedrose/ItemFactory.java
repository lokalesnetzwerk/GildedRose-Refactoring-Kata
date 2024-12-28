package com.gildedrose;

public class ItemFactory {
    private ItemFactory() {
    }

    public static Item createItem(String name, Integer sellIn, Integer quality) {
        if (name.equals("Sulfuras, Hand of Ragnaros")) {
            return new LegendaryItem(name, new SellIn(sellIn), new Quality(quality));
        } else {
            return new Item(name, sellIn, quality);
        }
    }
}
