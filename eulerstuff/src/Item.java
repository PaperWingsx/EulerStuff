
public class Item<T> {
	private Item<T> head;
	private Item<T> pre;
	private Item<T> next;
	// SET AND GET THE TYPE
	private T t;
	public void set(T t) { 
		this.t = t; 
	}
	public T get() { 
		return t;
	}
	public Item(){

	}
	public Item(T t){
		set(t);
	}
	public Item<T> getHead() {
		return head;
	}
	public void setHead(Item<T> head) {
		this.head = head;
	}
	public Item<T> getPre() {
		return pre;
	}
	public void setPre(Item<T> pre) {
		this.pre = pre;
	}
	public Item<T> getNext() {
		return next;
	}
	public void setNext(Item<T> next) {
		this.next = next;
	}




}
