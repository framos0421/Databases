/** A data structure to represent a Linked List of Integers.
 * Each IntList represents one node in the overall Linked List.
 *
 * @author Maurice Lee and Wan Fung Chui
 */

public class IntList {

    /**
     * The integer stored by this node.
     */
    public int item;
    /**
     * The next node in this IntList.
     */
    public IntList next;

    /**
     * Constructs an IntList storing ITEM and next node NEXT.
     */
    public IntList(int item, IntList next) {
        this.item = item;
        this.next = next;
    }

    /**
     * Constructs an IntList storing ITEM and no next node.
     */
    public IntList(int item) {
        this(item, null);
    }

    /**
     * Returns an IntList consisting of the elements in ITEMS.
     * IntList L = IntList.list(1, 2, 3);
     * System.out.println(L.toString()) // Prints 1 2 3
     */
    public static IntList of(int... items) {
        /** Check for cases when we have no element given. */
        if (items.length == 0) {
            return null;
        }
        /** Create the first element. */
        IntList head = new IntList(items[0]);
        IntList last = head;
        /** Create rest of the list. */
        for (int i = 1; i < items.length; i++) {
            last.next = new IntList(items[i]);
            last = last.next;
        }
        return head;
    }

    /**
     * Returns [position]th item in this list. Throws IllegalArgumentException
     * if index out of bounds.
     *
     * @param position, the position of element.
     * @return The element at [position]
     */
    public int get(int position) {
        IntList index = this;
        int i = 0;
        if (position < 0) {
            throw new IllegalArgumentException("POSITION IS OUT OF RANGE");
        }
        while (i < position) {
            if (index.next == null) {
                throw new IllegalArgumentException("POSITION OUT OF RANGE");
            }
            i += 1;
            index = index.next;
        }
        return index.item;
    }

    /**
     * Returns the string representation of the list. For the list (1, 2, 3),
     * returns "1 2 3".
     *
     * @return The String representation of the list.
     */
    public String toString() {
        //IntList i = new IntList;
        String listRep = "";
        while (this.next != null) {
            String character = Integer.toString(this.item);
            listRep += character;
        }
        return listRep;
    }

    public int iterativeSize() {
        IntList p = this;
        int totalSize = 0;
        while (p != null) {
            totalSize += 1;
            p = p.next;
        }
        return totalSize;
    }

    /**
     * Returns whether this and the given list or object are equal.
     *
     * @param obj, another list (object)
     * @return Whether the two lists are equal.
     */
    public boolean equals(Object obj) {
        if (obj instanceof IntList) {
            if (this.iterativeSize() == ((IntList) obj).iterativeSize()) {
                IntList another = this;
                int p = 0;
                int size = another.iterativeSize();
                while (p < size) {
                    if (another.item != ((IntList) obj).item) {
                        return false;
                    }
                    obj = ((IntList) obj).next;
                    another = another.next;
                    p += 1;
                }
                return true;
            }
            return false;
        }
        return false;
    }

        /**
         * Adds the given value at the end of the list.
         *
         * @param value, the int to be added.
         */
        public void add ( int value){
            IntList list = this;
            int size = list.iterativeSize();
            for (int i = 0; i < size; i++) {
                list = list.next;
            }
            list.next = new IntList( value, null);
        }

        /**
         * Returns the smallest element in the list.
         *
         * @return smallest element in the list
         */
        public int smallest(){
            IntList list = this.next;
            int size = this.iterativeSize();
            int small = this.item;
            for (int i =0; i < size-1; i++){
                if(list.item < small){
                    small = list.item;
                }
                list = list.next;
            }
            return small;
        }

        /**
         * Returns the sum of squares of all elements in the list.
         *
         * @return The sum of squares of all elements.
         */
        public int squaredSum () {
            // YOUR CODE HERE
            return -1;
        }

        /**
         * Destructively squares each item of the list.
         *
         * @param L list to destructively square.
         */
        public static void dSquareList (IntList L){
            while (L != null) {
                L.item = L.item * L.item;
                L = L.next;
            }
        }

        /**
         * Returns a list equal to L with all elements squared. Non-destructive.
         *
         * @param L list to non-destructively square.
         * @return the squared list.
         */
        public static IntList squareListIterative (IntList L){
            if (L == null) {
                return null;
            }
            IntList res = new IntList(L.item * L.item, null);
            IntList ptr = res;
            L = L.next;
            while (L != null) {
                ptr.next = new IntList(L.item * L.item, null);
                L = L.next;
                ptr = ptr.next;
            }
            return res;
        }

        /** Returns a list equal to L with all elements squared. Non-destructive.
         *
         * @param L list to non-destructively square.
         * @return the squared list.
         */
        public static IntList squareListRecursive (IntList L){
            if (L == null) {
                return null;
            }
            return new IntList(L.item * L.item, squareListRecursive(L.next));
        }

        /**
         * Returns a new IntList consisting of A followed by B,
         * destructively.
         *
         * @param A list to be on the front of the new list.
         * @param B list to be on the back of the new list.
         * @return new list with A followed by B.
         */
        public static IntList dcatenate (IntList A, IntList B){
            IntList C = A;
            for (int i = 0; i < A.iterativeSize(); i++){
                C = C.next;
            }
            C.next = B;
            return A;
        }

        /**
         * Returns a new IntList consisting of A followed by B,
         * non-destructively.
         *
         * @param A list to be on the front of the new list.
         * @param B list to be on the back of the new list.
         * @return new list with A followed by B.
         */
        public static IntList catenate (IntList A, IntList B){
            IntList Z = new IntList(0, null);
            IntList C = Z;
            for (int i = 0; i < A.iterativeSize(); i++){
                C.item = A.item;
                C = C.next;
                A = A.next;
            }
            return dcatenate(C,B);
            }
        }

