package com.heapdev.hashtable;

public class HashTable {

	private HashItem[] hashTable;

	public HashTable() {
		hashTable = new HashItem[Constants.TABLE_SIZE];
	}

	public int hashCodeValue(int key) {
		return key % Constants.TABLE_SIZE;
	}

	public void put(int key, int value) {

		int hashPosition = hashCodeValue(key);
		System.out.println("hashPosition:::" + hashPosition);

		if (hashTable[hashPosition] == null) {
			System.out.println("No colision, simple insertion");
			hashTable[hashPosition] = new HashItem(key, value);
		} else {
			System.out.println("Collision while inserting the key...");
			HashItem hashItem = hashTable[hashPosition];
			while (hashItem.getNextHashItem() != null) {
				System.out.println("Considering next item in the linked list of same bucket... " + hashItem.getValue());

				hashItem = hashItem.getNextHashItem();
			}
			System.out.println("finallly we have found, now inserting...");
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
