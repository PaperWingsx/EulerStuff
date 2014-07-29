import java.util.ArrayList;


public class ArrayManipulation<T>{

	public ArrayManipulation(){

	}
	public static void printArrayList(ArrayList input){
		for(Object item : input){
			System.out.println(""+item);
		}
	}
	public static void printArray(Object[] inlist){
		int length =inlist.length;
		for(int i=0;i<length;i++){
			System.out.println(""+inlist[i]);
		}
	}


}

