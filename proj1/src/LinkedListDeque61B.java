import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.ArrayList;

public class LinkedListDeque61B<T> implements Deque61B<T> {

    private static final Logger log = LoggerFactory.getLogger(LinkedListDeque61B.class);

    private Node sentinel;
    private int size;

    class Node {
        private T value;
        private Node prev;
        public Node next;

        public Node(T value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public LinkedListDeque61B() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }


    /**
     * Add {@code x} to the front of the deque. Assumes {@code x} is never null.
     *
     * @param x item to add
     */
    @Override
    public void addFirst(T x) {
        Node first = new Node(x, sentinel, sentinel.next);
        sentinel.next.prev = first;
        sentinel.next = first;
        size += 1;
    }

    /**
     * Add {@code x} to the back of the deque. Assumes {@code x} is never null.
     *
     * @param x item to add
     */
    @Override
    public void addLast(T x) {
        Node last = new Node(x, sentinel.prev, sentinel);
        sentinel.prev.next = last;
        sentinel.prev = last;
        size += 1;

    }

    /**
     * Returns a List copy of the deque. Does not alter the deque.
     *
     * @return a new list copy of the deque.
     */
    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node app = sentinel;
        while (app.next != sentinel) {
            returnList.add(app.next.value);
            app = app.next;
        }
        return returnList;
    }

    /**
     * Returns if the deque is empty. Does not alter the deque.
     *
     * @return {@code true} if the deque has no elements, {@code false} otherwise.
     */
    @Override
    public boolean isEmpty() {
        Node app = sentinel;
        if (app.next == sentinel) {
            return true;
        }
        return false;
    }

    /**
     * Returns the size of the deque. Does not alter the deque.
     *
     * @return the number of items in the deque.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Return the element at the front of the deque, if it exists.
     *
     * @return element, otherwise {@code null}.
     */
    @Override
    public T getFirst() {
        if (sentinel.next != sentinel) {
            return sentinel.next.value;
        }
        return null;
    }

    /**
     * Return the element at the back of the deque, if it exists.
     *
     * @return element, otherwise {@code null}.
     */
    @Override
    public T getLast() {
        if (sentinel.prev != sentinel) {
            return sentinel.prev.value;
        }
        return null;
    }

    /**
     * Remove and return the element at the front of the deque, if it exists.
     *
     * @return removed element, otherwise {@code null}.
     */
    @Override
    public T removeFirst() {
        if (sentinel.next != sentinel) {
            T firstElement = sentinel.next.value;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            return firstElement;
        }
        return null;
    }

    /**
     * Remove and return the element at the back of the deque, if it exists.
     *
     * @return removed element, otherwise {@code null}.
     */
    @Override
    public T removeLast() {
        if (sentinel.prev != sentinel) {
            T lastElement = sentinel.prev.value;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            return lastElement;
        }
        return null;
    }

    /**
     * The Deque61B abstract data type does not typically have a get method,
     * but we've included this extra operation to provide you with some
     * extra programming practice. Gets the element, iteratively. Returns
     * null if index is out of bounds. Does not alter the deque.
     *
     * @param index index to get
     * @return element at {@code index} in the deque
     */
    @Override
    public T get(int index) {
        Node app = sentinel;
        while (app.next != sentinel) {
            app = app.next;
            if (index < 0) {
                return null;
            }
            if (index == 0) {
                return app.value;
            }
            index -= 1;
        }
        return null;
    }

    /**
     * This method technically shouldn't be in the interface, but it's here
     * to make testing nice. Gets an element, recursively. Returns null if
     * index is out of bounds. Does not alter the deque.
     *
     * @param index index to get
     * @return element at {@code index} in the deque
     */
    @Override
    public T getRecursive(int index) {
        if (index < 0) {
            return null;
        }
        if (index == 0) {
            return sentinel.next.value;
        }
        if (sentinel.next != sentinel) {
            sentinel.next = sentinel.next.next;
            return getRecursive(index -= 1);
        }

        return null;
    }

    /**
     * another better method to tackle the final function
     */
    public T getrecursive(int index){
        if(index == 0 || index >= size){
            return null;
        }
        return(getrecursiveHelper(sentinel.next, index));
    }

    public T getrecursiveHelper(Node current, int index){
        if(index == 0){
            return current.value;
        }
        return getrecursiveHelper( current.next, index-1);

    }

}

//void main(String[] args){
//    Deque61B<Integer> lld = new LinkedListDeque61B<>();
//    lld.addLast(0);
//    lld.addLast(1);
//    lld.addFirst(-1);
//}
