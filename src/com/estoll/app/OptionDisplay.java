package com.estoll.app;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OptionDisplay extends JFrame{
	
	private JPanel oPanel;
	
	String[] boxOptions = new String[] {"Bubble Sort", "Quick Sort", "Insertion Sort", "Merge Sort"};
	
	JComboBox<String> sortTypeBox;
	
	private JTextField inputSizeField;
	private JTextField stepDelayField;
	
	private JLabel sortTypeLabel;
	private JLabel inputSizeLabel;
	private JLabel stepDelayLabel;
	
	private JButton sortButton;
	
	public OptionDisplay(ActionListener listener)
	{	
		super("Password Form");
		
		setSize(725,150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		oPanel = new JPanel();
		
		sortTypeBox = new JComboBox<>(boxOptions);
		
		inputSizeField = new JTextField(4);
		stepDelayField = new JTextField(4);
		
		sortTypeLabel = new JLabel("Sort Type");
		inputSizeLabel = new JLabel("Input Size");
		stepDelayLabel = new JLabel("Step Delay");
		
		sortButton = new JButton("Submit");
		
		oPanel.add(sortTypeLabel);
		oPanel.add(sortTypeBox);
		
		oPanel.add(inputSizeLabel);
		oPanel.add(inputSizeField);
		
		oPanel.add(stepDelayLabel);
		oPanel.add(stepDelayField);
		
		oPanel.add(sortButton);
		
		sortButton.addActionListener(listener);
		
		add(oPanel);
		
		setVisible(true);
	}
	
	public JButton getButton()
	{
		return this.sortButton;
	}
	
	public int getSorterType() {
		return this.sortTypeBox.getSelectedIndex();
	}
	
	public int getInputSize() {
		return Integer.parseInt(this.inputSizeField.getText());
	}
	
	public int getStepDelay() {
		return Integer.parseInt(this.stepDelayField.getText());
	}

}
