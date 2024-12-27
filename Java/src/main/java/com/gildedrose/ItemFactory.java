package com.gildedrose;

public class ItemFactory {
    private ItemFactory() {
    }

    public static Item createItem(String name, Integer sellIn, Integer quality) {
        if (name.equals("Sulfuras, Hand of Ragnaros")) {
            return new LegendaryItem(name, new SellIn(sellIn), new Quality(quality));
        } else if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            return new TicketItem(name, new SellIn(sellIn), new Quality(quality));
        } else if (name.equals("Aged Brie")) {
            return new CheeseItem(name, new SellIn(sellIn), new Quality(quality));
        } else if (name.contains("Conjured")) {
            return new ConjuredItem(name, new SellIn(sellIn), new Quality(quality));
        } else {
            return new CasualItem(name, new SellIn(sellIn), new Quality(quality));
        }
    }
}
