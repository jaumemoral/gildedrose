package com.gildedrose;

public class ItemFactory {

	public static Item createItem(String name, int sellIn, int quality) throws NegativeQualityException {
		if (quality<0) throw new NegativeQualityException();
		return new Item(name, sellIn, quality);
	}

}
