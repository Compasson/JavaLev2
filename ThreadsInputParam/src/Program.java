import static java.lang.System.out;

class MyThread extends Thread
{
	private int min;
	private int max;
	
	public MyThread(int min,int max)
	{
		this.min=min;
		this.max=max;
	}
	
	@Override
	public void run() {
		for(int i=min;i<=max;i++) {
			out.printf("%s : %d\n",getName(), i);
		}
	}
}

public class Program {

	public static void main(String[] args) {
		
		Thread t0=new MyThread(-50,0);
		
		final int min = 0;
		final int max = 50;
		
		Thread t1=new Thread(
				() -> {
					for(int i=min;i<=max;i++) {
						out.printf("%s : %d\n",Thread.currentThread().getName(), i);
					}
				});
		
		t0.start();
		t1.start();
	}

}
