import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;


public class CSVHandler {
	private File file;
	private String targetPath;
	public CSVHandler(){}
	public CSVHandler(String path){
		file = new File(path);
	}
	public File getFile(){
		if(file==null)
		{
			return new File("DefaultFile.txt");
		}
		else{
			return file;
		}
	}
	public void setFile(File file){
		this.file = file;
	}
	public void setFile(String path){
		file = new File(path);
	}
	public void append(String input) throws IOException, CSVNotSetException{
		BufferedWriter writer =getWriter(true);
		writer.write(input);;
	}
	public BufferedWriter getWriter(boolean mode) throws IOException, CSVNotSetException{
		if (file == null){
			throw new CSVNotSetException("File not set");
		}
		FileWriter writer = new FileWriter(file,mode);
		BufferedWriter out = new BufferedWriter(writer);
		return out;
	}
	public void wipe() throws IOException{
		Files.delete(file.toPath());
		file = new File(targetPath);
	}
	public BufferedReader getReader() throws FileNotFoundException, CSVNotSetException{
		if (file == null){
			throw new CSVNotSetException("File not set");
		}
		FileReader reader = new FileReader(file);
		BufferedReader out = new BufferedReader(reader);
		return out;
	}
	public int count() throws CSVNotSetException, IOException{
		int count = 0;
		BufferedReader reader = getReader();
		while(true){
			if((char)reader.read() ==',')count++;
			if(reader.read()==-1)break;
		}
		return count;
	}
	boolean isSet(){
		if(file!=null){return true;}
		else{return false;}		
	}
	private void nothing(){}

}
