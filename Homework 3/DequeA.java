public class DequeA<Item>{	
private Node<Item>  first;
private Node<Item>  last;
private int size = 0;

private static class Node<Item>{
	private  Item data;
	private Node<Item> next;
} 
public DequeA(){
	first = null;
	last = null;
}
public void enqueueFront(Item elem){
	Node<Item> newElement = first;
	first = new Node<Item>();
	first.data = elem;
	if(size == 0)
		last = first;
	else
		first.next = newElement;
	size += 1;
}
public Item dequeueFront(){
	Item element = first.data;
	size -= 1;
	if(size == 0)
		first = null;
	else
		first = first.next;
	return element;
}
public void enqueueBack(Item elem){
	Node<Item> newElement = last;
	last = new Node<Item>();
	last.data = elem;
	last.next = null;
	if(size == 0 )
		first = last;
	else
		newElement.next = last;
	size += 1;
}
public Item dequeueBack(){
	Item element = last.data;
	if(size == 1)
		last = null;
	else{
		Node<Item> current = first;
		for(int i = 0 ; i < size - 2 ; i++){
			current = current.next;
		}
		last = current;
	}
	size -= 1;
	return element;
}
public static void main(String[] args){
	DequeA<Integer> asd = new DequeA<Integer>();
	asd.enqueueFront(15);
	asd.enqueueFront(17);
	asd.enqueueFront(19);
	asd.enqueueFront(21);
	asd.enqueueBack(23);
	asd.enqueueBack(25);
	StdOut.println(asd.dequeueBack());
	StdOut.println(asd.dequeueBack());

	StdOut.println(asd.dequeueBack());
	StdOut.println(asd.dequeueFront());
	StdOut.println(asd.dequeueFront());
	StdOut.println(asd.dequeueFront());
}

}
