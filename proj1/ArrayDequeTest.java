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

    }
}
