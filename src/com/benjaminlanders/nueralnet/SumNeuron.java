package com.benjaminlanders.nueralnet;

/**
 * A version of the neuron that takes a sum of the input pulses from the input neurons and normalizes the input
 * the equation for normalization is 1/(1+e^(-sum/p)) where p is a constant that determines the curviness/sharpness
 * if p is large then it will be a gradual curve.
 * @author Benjamin Landers
 *
 */
public class SumNeuron extends Neuron 
{
	/**
	 * calls super(int)
	 * @param maxin the max number of input neurons
	 */
	public SumNeuron(int maxin)
	{
		super(maxin);
	}
	/**
	 * calls super(Neuron[])
	 * @param input an array of input neurons
	 */
	public SumNeuron(Neuron[] input)
	{
		super(input);
	}
	/**
	 * calls super(neuron[],double[])
	 * @param input the input neurons 
	 * @param weights the input neurons respective weights
	 */
	public SumNeuron(Neuron[] input, double[] weights)
	{
		super(input,weights);
	}
	/**
	 * The implimitation that makes it a sum neuron. It sums then normalizes the input
	 */
	@Override
	protected double privateUpdate()
	{
		double temp = 0;
		for(int i=0;i<inputs.length;i++)
		{
			temp+=weights[i]*inputs[i].getValue();
		}
		temp = 1/(1+Math.pow(Math.E, -temp)); // to noramalize should be                ______1______
											//   p is value that determines curve               -temp/p     
												//                                        1 +  e
		
		return temp;
	}

}
