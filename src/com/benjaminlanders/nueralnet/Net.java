package com.benjaminlanders.nueralnet;


public class Net implements Runnable
{
	private Nueron[] nuerons;
	int framerate = 0;
	
	public Net(int maxsize)
	{
		setNuerons(new Nueron[maxsize]);
	}
	public Nueron[] getNuerons()
	{
		return nuerons;
	}
	public void setNuerons(Nueron[] nuerons) 
	{
		this.nuerons = nuerons;
	}
	public void update()
	{
		for(Nueron i: nuerons)
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
