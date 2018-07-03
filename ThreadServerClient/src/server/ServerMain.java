package server;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

// ¬идео Day2 19:01

public class ServerMain {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		ServerSocket ss = new ServerSocket(1111);
		int rec=0; // —четчик обработанных запросов
		
		out.println("Server runing, ready by connect.");
		
		while(true)
		{
			Socket cs = ss.accept();
			
			out.printf("Accept connection from %s\n", 
					cs.getInetAddress().toString()); //внешний адрес
			
			BufferedReader reader=
					new BufferedReader(
							new InputStreamReader(cs.getInputStream(), Charset.forName("UTF-8")));
			
			String s = reader.readLine();
			
			out.printf("%s . %d\n",s,++rec);
			Thread.sleep(100);
			
			OutputStreamWriter writer = new OutputStreamWriter(
					cs.getOutputStream(),
					Charset.forName("UTF-8"));
			
			writer.write(s.toUpperCase()+"\n"); // Client нужен символ конца строки, иначе он не будет обрабатывать ничего
			writer.flush(); // тоже дл€ клиента
		}

	}

}
