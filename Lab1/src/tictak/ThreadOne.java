package tictak;

public class ThreadOne extends Thread {
  
	private Object monitor;
	
    public ThreadOne(Object mon) {
    	this.monitor=mon;
    }

    public void run () {
        try 
        {
            for (int i = 0; i < TicTak.num; i++) {
                System.out.print(1+" - ");
                synchronized(monitor) {
                	monitor.notify();
                	if(i<TicTak.num)
                		monitor.wait();
                }
            }
            
        }
        catch (InterruptedException e) { e.printStackTrace(); }
    }
}
