package client;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.Charset;

public class ClientMainCompact {

	public static void main(String[] args) {
		
	//для java 9	
		/*Runnable task = () - > {
			try {
				Socket cs =  new Socket("localhost",1111);
				
				OutputStreamWriter writer =
						new OutputStreamWriter(cs.getOutputStream(),
								Charset.forName("UTF-8"));
				
				writer.write("test\n");
				writer.flush();
				
				BufferedReader reader=
						new BufferedReader(
								new InputStreamReader(cs.getInputStream(),
										Charset.forName("UTF-8")));
				
				out.println(reader.readLine());
			}catch(Exception ex) {
				
			}
		};*/

	}

}
