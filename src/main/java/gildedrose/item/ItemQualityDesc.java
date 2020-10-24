package gildedrose.item;

/**
 * Quality descriptor of an item.<br>
 */
public enum ItemQualityDesc {

	NORMAL, AGED, LEGENDARY, CONJURED;

	public static ItemQualityDesc fromName(final String itemName) {
		if (itemName == null) {
			return NORMAL;
		}

		// check if item is legendary
		if (itemName.startsWith("Sulfuras, Hand of Ragnaros")) {
			return LEGENDARY;
		}

		// check if item is aging
		if (itemName.startsWith("Aged")) {
			return AGED;
		}

		// check if item is conjured
		if (itemName.startsWith("Conjured")) {
			return CONJURED;
		}

		return NORMAL;
	}
}
