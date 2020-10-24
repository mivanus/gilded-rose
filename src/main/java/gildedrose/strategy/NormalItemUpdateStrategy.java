package gildedrose.strategy;

import gildedrose.item.Item;

/**
 * - Once the sell by date has passed, Quality degrades twice as fast<br>
 * - The Quality of an item is never negative<br>
 */
public class NormalItemUpdateStrategy implements ItemUpdateStrategy {

	@Override
	public int update(final Item item) {
		item.sellIn -= 1;

		if (item.sellIn < 0) {
			item.quality -= 2;
		} else {
			item.quality -= 1;
		}

		if (item.quality < QUALITY_NORMAL_MIN) {
			item.quality = QUALITY_NORMAL_MIN;
		}

		return item.quality;
	}

}