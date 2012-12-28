package com.benjaminlanders.nueralnet;


public class InNeuron extends Neuron
{
	Helper hand;
	public InNeuron()
	{
		super(0);
	}

	public void setHelper(Helper helper)
	{
		this.hand=helper;
	}
	protected double privateupdate()
	{
		return  hand.getIn();
	}

}
