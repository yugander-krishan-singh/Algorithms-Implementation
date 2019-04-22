package org.practice.systemdesign;

import java.util.Map;
import java.util.HashMap;

public class LRUCache<K> {

	private final int SIZE;

	private int currentSize = 0;

	private final Map<K, Entry<K>> cacheMap = new HashMap<>();
	private Entry<K> head, tail;

	public LRUCache() {
		this(5);
	}

	public LRUCache(int size) {
		this.SIZE = size;
	}

	public int size() {
		return cacheMap.size();
	}

	public Entry<K> get(K key) {

		if (cacheMap.containsKey(key)) {

			Entry<K> entry = cacheMap.get(key);
			if (head != tail) {
				entry.prev.next = entry.next;
				entry.next.prev = entry.prev;
				entry.next = head;
				head.prev = entry;
				entry.prev = null;
				head = entry;
			}
			return entry;
		}
		return null;
	}

	private void addToTop(Entry<K> entry) {

		entry.next = head;
		if (head != null)
			head.prev = entry;
		head = entry;
		if (tail == null)
			tail = head;

	}

	public void remove() {
		removeFromEnd();
	}
	
	private K removeFromEnd() {
		if (head == null && tail == null) {
			throw new RuntimeException("Head and Tail cannot be null");
		}

		K key = null;

		if (head != null && head == tail) {
			key = tail.key;
			head = null;
			tail = head;
		}
		else {
			key = tail.key;
			tail = tail.prev;
			tail.next = null;
		}
		return key;
	}

	public boolean put(Entry<K> entry) {
		if (!cacheMap.containsKey(entry.key)) {

			if (currentSize == SIZE) {
				K key = removeFromEnd();
				currentSize--;
				cacheMap.remove(key);
			}
			addToTop(entry);
			currentSize++;

		} else {

			Entry<K> oldEntry = cacheMap.get(entry.key);
			oldEntry.prev.next = oldEntry.next;
			oldEntry.next.prev = oldEntry.prev;
			oldEntry = null;

			addToTop(entry);

		}

		cacheMap.put(entry.key, entry);
		return true;
	}

	public static class Entry<K> {
		K key;
		Entry<K> next;
		Entry<K> prev;
	}
}
