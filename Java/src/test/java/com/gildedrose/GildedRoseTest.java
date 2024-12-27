package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void foo() {
        CombinationApprovals.verifyAllCombinations(
            this::doUpdateQuality,
            new String[]{"foo", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros"},
            new Integer[]{-1, 0, 1, 5, 6, 10, 11},
            new Integer[]{0, 1, 49, 50}
        );
    }

    private String doUpdateQuality(String name, Integer sellIn, Integer quality) {
        Item[] items = new Item[1];
        items[0] = ItemFactory.createItem(name, sellIn, quality);

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item actual = app.items[0];

        return itemPrinter(actual);
    }

    String itemPrinter(Item item) {
        return item.name + ",sellIn:" + item.sellIn + ",Quality:" + item.quality;
    }
}
