public class ArrayDeque<T> {

    public T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque(){
        items = (T[]) new Object [8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    public ArrayDeque(T x){
        items = (T[]) new Object [8];
        this.items[4] = x;
        size = 1;
        nextFirst = 3;
        nextLast = 5;
    }

    private int wrap(int p, int size) {
        int r = p % size;
        if (r < 0) {
            r += size;
        }
        return r;
    }

    public void resize(int capacity){
        T[] a = (T[]) new Object [capacity];
        int currentLength = items.length;
        int lengthLast = nextFirst + 1;
        int lengthStart = currentLength - nextLast;
        int starting = capacity - (currentLength - nextLast);
        //Copies end of list
        System.arraycopy(items, 0, a, 0, lengthLast);
        //Copies beginning of list
        System.arraycopy(items, nextLast, a, starting, lengthStart);
        items = a;
        nextFirst = (nextFirst + currentLength);
    }

    //Adds an item of type T to front of deque.
    public void addFirst(T item){
        if (size < items.length) {
            this.items[nextFirst] = item;
            nextFirst = wrap((nextFirst - 1), items.length);
            size += 1;
        }else if(size == items.length){
            resize(items.length * 2);
            this.items[nextFirst] = item;
            nextFirst = (nextFirst - 1);
            size += 1;
        }
        }

    //Adds an item of type T to back of deque.
    public void addLast(T item){
        if (size < items.length){
            this.items[nextLast] = item;
            nextLast = wrap((nextLast + 1), items.length);
            size +=1;
        }else if(size == items.length){
            resize(items.length * 2);
            this.items[nextLast] = item;
            nextLast = (nextLast + 1);
            size += 1;
        }
    }

    //Returns true if deque is empty, false otherwise.
    public boolean isEmpty(){
        return true;
    }

    //Returns the number of items in the deque.
    public int size(){
        return size;
    }

    //Prints the items in the deque from first to last separated by a space.
    // Once all the items have been printed, print out a new line.
    public void printDeque(){

    }

    //Removes and returns the item at the front of the deque.
    //If no such item exists return null.
    public T removeFirst(){
        return null;
    }

    //Removes and returns the item at the back of the deque.
    // If no such item exists return null.
    public T removeLast(){
        return null;
    }

    //Gets the item at the given index.
    //If no such item exists return null.
    public T get(int index){
        return null;
    }


}
