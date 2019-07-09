/**
 * An SLList is a list of integers, which encapsulates the
 * naked linked list structure.
 */
public class SLList {

    /**
     * IntListNode is a nested class that represents a single node in the
     * SLList, storing an item and a reference to the next IntListNode.
     */
    private static class IntListNode {
        /*
         * The access modifiers inside a private nested class are irrelevant:
         * both the inner class and the outer class can access these instance
         * variables and methods.
         */
        public int item;
        public IntListNode next;

        public IntListNode(int item, IntListNode next) {
            this.item = item;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            IntListNode that = (IntListNode) o;
            return item == that.item;
        }

        @Override
        public String toString() {
            return item + "";
        }

    }

    /* The first item (if it exists) is at sentinel.next. */
    private IntListNode sentinel;
    private int size;

    /** Creates an empty SLList. */
    public SLList() {
        sentinel = new IntListNode(42, null);
        sentinel.next = sentinel;
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntListNode(42, null);
        sentinel.next = new IntListNode(x, null);
        sentinel.next.next = sentinel;
        size = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SLList slList = (SLList) o;
        if (size != slList.size) return false;

        IntListNode l1 = sentinel.next;
        IntListNode l2 = slList.sentinel.next;

        while (l1 != sentinel && l2 != sentinel) {
            if (!l1.equals(l2)) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    @Override
    public String toString() {
        IntListNode l = sentinel.next;
        String result = "";

        while (l != sentinel) {
            result += l + " ";
            l = l.next;
        }

        return result.trim();
    }

    /** Returns an SLList consisting of the given values. */
    public static SLList of(int... values) {
        SLList list = new SLList();
        for (int i = values.length - 1; i >= 0; i -= 1) {
            list.addFirst(values[i]);
        }
        return list;
    }

    /** Returns the size of the list. */
    public int size() {
        return size;
    }

    /** Adds x to the front of the list. */
    public void addFirst(int x) {
        sentinel.next = new IntListNode(x, sentinel.next);
        size += 1;
    }

<<<<<<< HEAD
    public void addLast(int x) {
        IntListNode p = sentinel.next;
        while (p.next != this.sentinel){
            p = p.next;
        }
        sentinel.next = new IntListNode(x, sentinel);
        size += 1;
=======
    /** Adds x to the end of the list. */
    public void addLast(int x) {
        IntListNode p = sentinel.next;
        int index = this.size -1;
        while (index > 0) {
            p = p.next;
            index -= 1;
        }
        p.next = new IntListNode(x, sentinel);
        this.size +=1;
>>>>>>> 4abad84760222d7af03c12a8b307011066493645
    }

    /** Return the value at the given index. */
    public int get(int index) {
        IntListNode p = sentinel.next;
        while (index > 0) {
            p = p.next;
            index -= 1;
        }
        return p.item;
    }

    /** Adds x to the list at the specified index. */
    public void add(int index, int x) {
<<<<<<< HEAD
        IntListNode p = sentinel.next;
        IntListNode o = sentinel;
        if (index > size()){
            addLast(x);
            }
        while (index > 0){
            p = p.next;
            o = o.next;
            index -=1;
        }
        p = new IntListNode(x, p);
        o.next = p;
        size += 1;


    }
    public IntListNode reverseHelper(IntListNode nList){
        if (nList.next == sentinel){
            return nList;
        }
        else{
            IntListNode temp = nList.next;
            IntListNode end = reverseHelper(temp);
            temp.next = nList;
            nList.next = sentinel;
            return end;
        }
    }

    /** Destructively reverses this list. */
    public void reverse() {
    IntListNode nListReversed = reverseHelper(sentinel.next);
    sentinel.next = nListReversed;
=======
        if(index> this.size-1){
            this.addLast(x);
        }
        else{
        IntListNode O = sentinel;
        IntListNode p = sentinel.next;
        while (index > 0) {
            p = p.next;
            O = O.next;
            index -= 1;
        }
        IntListNode NewNode = new IntListNode(x,p);
        O.next = NewNode;
        this.size+=1;}
        }



    /** Destructively reverses this list. */
    public void reverse() {
        IntListNode nakedListReversed = helper(this.sentinel.next);
        this.sentinel.next = nakedListReversed;
    }
    public IntListNode helper (IntListNode n){
        if (n.next == this.sentinel){
            return n;
        }
        IntListNode temp = n.next;
        IntListNode rest = helper(n.next);
        temp.next = n;
        n.next=sentinel;
        return rest;

>>>>>>> 4abad84760222d7af03c12a8b307011066493645
    }
}
