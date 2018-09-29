package com.ds.heap;

public class Heap {

	private Node[] dataArray;
	private int maxSize;
	private int currentSize;

	public Heap(int maxSize) {
		this.maxSize = maxSize;
		dataArray = new Node[maxSize];
		currentSize = 0;
	}

	public boolean insert(int key, String data) {
		Node node = new Node(key, data);
		if (currentSize == maxSize) {
			return false;
		}
		dataArray[currentSize] = node;
		bubbleUp(currentSize);
		currentSize++;
		return true;
	}

	private void bubbleUp(int index) {
		int parent = (index - 1) / 2;
		Node data = dataArray[index];
		while (index > 0 && data.key > dataArray[parent].key) {
			dataArray[index] = dataArray[parent];
			index = parent;
			parent = (index - 1) / 2;
		}
		dataArray[index] = data;
	}

	public Node remove() {
		if (currentSize == 0) {
			return null;
		}
		Node data = dataArray[0];
		dataArray[0] = dataArray[--currentSize];
		dataArray[currentSize] = null;
		tickleDown();
		return data;
	}

	private void tickleDown() {
		Node data = dataArray[0];
		int parent = 0;
		while ((parent * 2 + 2) < currentSize) {
			int leftChild = parent * 2 + 1;
			int rightChild = parent * 2 + 2;
			int largerChildIdx = 0;
			if (dataArray[leftChild].key > dataArray[rightChild].key) {
				largerChildIdx = leftChild;
			} else {
				largerChildIdx = rightChild;
			}

			if (data.key > dataArray[largerChildIdx].key) {
				break;
			} else {
				dataArray[parent] = dataArray[largerChildIdx];
				dataArray[largerChildIdx] = data;
				parent = largerChildIdx;
			}
		}
		dataArray[parent] = data;

	}

	public static void main(String[] args) {
		Heap heap = new Heap(10);
		heap.insert(10, "Ten");
		heap.insert(25, "Twentyfive");
		heap.insert(25, "Twentyfive");
		heap.insert(20, "Twenty");
		heap.insert(30, "Thirty");
		heap.insert(25, "Twentyfive");
		heap.insert(15,"Fifteen");
		heap.insert(5, "Five");
		heap.insert(40, "Forty");
		heap.insert(45, "Fortyfive");

		while (heap.currentSize != 0) {
			Node node = heap.remove();
			System.out.println(String.format("Key: %s, Value: %s", node.key, node.data));
		}
	}

	public static class Node {
		int key;
		String data;

		public Node(int key, String data) {
			this.key = key;
			this.data = data;
		}
	}

}
