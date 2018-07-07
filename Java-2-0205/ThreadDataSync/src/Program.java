import static java.lang.System.out;
import java.util.concurrent.atomic.*;

class Sync
{
	private volatile int counter = 0;

	public synchronized int getCounter() {
		return counter;
	}
	public synchronized void increment() {
		counter++;
	}
}

public class Program {
	
	//static int counter = 0;

	public static void main(String[] args) throws InterruptedException {
		//final Object sync = new Object();
		/*class Sync
		{
			volatile int counter = 0;
		}*/
		Sync sync = new Sync();
		//sync.getClass()
		
		AtomicInteger c = new AtomicInteger();
		LongAdder adder = new LongAdder();
		
		
		final Thread t0 = new Thread(() -> {
			for(int i=1; i <= 10000; i++) {
				//out.printf("%s : %d\n", Thread.currentThread().getName(), i);
				//counter++;
				/*synchronized(sync)
				{
					//counter = counter + 1;
					sync.counter++;
				}*/
				sync.increment();
				c.incrementAndGet();
				adder.add(i);
			}
		});
		
		Thread t1 = new Thread(() -> {
			for(int i=1; i <= 10000; i++) {
				//out.printf("%s : %d\n", Thread.currentThread().getName(), i);
				/*synchronized(sync)
				{
					//counter++;
					sync.counter++;
				}*/
				sync.increment();
				c.incrementAndGet();
				adder.add(i);
			}
		});
		
		t0.start();
		t1.start();
		
		t0.join();
		t1.join();
		
		//out.println(sync.counter);
		out.println(sync.getCounter());
		out.println(c.get());
		out.println(adder.sum());
	}

}
