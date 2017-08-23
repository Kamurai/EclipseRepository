package productconsumption;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class Consumer extends Thread
{
	private boolean runIt = true;
	private boolean sleeping = false;
	private int mode = 1;
	
	private int numbertoread = 0;
	private int numberupperbound = 100;
	
	private int numbertosleep = 0;
	private int sleepupperbound = 3000;
	
	private Random generator = new Random();
	
	private Producer Charizard;
	private ArrayList<Integer> datalist = new ArrayList<Integer>();;
	private int tracker = 0;
	
	private int movingaverage = 0;
	private int movingrange = 1;
	private int watching = 0;
	
	private FileManager Totodile = new FileManager("ProductConsumption.log");
	private FileManager Torchik = new FileManager("ProductConsumption.cfg");
	
	JTextPane outputfield = new JTextPane();
	
	public Consumer(Producer datafeed, int mode)
	{
		CheckMode(mode);
		
		Charizard = datafeed;
		
		if(this.mode == 1)
		{
			movingrange = Integer.parseInt(Torchik.GetLineFromFile(0));
		}
	}
	public Consumer(Producer datafeed, int mode, JTextPane output)
	{
		CheckMode(mode);
		
		Charizard = datafeed;
		
		if(this.mode == 1)
		{
			movingrange = Integer.parseInt(Torchik.GetLineFromFile(0));
		}
		
		outputfield = output;
	}
	
	
	
	
	public Consumer(Producer datafeed, int mode, int action)
	{
		CheckMode(mode);
		
		Charizard = datafeed;
		
		if(this.mode == 2)
		{
			numbertosleep = action*1000;
		}
		else if(this.mode == 1)
		{
			movingrange = Integer.parseInt(Torchik.GetLineFromFile(0));
		}
		
	}
		
	public void run()
	{
		while(true)
		{
			while((runIt) && (!sleeping) && tracker < Charizard.getOutput().size()-1)
			{
				try
				{
					if(mode == 1)
					{
						Mode1();
					}
					else if(mode == 2)
					{
						Mode2();
					}
					else if(mode == 3)
					{
						Mode3();
					}
					
					//sleep for y cycles
					sleeping = true;
				}
				catch(NullPointerException ex)
				{
					
				}
			}
			
			while((runIt) && sleeping)
			{
				//sleep for y cycles
				for(int x = 0; x < numbertosleep;x++)
				{
					sleeping = false;
				}
				
				
			}
		}
	}
	
	private void CheckMode(int mode)
	{
		if(mode == 1 || mode == 2 || mode ==3)
		{
			this.mode = mode;
		}
		else
		{
			this.mode = 1;
		}
	}
	
	public void startIt()
	{
		runIt = true;
	}
	
	public void stopIt()
	{
		runIt = false;
	}
		
	public void setRun(boolean input)
	{
		runIt = input;
	}
	
	public int getWatching()
	{
		return watching;
	}
	
	private void Mode1()
	{
		while(tracker < Charizard.getOutput().size()-1)
		{
			watching = Charizard.getOutput().get(tracker);
			
			datalist.add(watching);
			while(datalist.size() > 5)
			{
				datalist.remove(0);
			}
			
			for(int x = 0; x < movingrange; x++)
			{
				movingaverage += datalist.get(x);
			}
			
			movingaverage = movingaverage / movingrange;
			
			tracker++;
		}
	}
	
	private void Mode2()
	{
		numbertoread = generator.nextInt(numberupperbound);
		//generate x numbers, randomly, from lower to upper bound
		for(int x = 0; x < numbertoread; x++)
		{
			watching = Charizard.getOutput().get(tracker);
			tracker++;
		}
		sleeping = true;
	}
	
	private void Mode3()
	{
		while(tracker < Charizard.getOutput().size()-1)
		{
			watching = Charizard.getOutput().get(tracker);
			
			Totodile.SaveToFile(Integer.toString(watching));
			
			tracker++;
		}
	}
	
	public void setSleepDuration(int input)
	{
		if(!runIt)
		{
			numbertosleep = input / 1000;
		}
	}
	
	public void setMovingAverageRange(int input)
	{
		if(!runIt)
		{
			movingrange = input;
			Torchik.SaveToFile(Integer.toString(movingrange));
		}
	}
	
	public boolean getRun()
	{
		return runIt;
	}
}
