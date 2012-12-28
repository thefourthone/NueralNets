package com.benjaminlanders.nueralnet;

/**
 * A version of the nueron that takes a sum of the input pulses from the input nuerons and normalizes the input
 * the equation for normalization is 1/(1+e^(-sum/p)) where p is a constant that determines the curvyness/sharpness
 * if p is large then it will be a gradual curve.
 * @author Benjamin Landers
 *
 */
public class SumNueron extends Nueron 
{
	/**
	 * calls super(int)
	 * @param maxin the max number of input nuerons
	 */
	public SumNueron(int maxin)
	{
		super(maxin);
	}
	/**
	 * calls super(Nueron[])
	 * @param input an array of input nuerons
	 */
	public SumNueron(Nueron[] input)
	{
		super(input);
	}
	/**
	 * calls super(nueron[],double[])
	 * @param input the input nuerons 
	 * @param weights the input nuerons respective weights
	 */
	public SumNueron(Nueron[] input, double[] weights)
	{
		super(input,weights);
	}
	/**
	 * The implimitation that makes it a sum nueron. It sums then normalizes the input
	 */
	@Override
	protected double privateupdate()
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
