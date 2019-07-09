public class ArrayDeque<T> implements Deque<T> {

    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object [8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    private int wrap(int p, int total) {
        int r = p % total;
        if (r < 0) {
            r += total;
        }
        return r;
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object [capacity];
        int currentLength = items.length;
        int lengthLast = wrap(nextFirst + 1, items.length);
        int lengthStart = currentLength - nextLast;
        int starting = capacity - lengthStart;
        //Copies end of list
        System.arraycopy(items, 0, a, 0, lengthLast);
        //Copies beginning of list
        System.arraycopy(items, nextLast, a, starting, lengthStart);
        items = a;
        if (nextFirst != currentLength - 1) {
            nextFirst = (nextFirst + currentLength);
        }
    }

    private void resizeDown(int capacity) {
        T[] b = (T[]) new Object [capacity];
        int currentLength = items.length;
        int index = size() - 1;
        int newIndex = capacity - 1;
        for (int i = 0; i < size(); i++) {
            b[newIndex] = get(index);
            newIndex--;
            index--;
        }
        nextFirst = newIndex;
        nextLast = 0;
        items = b;
    }

    //Adds an item of type T to front of deque.
    public void addFirst(T item) {
        if (size < items.length) {
            this.items[nextFirst] = item;
            nextFirst = wrap((nextFirst - 1), items.length);
            size += 1;
        } else if (size == items.length) {
            resize(items.length * 2);
            this.items[nextFirst] = item;
            nextFirst = (nextFirst - 1);
            size += 1;
        }
    }

    //Adds an item of type T to back of deque.
    public void addLast(T item) {
        if (size < items.length) {
            this.items[nextLast] = item;
            nextLast = wrap((nextLast + 1), items.length);
            size += 1;
        } else if (size == items.length) {
            resize(items.length * 2);
            this.items[nextLast] = item;
            nextLast = (nextLast + 1);
            size += 1;
        }
    }

    //Returns the number of items in the deque.
    public int size() {
        return size;
    }

    //Prints the items in the deque from first to last separated by a space.
    // Once all the items have been printed, print out a new line.
    public void printDeque() {
        if (size() == 0) {
            return;
        }
        int index = wrap(nextFirst +  1, items.length);
        String result = "";
        while (index != nextLast) {
            result += this.items[index] + " ";
            index = wrap(index + 1, items.length);
        }

        System.out.println(result.trim());
    }

    //Removes and returns the item at the front of the deque.
    //If no such item exists return null.
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            int index = wrap(nextFirst + 1, items.length);
            T storedItem = this.items[index];
            this.items[index] = null;
            nextFirst = index;
            size -= 1;
            Double siz = new Double(size());
            Double ratio = siz / items.length;
            if (items.length > 8 && ((ratio) < 0.25)) {
                resizeDown(items.length / 2);
            }
            return storedItem;
        }

    }

    //Removes and returns the item at the back of the deque.
    // If no such item exists return null.
    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            int index = wrap(nextLast - 1, items.length);
            T storedItem = this.items[index];
            this.items[index] = null;
            nextLast = index;
            size -= 1;
            Double siz = new Double(size());
            Double ratio = siz / items.length;
            if (items.length > 8 && (ratio < 0.25)) {
                resizeDown(items.length / 2);
            }
            return storedItem;
        }
    }

    //Gets the item at the given index.
    //If no such item exists return null.
    public T get(int index) {
        if (index < 0 || index >= size()) {
            return null;
        } else {
            int begin = wrap(nextFirst + 1, items.length);
            int place = wrap(begin + index, items.length);
            return this.items[place];
        }
    }
}
