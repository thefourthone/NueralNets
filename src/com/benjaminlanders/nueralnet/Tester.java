package com.benjaminlanders.nueralnet;


import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JTextField;
/**
 * The tester class for the library (should NOT be in final build)
 * @author Benjamin Landers
 *
 */
public class Tester implements KeyListener 
{
	JFrame frame;
	JTextField input1, input2, output;
	int in1=0,in2=0;
	Net testnet;
	public static void main(String[] args)
	{
		new Tester().setup();
	}
	/**
	 * code used to set up the JFrame and calls setUpNuerons
	 */
	public void setup()
	{
		frame = new JFrame("net");
		input1 = new JTextField(20);
		input1.addKeyListener(this);
		frame.add(BorderLayout.NORTH,input1);
		input2 = new JTextField(20);
		input2.addKeyListener(this);
		frame.add(BorderLayout.CENTER,input2);
		output = new JTextField(20);
		output.setEditable(false);
		frame.add(BorderLayout.SOUTH,output);
		frame.setVisible(true);
		frame.setSize(100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUpNuerons();
		
	}
	/**
	 * fills nuerons in for the test using a hard coded method
	 */
	public void setUpNuerons()
	{
		testnet = new Net(5); //new net
		Nueron[] builder  = new Nueron[5]; //make new array for nuerons
		builder[0]=new InNueron(); //make nuerons
		builder[1]=new InNueron();
		builder[2]=new SumNueron(2);
		builder[3]=new SumNueron(2);
		builder[4]=new OutNueron(2);
		builder[2].setInput(0,builder[0]); //start filling inputs
		builder[2].setInput(1,builder[1]);
		builder[3].setInput(0,builder[0]);
		builder[3].setInput(1,builder[1]);
		builder[4].setInput(0,builder[2]);
		builder[4].setInput(1,builder[3]);
		builder[2].setWeight(0, .5); //set weights
		builder[2].setWeight(1, .5);
		builder[3].setWeight(0, .5);
		builder[3].setWeight(1, .5);
		builder[4].setWeight(0, .5);
		builder[4].setWeight(1, .5);
		((InNueron) builder[0]).setHelper(new Helper()
		{
			public double getIn()
			{
				// put code to get input
				return in1;
			}
			public void setOut(double out)
			{
			}
			
		});
		((InNueron) builder[1]).setHelper(new Helper()
		{
			public double getIn()
			{
				// put code to get input
				return in2;
			}
			public void setOut(double out)
			{
			}
			
		});
		((OutNueron) builder[4]).setHelper(new Helper()
		{
			public double getIn()
			{
				return 0;
			}
			public void setOut(double out)
			{
				DecimalFormat d = new DecimalFormat("0.00000000000");
				output.setText(d.format(out));
			}
			
		});
		testnet.setNuerons(builder);
		testnet.start(200);
	}
	@Override
	public void keyPressed(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	/**
	 * sets the input ints to the correct value 
	 */
	@Override
	public void keyReleased(KeyEvent e)
	{
		
		in1 = Integer.parseInt(input1.getText());
		in2 = Integer.parseInt(input2.getText());
		
	}
	@Override
	public void keyTyped(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
}
