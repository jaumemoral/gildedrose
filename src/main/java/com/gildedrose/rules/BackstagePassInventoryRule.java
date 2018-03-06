package com.gildedrose.rules;

import com.gildedrose.Item;

public class BackstagePassInventoryRule extends InventoryRule {

	public void apply(Item item) {
		decreaseSellBy(item);
		if (item.sellIn<0) item.quality=0;
		else if (item.sellIn<=5) increaseQuality(item,3);
		else if (item.sellIn<=10) increaseQuality(item,2);
		else increaseQuality(item);
	}

	public boolean canApply(Item item) {
		return "Backstage pass".equals(item.name);
	}


}
