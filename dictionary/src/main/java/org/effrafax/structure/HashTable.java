package org.effrafax.structure;


public class HashTable<K, V> {
	private final LinkList<TableEntry<K,V>> entries = new LinkList<TableEntry<K,V>>();
	private int size;

	public void put(K key, V value) {
		TableEntry<K, V> target = new TableEntry<K,V>(key, null);
		if (entries.contains(target)) {
			int index = entries.indexOf(target);
			entries.get(index).setValue(value);
		} else {
			entries.add(new TableEntry<K,V>(key, value));
		}
		size++;
	}

	public V get(K key) {
		TableEntry<K, V> target = new TableEntry<K,V>(key, null);
		if (entries.contains(target)) {
			int index = entries.indexOf(target);
			return entries.get(index).getValue();
		}
		return null;
	}

	public int size() {
		return entries.size();
	}

}

class TableEntry<K, V> {

	private final K key;
	private V value;

	public TableEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (! (o instanceof TableEntry)) {
			return false;
		}
		return key.equals(((TableEntry)o).key);
	}

}
