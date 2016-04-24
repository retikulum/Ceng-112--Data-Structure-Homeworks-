public class Stack<Item> {
    private Item[] items;
    private int size;

    public Stack(int initialCapacity) {
        items = (Item[]) new Object[initialCapacity];
        size = 0;
    }

    public void push(Item item) {
        if (size == items.length)
            resize(items.length*2);
        items[size] = item;
        size += 1;
    }

    public Item pop() {
        size -= 1;
        Item r = items[size];
        items[size] = null;

        if (size > 0 && size < items.length/4)
            resize(items.length/2);
        
        return r;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int newCapacity) {
        Item[] newItems = (Item[]) new Object[newCapacity];
        for (int i = 0; i < size; i += 1) {
            newItems[i] = items[i];
        }
        items = newItems;
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>(1);
        Stack<String> ss = new Stack<String>(1);
        
        for (int i = 0; i < 5; ++i) {
            s.push(new Integer(i));
            ss.push("Item " + i);
        }

        s.push(42);
        StdOut.println("Pushed " + s.size() + " elements onto the integer stack.");
        
        while (!s.isEmpty())
            StdOut.println(s.pop());
    
        StdOut.println("There are " + s.size() + " elements left on the integer stack.");

        while (!ss.isEmpty())
            StdOut.println(ss.pop());
        
    }
}
