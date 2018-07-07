
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.function.DoubleFunction;

public class Integral {
	
	public final static int STEPS = 10000000;
	public static final int THREADS = 50; 
	
	static double singleThread(DoubleFunction<Double> f,
			double a, double b, int steps)
	{
		double summa = 0d;
		double w = (b-a)/steps;
		
		for(int i=0; i < steps; i++)
		{
			double x = a + i*w+w/2;
			summa += w*f.apply(x);
		}
		return summa;
	}
	
	// y = f(x)
	public static double singleThread(DoubleFunction<Double> f,
			double a, double b)
	{
		return singleThread(f, a, b, STEPS);
	}
	
	public static double multiThread(DoubleFunction<Double> f,
			double a, double b) throws InterruptedException
	{
		double h = (b-a)/THREADS;
		Thread[] threads = new Thread[THREADS];
		
		/*class Result
		{
			volatile double result = 0d;
		}
		final Result r = new Result();*/
		
		DoubleAdder r = new DoubleAdder();
		
		for(int i=0; i < THREADS; i++)
		{
			final double ax = a + h * i;
			final double bx = ax + h;
			threads[i] = new Thread()
			{
				public void run() {
					double y = singleThread(f, ax, bx, STEPS/THREADS);
					r.add(y);
					/*synchronized(r)
					{
						r.result += y;
					}*/
				}
			};
			threads[i].start();
		}
		
		for(Thread t : threads)
			t.join();
		
		//return r.result;
		return r.sum();
	}
	
	public static double multiThread2(DoubleFunction<Double> f,
			double a, double b) throws InterruptedException, ExecutionException
	{
		ExecutorService pool = Executors.newWorkStealingPool();
				//Executors
				//.newFixedThreadPool(THREADS); 
				//Executors.newWorkStealingPool(); 
				//Executors.newWorkStealingPool();    
				//Executors.newFixedThreadPool(THREADS);
				//Executors.newSingleThreadExecutor();
				//Executors.newWorkStealingPool(20); 
		
		double hx = (b-a)/THREADS;
		Future<Double>[] results = new Future[THREADS]; 
		for(int i=0; i < THREADS; i++)
		{
			final double ax = a+i*hx;
			final double bx = ax+hx;
			results[i] = 
				pool.submit(
					()->Integral.singleThread(f, ax, bx, STEPS/THREADS));
		}
		
		double r = 0d;
		for(int i=0; i < results.length; i++)
			r += results[i].get();
		
		pool.shutdown();
		
		return r;
		
		
	}
	
	public static double multiThread3(DoubleFunction<Double> f,
			double a, double b) throws InterruptedException
	{
		
		class Pair
		{
			double a;
			double b;
			public Pair(double a, double b) {
				this.a = a;
				this.b = b;
			}
		}
		
		List<Pair> ts = 
				new ArrayList<Pair>();
		
		double h = (b-a)/THREADS;
		for(int i =0; i < THREADS; i++)
			ts.add(new Pair(a + i*h, a + (i+1)*h));
		
		return ts.parallelStream().
				mapToDouble(p->singleThread(f, 
						p.a, p.b,STEPS/THREADS)).
				sum();
		
	}			

}
