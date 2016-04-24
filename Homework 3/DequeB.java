public class DequeB<Item>{
	private Node<Item> first;
	private Node<Item> last;
	private int size;
	private  class Node<Item>{
		private Item item;
		private Node<Item> next;
		private Node<Item> prev;
	}
	public DequeB(){
		first = null;
		last = null;
		size =  0;
	}
	public void enqueueFront(Item elem){
		if(size == 0){
			first = new Node<Item>();
			first.item = elem;
			last = first;
		}
		else{
		Node<Item> newElement = first;
		first = new Node<Item>();
		first.item = elem;
		first.next = newElement;
		first.prev = last;
		newElement.prev = first;
	}
		size += 1;
	}
	public Item dequeueFront(){
		Item item = first.item;
		if(size == 1){
			first = null;
			last = first;
		}
		else{
			first = first.next;
			first.prev = last;
			last.next = first;
		}
		size -= 1;
		return item;
	}
	public void enqueueBack(Item elem){
		if(size == 0){
			last = new Node<Item>();
			last.item = elem;
			first = last;
		}
		else{
			Node<Item> newElement = last;
			last = new Node<Item>();
			last.next = first;
			last.item = elem;
			last.prev = newElement;
			newElement.next = last;
			first.prev = last;

		}
		size += 1;
	}
	public Item dequeueBack(){
		Item elem = last.item;
		if(size == 0 ){
			last = null;
			first = last;
		}
		else{
			last = last.prev;
			last.next = first;
			first.prev = last;

		}
		size -= 1;
		return elem;
	}
	public static void main(String[] args) {
		DequeB<Integer> asd = new DequeB<Integer>();
		asd.enqueueFront(10);
		asd.enqueueFront(15);
		asd.enqueueBack(20);
		asd.enqueueFront(25);
		asd.enqueueBack(30);
		StdOut.println(asd.dequeueBack());
		StdOut.println(asd.dequeueFront());
		StdOut.println(asd.dequeueBack());
		StdOut.println(asd.dequeueFront());
		StdOut.println(asd.dequeueFront());

	}
}