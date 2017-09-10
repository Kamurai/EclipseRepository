package homework3;



public class Buffer
{
	// Shared data
	int size;		
	int buffer [];
	//the index of the last element + 1
	int tracker = 0;
	
	// Constructor for the Thread
	public Buffer(int size) 
	{
		buffer = new int[size];
	}

	//Check to see the size of the Buffer
	public synchronized int CheckSize()
	{
		return tracker;
	}
	
	//Check to see if Buffer is empty
	public synchronized boolean CheckEmpty()
	{
		if(tracker == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	//Check to see if Buffer is Full
	public synchronized boolean CheckFull()
	{
		if(tracker == buffer.length)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	//Add an integer to the Buffer
	public synchronized void AddTo(int time)
	{
		
		int product = (int) (Math.random() * 9)+1;
		System.out.println("Produced " + product);
		buffer[tracker] = product;
		tracker++;
		//prevent out of bounds exception
		if(tracker > buffer.length)
		{
			//tracker - 1 = last element of buffer at this point
			tracker = buffer.length;
		}
		PrintBuffer('P');
	}
	
	//Remove an integer from the Buffer
	public synchronized void RemoveFrom(int time)
	{
		
		int consumable = GetLast();
		System.out.println("Consumed " + consumable);
		buffer[tracker-1] = 0;
		tracker--;
		//prevent out of bounds exception
		if(tracker-1 < 0)
		{
			//tracker = first element of buffer at this point
			tracker = 0;
		}
		PrintBuffer('C');
	}
	
	//Get element at tracker-1
	public synchronized int GetLast()
	{
		return buffer[tracker-1];
	}

	public synchronized void PrintBuffer(char t)
	{
		for(int x = 0; x < buffer.length; x++)
		{
			System.out.println( t + "" + (x+1) + ": " + buffer[x]);
		}
	}
	
	
}
