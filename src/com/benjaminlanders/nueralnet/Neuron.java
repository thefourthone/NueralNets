package com.benjaminlanders.nueralnet;

/**
 * the abstract class that is the base for all types of neurons
 * @author Benjamin Landers
 */
public abstract class Neuron
{
	private double value=0;
	protected double[] weights;
	protected Neuron[] inputs;
	public static final int SUM = 0, IN = 1, OUT = 2;
	
	public Neuron(int maxin)
	{
		inputs = new Neuron[maxin];
		weights = new double[maxin];
	}
	public Neuron(Neuron[] input)
	{
		inputs = input;
		weights = new double[input.length];
	}
	public Neuron(Neuron[] input, double[] weights)
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

	public Neuron[] getInputs()
	{
		return inputs;
	}

	public void setInputs(Neuron[] inputs)
	{
		this.inputs = inputs;
	}
	public void setInput(int index, Neuron value)
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
	public static Neuron getNueron(int type, int maxin)
	{
		switch(type)
		{
		case SUM:
			return new SumNeuron(maxin);
		case IN:
			return new InNeuron();
		case OUT:
			return new OutNeuron(maxin);
		default:
			return null;
		}
	}
}
