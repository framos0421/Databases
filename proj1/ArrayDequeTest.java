import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    public void yourTestHere() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();

        ad1.addFirst(0);
        assertEquals(1, ad1.size());

        ad1.addFirst(-1);
        assertEquals(2, ad1.size());

        ad1.addLast(1);
        assertEquals(3, ad1.size());

        ad1.addLast(2);
        assertEquals(4, ad1.size());

        ad1.addFirst(-2);
        assertEquals(5, ad1.size());

        ad1.addLast(3);
        assertEquals(6, ad1.size());

        ad1.addFirst(-3);
        assertEquals(7, ad1.size());

        ad1.addLast(4);
        assertEquals(8, ad1.size());
        System.out.println("before resizing works");

        ad1.addFirst(-4);
        assertEquals(9, ad1.size());

        //ad1.removeFirst();
        int a = ad1.removeFirst();
        assertEquals(-4, a);
        assertEquals(8, ad1.size());

        ad1.printDeque();

        //ad1.get(3);
        //int b = ad1.get(3);
        //assertEquals(1, b);

        //ad1.removeLast();
        int c = ad1.removeLast();
        assertEquals(4, c);

        ad1.printDeque();

    }

    @Test
    public void yourTest2Here() {
        ArrayDeque<Integer> ad2 = new ArrayDeque<>();
        ad2.addFirst(0);

        ad2.addFirst(1);

        ad2.addLast(2);

        ad2.get(1);

        ad2.removeLast();

        ad2.removeFirst();

        ad2.addLast(6);

        ad2.removeFirst();

        ad2.removeLast();

        ad2.addFirst(9);

        ad2.addLast(10);

        ad2.addFirst(11);

        ad2.get(0);

        ad2.addLast(13);

        ad2.addLast(14);

        ad2.addFirst(15);

        ad2.addFirst(16);

        ad2.addFirst(17);

        ad2.addFirst(18);

        ad2.addLast(19);

        ad2.addFirst(20);

        ad2.removeLast();

        ad2.get(2);
        System.out.println(ad2.get(2) + "get works" + ad2.size());

        ad2.removeFirst();
        ad2.removeLast();

        ad2.removeFirst();
        ad2.removeLast();

        ad2.removeFirst();
        ad2.removeLast();

        ad2.removeLast();




    }
}
