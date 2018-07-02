import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Program {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		
		ExecutorService pool=Executors.newCachedThreadPool();
		
			//Executors.newCachedThreadPool();
			//Executors.newSingleThreadExecutor(); - ����� ���������� 7.5 ���. ���������������� ����������
			//Executors.newWorkStealingPool(Runtime.getRuntime().availableProcessors());
			
			//.newCashedThreadPool();
			//.newFixedThreadPool(5); -����� ���������� 3.1 ���
			//.newSingleThreadExecutor()
			
		long t1=System.currentTimeMillis();
		
		Future[] tasks=new Future[10];
		for(int i=0;i<10;i++)
			tasks[i]=pool.submit(new MyCallTask()); //submit ���������� ������� future
		
		//Thread.sleep(3000);
		//pool.shutdown();
		//System.out.println(pool.isShutdown());
		//System.out.println(pool.isTerminated());
		pool.shutdownNow();
		//Thread.sleep(10);
		System.out.println(tasks[0].cancel(false)); // �������� ������
		
		//Future<Long> t11=pool.submit(new MyCallTask());
		//Future<Long> t12=pool.submit(new MyCallTask());
		
		for(Future<?> t : tasks)
		{
			if(t.isCancelled())
				System.out.println("canceled");
			else
				System.out.println(t.get()); //get ���������� ���������� �����
		}
		
		//System.out.println(t11.get());
		//System.out.println(t12.get());
		
		long t2 = System.currentTimeMillis();
		System.out.printf("Time (ms): %d\n",t2-t1);
		
		//pool.shutdown();
	}

}
