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
            } else if (item instanceof CasualItem) {
                ((CasualItem) item).dailyUpdate();
            }
        }
    }
}
