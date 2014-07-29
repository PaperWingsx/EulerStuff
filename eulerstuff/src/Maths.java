import java.util.ArrayList;
import java.util.Random;

import org.joda.time.DateTime;

import javax.swing.Spring;


public class Maths {
	public Maths(){

	}
//
//	public static void main(String [] args){
//		Maths arbmaths = new Maths();
//		try {
//			ArrayList<Integer> arblist = arbmaths.ListFactors(50);
//			ArrayManipulation.printArrayList(arblist);
//			System.out.println("testing random array");
//			ArrayManipulation.printArrayList(randomiseArrayList(arblist));
//		} catch (OutOfBoundsException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

	public ArrayList<Integer>ListFactors(int input) throws OutOfBoundsException{

		if (input<=0||input==1){
			throw new OutOfBoundsException("less than or equal to 0");
		}
		ArrayList<Integer> outlist = new ArrayList<Integer>();
		for(int i = 1;i<input;i++){
			if(input%i == 0){
				outlist.add(i);
			}

		}
		return outlist;
	}
	public DateTime arb(){return null;}
	public int difference(int a, int b){
		int out = 0;
		if( a<b){
			out = b-a;
		}
		if(a>b){
			out = a-b;
		}
		return out;
	}
	// returns the numbers 0-i in a random order 
	public static ArrayList<Integer> randomSequence(int limit) throws OutOfBoundsException
	{
		ArrayList<Integer> out = new ArrayList<Integer>(limit+1);
		Random rand = new Random();
		if(limit>0){
			for(int i = 0; i<limit;i++){
				int p =rand.nextInt(limit);
				boolean test = true;
				// locate an empty spot and insert
				while(test)
					if(out.get(p)==null){
						out.add(p, i);
						test= false;
					}			
			}	
		}
		else{
			throw new OutOfBoundsException();
		}
		return out;
	}
	// randomises the numbers start to I throws error and shitty input
	public ArrayList<Integer> randomSequence(int start,int limit) throws OutOfBoundsException
	{
		if(limit>start){
			throw new OutOfBoundsException();
		}
		ArrayList<Integer> out = new ArrayList<Integer>(limit+1);
		Random rand = new Random();
		for(int i = start; i<limit;i++){
			int p =rand.nextInt(limit);
			boolean test = true;
			// locate an empty spot and insert
			while(test)
				if(out.get(p)==null){
					out.add(p, i);
					test= false;
				}			
		}	
		return out;
	}
	//Randomises an arraylist
	public static ArrayList<Object> randomiseArrayList(ArrayList inputList){
		ArrayList<Object> out = new ArrayList<Object>();
		try {
			ArrayList<Integer> randomArrayList = randomSequence(inputList.size());
			// for every object in input setlocation as iteration in out list
			for(int i = 0;i<inputList.size();i++){
				int p = randomArrayList.get(i);
				out.add(i, inputList.get(p));				
			}
		} catch (OutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(NullPointerException NPE){
			System.out.println("NPE");
		}
		return out;
	}
}
