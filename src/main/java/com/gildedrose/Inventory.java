package com.gildedrose;

import com.gildedrose.rules.AgedBrieInventoryRule;
import com.gildedrose.rules.BackstagePassInventoryRule;
import com.gildedrose.rules.DefaultInventoryRule;
import com.gildedrose.rules.ExpiredProductInventoryRule;
import com.gildedrose.rules.InventoryRule;
import com.gildedrose.rules.SulfurasInventoryRule;

public class Inventory {

	InventoryRule[] inventoryRules=new InventoryRule[]{
			new SulfurasInventoryRule(),
			new AgedBrieInventoryRule(),
			new BackstagePassInventoryRule(),
			new ExpiredProductInventoryRule()
	};

	public InventoryRule findInventoryRule(Item item) {
		for (InventoryRule rule : inventoryRules) if (rule.canApply(item)) return rule;
		return new DefaultInventoryRule();
	}

	public void updateItem(Item item) throws NegativeQualityException {
		findInventoryRule(item).apply(item);
	}

}
