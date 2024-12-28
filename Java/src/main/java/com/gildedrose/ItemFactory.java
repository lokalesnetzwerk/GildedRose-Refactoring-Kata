package com.gildedrose;

public class ItemFactory {
    private ItemFactory() {
    }

    public static Item createItem(String name, Integer sellIn, Integer quality) {
        switch (name) {
            case "Sulfuras, Hand of Ragnaros":
                return new LegendaryItem(name, new SellIn(sellIn), new Quality(quality));
            case "Backstage passes to a TAFKAL80ETC concert":
                return new TicketItem(name, new SellIn(sellIn), new Quality(quality));
            case "Aged Brie":
                return new CheeseItem(name, new SellIn(sellIn), new Quality(quality));
            default:
                return new CasualItem(name, new SellIn(sellIn), new Quality(quality));
        }
    }
}
