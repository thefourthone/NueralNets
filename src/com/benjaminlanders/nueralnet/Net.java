package com.benjaminlanders.nueralnet;

/**
 * A network of neurons and a centralized control system
 * @author Benjamin Landers
 *
 */
public class Net implements Runnable
{
	private Neuron[] neurons;
	int updateRate = 0;
	/**
	 * makes a new net of a certain size
	 * @param maxsize the max number of neurons in the net
	 */
	public Net(int maxsize)
	{
		setNeurons(new Neuron[maxsize]);
	}
	/**
	 * gets the neurons
	 * @return the neurons
	 */
	public Neuron[] getNeurons()
	{
		return neurons;
	}
	/**
	 * sets the neuron[]
	 * @param neurons the neurons that will be set
	 */
	public void setNeurons(Neuron[] neurons) 
	{
		this.neurons = neurons;
	}
	/**
	 * updates all of the neurons 
	 */
	public void update()
	{
		for(Neuron i: neurons)
		{
			i.update();
		}
	}
	/**
	 * begins the run method in a new thread
	 * @param i sets update rate
	 */
	public void start(int i) 
	{
		Thread update = new Thread(this);
		updateRate=i;
		update.start();
		
	}
	/**
	 * updates the neurons until it is stopped 
	 */
	@Override
	public void run()
	{
		while(true)
		{
			update();
			try
			{
				Thread.sleep(updateRate);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
