package com.ds.tree;

public class Node {
	public int key;
	public String data;
	public Node leftChild;
	public Node rightChild;

	public Node(int key, String data) {
		this.key = key;
		this.data = data;
	}
	
	public String toString() {
		return String.format("[#%s -> %s]", key, data);
	}
}
