public class LinkedListDeque <T>{

    private static class ListNode<T> {
        private T item;
        public ListNode<T> next;
        public ListNode<T> prev;

        public ListNode(T item, ListNode next, ListNode prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

        private ListNode sentinel;
        private int size;
        //private T item;

        public LinkedListDeque(){
            sentinel = new ListNode(33, null, null);
            size = 0;
        }

        public LinkedListDeque(T x){
            sentinel = new ListNode(33, null, null);
            sentinel.next = new ListNode(x, null, null);
            size = 1;
        }

        //Creates an empty linked list deque.
        //public LinkedListDeque(){}


        //Adds an item of type T to front of deque.
    public void addFirst(T item){
        ListNode first = new ListNode(item, sentinel.next, sentinel.next.prev);
        sentinel.next.prev.next = first;
        sentinel.next.prev = first;
        sentinel.next = first;
        size += 1;
    }

    //Adds an item of type T to back of deque.
    public void addLast(T item){
        ListNode last = new ListNode(item, sentinel.next, sentinel.next.prev);
        sentinel.next.prev.next = last;
        sentinel.next.prev = last;
        size +=1;
    }
    //Returns true if deque is empty, false otherwise.
    public boolean isEmpty(){
        return sentinel.next == null;
    }
    //Returns the number of items in the deque.
    public int size(){
        return size;
    }

    //Prints the items in the deque from first to last separated by a space.
        // Once all the items have been printed, print out a new line.
    public void printDeque(){
        ListNode l = sentinel.next;
        String result = "" + l.item;
        ListNode x = l.next;
        while (x != l) {
            result += x.item + " ";
            x = x.next;
        }

        System.out.println(result.trim());
    }

    //Removes and returns the item at the front of the deque.
        //If no such item exists return null.
    public T removeFirst(){
        if (isEmpty()){
            return null;
        }
        T itemFirst;
        itemFirst = sentinel.next.item;
        sentinel.next.prev.next = sentinel.next.next;
        sentinel.next.next.prev = sentinel.next.prev;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return itemFirst;
    }
    //Removes and returns the item at the back of the deque.
        // If no such item exists return null.
    public T removeLast(){
        if (isEmpty()){
            return null;
        }
        T itemLast = sentinel.next.prev.item;
        sentinel.next.prev = sentinel.next.prev.prev;
        sentinel.next.prev.prev.next = sentinel.next;
        size -= 1;
        return itemLast;
    }

    //Gets the item at the given index.
        //If no such item exists return null.
    public T get(int index) {
        ListNode p = sentinel.next;
        if (index >= size()) {
            while (index > 0) {
                p = p.next;
                index -= 1;
            }
            return p.item;
        }
    }

    //Get using recursion.
    public ListNode helper(int index, ListNode x){
        if (index == 0){
            return x;
        }
        else{
            return helper(index -1, x.next);
        }
    }
    public T getRecursive(int index){
            return (helper(index, sentinel.next)).item;
    }
}
