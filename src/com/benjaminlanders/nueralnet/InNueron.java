package com.benjaminlanders.nueralnet;


public class InNueron extends Nueron
{
	Helper hand;
	public InNueron()
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
