package com.app;

import com.ds.tree.BinarySearchTree;

public class Application {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(20, "twenty");
		bst.insert(30, "thirty");
		bst.insert(17, "seventeen");
		bst.insert(40, "forty");
		bst.insert(25, "twentyfive");
		bst.insert(15, "fifteen");
		bst.insert(10, "ten");
		bst.insert(5, "five");
		bst.insert(1, "one");
		
		bst.remove(1);
		bst.inOrderTravel(bst.root);
	}
}
