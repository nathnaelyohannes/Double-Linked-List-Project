import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;
import java.util.Iterator;

public class SortedDoubleLinkedList_STUDENT_Test {

    @Test
    public void testAdd() {
        Comparator<Integer> intComparator = Integer::compareTo;
        SortedDoubleLinkedList<Integer> list = new SortedDoubleLinkedList<>(intComparator);

        list.add(5);
        list.add(3);
        list.add(10);

        assertEquals(3, (int) list.getFirst());
        assertEquals(10, (int) list.getLast());
    }

    @Test
    public void testGetSize() {
        Comparator<Integer> intComparator = Integer::compareTo;
        SortedDoubleLinkedList<Integer> list = new SortedDoubleLinkedList<>(intComparator);

        list.add(5);
        list.add(3);
        list.add(10);

        assertEquals(3, list.getSize());
    }

    @Test
    public void testGetFirst() {
        Comparator<String> stringComparator = String::compareTo;
        SortedDoubleLinkedList<String> list = new SortedDoubleLinkedList<>(stringComparator);

        list.add("Banana");
        list.add("Cherry");
        list.add("Apple");

        assertEquals("Apple", list.getFirst());
    }

    @Test
    public void testGetLast() {
        Comparator<String> stringComparator = String::compareTo;
        SortedDoubleLinkedList<String> list = new SortedDoubleLinkedList<>(stringComparator);

        list.add("Banana");
        list.add("Cherry");
        list.add("Apple");

        assertEquals("Cherry", list.getLast());
    }

    @Test
    public void testIterator() {
        Comparator<String> stringComparator = String::compareTo;
        SortedDoubleLinkedList<String> list = new SortedDoubleLinkedList<>(stringComparator);

        list.add("Banana");
        list.add("Cherry");
        list.add("Apple");

        Iterator<String> iterator = list.iterator();
        StringBuilder result = new StringBuilder();
        while (iterator.hasNext()) {
            result.append(iterator.next());
        }
        assertEquals("AppleBananaCherry", result.toString());
    }

    @Test
    public void testRetrieveFirstElement() {
        Comparator<Integer> intComparator = Integer::compareTo;
        SortedDoubleLinkedList<Integer> list = new SortedDoubleLinkedList<>(intComparator);

        list.add(5);
        list.add(3);
        list.add(10);

        assertEquals(3, (int) list.retrieveFirstElement());
    }

    @Test
    public void testRetrieveLastElement() {
        Comparator<Integer> intComparator = Integer::compareTo;
        SortedDoubleLinkedList<Integer> list = new SortedDoubleLinkedList<>(intComparator);

        list.add(5);
        list.add(3);
        list.add(10);

        assertEquals(10, (int) list.retrieveLastElement());
    }
}
