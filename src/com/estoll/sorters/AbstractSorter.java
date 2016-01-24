package com.estoll.sorters;

import com.estoll.app.Dataset;
import com.estoll.app.GraphDisplay;

public abstract class AbstractSorter {
	
	protected Thread thread;
	private GraphDisplay gDisp;
	
	protected Dataset dataset;
	private int stepDelay;
	
	public AbstractSorter(Dataset dataset, int stepDelay) {
		this.dataset = dataset;
		this.stepDelay = stepDelay;
		this.gDisp =  new GraphDisplay(dataset);
		
		this.thread = new Thread() {
			public void run() {
					sort();
			}
		};
		thread.start();
	}
	
	public void initGraphDisplay() {
		gDisp = new GraphDisplay(dataset);
	}
	
	public void setDataset(Dataset dataset) {
		this.dataset = dataset;
		this.initGraphDisplay();
	}
	
	public void setStepDelay(int stepDelay) {
		this.stepDelay = stepDelay;
	}
	
	public void updateGraphDisplay() {
		gDisp.setDataset(dataset);
		try {
			Thread.sleep(stepDelay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gDisp.repaint();
	}
	
	public boolean isRunning() {
		if(gDisp.isOpen())
			return true;
		else
			return false;
	}
	
	public void sort() {
		
	}

}
