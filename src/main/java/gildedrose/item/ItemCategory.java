package gildedrose.item;

/**
 * Category of an item.<br>
 * eg. tool, drink, food, weapon
 */
public enum ItemCategory {

	GENERAL, BACKSTAGE_PASS;

	public static ItemCategory fromName(final String itemName) {
		if (itemName == null || !itemName.startsWith("Backstage passes")) {
			return GENERAL;
		}

		return BACKSTAGE_PASS;
	}
}
