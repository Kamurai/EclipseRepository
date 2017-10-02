package productconsumption;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class Producer extends Thread
{
	private boolean runIt;
	private boolean sleeping;	
	
	private int numbertogenerate;
	private int generatelowerbound;
	private int generateupperbound;
	
	private int numbertosleep;
	@SuppressWarnings("unused")
	private int sleeplowerbound;
	private int sleepupperbound;
	
	private Random generator;
	
	private ArrayList<Integer> output;
	
	private JTextPane outputfield;
	
	
	public Producer()
	{
		runIt = true;
		sleeping = false;
		
		numbertogenerate = 0;
		generateupperbound = 5000;
		
		numbertosleep = 1000;
		sleepupperbound = 5000;
		
		generator = new Random();
		output = new ArrayList<Integer>();
	}
	
	public Producer(JTextPane outputlog)
	{
		runIt = true;
		sleeping = false;
		
		numbertogenerate = 0;
		generateupperbound = 5000;
		
		numbertosleep = 1000;
		sleepupperbound = 5000;
		
		generator = new Random();
		output = new ArrayList<Integer>();
		
		outputfield = outputlog;
	}
		
	public void run()
	{
		while(true)
		{
			while((runIt) && (!sleeping))
			{
				try
				{
					numbertogenerate = generator.nextInt(generateupperbound);
					//generate x numbers, randomly, from lower to upper bound
					for(int x = 0; x < numbertogenerate; x++)
					{
						output.add(generator.nextInt(100));
						outputfield.setText("output");
					}
					
					//sleep for y cycles
					sleeping = true;
					numbertosleep = generator.nextInt(sleepupperbound);
				}
				catch(NullPointerException ex)
				{
					
				}
			}
			
			while((runIt) && sleeping)
			{
				//sleep for y cycles
				numbertosleep--;
				
				if(numbertosleep == 0)
				{
					sleeping = false;
				}
			}
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
	
	public boolean getRun()
	{
		return runIt;
	}
	
	public ArrayList<Integer> getOutput()
	{
		
		return output;
	}
}
