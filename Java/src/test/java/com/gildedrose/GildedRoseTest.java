package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void acceptanceTest() {
        CombinationApprovals.verifyAllCombinations(
            this::updateItems,
            new String[]{"foo", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros"},
            new Integer[]{-1, 0, 1, 4, 6, 7, 11, 12},
            new Integer[]{0, 1, 49, 50, 51}
        );
    }

    private String updateItems(String name, Integer sellIn, Integer quality) {
        Item[] items = new Item[]{
            ItemFactory.createItem(name, sellIn, quality)
        };

        GildedRose testee = new GildedRose(items);
        testee.updateQuality();

        Item actual = items[0];
        return printItem(actual);
    }

    private String printItem(Item item) {
        return "Name: " + item.name + ", SellIn: " + item.sellIn + ", Quality: " + item.quality;
    }

}
