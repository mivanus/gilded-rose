package gildedrose.strategy;

import gildedrose.item.Item;

/**
 * - "Backstage passes" increases in Quality as its SellIn value approaches<br>
 * - Quality increases by 2 when there are 10 days or less and by 3 when there
 * are 5 days or less but Quality drops to 0 after the concert<br>
 */
public class BackstagePassItemUpdateStrategy implements ItemUpdateStrategy {

	@Override
	public int update(final Item item) {
		item.sellIn -= 1;

		if (item.sellIn < 0) {
			return item.quality = QUALITY_NORMAL_MIN;
		}

		item.quality += 1;

		if (item.sellIn < 10) {
			item.quality += 1;
		}

		if (item.sellIn < 5) {
			item.quality += 1;
		}

		if (item.quality > QUALITY_NORMAL_MAX) {
			item.quality = QUALITY_NORMAL_MAX;
		}

		return item.quality;
	}

}