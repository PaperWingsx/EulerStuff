import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EULER {
	EULER euler = new EULER();
	public static void main(String[] args) {
		try {
			System.out.println("nthFibNumber:"+nthFibNumber(5));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// find the sum of all numbers that are multiples of var 1 or var 2
	private static int question1(int var1, int var2, int limit){
		int out =0;
		ArrayList<Integer> multiples = new ArrayList<Integer>();
		for(int i=0;i<limit;i++){
			if(i%var1==0 || i%var2==0){
				out = out+i;
				multiples.add(i);
			}
		}
		return out;
	}

	private static int question2(){
		int out = 0;
		// BASE VALUES
		int a = 1;
		int b =2;
		ArrayList<Integer> evencollect = new ArrayList<Integer>();
		evencollect.add(b);
		//////////////
		while(nextFib(a,b)<4000000){// next number isnt 4million
			int newB = nextFib(a,b);
			a=b;
			b=newB;
			if(newB%2==0){
				evencollect.add(newB);
			}
		}
		// add the collction up
		for(int i = 0;i<evencollect.size();i++){
			out=out +evencollect.get(i);
		}
		return out;
	}

	// return the next fib number
	private static int nextFib(int a,int b){
		return a+b;
	}

	// implementing a file to keep a record of all previously calculated fib numbers to save time
	private static int nthFibNumber(int input) throws IOException{
		int out =0;
		int iterations = 0; // a counter incase we reach EOF and havent found the nth term
		boolean check = false;
		File fibs = new File("Fibs.txt");
		FileReader FR =null;
		BufferedReader reader =null;
		if(fibs.exists()){
			reader = new BufferedReader(new FileReader(fibs));
		}
		//		if(fibs.exists()&&!fibs.isDirectory()){
		//			// file has been found, read from file either N times or start calculating more numbers
		//			for(int i=0;i<input;i++)	{
		//				int current = reader.read();
		//				if(current==-1){
		//					check = false;	
		//				}
		//				if(reader.read()=='\''){
		//					iterations ++;
		//				}
		//			}
		//		}
		//		
		//		else{
		//			//file doesn't exist start calculating fibs
		//		}
		if(fibs.exists()&&!fibs.isDirectory()){
			while((reader.readLine() != null) && (check = false)){
				iterations++;	// we have another int
				if(iterations==input){
					out = getIntAtline(reader,input);
					check = true;// we have found the nth number yay
				}
			}
			if(!check){
				int filelength = getNumberOfLinesReader(reader);
				int a = getIntAtline(reader,filelength-2);
				int b = getIntAtline(reader,filelength-1);
				BufferedWriter appender = new BufferedWriter(new FileWriter("Fibs.txt", true));
				while(iterations<input){
					iterations++;
					int newB = nextFib(a,b);
					String arb = ""+newB;
					appender.append(arb);
					a=b;
					b=newB;
				}
				out = getIntAtline(reader,input);
			}
			// start adding more fib numbers calculate number, put it into the file then repeat till necessary (nth number)
		}
		else{
			File f = new File("Fibs.txt"); 
			f.createNewFile();
			// no file at all, first iteration, start generating fib sequence and writing to file
			int a2=1;
			int b2=1;
			BufferedWriter appender = new BufferedWriter(new FileWriter("Fibs.txt", true));
			while(iterations<input){
				iterations++;
				int newB = nextFib(a2,b2);
				String arb = ""+newB;
				appender.append(arb);
				a2=b2;
				b2=newB;
			}
			out = getIntAtline(reader,input);
		}
		return out;
	}

	// get number of lines in the file that the reader is reading from
	static int getNumberOfLinesReader(BufferedReader input) throws IOException{
		int lines =0;
		while(input.readLine()!=null) lines++;
		return lines;
	}
	// get the integer at a line(DONT USE THIS LIKE A RETARD)
	static int getIntAtline(BufferedReader reader, int input) throws IOException{
		int out = 0;
		String line ="";
		for(int i=0;i<input-1;i++){
			line =reader.readLine();
		}	
		out = Integer.parseInt(line);		
		return out;
	}

	//List all Factors
	private ArrayList<Integer> listAllFactors(int input){
		ArrayList<Integer> out = new ArrayList<Integer>();
		for(int i=0;i<input;i++){
			if(input%i==0){
				out.add(i);
			}
		}
		return out;
	}
	//list all prime factors
	private ArrayList<Integer> listAllPrimeFactors(ArrayList<Integer> input){
		ArrayList<Integer> out = new ArrayList<Integer>();
		for(int i =0;i<input.size();i++){
			if(isPrime(input.get(i))){
				out.add(input.get(i));
			}
		}
		return out;
	}
	// ERROR CHECKING IS FOR SCRUBS
	private boolean isPrime(int input){
		boolean out = true;
		for(int i = 0;i< input;i++){
			if(input%i==0){
				out=false;
			}
		}
		return  out;
	}
	// THE QUESTION WANTS AN INPUT OF 600851475143
	private Integer question3(int input){
		int out = 0;
		ArrayList<Integer> factors = listAllFactors(input);
		ArrayList<Integer> PFactors = listAllPrimeFactors(factors);
		out = PFactors.get(PFactors.size()-1);
		return out;
	}

	// find the largest palindronmic numbers from three digits
	private Integer question4(){
		Integer out = 0;
		for(int i = 100;i<999;i++){
			for(int j = 100;j<999;j++){
				int p = i*j;
				String test = ""+p;
				String reversed =reverseString(test);
				if(test.equals(reversed)){
					out = p;
				}
			}
		}
		return out;
	}
	// REVERSES A STRING I HOPE
	private String reverseString(String input){
		String reversed ="";
		for(int t = input.length()-1;t>=0;t--){
			reversed= reversed+input.charAt(t);
		}
		return reversed;
	}
	//find the smallest number that can be divided by the numbers 1-20 with no remainder
	private int question5(){
		int out = 0;
		boolean check = false;
		for(int p = 2020;check=false;p++){
			for(int q =0;q<21;q++){
				if(p%q==0){
					check = true;
					out = p;
				}
				else{
					check=false;
				}
			}
		}
		return out;
	}
// returns x^x
	private int powerofself(int input){
		int out = input;
		int base = input;
		for(int i = 0;i<input;i++){
			out=out*base;			
		}		
		return out;
	}
	private int square(int input){
		return input*input;
	}

	// calculate the difference between the square values and the
	private int question6(int input){
		int out = 0;
		int tally1 = 0;
		for(int i =0;i<input;i++){
			tally1 = tally1+square(i);
		}
		int sumSquared= square(getNthSquareNumber(input));
		out = tally1-sumSquared;
		return out;
	}
	private int squareOfTheSum(int input){
		int out =0;
		return out;
	}
	private int getNthSquareNumber(int input){
		int out = 0;
		for(int i =0;i<input;i++){
			out =out+i;
		}
		return out;
	}
	//return a sorted array we might be doing a bubble sort at some point for alphabetical order,
	//also usefull for pivots i guess
	private String[] orderAlphabetically(String input1, String input2){
		String[] out;
		out = new String[2];
		if(input1.compareToIgnoreCase(input2)<0){ // no need to do inmput1/2 .toUpperCase();
			// negative for 1 before 2
			out[0] = input1;
			out[1] = input2;
		}
		else if(input1.compareToIgnoreCase(input2)>=0){
			// positive means 2 is before 1
			out[0]=input2;
			out[1]=input1;
		}
		else{// same string 
			out[0] = input1;
			out[1] = input2;
		}
		return out;
	}



}