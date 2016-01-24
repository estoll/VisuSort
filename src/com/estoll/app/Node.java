package com.estoll.app;

import java.awt.Color;

public class Node {
	
	private int value;
	private Color color;
	
	public Node(int value) {
		this.value = value;
		this.color = Color.WHITE;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return this.color;
	}

}
