package gildedrose.strategy;

import gildedrose.item.Item;

/**
 * - Item can never have its Quality increase above 50<br>
 * - Item actually increases in Quality the older it gets<br>
 */
public class AgingItemUpdateStrategy implements ItemUpdateStrategy {

	@Override
	public int update(final Item item) {
		item.sellIn -= 1;

		if (item.sellIn < 0) {
			item.quality += 2;
		} else {
			item.quality += 1;
		}

		if (item.quality > QUALITY_NORMAL_MAX) {
			item.quality = QUALITY_NORMAL_MAX;
		}

		return item.quality;
	}

}