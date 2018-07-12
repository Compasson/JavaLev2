import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Program {
	


	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Thread t0 = new Thread(()->{
			System.out.printf("Name : %s\n",Thread.currentThread().getName());
		});
		
		t0.start();
		
		t0.join();
		
		Thread.sleep(3000);
		
		System.out.printf("Main thread : %s\n",Thread.currentThread().getName());
		
		
		ExecutorService pool = Executors.newCachedThreadPool();
		
		double summ=0;
		
		Future[] task = new Future[20];
		for(int i=0;i<10;i++)
		{
			task[i]=pool.submit(new ThreadInputNumbers());
		}
		for(int i=10;i<20;i++)
		{
			task[i]=pool.submit(new ThreadInputNumbers());
		}
		

	}

}
