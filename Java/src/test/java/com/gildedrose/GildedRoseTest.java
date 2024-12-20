package com.gildedrose;

import com.gildedrose.attributes.Quality;
import com.gildedrose.attributes.SellIn;
import com.gildedrose.items.*;
import org.approvaltests.combinations.CombinationApprovals;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        Item[] items = new Item[] { ItemFactory.createItem(name, sellIn, quality) };
        
        GildedRose app = new GildedRose(items);
        Item[] actual = app.newDayItemUpdate();

	    return itemPrinter(actual[0]);
    }

    String itemPrinter(Item item) {
        return item.name + ",sellIn:" + item.sellIn + ",Quality:"+ item.quality;
    }
    
    @Test
    void secondTryTest() {
        Item[] actual = getItems();

        GildedRose app = new GildedRose(actual);
        app.newDayItemUpdate();
        
        Assertions.assertThat(actual[0].quality.getValue()).isZero();
        Assertions.assertThat(actual[0].sellIn.getValue()).isZero();
        Assertions.assertThat(actual[1].quality.getValue()).isEqualTo(1);
        Assertions.assertThat(actual[1].sellIn.getValue()).isEqualTo(1);
        Assertions.assertThat(actual[2].quality.getValue()).isEqualTo(0);
        Assertions.assertThat(actual[2].sellIn.getValue()).isEqualTo(-1);
    }

    private static Item[] getItems() {
        Item[] items = new Item[3];

        Legendary ragnaros = new Legendary("Sulfuras, Hand of Ragnaros", new SellIn(0), new Quality(0));
        items[0] = ragnaros;
        Cheese agedBrie = new Cheese("Aged Brie", new SellIn(2), new Quality(0));
        items[1] = agedBrie;
        ConcertTicket backstagePasses = new ConcertTicket("Backstage passes to a TAFKAL80ETC concert", new SellIn(0), new Quality(0));
        items[2] = backstagePasses;

        return items;
    }
}

















