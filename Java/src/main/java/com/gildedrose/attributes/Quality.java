package com.gildedrose.attributes;

public class Quality {

	private static final int MIN_QUALITY = 0;
	private static final int MAX_QUALITY = 50;
	private final Integer quality;

	public Quality(Integer quality) {
		this.quality = clamp(quality);
	}

	public Quality increase(int increment) {
		return new Quality(this.quality + increment);
	}

	public Quality decrease(int decrement) {
		return new Quality(this.quality - decrement);
	}

	public int getValue() {
		return quality;
	}

	private int clamp(int quality) {
		return Math.max(MIN_QUALITY, Math.min(MAX_QUALITY, quality));
	}

	@Override
	public String toString() {
		return String.valueOf(quality);
	}
}
