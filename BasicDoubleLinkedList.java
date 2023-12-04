import java.util.ArrayList;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Comparator;

public class BasicDoubleLinkedList<T> implements Iterable<T> {

    protected class Node {
	    
        T data;
        Node prev;
        Node next;

        Node(T data) {
        	
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    protected class DoubleLinkedListIterator implements ListIterator<T> {
    	
        private Node current;
        private int index;

        DoubleLinkedListIterator() {
        	
            current = head;
            index = 0;
        }

        @Override
        public boolean hasNext() {
        	
            return current != null;
        }

        @Override
        public T next() {
        	
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            
            T data = current.data;
            current = current.next;
            index++;
            
            return data;
        }

        @Override
        public boolean hasPrevious() {
        	
            return index > 0;
        }

        @Override
        public T previous() {
        	
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            
            if (current == null) {
                current = tail;
            } 
            
            else {
                current = current.prev;
            }
            
            index--;
            
            return current.data;
        }
        public void remove() {
        	
            throw new UnsupportedOperationException();
        }

		@Override
		public int nextIndex() {
			
			if (hasNext()) {
	            return index;
	        } 
			
			else {
	            return size;
	        }
		}

		@Override
		public int previousIndex() {
			
			if (hasPrevious()) {
	            return index - 1;
	        } 
			
			else {
	            return -1;
	        }
		}

		@Override
		public void set(T e) {
			
			throw new UnsupportedOperationException();
			
		}

		@Override
		public void add(T e) {
			
			throw new UnsupportedOperationException();
			
		}
    }

    protected Node head;
    protected Node tail;
    protected int size;

    public BasicDoubleLinkedList() {
    	
        head = null;
        tail = null;
        size = 0;
    }

    public int getSize() {
    	
        return size;
    }

    public void addToEnd(T data) {
    	
        Node newNode = new Node(data);
        
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } 
        
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        
        size++;
    }

    public void addToFront(T data) {
    	
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
            tail = newNode;
        } 
        
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        
        size++;
    }

    public T getFirst() {
    	
        if (head == null) {
            return null;
        }
        
        return head.data;
    }

    public T getLast() {
    	
        if (tail == null) {
            return null;
        }
        
        return tail.data;
    }

    public ListIterator<T> iterator() {
    	
        return new DoubleLinkedListIterator();
    }

    public Node remove(T targetData, Comparator<T> comparator) {
    	
        Node current = head;
        
        while (current != null) {
        	
            if (comparator.compare(current.data, targetData) == 0) {
            	
                if (current == head) {
                	head = current.next;
                	
                    if (head != null) {
                    	head.prev = null;
                    }
                    
                    else {
                        tail = null;
                    }
                } 
                
               else if (current == tail) {
                    tail = current.prev;
                    tail.next = null;
                } 
                
              else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                
               size--;
               
               return current;
            }
            
           current = current.next;
           
        }
        
       return null;
    }

    public T retrieveFirstElement() {
    	
        if (head == null) {
            return null;
        }
        
        T data = head.data;
        head = head.next;
        
        if (head != null) {
            head.prev = null;
        } 
        
        else {
            tail = null;
        }
        
        size--;
        
        return data;
    }

    public T retrieveLastElement() {
    	
        if (tail == null) {
            return null;
        }
        
        T data = tail.data;
        tail = tail.prev;
        
        if (tail != null) {
            tail.next = null;
        } 
        
        else {
            head = null;
        }
        
        size--;
        
        return data;
    }

    public ArrayList<T> toArrayList() {
    	
        ArrayList<T> list = new ArrayList<>();
        Node current = head;
        
        while (current != null) {
            list.add(current.data);
            current = current.next;
        }
        
        return list;
    }
}
