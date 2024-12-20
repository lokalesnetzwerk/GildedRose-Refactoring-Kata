package com.gildedrose.attributes;

public class SellIn {
	
	private final Integer sellIn;

	public SellIn(Integer sellIn) {
		this.sellIn = sellIn;
	}

	public SellIn decrease(Integer decrement) {
		return new SellIn(this.sellIn - decrement);
	}
	
	public int getValue() {
		return sellIn;
	}

	@Override
	public String toString() {
		return String.valueOf(sellIn);
	}
}
