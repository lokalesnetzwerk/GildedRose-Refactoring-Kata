package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void acceptanceTest() {
        CombinationApprovals.verifyAllCombinations(
            this::updateItems,
            new String[]{"foo", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros", "Conjured Mana Cake"},
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

    @Test
    void updateConjuredItem() {
        Item[] items = new Item[]{
            ItemFactory.createItem("Conjured Mana Cake positive MHD", 1, 10),
            ItemFactory.createItem("Conjured Mana Cake negative MHD", -1, 10)
        };

        GildedRose testee = new GildedRose(items);
        testee.updateQuality();

        Item actualPositiveMHD = items[0];
        Item actualNegativeMHD = items[1];

        Assertions.assertThat(actualPositiveMHD.quality).isEqualTo(8);
        Assertions.assertThat(actualPositiveMHD.sellIn).isZero();
        Assertions.assertThat(actualNegativeMHD.quality).isEqualTo(6);
        Assertions.assertThat(actualNegativeMHD.sellIn).isEqualTo(-2);
    }
}
