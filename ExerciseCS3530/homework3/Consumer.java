package homework3;

public class Consumer extends Thread 
{
	//shared Buffer
	Buffer target;
	//output variable
	int consumable = 0;
	//time Consumer sleeps
	int time = 0;
	
	   // Constructor for the Thread
		public Consumer(Buffer buffer, int time) 
		{
			//assign buffer for which Producer produces.
			target = buffer;
			//assign sleep time for Consumer
			this.time = time;
			//set name of Consumer
			setName("Consumer");
		}

	   public void run() 
	   {
		   // Code for separate thread
		   
		   
		 //begin continuous loop
		   while(true)
			{
			   //(Locking)
			   //isolate variable to share with producer
				synchronized(target)
				{
					//Begin loop to check and wait if the buffer is empty
					while(target.CheckEmpty() == true)
					{
						try
						{
							System.out.println("Consumer begins waiting...");
							//wait for buffer to have content
							target.wait();
						}
						catch(InterruptedException e)
						{
						}
					}
				}
				System.out.println("Consumer ends waiting...");
				
				//utilize buffer for some time
				try
				{
					System.out.println("Consumer begins sleeping...");
					Thread.sleep(time);
				}
				catch(InterruptedException e)
				{
				}
				System.out.println("Consumer ends sleeping...");
				
				//execute action (Consume)
					//since Consumer has exclusive rights over buffer
					//no CheckEmpty is needed
				RemoveFromBuffer();
				
				//Release the common data
				synchronized(target)
				{
					target.notify();
				}
			}
	   }
	   
	 //Remove an integer from the Buffer
		public synchronized void RemoveFromBuffer()
		{
			
			int consumable = target.GetLast();
			System.out.println("Consumed " + consumable);
			target.RemoveFrom(consumable);
		}
}
