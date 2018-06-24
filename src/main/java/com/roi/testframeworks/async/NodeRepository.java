package com.roi.testframeworks.async;

import java.util.HashSet;
import java.util.Set;

public class NodeRepository {
	Set<Node> nodes = new HashSet<>();

	public void addNode(Node node){
		nodes.add(node);
	}
	
	public int size(){
		return nodes.size();
	}
}

