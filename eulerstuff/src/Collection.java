import java.util.ArrayList;


public class Collection<T> {

	private Item<T> head;
	private int size;
	
	public Collection(Collection<T> c){
		head = c.getHead();
		size = c.getSize();
	}
	public Collection(){
		size = 0;
	}
	public void Add(Item<T> i){
		if(head ==null){
			head = i;
		}
		else{
			getlast().setNext(i);
		}
		size++;
	}

	public Item<T> getlast(){
		Item<T> current = head;
		while (current.getNext()!=null){
			current = current.getNext();
		}
		return current;
	}
	
	public Item<T> get(int i) throws OutOfBoundsException{
		if(head==null){
			throw new OutOfBoundsException("no items in collection");
		}
		else if(i<0){
			throw new OutOfBoundsException("less than 0");
		}
		Item<T> current = head;
		for(int p =0;p<i;p++){
			if(current.getNext()!=null){
				current = current.getNext();
			}
			else{throw new OutOfBoundsException("Collection is too small");
			}
		}

		return current;
	}

	public Item<T> getHead() {
		return head;
	}
	public void setHead(Item<T> head) {
		this.head = head;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	public void remove(int i) throws OutOfBoundsException{
		Item<T> current = get(i); // HEY LOOK WE'RE USING METHODS WITH NO TESTING
		Item<T> last = current.getPre(); // take the one before
		Item<T> next = current.getNext(); 
		last.setNext(next); // add it to the next one
		current = null; // remove the desired item
	}


	public void reverseArrayList(ArrayList<T> arb){
		int size = arb.size();
		int i = size;
		ArrayList<T> outlist = new ArrayList<T>();
		for(;i>=0;i--){
			outlist.add(arb.get(i));
		}
	}
	public Object getObjectAt(int i) throws OutOfBoundsException{
		Item<T> item =get(i);
		return item.get();
	}
	
	
}
