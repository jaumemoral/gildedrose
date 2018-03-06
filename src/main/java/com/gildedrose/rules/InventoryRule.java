package com.gildedrose.rules;

import com.gildedrose.Item;

public abstract class InventoryRule {

	public abstract void apply(Item item);
	public abstract boolean canApply(Item item);

	protected void decreaseSellBy(Item item) {
		item.sellIn--;
	}

	protected void decreaseQuality(Item item) {
		decreaseQuality(item,1);
	}

	protected void decreaseQuality(Item item,int factor) {
		item.quality-=factor;
		if (item.quality<0) item.quality=0;
	}

	protected void increaseQuality(Item item,int factor) {
		item.quality+=factor;
		if (item.quality>50) item.quality=50;
	}

	protected void increaseQuality(Item item) {
		increaseQuality(item,1);
	}

}