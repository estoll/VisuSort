package com.estoll.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphDisplay extends JFrame implements WindowListener {
	
	private boolean isOpen;
	
	private final int screenWidth = 1280;
	private final int screenHeight = 720;
	
	private JPanel gPanel;
	
	private Dataset dataset;
	private int barWidth;
	
	public GraphDisplay(Dataset dataset) {
		super("Graph");
		
		this.addWindowListener(this);
		
		this.dataset = dataset;
		this.barWidth = 1;
		
		this.barWidth = (screenWidth-this.dataset.getSize())/this.dataset.getSize();
		if(this.barWidth < 1) {
			this.barWidth = 1;
		}
		
		setSize(screenWidth,screenHeight);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		gPanel = new JPanel();
		add(gPanel);
		
		add(new DrawGraph());
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		
		this.isOpen = true;
	}
	
	public void setDataset(Dataset dataset) {
		this.dataset = dataset;
	}
	
	public boolean isOpen() {
		return this.isOpen;
	}
	
	private class DrawGraph extends JComponent {
		public void paint(Graphics g) {
			Graphics2D g2 = (Graphics2D)g;
			
			g2.setColor(Color.BLACK);
			g2.fillRect(0, 0, getWidth(), getHeight());
			
			for(int i=0; i<dataset.getSize(); i++) {
				g2.setPaint(dataset.getNode(i).getColor());
				g2.fillRect(i*barWidth, getHeight() - dataset.getNode(i).getValue(), barWidth, dataset.getNode(i).getValue());
			}
		}
	}
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		this.isOpen = false;
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
