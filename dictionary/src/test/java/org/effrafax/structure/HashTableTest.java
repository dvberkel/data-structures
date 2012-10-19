package org.effrafax.structure;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HashTableTest {

	@Test
	public void shouldBePossibleToMapKeyToValue() {
		HashTable<String, String> table = new HashTable<String, String>();

		table.put("John", "Doe");

		assertEquals(1, table.size());
	}

	@Test
	public void shouldBeAbleToRetrieveViaKey() {
		HashTable<String, String> table = new HashTable<String, String>();
		table.put("John", "Murray");
		table.put("Jane", "Doe");

		String value = table.get("Jane");

		assertEquals("Doe", value);
	}

	@Test
	public void shouldUpdateEntryWhenSameKeyIsUsed() {
		HashTable<String, String> table = new HashTable<String, String>();
		table.put("John", "Murray");

		table.put("John", "Doe");

		assertEquals(1, table.size());
		assertEquals("Doe", table.get("John"));
	}

}
