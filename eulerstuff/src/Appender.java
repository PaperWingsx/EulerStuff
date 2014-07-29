import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Appender {
	public Appender(){}

	public void append(String fileDir, String textIn) throws IOException{
		File fIn = new File(fileDir);
		FileWriter writer = new FileWriter(fIn.getName(),true);
		writer.write(textIn);
	}


}
