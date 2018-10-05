package com.chapter4;

import com.ds.tree.Node;

public class DataNode {

	int depth;
	Node node;

	public DataNode(int depth, Node node) {
		this.depth = depth;
		this.node = node;
	}

	public String toString() {
		return String.format("%s => %s", node, depth);
	}

}
