package com.estoll.sorters;

import java.awt.Color;

import com.estoll.app.Dataset;

public class InsertionSorter extends AbstractSorter {

	public InsertionSorter(Dataset dataset, int stepDelay) {
		super(dataset, stepDelay);
	}
	
	@Override
	public void sort() {
		for(int i=1; i<this.dataset.getSize(); i++) {
			int temp = this.dataset.getNode(i).getValue();
			int j;
			for(j=i-1; j>=0 && temp<this.dataset.getNode(j).getValue(); j--) {
				this.dataset.getNode(j+1).setValue(this.dataset.getNode(j).getValue());
				this.dataset.getNode(j+1).setColor(Color.RED);
				this.updateGraphDisplay();
				this.dataset.getNode(j+1).setColor(Color.WHITE);
			}
			this.dataset.getNode(j+1).setValue(temp);
			this.dataset.getNode(j+1).setColor(Color.RED);
			this.updateGraphDisplay();
			this.dataset.getNode(j+1).setColor(Color.WHITE);
			if(!this.isRunning())
				return;
		}
	}
	

}
