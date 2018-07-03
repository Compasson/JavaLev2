package client;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.concurrent.Callable;

public class TaskClient implements Callable {

	@Override
	public Object call() {
		
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
		
		return null;
	}

}
