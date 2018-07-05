

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

// Видео Day2 19:01

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		ServerSocket ss = new ServerSocket(1111);
		final ExecutorService p = Executors.newCachedThreadPool();
		final AtomicInteger rec = new AtomicInteger(); //Счетчик
		
		out.println("Server runing, ready by connect.");
		
		while(true)
		{
			final Socket cs = ss.accept();
			
			p.submit(() ->{
				
				try {
					out.printf("Accept connection from %s\n", 
							cs.getInetAddress().toString()); //внешний адрес
					
					BufferedReader reader=
							new BufferedReader(
									new InputStreamReader(cs.getInputStream(), Charset.forName("UTF-8")));
					
					String s = reader.readLine();
					
					out.printf("%s . %d\n",s,rec.incrementAndGet());
					Thread.sleep(100);
					
					OutputStreamWriter writer = new OutputStreamWriter(
							cs.getOutputStream(),
							Charset.forName("UTF-8"));
					
					writer.write(s.toUpperCase()+"\n"); // Client нужен символ конца строки, иначе он не будет обрабатывать ничего
					writer.flush(); // тоже для клиента
				}catch(Exception e) {
					out.println(e.getMessage());
				}
			});
			

		}

	}

}
