package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item instanceof LegendaryItem) {
                ((LegendaryItem) item).dailyUpdate();
            } else if (item instanceof TicketItem) {
                ((TicketItem) item).dailyUpdate();
            } else if (item instanceof CheeseItem) {
                ((CheeseItem) item).dailyUpdate();
            } else {
                if (item.quality > 0) {
                    item.quality = item.quality - 1;
                }
                item.sellIn = item.sellIn - 1;
                if (item.sellIn < 0) {
                    if (item.quality > 0) {
                        item.quality = item.quality - 1;
                    }
                }
            }
        }
    }
}
