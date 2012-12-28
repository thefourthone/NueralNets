package com.benjaminlanders.nueralnet;

/**
 * the abstract class that is the base for all types of nuerons
 * @author Benjamin Landers
 */
public abstract class Nueron
{
	private double value=0;
	protected double[] weights;
	protected Nueron[] inputs;
	public static final int SUM = 0, IN = 1, OUT = 2;
	
	public Nueron(int maxin)
	{
		inputs = new Nueron[maxin];
		weights = new double[maxin];
	}
	public Nueron(Nueron[] input)
	{
		inputs = input;
		weights = new double[input.length];
	}
	public Nueron(Nueron[] input, double[] weights)
	{
		inputs = input;
		this.weights = weights;
	}
	public void update()
	{
		value = privateupdate();
	}
	protected abstract double privateupdate();
	public double getValue() 
	{
		return value;
	}

	public Nueron[] getInputs()
	{
		return inputs;
	}

	public void setInputs(Nueron[] inputs)
	{
		this.inputs = inputs;
	}
	public void setInput(int index, Nueron value)
	{
		this.inputs[index] = value;
	}
	public void setWeights(double[] weights)
	{
		this.weights = weights;
	}
	public void setWeight(int index, double value)
	{
		this.weights[index] = value;
	}
	public static Nueron getNueron(int type, int maxin)
	{
		switch(type)
		{
		case SUM:
			return new SumNueron(maxin);
		case IN:
			return new InNueron();
		case OUT:
			return new OutNueron(maxin);
		default:
			return null;
		}
	}
}
