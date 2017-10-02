package homework3;

public class BufferTester 
{
	public static void main(String [] args)
	{
		Buffer buffer = new Buffer(5);
		
		Producer producer = new Producer(buffer, 4000);
		Consumer consumer = new Consumer(buffer, 4000);
		
		
		consumer.start();
		producer.start();
		
	}
}
