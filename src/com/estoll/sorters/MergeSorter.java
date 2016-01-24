package com.estoll.sorters;

import java.awt.Color;
import java.util.ArrayList;

import com.estoll.app.Dataset;
import com.estoll.app.Node;

public class MergeSorter extends AbstractSorter {
	
	public MergeSorter(Dataset dataset, int stepDelay) {
		super(dataset, stepDelay);
	}
	
	@Override
	public void sort() {
		divide(0, this.dataset.getSize()-1);
	}
	
	private void divide(int startIndex, int endIndex) {
		if(startIndex<endIndex && (endIndex-startIndex) >= 1) {
			int mid = (endIndex + startIndex)/2;
			divide(startIndex, mid);
			divide(mid+1, endIndex);
		
			merger(startIndex, mid, endIndex);
		}
	}
	
	private void merger(int startIndex, int midIndex, int endIndex) {
		
		ArrayList<Integer> mergedSortedList = new ArrayList<Integer>();
		
		int leftIndex = startIndex;
		int rightIndex = midIndex+1;
		
		while(leftIndex <= midIndex && rightIndex <= endIndex) {
			if(this.dataset.getNode(leftIndex).getValue() <= this.dataset.getNode(rightIndex).getValue()) {
				mergedSortedList.add(this.dataset.getNode(leftIndex).getValue());
				leftIndex++;
			}else{
				mergedSortedList.add(this.dataset.getNode(rightIndex).getValue());
				rightIndex++;
			}
		}
		
		while(leftIndex <= midIndex) {
			mergedSortedList.add(this.dataset.getNode(leftIndex).getValue());
			leftIndex++;
		}
		
		while(rightIndex <= endIndex) {
			mergedSortedList.add(this.dataset.getNode(rightIndex).getValue());
			rightIndex++;
		}
		
		int i = 0;
		int j = startIndex;
		
		while(i<mergedSortedList.size()) {
			this.dataset.getNode(j).setValue(mergedSortedList.get(i++));
			this.dataset.getNode(j).setColor(Color.RED);
			this.updateGraphDisplay();
			this.dataset.getNode(j).setColor(Color.WHITE);
			j++;
			if(!this.isRunning())
				return;
		}
	}

}
