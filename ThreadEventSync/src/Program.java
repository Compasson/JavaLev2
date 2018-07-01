import static java.lang.System.out;

public class Program {

	public static void main(String[] args) {
		
		//final Object sync = new Object();
		class Sync{
			int counter=0;
		}
		Sync sync = new Sync();
		
		 final Thread t0 = new Thread(() -> {
			for(int i=1; i<=100;i++) {
				out.printf("%s : %d\n",Thread.currentThread().getName(), i);
				// Условие пробуждения потока t1
				//if(i==50) {
					synchronized(sync) {
						sync.counter=i; // Здесь передается параметр для потока t1
						sync.notify();// уведомить, известить
					}
				//}
			}
		});
		 
		 Thread t1 = new Thread(() -> {
			 
			 synchronized(sync){
				 try {
					 //Здесь условие ожидания в самом потоке t1
					 while(sync.counter<50) {
						 sync.wait(1);
						 out.printf("t1 still waiting. conter = %d\n", sync.counter);
					 }
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
			 
			for(int i=1; i<=100;i++)
				out.printf("%s : %d\n",Thread.currentThread().getName(), i);
		 });
		 
		 t0.start();
		 t1.start();
	}

}
