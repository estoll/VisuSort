package com.estoll.sorters;

import java.awt.Color;

import com.estoll.app.Dataset;
import com.estoll.app.Node;

public class QuickSorter extends AbstractSorter {
	
	private int low;
	private int high;

	public QuickSorter(Dataset dataset, int stepDelay) {
		super(dataset, stepDelay);
		this.low = 0;
		this.high = dataset.getSize() - 1; 
	}
	
	@Override
	public void sort() {
		this.quicksort(dataset, this.low, this.high);
	}
	
	public void quicksort(Dataset dataset, int low, int high) {
		
		if(dataset == null || dataset.getSize() == 0)
			return;
		
		if(low >= high)
			return;
		
		int middle = low + (high - low) / 2;
		int pivot = this.dataset.getNode(middle).getValue();
		
		int i = low, j = high;
		while(i <= j) {
			while(this.dataset.getNode(i).getValue() < pivot) {
				i++;
			}
			
			while(this.dataset.getNode(j).getValue() > pivot) {
				j--;
			}
			
			if(i <= j) {
				int temp = this.dataset.getNode(i).getValue();
				this.dataset.getNode(i).setValue(this.dataset.getNode(j).getValue());
				this.dataset.getNode(j).setValue(temp);
				this.dataset.getNode(i).setColor(Color.RED);
				this.dataset.getNode(j).setColor(Color.RED);
				this.updateGraphDisplay();
				this.dataset.getNode(i).setColor(Color.WHITE);
				this.dataset.getNode(j).setColor(Color.WHITE);
				i++;
				j--;
				if(!this.isRunning())
					return;
			}
			
			if(low < j)
				quicksort(this.dataset, low, j);
			
			if(high > i)
				quicksort(this.dataset, i, high);
			
		}
	}
	

}
