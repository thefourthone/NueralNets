package com.benjaminlanders.nueralnet;

/**
 * A neuron that allows the net to output. It outputs the sum of its neurons
 * @author Benjamin Landers 
 *
 */
public class OutNeuron extends Neuron 
{
	private Helper hand;
	/**
	 * calls super(int)
	 * @param maxin the max number of input neurons
	 */
	public OutNeuron(int maxin)
	{
		super(maxin);
	}
	/**
	 * calls super(Neuron[])
	 * @param input the input array of neurons
	 */
	public OutNeuron(Neuron[] input)
	{
		super(input);
	}
	/**
	 * calls super(Neuron[],double[])
	 * @param input the input array of neurons
	 * @param weights the respective array of weights
	 */
	public OutNeuron(Neuron[] input, double[] weights)
	{
		super(input,weights);
	}
	/**
	 * calls hand.setOut(int) with the sum of its inputs (not normalized)
	 */
	@Override
	protected double privateUpdate() 
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
