import static java.lang.System.out;

public class Program {
	
	
	//  double x = 1;
	//  boolean isSin = true

	public static void main(String[] args) throws InterruptedException {
		//final Object sync = new Object();
		class Sync
		{
			int counter = 0;
		}
		
		final Sync sync = new Sync();
		
		
		final Thread t0 = new Thread(() -> {
			for(int i=1; i <= 100; i++) {
				out.printf("%s : %d\n", Thread.currentThread().getName(), i);
				//if (i == 50) {
					synchronized(sync) {
						sync.counter = i;
						sync.notifyAll();
					}
				//}
			}
		});
		final Thread t1 = new Thread(() -> {
			
			synchronized(sync) {
				try {
					while(sync.counter < 50) {
						sync.wait(1);
						out.printf("t1 still waiting. counter: %d\n", sync.counter);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			
			for(int i=1; i <= 100; i++)
				out.printf("%s : %d\n", Thread.currentThread().getName(), i);
		});
		final Thread t2 = new Thread(() -> {
			
			synchronized(sync) {
				try {
					while(sync.counter < 80) {
						sync.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			
			for(int i=1; i <= 100; i++)
				out.printf("%s : %d\n", Thread.currentThread().getName(), i);
		});
		
		t0.start();
		//t0.join();
		//Thread.sleep(1000);
		t1.start();
		t2.start();
		

	}

}
