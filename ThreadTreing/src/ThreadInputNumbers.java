import java.util.concurrent.Callable;

public class ThreadInputNumbers implements Callable<Double> {

	@Override
	public Double call() throws Exception {
		
		double summ=0;
		int n=0;
		
		for(int i =1;i<=100;i++) {
			n+=i;
			System.out.printf("Summ = %d %s\n",n, Thread.currentThread().getName());
			
		}

		System.out.printf("Summ = %d %s\n",n, Thread.currentThread().getName());
		
		return summ;
	}

}
