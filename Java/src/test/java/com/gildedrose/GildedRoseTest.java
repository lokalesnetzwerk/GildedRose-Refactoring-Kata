package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class GildedRoseTest {

    @Test
    void foo() {
        CombinationApprovals.verifyAllCombinations(
                this::doUpdateQuality,
                new String[] {"foo", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros"},
                new Integer[] {-1, 0, 1, 5, 6, 10, 11},
                new Integer[] {0, 1, 49, 50}
        );
    }

    private String doUpdateQuality(String name, Integer sellIn, Integer quality) {
        Item[] items = new Item[] {
            new Item(name, sellIn, quality),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item item = items[0];
	    return itemPrinter(item).trim();
    }

    String itemPrinter(Item item) {
        return item.name + ",sellIn:" + item.sellIn + ",Quality:"+ item.quality;
    }
    
    @Test
    void secondTryTest() {
        List<Updateable> updateables = new ArrayList<>();

        Legendary ragnaros = new Legendary("Sulfuras, Hand of Ragnaros", 9, 80);
        updateables.add(ragnaros);
        Cheese agedBrie = new Cheese("Aged Brie", 2, 0);
        updateables.add(agedBrie);
        ConcertTicket backstagePasses = new ConcertTicket("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        updateables.add(backstagePasses);
        
        GildedRose app = new GildedRose(updateables);
        List<Updateable> actual = app.newDayItemUpdate();

        Assertions.assertThat(actual.get(0).).isEqualTo(80);
        Assertions.assertThat(actual.get(0).sellIn).isEqualTo(9);
        Assertions.assertThat(app.items[1].quality).isEqualTo(1);
        Assertions.assertThat(app.items[1].sellIn).isEqualTo(1);
        Assertions.assertThat(app.items[2].quality).isEqualTo(21);
        Assertions.assertThat(app.items[2].sellIn).isEqualTo(14);
    }
}

















