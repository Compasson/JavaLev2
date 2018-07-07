import java.util.concurrent.ExecutionException;

public class Program {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Integral.singleThread(Math::sin, 0, Math.PI/2);
		Integral.singleThread(Math::sin, 0, Math.PI/2);
		Integral.singleThread(Math::sin, 0, Math.PI/2);
		Integral.multiThread3( Math::sin , 0, Math.PI/2);
		Integral.multiThread3( Math::sin , 0, Math.PI/2);
		Integral.multiThread3( Math::sin , 0, Math.PI/2);
		
		
		long t1 = System.currentTimeMillis();
		double r1 = Integral.singleThread(Math::sin, 0, Math.PI/2);
		long t2 = System.currentTimeMillis();
		System.out.printf("Integral single thread: %f time: %d\n", r1, t2-t1);

		long t3 = System.currentTimeMillis();
		double r2 = Integral.multiThread3( Math::sin , 0, Math.PI/2);
		long t4 = System.currentTimeMillis();
		System.out.printf("multiThread sin : %f time: %d\n", r2, t4-t3);
	}	

}