package com.estoll.app;

import java.util.ArrayList;
import java.util.Random;


public class Dataset {
	
	private final int randMin = 0;
	private final int randMax = 400;
	
	private ArrayList<Node> set;
	private int size;
	
	public Dataset() {
		this.size = 0;
		set = new ArrayList<Node>();
	}
	
	public void populateDataset(int inputSize) {
		this.size = inputSize;
		Random rand = new Random();
		
		for(int i=0; i<this.size; i++) {
			int randomNum = rand.nextInt((this.randMax - this.randMin) + 1) + this.randMin;
			Node tmpNode = new Node(randomNum);
			this.set.add(tmpNode);
		}
	}
	
	public int getSize() {
		return this.size;
	}
	
	public Node getNode(int i) {
		return this.set.get(i);
	}
	
	public void setNode(int i, Node n) {
		this.set.set(i, n);
	}
	
	public void printDataset() {
		for(int i=0; i<this.size; i++) {
			System.out.println(this.set.get(i).getValue());
		}
	}

}
