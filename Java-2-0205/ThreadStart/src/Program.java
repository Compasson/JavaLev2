
import static java.lang.System.out;

class MyThread extends Thread {
	@Override
	public void run() {
		for(int i=1; i <= 100; i++) {
			if (Thread.interrupted()) {
				out.printf("%s : normal shutdown\n", getName());
				return;
			}
			out.printf("%s : %d\n", getName(), i);
		}
	}
}

class MySuperThread implements Runnable {
	
	private int a,b;
	
	public MySuperThread(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public void run() {
		for(int i=a; i <= b; i++)
			out.printf("%s : %d\n", Thread.currentThread().getName(), i);
	}
}


public class Program {

	public static void main(String[] args) {
		Thread t0 = new MyThread();
		//t0.setPriority(Thread.MAX_PRIORITY);
		
		Thread t1 = new MyThread();
		Thread t2 = new Thread( new MySuperThread(1, 50) );
		
		Thread t3 = new Thread(
			new Runnable() {
				public void run() {
					for(int i=1; i <= 100; i++)
						out.printf("%s : %d\n", Thread.currentThread().getName(), i);
				}
			}
		);
		/*Thread t4 = new Thread(() -> {
			for(int i=1; i <= 100; i++)
				out.printf("%s : %d\n", Thread.currentThread().getName(), i);
		});*/
		
		final int a = 51;
		final int b = 100;
		
		/*(new Thread(() -> {
			for(int i=a; i <= b; i++)
				out.printf("%s : %d\n", Thread.currentThread().getName(), i);
		})).start();
		
		
		
		(new Thread() {
			public void run() {
				for(int i=1; i <= 100; i++)
					out.printf("%s : %d\n", Thread.currentThread().getName(), i);
			}
		}).start();*/
		
		//t0.setDaemon(true);
		t1.setDaemon(true);
		t2.setDaemon(true);
		t3.setDaemon(true);
		
		t0.start();
		t1.start();
		t2.start();
		t3.start();
		//t4.start();
		
		out.printf("T0 is Alive: %s\n", t0.isAlive());
		t0.interrupt();
		out.printf("T1 State: %s\n", t1.getState());
		out.println(Thread.currentThread().getName());
		

	}

}
