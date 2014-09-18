import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;


// put all stuff for reading/writing to primes.txt in here
public class PrimeCollection {
	File fIn;
	public PrimeCollection(){
		fIn = new File("Primes.txt");
	}

	public void append(int input) throws IOException{
		FileWriter writer = new FileWriter(fIn,true);
		BufferedWriter bWriter = new BufferedWriter(writer);
		bWriter.write(input+",");
		bWriter.close();
		writer.close();
	}

	public boolean contains(int target) throws IOException{
		FileReader reader = new FileReader("Primes.txt");
		BufferedReader bReader = new BufferedReader(reader);
		boolean check = false;
		char currentchar = ',';
		int count =0;
		String current ="";
		boolean out = false;
		while(check){
			currentchar = (char)bReader.read();
			if(currentchar==','){
				count++;
				if(Integer.parseInt(current)==target){
					out = true; 
					
					break;
				}
				current="";
			}
			if(count ==target){
				current = current +currentchar;
			}
			if(bReader.read()==-1){//eof
				check = false;
			}
		}
		bReader.close();
		reader.close();
		return out;
	}

	public int size() throws IOException{
		int count = 0;
		FileReader reader = new FileReader(fIn.getName());
		BufferedReader bReader = new BufferedReader(reader);
		while(bReader.read()!=-1){
			if(bReader.read()==','){
				count++;
			}
		}
		reader.close();
		bReader.close();
		return count;
	}

	//	public void write(int input) throws IOException{
	//		if(!contains(input)){
	//			FileWriter writer = new FileWriter(fIn.getName(),true);
	//			writer.write(input+",");
	//		}
	//	}

	public int getNthPrime(int target) throws IOException{
		FileReader reader = new FileReader(fIn.getName());
		BufferedReader bReader = new BufferedReader(reader);
		if(target>size()){
			// do something like calculate the nth prime here
		}
		boolean check = true;
		int count = 0;
		String current ="";
		char currentchar =',';
		while(check){
			currentchar = (char)bReader.read();
			if(currentchar==','){
				count++;
			}
			if(count ==target){
				current = current +currentchar;
			}
			if(bReader.read()==-1){
				check = false;
			}
		}
		int out = Integer.parseInt(current);
		bReader.close();
		reader.close();
		return out;
	}

	public int getLast() throws IOException{
		int out = 0;
		boolean check = true;
		int i = 0;
		char currentchar = ',';
		String numbString = "";
		BufferedReader reader = getReader();
		while(check)
		{
			currentchar = (char)reader.read();
			if(currentchar==','){
				i++;
			}
			if(i==size()-1){
				// we're on the nth entry
				numbString += currentchar;
			}
			if(reader.read()==-1){
				check = false;
			}
		}	
		out = Integer.parseInt(numbString);
		reader.close();
		return out;
	}

	public BufferedReader getReader() throws FileNotFoundException{
		FileReader reader = new FileReader(fIn.getName());
		BufferedReader bReader = new BufferedReader(reader);
		return bReader;
	}
	
	public void add(int input) throws IOException{
		if(!contains(input)){
			append(input);
		}		
	}
	
	public ArrayList<Integer> toArrayList() throws IOException{
		ArrayList<Integer> outlist= new ArrayList<Integer>();
		for(int i =0; i <size();i++){
			outlist.add(getNthPrime(i));			
		}
		return outlist;
	}
	
	public ArrayList<Integer> sortArrayList(ArrayList<Integer> numbers) throws IOException{
		 if (numbers.size() <= 1)
	            return numbers;
	        int pivot = numbers.size() / 2;
	        ArrayList<Integer> lesser = new ArrayList<Integer>();
	        ArrayList<Integer> greater = new ArrayList<Integer>();
	        int sameAsPivot = 0;
	        for (int number : numbers) {
	            if (number > numbers.get(pivot))
	                greater.add(number);
	            else if (number < numbers.get(pivot))
	                lesser.add(number);
	            else
	                sameAsPivot++;
	        }
	        lesser = sortArrayList(lesser);
	        for (int i = 0; i < sameAsPivot; i++)
	            lesser.add(numbers.get(pivot));
	        greater = sortArrayList(greater);
	        ArrayList<Integer> sorted = new ArrayList<Integer>();
	        for (int number : lesser)
	            sorted.add(number);
	        for (int number: greater)
	            sorted.add(number);
	        return sorted;
	}
	
	public void sortFile() throws IOException{
		ArrayList<Integer> sortedList = sortArrayList(toArrayList());
		wipeTXT();
		for(Integer i : sortedList){
			add(i);
		}
	}
	
	public synchronized void wipeTXT() throws IOException{
		Files.delete(fIn.toPath());
		fIn = new File("Primes.txt");
	}

	
}






