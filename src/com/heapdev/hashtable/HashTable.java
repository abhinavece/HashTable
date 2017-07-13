package com.heapdev.hashtable;

public class HashTable {

	private HashItem[] hashTable;

	public int hashCodeValue(int key) {
		return key % Constants.TABLE_SIZE;
	}

	public void put(int key, int value) {

		int hashPosition = hashCodeValue(key);

		if (hashTable[hashPosition] == null) {
			hashTable[hashPosition] = new HashItem(key, value);
		} else {
			HashItem hashItem = hashTable[hashPosition];

			while (hashItem.getNextHashItem() != null) {
				hashItem = hashItem.getNextHashItem();
			}

			hashItem.setNextHashItem(new HashItem(key, value));
		}
	}

	public int get(int key) {

		int hashPosition = hashCodeValue(key);

		HashItem hashItem = hashTable[hashPosition];

		while (hashItem != null && hashItem.getKey() != key) {
			hashItem = hashItem.getNextHashItem();
		}

		if (hashTable[hashPosition] == null) {
			return -1;
		} else {
			return hashItem.getValue();
		}

	}

}
