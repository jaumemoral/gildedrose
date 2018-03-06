package com.gildedrose.rules;

import com.gildedrose.Item;

public class SulfurasInventoryRule extends InventoryRule{

	public void apply(Item item) {
		return;
	}

	public boolean canApply(Item item) {
		return "Sulfuras".equals(item.name);
	}

}