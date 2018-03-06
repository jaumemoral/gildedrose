package com.gildedrose.rules;

import com.gildedrose.Item;

public class DefaultInventoryRule extends InventoryRule {

	public void apply(Item item) {
		decreaseQuality(item);
		decreaseSellBy(item);
	}

	public boolean canApply(Item item) {
		return true;
	}

}