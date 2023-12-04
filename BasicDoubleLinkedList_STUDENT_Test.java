import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BasicDoubleLinkedList_STUDENT_Test {

    @Test
    public void testGetSize() {
        BasicDoubleLinkedList<Integer> list = new BasicDoubleLinkedList<>();
        assertEquals(0, list.getSize());
        list.addToEnd(1);
        assertEquals(1, list.getSize());
        list.addToFront(2);
        assertEquals(2, list.getSize());
    }

    @Test
    public void testAddToEnd() {
        BasicDoubleLinkedList<String> list = new BasicDoubleLinkedList<>();
        list.addToEnd("Hello");
        assertEquals("Hello", list.getLast());
        list.addToEnd("World");
        assertEquals("World", list.getLast());
    }

    @Test
    public void testAddToFront() {
        BasicDoubleLinkedList<Integer> list = new BasicDoubleLinkedList<>();
        list.addToFront(2);
        assertEquals(2, (int) list.getFirst());
        list.addToFront(1);
        assertEquals(1, (int) list.getFirst());
    }

    @Test
    public void testGetFirst() {
        BasicDoubleLinkedList<Integer> list = new BasicDoubleLinkedList<>();
        list.addToFront(1);
        assertEquals(1, (int) list.getFirst());
        list.addToFront(2);
        assertEquals(2, (int) list.getFirst());
    }

    @Test
    public void testGetLast() {
        BasicDoubleLinkedList<String> list = new BasicDoubleLinkedList<>();
        list.addToEnd("Hello");
        assertEquals("Hello", list.getLast());
        list.addToEnd("World");
        assertEquals("World", list.getLast());
    }

    @Test
    public void testRetrieveFirstElement() {
        BasicDoubleLinkedList<Character> list = new BasicDoubleLinkedList<>();
        list.addToEnd('A');
        list.addToEnd('B');
        assertEquals('A', (char) list.retrieveFirstElement());
        assertEquals('B', (char) list.retrieveFirstElement());
    }

    @Test
    public void testRetrieveLastElement() {
        BasicDoubleLinkedList<Integer> list = new BasicDoubleLinkedList<>();
        list.addToEnd(1);
        list.addToEnd(2);
        assertEquals(2, (int) list.retrieveLastElement());
        assertEquals(1, (int) list.retrieveLastElement());
    }
}
