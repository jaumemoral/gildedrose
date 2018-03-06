package com.gildedrose.rules;

import com.gildedrose.Item;

public class ExpiredProductInventoryRule extends InventoryRule {

	public void apply(Item item) {
		decreaseSellBy(item);
		decreaseQuality(item,2);
	}

	public boolean canApply(Item item) {
		return (item.sellIn==0);
	}

}