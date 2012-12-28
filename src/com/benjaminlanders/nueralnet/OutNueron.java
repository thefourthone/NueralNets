package com.benjaminlanders.nueralnet;

/**
 * A nueron that allows the net to output. It outputs the sum of its nuerons
 * @author Benjamin Landers 
 *
 */
public class OutNueron extends Nueron 
{
	private Helper hand;
	/**
	 * calls super(int)
	 * @param maxin the max number of input nuerons
	 */
	public OutNueron(int maxin)
	{
		super(maxin);
	}
	/**
	 * calls super(Nueron[])
	 * @param input the input array of nuerons
	 */
	public OutNueron(Nueron[] input)
	{
		super(input);
	}
	/**
	 * calls super(Nueron[],double[])
	 * @param input the input array of nuerons
	 * @param weights the respective array of weigths
	 */
	public OutNueron(Nueron[] input, double[] weights)
	{
		super(input,weights);
	}
	/**
	 * calls hand.setOut(int) with the sum of its inputs (not normalized)
	 */
	@Override
	protected double privateupdate() 
	{
		double temp = 0;
		for(int i=0;i<inputs.length;i++)
		{
			temp+=weights[i]*inputs[i].getValue();
		}
		hand.setOut(temp);
		return 0;
	}
	/**
	 * a setter for the helper 
	 * @param help the helper object reference
	 */
	public void setHelper(Helper help)
	{
		this.hand=help;
	}

}
