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
	/**
	 * makes two new arrays, one for neurons another for weights
	 * @param maxin the max input neurons 
	 */
	public Neuron(int maxin)
	{
		inputs = new Neuron[maxin];
		weights = new double[maxin];
	}
	/**
	 * sets the input neuron array and makes a new double array for weights
	 * @param input the input neuron array
	 */
	public Neuron(Neuron[] input)
	{
		inputs = input;
		weights = new double[input.length];
	}
	/**
	 * sets the two inputs to their respective references
	 * @param input the input neuron array
	 */
	public Neuron(Neuron[] input, double[] weights)
	{
		inputs = input;
		this.weights = weights;
	}
	/**
	 * calls the privateUpdate() in descendants and assigns its return to value
	 */
	public void update()
	{
		value = privateUpdate();
	}
	/**
	 * for implementation in descendants
	 * @return the output value from the neuron
	 */
	protected abstract double privateUpdate();
	/**
	 * gets the value of the neuron
	 * @return the last output from private update
	 */
	public double getValue() 
	{
		return value;
	}
	/**
	 * gets the input neurons
	 * @return the input[]
	 */
	public Neuron[] getInputs()
	{
		return inputs;
	}
	/**
	 * sets the inputs
	 * @param inputs the new input neurons
	 */
	public void setInputs(Neuron[] inputs)
	{
		this.inputs = inputs;
	}
	/**
	 * sets a array value to a neuron
	 * @param index the input number
	 * @param value the neuron that will be an input
	 */
	public void setInput(int index, Neuron value)
	{
		this.inputs[index] = value;
	}
	/**
	 * sets weights
	 * @param weights an array of weights
	 */
	public void setWeights(double[] weights)
	{
		this.weights = weights;
	}
	/**
	 * sets a specific value in the weight array
	 * @param index index for the array
	 * @param value the value to be set to
	 */
	public void setWeight(int index, double value)
	{
		this.weights[index] = value;
	}
	/**
	 * 
	 * @param type the type of Neuron ex/ SUM
	 * @param maxin the max input number
	 * @return the new Neuron
	 */
	public static Neuron getNeuron(int type, int maxin)
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

