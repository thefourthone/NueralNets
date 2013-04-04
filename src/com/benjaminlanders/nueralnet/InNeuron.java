package com.benjaminlanders.nueralnet;

/**
 * A neuron that takes input from the outside world
 * @author Benjamin Landers
 *
 */
public class InNeuron extends Neuron
{
	Helper hand;
	/**
	 * a blank constructor that calls super(0)
	 */
	public InNeuron()
	{
		super(0);		
	}
	/**
	 * calls super(0) 
	 * @param hand the helper object for the class
	 */
	public InNeuron(Helper hand)
	{
		super(0);
		this.hand = hand;
	}
	/**
	 * sets helper
	 * @param helper the helper being set
	 */
	public void setHelper(Helper helper)
	{
		this.hand=helper;
	}
	/**
	 * takes input from the helper 
	 */
	protected double privateUpdate()
	{
		return  hand.getIn();
	}

}
