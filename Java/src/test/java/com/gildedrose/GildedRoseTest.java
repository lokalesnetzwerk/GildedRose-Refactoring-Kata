package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        CombinationApprovals.verifyAllCombinations(
            this::doUpdateQuality,
            new String[] {"foo", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros", "Aged Brie"},
            new Integer[] {0, 1, 10, 11, 49, 50},
            new Integer[] {0, 1, 10, 11, 49, 50, 80}
        );

    }

    String doUpdateQuality(String name, int sellIn, int quality) {
        Item[] items = new Item[] {new Item(name, sellIn, quality)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item actual = items[0];

        return "Name:" + actual.name + ",SellIn: " + actual.sellIn + ",Quality: " + actual.quality;
    }

}
