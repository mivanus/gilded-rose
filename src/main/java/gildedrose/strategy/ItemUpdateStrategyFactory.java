package gildedrose.strategy;

import gildedrose.item.Item;
import gildedrose.item.ItemCategory;
import gildedrose.item.ItemQualityDesc;

/**
 * Creates item update strategy based on item category and quality.
 */
public class ItemUpdateStrategyFactory {

	private static final NormalItemUpdateStrategy NORMAL_ITEM_UPDATE_STRATEGY = new NormalItemUpdateStrategy();
	private static final ConjuredItemUpdateStrategy CONJURED_ITEM_UPDATE_STRATEGY = new ConjuredItemUpdateStrategy();
	private static final BackstagePassItemUpdateStrategy BACKSTAGE_PASS_ITEM_UPDATE_STRATEGY = new BackstagePassItemUpdateStrategy();
	private static final AgingItemUpdateStrategy AGING_ITEM_UPDATE_STRATEGY = new AgingItemUpdateStrategy();
	private static final LegendaryItemUpdateStrategy LEGENDARY_ITEM_UPDATE_STRATEGY = new LegendaryItemUpdateStrategy();

	public ItemUpdateStrategy getInstance(final Item item) {
		ItemQualityDesc itemQuality = ItemQualityDesc.fromName(item.name);
		ItemCategory itemCategory = ItemCategory.fromName(item.name);

		if (ItemQualityDesc.LEGENDARY == itemQuality) {
			return LEGENDARY_ITEM_UPDATE_STRATEGY;
		}

		if (ItemQualityDesc.AGED == itemQuality) {
			return AGING_ITEM_UPDATE_STRATEGY;
		}

		if (ItemCategory.BACKSTAGE_PASS == itemCategory) {
			return BACKSTAGE_PASS_ITEM_UPDATE_STRATEGY;
		}

		if (ItemQualityDesc.CONJURED == itemQuality) {
			return CONJURED_ITEM_UPDATE_STRATEGY;
		}

		return NORMAL_ITEM_UPDATE_STRATEGY;
	}

}
