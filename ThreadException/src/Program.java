//---------------Почему-то не работает 
public class Program {

	public static void main(String[] args) throws InterruptedException {
		
		Thread t = new Thread() {
			
			public void run() {
				System.out.println("Sleeping...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("Interrupted.");
				}
				System.out.printf("Throwing exception from thread %s\n",
						this.getName());
				throw new RuntimeException();
			}
		};
		
		// Обработчик ошибок для одного потока
		/*Thread.UncaughtExceptionHandler h = new Thread.UncaughtExceptionHandler() {	
			@Override
			public void uncaughtException(Thread th, Throwable e) {
				System.out.printf("Uncaught exception from thread %s handled by thread %s : (specific) %s\n",
						th.getName(), Thread.currentThread().getName(), e);
				
			}
		};
		t.setUncaughtExceptionHandler(h);
		
		//Универсальный обработчик ошибок для нескольких потоков
		Thread.setDefaultUncaughtExceptionHandler( // статический метод
				new Thread.UncaughtExceptionHandler() {
					
					@Override
					public void uncaughtException(Thread th, Throwable ex) {
						
						System.out.printf("Uncaught exception from thread %s handled by thread %s : (unspecific) %s\n",
								th.getName(), Thread.currentThread().getName(), ex);					
					}
		});*/
		
		t.start();
		
		Thread.sleep(5000);
		
		System.out.println("main");
		
		
	}

}
