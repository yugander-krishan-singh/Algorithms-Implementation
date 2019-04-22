package org.practice.systemdesign;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.practice.systemdesign.LRUCache.Entry;

public class LRUCacheTest {

	@Test
	public void isEmpty() {
		LRUCache<Integer> cache = new LRUCache<Integer>();

		assertEquals(cache.size(), 0);
	}

	@Test
	public void getReturnNull() {
		LRUCache<Integer> cache = new LRUCache<Integer>();
		assertEquals(cache.get(1), null);
	}

	@Test
	public void getReturnNonNull() {
		LRUCache<Integer> cache = new LRUCache<Integer>();
		Entry<Integer> entry = new Entry<Integer>();
		entry.key = 1;
		cache.put(entry);
		assertFalse(cache.get(1) == null);
	}

	@Test
	public void verifyReturn() {
		LRUCache<Integer> cache = new LRUCache<Integer>();

		Entry<Integer> entry = new Entry<Integer>();
		entry.key = 1;
		assertEquals(true, cache.put(entry));

		Entry<Integer> getEntry = cache.get(entry.key);

		assertEquals(getEntry.key, entry.key);
	}

	@Test
	public void validateSize() {
		LRUCache<Integer> cache = new LRUCache<>();
		Entry<Integer> entry = new Entry<>();
		entry.key = 1;
		assertEquals(true, cache.put(entry));

		Entry<Integer> entry1 = new Entry<>();
		entry.key = 2;
		assertEquals(true, cache.put(entry1));

		assertEquals(2, cache.size());

	}

	@Test
	public void testRemoveFromEmptyCache() {

		LRUCache<Integer> cache = new LRUCache<>();
		assertThrows(RuntimeException.class, () -> cache.remove());
	}
	
	@Test
	public void testLRUOperationValidation() {
		LRUCache<Integer> cache = new LRUCache<>(2);
		Entry<Integer> entry = new Entry<>();
		entry.key = 1;
		assertEquals(true, cache.put(entry));

		Entry<Integer> entry1 = new Entry<>();
		entry1.key = 2;
		assertEquals(true, cache.put(entry1));
		
		Entry<Integer> entry2 = new Entry<>();
		entry2.key = 3;
		assertEquals(true, cache.put(entry2));
		
		assertNull(cache.get(1));
		
		assertEquals(2, cache.size());
	}
	
	@Test
	public void testLRUOperationWhenSizeLimitedToOne() {
		LRUCache<Integer> cache = new LRUCache<>(1);
		
		Entry<Integer> entry = new Entry<>();
		entry.key = 1;
		assertEquals(true, cache.put(entry));		
		assertEquals(entry.key, cache.get(entry.key).key);
		
		Entry<Integer> entry1 = new Entry<>();
		entry1.key = 2;
		assertEquals(true, cache.put(entry1));		
		assertEquals(entry1.key, cache.get(entry1.key).key);
	}
}
