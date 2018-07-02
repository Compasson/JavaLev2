
public class Program {

	public static void main(String[] args) throws InterruptedException {
		
		Thread t = new Thread() {
			public void run() {
				System.out.println("Sleeping...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("Interrupt");
				}
				System.out.printf("Interrupted exception from thread %s\n",this.getName());
				throw new RuntimeException();
			}
		};
		
		
		
		
	}

}
