package com.gildedrose;

import com.gildedrose.items.Item;

class GildedRose {
    
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public Item[] newDayItemUpdate() {
        for (Item item : items) {
            item.dailyUpdate();
        }
        return items;
    }
}
