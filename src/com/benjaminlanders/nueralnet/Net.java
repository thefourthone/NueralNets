package com.benjaminlanders.nueralnet;


public class Net implements Runnable
{
	private Neuron[] neurons;
	int framerate = 0;
	
	public Net(int maxsize)
	{
		setNeurons(new Neuron[maxsize]);
	}
	public Neuron[] getNuerons()
	{
		return neurons;
	}
	public void setNeurons(Neuron[] nuerons) 
	{
		this.neurons = nuerons;
	}
	public void update()
	{
		for(Neuron i: neurons)
		{
			i.update();
		}
	}
	public void start(int i) 
	{
		Thread update = new Thread(this);
		framerate=i;
		update.start();
		
	}
	@Override
	public void run()
	{
		while(true)
		{
			update();
			try
			{
				Thread.sleep(framerate);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
