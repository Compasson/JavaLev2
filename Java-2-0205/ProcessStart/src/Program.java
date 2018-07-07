
import static java.lang.System.out;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.io.BufferedReader;

public class Program {

	public static void main(String[] args) 
			throws IOException, InterruptedException {
		out.println("Starting process");
		Process p = Runtime.getRuntime().exec("cmd /C dir");
		
		
		BufferedReader reader = 
			new BufferedReader(
					new InputStreamReader(p.getInputStream(), 
							Charset.forName("cp866")));
		
		String s;
		while ( (s = reader.readLine()) != null)
			out.println(s);
		
		
		//int exitCode = p.waitFor();
		p.waitFor();
		int exitCode = p.exitValue();
		
		out.printf("Process exit. Code: %d\n", exitCode);

	}

}
