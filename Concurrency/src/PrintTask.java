import java.security.SecureRandom;

public class PrintTask implements Runnable
{
	private static final SecureRandom generator = new SecureRandom();
	private final int sleepTime;		// random sleep time for thread.
	private final String taskName;
	
	public PrintTask(String taskName)
	{
		this.taskName = taskName;
		// pick random sleep time between 0 and 5 seconds
		sleepTime = generator.nextInt(5000);
	}
	
	public void run()
	{
		try
		{
			System.out.printf("%s going to sleep for %d milliseconds.%n", taskName, sleepTime);
			Thread.sleep(sleepTime);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		
		System.out.printf("%s done sleeping%n", taskName);
	}
}
