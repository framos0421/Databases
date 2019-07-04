public class ArrayDeque<T> {

    private T[] items;
    private int size;

    public ArrayDeque(){
        //this.items = new T[8];
        int size = 0;
        int nextFirst = 4;
        int nextLast = 5;
    }

    public ArrayDeque(T x){
        //this.items = new T[8];
        this.items[4] = x;
        int size = 1;
        int nextFirst = 3;
        int nextLast = 5;
    }

    //Adds an item of type T to front of deque.
    public void addFirst(T item){
        if (size == items.length){
            //T[] a = new T[size + 1];
            //System.arraycopy(items, 0, a, 1, size);
            //items = a;
            items[0] = item;
            size += 1;
        }
        }

    //Adds an item of type T to back of deque.
    public void addLast(T item){
        if (size == items.length){
            //T[] a = new T[size + 1];
            //System.arraycopy(items, 0, a, 0, size);
            //items = a;
            items[size] = item;
            size += 1;
        }
    }

    //Returns true if deque is empty, false otherwise.
    public boolean isEmpty(){
        return true;
    }

    //Returns the number of items in the deque.
    public int size(){
        return 0;
    }

    //Prints the items in the deque from first to last separated by a space.
    // Once all the items have been printed, print out a new line.
    public void printDeque(){

    }

    //Removes and returns the item at the front of the deque.
    //If no such item exists return null.
    //public T removeFirst(){ }

    //Removes and returns the item at the back of the deque.
    // If no such item exists return null.
    //public T removeLast(){ }

    //Gets the item at the given index.
    //If no such item exists return null.
    //public T get(int index){ }


}
