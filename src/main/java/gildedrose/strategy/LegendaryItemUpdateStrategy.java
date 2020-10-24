package gildedrose.strategy;

import gildedrose.item.Item;

/**
 * - Legendary item never has to be sold or decreases in Quality<br>
 * - Quality is 80 and it never alters<br>
 */
public class LegendaryItemUpdateStrategy implements ItemUpdateStrategy {

	@Override
	public int update(final Item item) {
		if (item.quality != QUALITY_LEGENDARY) {
			item.quality = QUALITY_LEGENDARY;
		}

		return item.quality;
	}

}