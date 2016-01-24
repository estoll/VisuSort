package com.estoll.sorters;

import java.awt.Color;

import com.estoll.app.Dataset;
import com.estoll.app.Node;


public class BubbleSorter extends AbstractSorter {
	
	public BubbleSorter(Dataset dataset, int stepDelay) {
		super(dataset, stepDelay);
	}

	@Override
	public void sort() {
		
		for(int i=dataset.getSize()-1; i>=0; i--) {
			for(int j=0; j<i; j++) {
				dataset.getNode(j).setColor(Color.RED);
				dataset.getNode(j+1).setColor(Color.RED);
				if(dataset.getNode(j).getValue() > dataset.getNode(j+1).getValue()) {
					Node temp = new Node(dataset.getNode(j).getValue());
					dataset.getNode(j).setValue(dataset.getNode(j+1).getValue());
					dataset.getNode(j+1).setValue(temp.getValue());
					this.updateGraphDisplay();
					if(!this.isRunning())
						return;
				}
				dataset.getNode(j).setColor(Color.WHITE);
				dataset.getNode(j+1).setColor(Color.WHITE);
			}
		}
	}

}
