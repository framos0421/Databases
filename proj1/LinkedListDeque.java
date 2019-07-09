public class LinkedListDeque<T> implements Deque<T> {

    private class ListNode {
        private T item;
        private ListNode next;
        private ListNode prev;

        public ListNode(T item, ListNode next, ListNode prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    private ListNode sentinel;
    private int size;
    //private T item;

    public LinkedListDeque() {
        sentinel = new ListNode(null, null, null);
        size = 0;
    }

    //Creates an empty linked list deque.
    //public LinkedListDeque(){}

    //Adds an item of type T to front of deque.
    public void addFirst(T item) {
        if (isEmpty()) {
            ListNode initial = new ListNode(item, null, null);
            sentinel.next = initial;
            size += 1;
        } else if (size() == 1) {
            ListNode second = new ListNode(item, sentinel.next, sentinel.next);
            sentinel.next.next = second;
            sentinel.next.prev = second;
            sentinel.next = second;
            size += 1;
        } else {
            ListNode first = new ListNode(item, sentinel.next, sentinel.next.prev);
            sentinel.next.prev.next = first;
            sentinel.next.prev = first;
            sentinel.next = first;
            size += 1;
        }
        size();
    }

    //Adds an item of type T to back of deque.
    public void addLast(T item) {
        if (isEmpty()) {
            ListNode add = new ListNode(item, null, null);
            sentinel.next = add;
            size += 1;
        } else if (size() == 1) {
            ListNode second = new ListNode(item, sentinel.next, sentinel.next);
            sentinel.next.next = second;
            sentinel.next.prev = second;
            size += 1;
        } else {
            ListNode last = new ListNode(item, sentinel.next, sentinel.next.prev);
            sentinel.next.prev.next = last;
            sentinel.next.prev = last;
            size += 1;
        }
        size();
    }

    //Returns the number of items in the deque.
    public int size() {
        if (size < 0) {
            size = 0;
        }
        return size;
    }

    //Prints the items in the deque from first to last separated by a space.
    // Once all the items have been printed, print out a new line.
    public void printDeque() {
        if (size() == 0) {
            return;
        }
        ListNode l = sentinel.next;
        String result = "" + l.item + " ";
        ListNode x = l.next;
        while (x != l) {
            result += x.item + " ";
            x = x.next;
        }

        System.out.println(result.trim());
    }

    //Removes and returns the item at the front of the deque.
    //If no such item exists return null.
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else if (size() == 1) {
            T itemFirst = sentinel.next.item;
            sentinel.next = null;
            size -= 1;
            size();
            return itemFirst;
        } else if (size() == 2) {
            T itemFirst = sentinel.next.item;
            ListNode removed = sentinel.next;
            sentinel.next.prev.next = null;
            sentinel.next.prev.prev = null;
            sentinel.next.item = null;
            sentinel.next = sentinel.next.prev;
            removed.item = null;
            removed.next = null;
            removed.prev = null;
            size -= 1;
            size();
            return itemFirst;
        } else {
            T itemFirst = sentinel.next.item;
            ListNode removed = sentinel.next;
            sentinel.next.prev.next = sentinel.next.next;
            sentinel.next.next.prev = sentinel.next.prev;
            sentinel.next = sentinel.next.next;
            removed.item = null;
            removed.next = null;
            removed.prev = null;
            size -= 1;
            size();
            return itemFirst;
        }

    }

    //Removes and returns the item at the back of the deque.
    // If no such item exists return null.
    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else if (size() == 1) {
            T itemFirst = sentinel.next.item;
            sentinel.next = null;
            size -= 1;
            size();
            return itemFirst;
        } else if (size() == 2) {
            T itemLast = sentinel.next.next.item;
            ListNode removed = sentinel.next.next;
            sentinel.next.next = null;
            sentinel.next.prev = null;
            removed.item = null;
            removed.next = null;
            removed.prev = null;
            size -= 1;
            size();
            return itemLast;
        } else {
            ListNode removed = sentinel.next.prev;
            T itemLast = sentinel.next.prev.item;
            sentinel.next.prev.prev.next = sentinel.next;
            sentinel.next.prev = sentinel.next.prev.prev;
            removed.item = null;
            removed.next = null;
            removed.prev = null;
            size -= 1;
            size();
            return itemLast;
        }
    }

    //Gets the item at the given index.
    //If no such item exists return null.
    public T get(int index) {
        if (index >= size() || (index < 0)) {
            return null;
        } else {
            ListNode p = sentinel.next;
            while (index > 0) {
                p = p.next;
                index -= 1;
            }
            return p.item;
        }
    }

    //Get using recursion.
    private ListNode helper(int index, ListNode x) {
        if (index == 0) {
            return x;
        } else {
            return helper(index - 1, x.next);
        }
    }

    public T getRecursive(int index) {
        if (index >= size() || (index < 0)) {
            return null;
        } else {
            return (helper(index, sentinel.next)).item;
        }
    }
}
