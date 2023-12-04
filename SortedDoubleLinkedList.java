import java.util.Comparator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {

    private Comparator<T> comparator;

    public SortedDoubleLinkedList(Comparator<T> comparator) {
        super();
        this.comparator = comparator;
    }

    public void add(T data) {
        Node newNode = new Node(data);
        Node current = head;
        Node previous = null;

        while (current != null && comparator.compare(current.data, data) <= 0) {
            previous = current;
            current = current.next;
        }

        if (previous == null) {
            head = newNode;
            newNode.next = current;
        } else {
            previous.next = newNode;
            newNode.next = current;
        }
        
        newNode.prev = previous;
        newNode.next = current;

        if (current == null) {
            tail = newNode;
        } else {
            current.prev = newNode;
        }

        size++;
    }
}
