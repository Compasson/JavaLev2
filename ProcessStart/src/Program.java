
import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Program {

	public static void main(String[] args) 
			throws IOException, InterruptedException {
		out.println("Starting process");
		//Runtime.getRuntime().exec("cmd /c dir"); не запуститс€ так как процесс не знает куда выводить информацию от команды cmd /c dir
		// „тобы перенаправл€ть потоки данных используем getInputStream getOutputSream
		Process p = Runtime.getRuntime().exec("cmd /c dir");
		
		BufferedReader reader=
				new BufferedReader(
						new InputStreamReader(p.getInputStream(), Charset.forName("cp866")));
		
		String s;
		while((s = reader.readLine())!=null)
			out.println(s);
			
		p.waitFor();
		int exitCode=p.exitValue();
		out.printf("Process exit whith codeExite = %d\n", exitCode);
	}

}
