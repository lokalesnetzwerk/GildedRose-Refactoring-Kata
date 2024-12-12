package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    decrementQuality(i);
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        updateQualityOfTicket10DaysBeforeEvent(i, 11);
                        updateQualityOfTicket5DaysBeforeEvent(i, 6);
                    }
                }
            }

            decrementSellIn(i);

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            decrementQuality(i);
                        }
                    } else {
                        items[i].quality = 0;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }

    private void updateQualityOfTicket10DaysBeforeEvent(int i, int x) {
        if (items[i].sellIn < x && items[i].quality < 50) {
            items[i].quality = items[i].quality + 1;
        }

    }

    private void updateQualityOfTicket5DaysBeforeEvent(int i, int x) {
        if (items[i].sellIn < x && items[i].quality < 50) {
            items[i].quality = items[i].quality + 1;
        }

    }

    private void decrementSellIn(int i) {
        if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
            items[i].sellIn = items[i].sellIn - 1;
        }
    }

    private void decrementQuality(int i) {
        if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
            items[i].quality = items[i].quality - 1;
        }
    }
}
