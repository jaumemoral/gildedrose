package com.gildedrose.rules;

import com.gildedrose.Item;

public class AgedBrieInventoryRule extends InventoryRule{

	public void apply(Item item) {
		increaseQuality(item);
		decreaseSellBy(item);
	}

	public boolean canApply(Item item) {
		return "Aged Brie".equals(item.name);
	}

}