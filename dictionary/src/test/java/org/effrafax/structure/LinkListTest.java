package org.effrafax.structure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LinkListTest {
	@SuppressWarnings("rawtypes")
	@Test
	public void shouldInitialyHaveSize0() {
		LinkList list = new LinkList();

		int size = list.size();

		assertEquals(0, size);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void shouldBeAbleToAddElement() {
		LinkList list = new LinkList();

		list.add(new Object());

		assertEquals(1, list.size());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void shouldBeAbleToAddMultipleElements() {
		LinkList list = new LinkList();

		list.add(new Object());
		list.add(new Object());
		list.add(new Object());

		assertEquals(3, list.size());
	}

	@Test
	public void shouldBeAbleToDetermineIfItContainsAnElement() {
		LinkList<String> list = createHayStack("hay", "needle", "some more hay");

		boolean found = list.contains("needle");

		assertTrue(found);
	}

	@Test
	public void shouldBeAbleToDetermineIfItDoesNotContainsAnElement() {
		LinkList<String> list = createHayStack("hay", "needle", "some more hay");

		boolean found = list.contains("towel");

		assertFalse(found);
	}

	@Test
	public void shouldBeAbleToEvenDetermineIfItDoesContainNull() {
		LinkList<String> list = createHayStack("hay", null, "some more hay");

		boolean found = list.contains(null);

		assertTrue(found);
	}

	@Test
	public void shouldBeAbleGetByIndex() {
		LinkList<String> list = createHayStack("A", "B", "C", "D");

		String result = list.get(3);

		assertEquals("D", result);
	}

	@Test
	public void shouldBeAbleToDeterminTheIndexOfAnElement() {
		LinkList<String> list = createHayStack("A", "B", "C", "D");

		int index = list.indexOf("C");

		assertEquals(2, index);
	}

	private static <T> LinkList<T> createHayStack(T... contents ) {
		LinkList<T> list = new LinkList<T>();
		for (T item : contents) {
			list.add(item);
		}
		return list;
	}
}
