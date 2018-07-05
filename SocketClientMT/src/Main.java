

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
	
	public static final int CONNECTIONS = 100;

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService pool = Executors.newFixedThreadPool(50);
		
		Future[] tasks = new Future[CONNECTIONS];
		for(int i=0;i<CONNECTIONS;i++)
			tasks[i]=pool.submit(() -> {
				
				try {
					Socket cs =  new Socket("localhost",1111);
					
					OutputStreamWriter writer =
							new OutputStreamWriter(cs.getOutputStream(),
									Charset.forName("UTF-8"));
					
					writer.write("test:"+String.valueOf(Thread.currentThread().getId()) +"\n");
					writer.flush();
					
					BufferedReader reader=
							new BufferedReader(
									new InputStreamReader(cs.getInputStream(),
											Charset.forName("UTF-8")));
					
					out.println(reader.readLine());
				}catch(IOException ex){
					out.printf(" %s is not must connected. IOException = %s\n",Thread.currentThread().getName(), ex.getMessage());
				}
			});
		
		
		pool.shutdown();
		
		Thread.sleep(5000);

	}

}
