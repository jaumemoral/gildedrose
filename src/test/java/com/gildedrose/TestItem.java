package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestItem {

	Inventory inventory=new Inventory();

	@Test
	public void test() {
		assertTrue(true);
	}

	@Test
	public void testCreateItem() throws NegativeQualityException {
		String name="Thing";
		int sellIn=1;
		int quality=2;
		Item item=ItemFactory.createItem(name,sellIn,quality);
		assertEquals(item.name,name);
		assertEquals(item.sellIn,sellIn);
		assertEquals(item.quality,quality);
	}

	@Test
	public void testNegativeQuality() {
		try {
			Item item=ItemFactory.createItem("Thing",1,-1);
			assertTrue(false);
		} catch (NegativeQualityException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testUpdateRegularItem() throws NegativeQualityException {
		int initialSellIn=10;
		int initialQuality=20;
		Item item=ItemFactory.createItem("Thing",initialSellIn,initialQuality);
		inventory.updateItem(item);
		assertEquals(item.sellIn,initialSellIn-1);
		assertEquals(item.quality,initialQuality-1);
	}

	@Test
	public void testUpdateRegularItemNegativeQuality() throws NegativeQualityException {
		int initialSellIn=10;
		int initialQuality=0;
		Item item=ItemFactory.createItem("Thing",initialSellIn,initialQuality);
		inventory.updateItem(item);
		assertEquals(item.sellIn,initialSellIn-1);
		assertEquals(item.quality,initialQuality);
	}

	@Test
	public void testUpdatePassedSellBy() throws NegativeQualityException {
		int initialSellIn=0;
		int initialQuality=20;
		Item item=ItemFactory.createItem("Thing",initialSellIn,initialQuality);
		inventory.updateItem(item);
		assertEquals(item.sellIn,initialSellIn-1);
		assertEquals(item.quality,initialQuality-2);
	}

	@Test
	public void testAgedBrie() throws NegativeQualityException {
		int initialSellIn=0;
		int initialQuality=20;
		Item item=ItemFactory.createItem("Aged Brie",initialSellIn,initialQuality);
		inventory.updateItem(item);
		assertEquals(item.sellIn,initialSellIn-1);
		assertEquals(item.quality,initialQuality+1);
	}

	@Test
	public void testSulfuras() throws NegativeQualityException {
		int initialSellIn=10;
		int initialQuality=80;
		Item item=ItemFactory.createItem("Sulfuras",initialSellIn,initialQuality);
		inventory.updateItem(item);
		assertEquals(item.sellIn,initialSellIn);
		assertEquals(item.quality,initialQuality);
	}

	@Test
	public void testBackstagePass() throws NegativeQualityException {
		Item item=ItemFactory.createItem("Backstage pass",12,10);
		inventory.updateItem(item);
		assertEquals(item.sellIn,11);
		assertEquals(item.quality,11);
		inventory.updateItem(item);
		assertEquals(item.sellIn,10);
		assertEquals(item.quality,13);
		inventory.updateItem(item);
		assertEquals(item.sellIn,9);
		assertEquals(item.quality,15);
		inventory.updateItem(item);
		assertEquals(item.sellIn,8);
		assertEquals(item.quality,17);
		inventory.updateItem(item);
		assertEquals(item.sellIn,7);
		assertEquals(item.quality,19);
		inventory.updateItem(item);
		assertEquals(item.sellIn,6);
		assertEquals(item.quality,21);
		inventory.updateItem(item);
		assertEquals(item.sellIn,5);
		assertEquals(item.quality,24);
		inventory.updateItem(item);
		assertEquals(item.sellIn,4);
		assertEquals(item.quality,27);
		inventory.updateItem(item);
		assertEquals(item.sellIn,3);
		assertEquals(item.quality,30);
		inventory.updateItem(item);
		assertEquals(item.sellIn,2);
		assertEquals(item.quality,33);
		inventory.updateItem(item);
		assertEquals(item.sellIn,1);
		assertEquals(item.quality,36);
		inventory.updateItem(item);
		assertEquals(item.sellIn,0);
		assertEquals(item.quality,39);
		inventory.updateItem(item);
		assertEquals(item.sellIn,-1);
		assertEquals(item.quality,0);


	}
}
