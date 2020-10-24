package gildedrose;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import gildedrose.item.Item;

class GildedRoseTest {

	@Test
	void test() throws IOException {
		StringBuilder out = new StringBuilder();
		out.append("OMGHAI!\r\n");

		Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20), //
				new Item("Aged Brie", 2, 0), //
				new Item("Elixir of the Mongoose", 5, 7), //
				new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
				new Item("Sulfuras, Hand of Ragnaros", -1, 80), //
				new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20), //
				new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49), //
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49), //
				new Item("Conjured Mana Cake", 3, 6) };

		GildedRose app = new GildedRose(items);

		for (int i = 0; i <= 30; i++) {
			out.append("-------- day " + i + " --------\r\n");
			out.append("name, sellIn, quality\r\n");
			for (Item item : items) {
				out.append(item);
				out.append("\r\n");
			}
			out.append("\r\n");
			app.updateQuality();
		}

		System.out.println(out.toString());

		Assertions.assertEquals(expectedOutput(), out.toString());
	}

	private String expectedOutput() throws IOException {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();

		try (InputStream is = this.getClass().getClassLoader()
				.getResourceAsStream("GildedRoseTest.test - expected.txt")) {
			int nRead;
			byte[] data = new byte[1024];
			while ((nRead = is.read(data, 0, data.length)) != -1) {
				buffer.write(data, 0, nRead);
			}

			buffer.flush();
		}

		return new String(buffer.toByteArray(), StandardCharsets.UTF_8);
	}
}
