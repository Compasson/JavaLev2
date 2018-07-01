/*
 *  есть поле double x=1;
 *  
 *  в первом потоке взять sin(x) обратно в x
 *  
 *  во втором потоке взять arcsin(x)
 *  
 *  синхронихационный класс
 *  double x=1;
 *  boolean isSin=true; //
 *  
 *  
 */
import java.lang.Math;

import static java.lang.System.out;



public class Program {

	public static void main(String[] args) throws InterruptedException {
		
		class Sync
		{
			volatile double x=1d;
			volatile boolean isSin=true;

		}
		
		Sync sync =new Sync();
		
		Thread tsin = new Thread(() -> {
			for(int i=0;i<10;i++) {
				synchronized(sync)
				{
					while(!sync.isSin)
						try {
							sync.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					sync.x=Math.sin(sync.x);
					out.println(sync.x);
					sync.isSin=false;
					sync.notify();
				}
			}
		});
		
		Thread tasin = new Thread(() -> {
			for(int i=0;i<20;i++) {
				synchronized(sync)
				{
					while(sync.isSin)
						try {
							sync.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					sync.x=Math.asin(sync.x);
					out.println(sync.x);
					sync.isSin=true;
					sync.notify();
				}
			}
		});
		
		tsin.start();
		Thread.sleep(1000);
		tasin.start();
	}

}
