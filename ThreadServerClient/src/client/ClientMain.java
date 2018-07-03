package client;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ClientMain {
	
	public static final int CONNECTIONS = 100;

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService pool = Executors.newFixedThreadPool(100);
		
		Future[] tasks = new Future[CONNECTIONS];
		for(int i=0;i<CONNECTIONS;i++)
			tasks[i]=pool.submit(new TaskClient());
		
		
		pool.shutdown();
		
		Thread.sleep(5000);

	}

}
