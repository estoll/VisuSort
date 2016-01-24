package com.estoll.app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.estoll.sorters.AbstractSorter;
import com.estoll.sorters.BubbleSorter;
import com.estoll.sorters.InsertionSorter;
import com.estoll.sorters.MergeSorter;
import com.estoll.sorters.QuickSorter;

public class Main implements ActionListener {
	
	private static int inputSize;
	private static int stepDelay;
	
	private AbstractSorter sorter;
	
	private static OptionDisplay disp;

	public static void main(String[] args) {
		
		Main main = new Main();

	}
	
	public Main() {
		disp = new OptionDisplay(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		inputSize = disp.getInputSize();
		stepDelay = disp.getStepDelay();
		
		Dataset dataset = new Dataset();
		dataset.populateDataset(inputSize);
		
		sorter = null;
		
		if(disp.getSorterType() == 0) {
			sorter = new BubbleSorter(dataset, stepDelay);
		}
		if(disp.getSorterType() == 1) {
			sorter = new QuickSorter(dataset, stepDelay);
		}
		if(disp.getSorterType() == 2) {
			sorter = new InsertionSorter(dataset, stepDelay);
		}
		if(disp.getSorterType() == 3) {
			sorter = new MergeSorter(dataset, stepDelay);
		}
	}
	
	public class GraphThread implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	}

}
