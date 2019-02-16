package com.ds.hashTable;

/**
 * THis HashTable implementation uses double hashing to resolve conflicts
 * 
 *
 */
public class HashTable {

	private Node[] dataArray;

	public HashTable(int size) {
		// The arraysize has to be a prime number in order to avoid infinite looping
		int maxSize = isPrime(size) ? size : getNextPrime(size);
		dataArray = new Node[maxSize];
		System.out.println("HashTable size: " + maxSize);
	}

	public void put(String key, String value) {
		int position = getPrimaryPosition(key);
		int stepSize = getStepSize(key);

		while (dataArray[position] != null) {
			position = (position + stepSize) % dataArray.length;
		}
		dataArray[position] = new Node(key, value);
	}

	public String get(String key) {
		int position = getPrimaryPosition(key);
		int stepSize = getStepSize(key);

		while (!dataArray[position].key.equals(key)) {
			position = (position + stepSize) % dataArray.length;
		}
		return dataArray[position].data;
	}

	private int getPrimaryPosition(String key) {
		int primaryPosition = key.hashCode() % dataArray.length;

		if (primaryPosition < 0) {
			primaryPosition += dataArray.length;
		}
		return primaryPosition;
	}

	private int getStepSize(String key) {
		int code = key.hashCode() % dataArray.length;

		if (code < 0) {
			code += dataArray.length;
		}

		// number below (here in case 3) must be a prime number smaller than array
		// size
		return 17 - code % 17;
	}

	private boolean isPrime(int num) {
		for (int i = 2; i * i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	private int getNextPrime(int num) {

		for (int i = num + 1; true; i++) {
			if (isPrime(i)) {
				return i;
			}
		}
	}

	private class Node {
		String key;
		String data;

		Node(String key, String data) {
			this.key = key;
			this.data = data;
		}
	}

	void primtData() {
		for (int i = 0; i < dataArray.length; i++) {
			if (dataArray[i] != null) {
				System.out.println(i + " -> " + dataArray[i].key + " : " + dataArray[i].data);
			} else {
				System.out.println(i + " -> ");
			}
		}
	}

	public static void main(String[] args) {
		HashTable hashTable = new HashTable(50);
		hashTable.put("apple", "value1");
		hashTable.put("ball", "value2");
		hashTable.put("cat", "value3");
		hashTable.put("dog", "value4");
		hashTable.put("egg", "value5");
		hashTable.put("fox", "value6");
		hashTable.put("goat", "value7");
		hashTable.put("house", "value8");
		hashTable.put("ink", "value9");
		hashTable.put("jackle", "value0");
		//hashTable.primtData();
		System.out.println(hashTable.get("dog"));
	}
}
