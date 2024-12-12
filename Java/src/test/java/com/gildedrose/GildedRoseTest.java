package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class GildedRoseTest {

    Item[] items;
    GildedRose testee;

    @Test
    void increaseQualityOfAgendBrie_WhenSellInNotNegative() {
        items = new Item[]{new Item("Aged Brie", 1, 30)};
        testee = new GildedRose(items);

        testee.updateQuality();

        Optional<Item> actualCasualSellIn = Arrays.stream(testee.items).filter(item -> item.name.equals("Aged Brie")).findAny();
        assertThat(actualCasualSellIn).isPresent();
        assertThat(actualCasualSellIn.get().quality).isEqualTo(31);
    }

    @Test
    void increaseQualityOfAgendBrie_WhenSellInNegative() {
        items = new Item[]{new Item("Aged Brie", -1, 30)};
        testee = new GildedRose(items);

        testee.updateQuality();

        Optional<Item> actualCasualSellIn = Arrays.stream(testee.items).filter(item -> item.name.equals("Aged Brie")).findAny();
        assertThat(actualCasualSellIn).isPresent();
        assertThat(actualCasualSellIn.get().quality).isEqualTo(32);
    }

    @Test
    void increaseQualityOfTickets_WhenSellInPositiveAndGreater10() {
        items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 11, 30)};
        testee = new GildedRose(items);

        testee.updateQuality();

        Optional<Item> actualCasualSellIn = Arrays.stream(testee.items).filter(item -> item.name.equals("Backstage passes to a TAFKAL80ETC concert")).findAny();
        assertThat(actualCasualSellIn).isPresent();
        assertThat(actualCasualSellIn.get().sellIn).isEqualTo(10);
        assertThat(actualCasualSellIn.get().quality).isEqualTo(31);
    }

    @Test
    void increaseQualityOfTickets_WhenSellInPositiveAndGreater5() {
        items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 6, 30)};
        testee = new GildedRose(items);

        testee.updateQuality();

        Optional<Item> actualCasualSellIn = Arrays.stream(testee.items).filter(item -> item.name.equals("Backstage passes to a TAFKAL80ETC concert")).findAny();
        assertThat(actualCasualSellIn).isPresent();
        assertThat(actualCasualSellIn.get().sellIn).isEqualTo(5);
        assertThat(actualCasualSellIn.get().quality).isEqualTo(32);
    }

    @Test
    void increaseQualityOfTickets_WhenSellInPositive() {
        items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 1, 30)};
        testee = new GildedRose(items);

        testee.updateQuality();

        Optional<Item> actualCasualSellIn = Arrays.stream(testee.items).filter(item -> item.name.equals("Backstage passes to a TAFKAL80ETC concert")).findAny();
        assertThat(actualCasualSellIn).isPresent();
        assertThat(actualCasualSellIn.get().sellIn).isEqualTo(0);
        assertThat(actualCasualSellIn.get().quality).isEqualTo(33);
    }

    @Test
    void increaseQualityOfTickets_WhenSellInNegative() {
        items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", -1, 30)};
        testee = new GildedRose(items);

        testee.updateQuality();

        Optional<Item> actualCasualSellIn = Arrays.stream(testee.items).filter(item -> item.name.equals("Backstage passes to a TAFKAL80ETC concert")).findAny();
        assertThat(actualCasualSellIn).isPresent();
        assertThat(actualCasualSellIn.get().sellIn).isEqualTo(-2);
        assertThat(actualCasualSellIn.get().quality).isEqualTo(0);
    }


    @Test
    void keepQuality_WhenQuality50OrBigger() {
        items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50)};
        testee = new GildedRose(items);

        testee.updateQuality();

        Optional<Item> actualCasualSellIn = Arrays.stream(testee.items).filter(item -> item.name.equals("Backstage passes to a TAFKAL80ETC concert")).findAny();
        assertThat(actualCasualSellIn).isPresent();
        assertThat(actualCasualSellIn.get().sellIn).isEqualTo(4);
        assertThat(actualCasualSellIn.get().quality).isEqualTo(50);
    }

    @Test
    void lowerSellInOnUpdate() {
        items = new Item[]{new Item("sellInCheck", 10, 10),};
        testee = new GildedRose(items);
        testee.updateQuality();

        Optional<Item> actualCasualSellIn = Arrays.stream(testee.items).filter(item -> item.name.equals("sellInCheck")).findAny();
        assertThat(actualCasualSellIn).isPresent();
        assertThat(actualCasualSellIn.get().sellIn).isEqualTo(9);
        assertThat(actualCasualSellIn.get().quality).isEqualTo(9);
    }

    @Test
    void lowerQualityOnUpdate() {
        items = new Item[]{new Item("sellInCheck", 10, 10),};
        testee = new GildedRose(items);
        testee.updateQuality();

        Optional<Item> actualCasualSellIn = Arrays.stream(testee.items).filter(item -> item.name.equals("sellInCheck")).findAny();

        assertThat(actualCasualSellIn).isPresent();
        assertThat(actualCasualSellIn.get().sellIn).isEqualTo(9);
        assertThat(actualCasualSellIn.get().quality).isEqualTo(9);
    }

    @Test
    void lowerQualityOnUpdate_WhenSellInIsNegative() {
        items = new Item[]{new Item("sellInCheck", -2, 10),};
        testee = new GildedRose(items);
        testee.updateQuality();

        Optional<Item> actualCasualSellIn = Arrays.stream(testee.items).filter(item -> item.name.equals("sellInCheck")).findAny();

        assertThat(actualCasualSellIn).isPresent();
        assertThat(actualCasualSellIn.get().sellIn).isEqualTo(-3);
        assertThat(actualCasualSellIn.get().quality).isEqualTo(8);
    }


    @Test
    void legendaryQualityUpdate() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 50, 80)};
        GildedRose testee = new GildedRose(items);

        testee.updateQuality();

        Optional<Item> actualRagnaros = Arrays.stream(testee.items).filter(item -> item.name.equals("Sulfuras, Hand of Ragnaros")).findAny();
        assertThat(actualRagnaros).isPresent();
        assertThat(actualRagnaros.get().sellIn).isEqualTo(50);
        assertThat(actualRagnaros.get().quality).isEqualTo(80);
    }
}
