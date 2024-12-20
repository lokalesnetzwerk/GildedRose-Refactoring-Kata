package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        CombinationApprovals.verifyAllCombinations(
                this::doUpdateQuality,
                new String[] {"foo", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert",  "Sulfuras, Hand of Ragnaros"},
                new Integer[] {-1, 0, 1, 5, 6, 10, 11},
                new Integer[] {0, 1, 49, 50}
        );
    }

    private String doUpdateQuality(String name, Integer sellIn, Integer quality) {
        Item[] items = new Item[] { new Item(name, sellIn, quality) };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        return itemPrinter(actual[0]);
    }
}
