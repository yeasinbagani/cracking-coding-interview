package com.ds.graph;

import java.util.LinkedList;

public class Graph {
	int maxSize;
	int currentSize;	
	Vertex[] vertices;
	
	public Graph(int maxSize) {
		this.maxSize = maxSize;
		this.currentSize = 0;
		this.vertices = new Vertex[maxSize];
	}
	
	public boolean addVertex(String data) {
		if (maxSize == currentSize) {
			return false;
		}
		
		return true;		
	}
	

	public static class Vertex {
		String data;
		LinkedList<Integer> edgeList;

		public Vertex(String data) {
			this.data = data;
			this.edgeList = new LinkedList<>();
		}
	}
}
