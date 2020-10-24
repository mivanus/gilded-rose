package gildedrose.strategy;

import gildedrose.item.Item;

public interface ItemUpdateStrategy {

	int QUALITY_LEGENDARY = 80;
	int QUALITY_NORMAL_MAX = 50;
	int QUALITY_NORMAL_MIN = 0;

	int update(Item item);

}
