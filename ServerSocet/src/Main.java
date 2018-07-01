
import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

public class Main {

	/**
	 * 
	 * @param args
	 * @throws IOExeption
	 * @throws InterruptedException
	 */
	
	public static void main(String[] args) throws IOException, InterruptedException {

		//127.0.0.1:1111 - localhost port 1111
		
		ServerSocket ss = new ServerSocket(1111);
		
		while(true)
		{
			Socket cs = ss.accept();
			
			out.printf("Accept connection from %s\n", 
					cs.getInetAddress().toString()); //внешний адрес
			
			BufferedReader reader=
					new BufferedReader(
							new InputStreamReader(cs.getInputStream(), Charset.forName("UTF-8")));
			
			String s = reader.readLine();
			
			out.println(s);
			Thread.sleep(1000);
			
			OutputStreamWriter writer = new OutputStreamWriter(
					cs.getOutputStream(),
					Charset.forName("UTF-8"));
			
			writer.write(s.toUpperCase()+"\n"); // Client нужен символ конца строки, иначе он не будет обрабатывать ничего
			writer.flush(); // тоже для клиента
		}
	}

}
