package com.gildedrose;

public class Quality {

    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 50;
    int value;

    public Quality(int value) {
        this.value = value;
    }

    void decrease(int subtract) {
        this.value = Math.max(MIN_VALUE, value - subtract);
    }

    void increase(int add) {
        this.value = Math.min(MAX_VALUE, value + add);
    }
}
