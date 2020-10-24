package gildedrose.item;

import gildedrose.strategy.ItemUpdateStrategyFactory;

public class ItemUpdater {

	private static final ItemUpdateStrategyFactory UPDATE_STRATEGY_FACTORY = new ItemUpdateStrategyFactory();

	public static int update(final Item item) {
		return UPDATE_STRATEGY_FACTORY.getInstance(item).update(item);
	}

}
