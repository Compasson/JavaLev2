import static java.lang.System.out;

class Sync
{
	private volatile int counter=0;
	
	// Что бы весь класс Sync был потокобезопасным, то надо чтобы все его методы sinchronized
	public synchronized int getCounter() {
		return counter;
	}
	public synchronized void increment() {
		counter++;
	}
}

public class Program {

	static int counter = 0;
	
	public static void main(String[] args) throws InterruptedException {
		
		 //final Object sync = new Object();	
		/*class Sync
		{
			int counter=0;
		}*/
		Sync sync=new Sync();
		//sync.getClass() для статических синхронных методов
		
		
		 final Thread t0 = new Thread(() -> {
			for(int i=1; i<=10000;i++) {
					//out.printf("%s : %d\n",Thread.currentThread().getName(), i);
					/*synchronized(sync) {
						//counter++;
						sync.counter++;
					}*/
					sync.increment();
			}
		 });
		 
		 Thread t1 = new Thread(() -> {
			for(int i=1; i<=10000;i++) {
					//out.printf("%s : %d\n",Thread.currentThread().getName(), i);
					/*synchronized(sync) {
						//counter++;
						sync.counter++;
					}*/
					sync.increment();
			}
		 });
		 
		 t0.start();
		 t1.start();
		 
		 t0.join();
		 t1.join();
		 
		 //out.println(sync.counter);
		 out.println(sync.getCounter());
	}

}
