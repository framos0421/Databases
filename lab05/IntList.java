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
        if (position <0){
            throw new IllegalArgumentException("Position out of range");
        }
        IntList p = this;
        int l = 0;
        while (l< position){
           if(p.next==null){
               throw new IllegalArgumentException("Position out of range");
           }
            p = p.next;
            l++;
        }
        return p.item;
    }

    /**
     * Returns the string representation of the list. For the list (1, 2, 3),
     * returns "1 2 3".
     *
     * @return The String representation of the list.
     */
    public String toString() {
        IntList p = this;
        String msg = "";
        while (!(p.next == null)){
            msg+= Integer.toString(p.item) +" ";
            p = p.next;
        }
        msg += p.item;
        return msg;
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
        if (obj instanceof IntList){
            if (this.iterativeSize()==((IntList) obj).iterativeSize()){
                IntList des = this;
                int p = this.iterativeSize();
                int i = 0;
                while (i<p){
                    if (des.item != ((IntList)obj).item){
                        return false;
                    }
                    des = des.next;
                    obj = ((IntList)obj).next;
                    i++;
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Adds the given value at the end of the list.
     *
     * @param value, the int to be added.
     */
    public void add(int value) {
        int p = this.iterativeSize();
        IntList des = this;
        for(int i =1; i<p;i++){
            des = des.next;
        }
        des.next = new IntList(value, null);
    }

    /**
     * Returns the smallest element in the list.
     *
     * @return smallest element in the list
     */
    public int smallest() {
        int small = this.item;
        int p = this.iterativeSize();
        IntList des = this.next;
        for( int i = 0; i<p-1;i++){
            if(des.item<small){
                small = des.item;
            }
            des = des.next;
        }
        return small;
    }

    /**
     * Returns the sum of squares of all elements in the list.
     *
     * @return The sum of squares of all elements.
     */
    public int squaredSum() {
        IntList des = this;
        int p = iterativeSize();
        int sum = 0;
        for (int i =0; i<p;i++){
            sum += des.item*des.item;
            des = des.next;

        }
        return sum;
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
    public static IntList dcatenate(IntList A, IntList B) {
        IntList C = A;
        for  (int i = 0; i < C.iterativeSize(); i++){
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
     public static IntList catenate(IntList A, IntList B) {
         IntList D = new IntList(0, null);
         IntList C = D;
         for (int i=0; i<A.iterativeSize();i++){
             C.item = A.item;
             C.next = new IntList(A.next.item,null);
             C = C.next;
             A= A.next;
         }
         IntList.dcatenate(D, B);
         return D;

     }
}
