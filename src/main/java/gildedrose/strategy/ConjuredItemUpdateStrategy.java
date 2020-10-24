package gildedrose.strategy;

import gildedrose.item.Item;

/**
 * - "Conjured" items degrade in Quality twice as fast as normal items
 */
public class ConjuredItemUpdateStrategy implements ItemUpdateStrategy {

	@Override
	public int update(final Item item) {
		item.sellIn -= 1;

		if (item.sellIn < 0) {
			item.quality -= 4;
		} else {
			item.quality -= 2;
		}

		if (item.quality < QUALITY_NORMAL_MIN) {
			item.quality = QUALITY_NORMAL_MIN;
		}

		return item.quality;
	}

}