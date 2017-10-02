package homework3;

public class Producer extends Thread 
{
	//shared Buffer
	Buffer target;
	//output variable
	int product = 0;
	//time that Producer sleeps
	int time = 0;
	
	   // Constructor for the Thread
		public Producer(Buffer buffer, int time) 
		{
			//assign buffer for which Producer produces.
			target = buffer;
			//assign time Producer sleeps
			this.time = time;
			//set Producer's name
			setName("Producer");
		}

	   public void run() 
	   {
		   // Code for separate thread
		   
		   
		   //begin continuous loop
		   while(true)
			{
			   //(Locking)
			   //isolate variable to share with consumer
				synchronized(target)
				{
					//begin loop to check and wait if the buffer is full
					while(target.CheckFull() == true)
					{
						try
						{
							System.out.println("Producer begins waiting...");
							//wait for buffer to have space
							target.wait();
						}
						catch(InterruptedException e)
						{
						}
					}
				}
				System.out.println("Producer ends waiting...");
				
				//utilize buffer for some time
				try
				{
					System.out.println("Producer begins sleeping...");
					Thread.sleep(time);
				}
				catch(InterruptedException e)
				{
				}
				System.out.println("Producer ends sleeping...");
				
				
				//execute action (Produce)
					//since Producer has exclusive rights over buffer
					//no CheckFull is needed
				AddToBuffer();
								
				//Release the buffer
				synchronized(target)
				{
					target.notify();
				}
			}
	   }
	   
	 //Add an integer to the Buffer
		public synchronized void AddToBuffer()
		{
			int product = (int) (Math.random() * 9)+1;
			System.out.println("Produced " + product);
			target.AddTo(product);
		}
	   
	   
	   
	   
	   
}
