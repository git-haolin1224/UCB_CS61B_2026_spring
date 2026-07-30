import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayDeque61B <T> implements Deque61B<T> {
    private int size;
    private T[] items;
    private int nextFirst;
    private int nextLast;


    public ArrayDeque61B(){
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;

    }

    public int minusOne(int index){
        if(index - 1 < 0){
             index = items.length - 1;
        }
        else{
            index -= 1;
        }
        return index;
    }

    public int plusOne(int index){
        if(index + 1 > items.length-1){
            index = 0;
        }
        else{
            index += 1;
        }
        return index;

    }

    /**
     * Add {@code x} to the front of the deque. Assumes {@code x} is never null.
     *
     * @param x item to add
     */
    @Override

    public void addFirst(T x) {
        if(size == items.length){
            this.resizeup();
        }
        items[nextFirst] = x;
        nextFirst = minusOne(nextFirst);
        size += 1;
    }

    /**
     * Add {@code x} to the back of the deque. Assumes {@code x} is never null.
     *
     * @param x item to add
     */
    @Override
    public void addLast(T x) {
        if(size == items.length){
            this.resizeup();
        }
        items[nextLast] = x;
        nextLast = plusOne(nextLast);
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
        int pointer = plusOne(nextFirst);
        for(int i = 0; i < size; i++){
            returnList.add(items[pointer]);
            pointer = plusOne(pointer);
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
        if(size == 0){
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
        if(size==0){
            return null;
        }
        else{
            return items[plusOne(nextFirst)];
        }
    }

    /**
     * Return the element at the back of the deque, if it exists.
     *
     * @return element, otherwise {@code null}.
     */
    @Override
    public T getLast() {
        if(size == 0){
            return null;
        }
        else{
            return items[minusOne(nextLast)];
        }
    }

    /**
     * Remove and return the element at the front of the deque, if it exists.
     *
     * @return removed element, otherwise {@code null}.
     */
    @Override
    public T removeFirst() {
        if(size == 0){
            return null;
        }
        T result = items[plusOne(nextFirst)];
        items[plusOne(nextFirst)] = null;
        nextFirst = plusOne(nextFirst);
        size = size - 1;
        if (size <= items.length * 0.25 && items.length>=16) {
            this.resizedown();
        }
        return result;

    }

    /**
     * Remove and return the element at the back of the deque, if it exists.
     *
     * @return removed element, otherwise {@code null}.
     */
    @Override
    public T removeLast() {
        if(size == 0){
            return null;
        }
        T result = items[minusOne(nextLast)];
        items[minusOne(nextLast)] = null;
        nextLast = minusOne(nextLast);
        size = size - 1;
        if (size <= items.length * 0.25 && items.length>=16) {
            this.resizedown();
        }
        return result;
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
        if(index > size-1){
            return null;
        }
        if(index < 0){
            return null;
        }
        else{
            index = (index + plusOne(nextFirst)) % items.length;
            T result = items[index];
            return result;
        }
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
        throw new UnsupportedOperationException("No need to implement getRecursive for ArrayDeque.");
    }

    public void resize(int Capacity){
        T[] resize = null;
        resize = (T[]) new Object[Capacity];
        int pointer = plusOne(nextFirst);
        for(int i = 0; i < size; i++){
            if(pointer >= items.length){
                resize[i] = items[pointer-items.length];
            }
            else{
                resize[i] = items[pointer];
            }
            pointer = pointer + 1;
        }
        items = resize;
        nextFirst = Capacity-1;
        nextLast = size;
    }

    public void resizeup() {
        this.resize(items.length * 2);
    }

    public void resizedown() {
        this.resize(items.length / 2);
    }

    @Override
    public Iterator<T> iterator(){
        return new ArrayDequeIterator();
    }

    public class ArrayDequeIterator implements Iterator<T> {
        public int arrayPos;

        public ArrayDequeIterator(){
            arrayPos = 0;
        }        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        public boolean hasNext() {
            return arrayPos < size;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        public T next() {
            T returnItem = items[arrayPos];
            arrayPos += 1;
            return returnItem;
        }
    }

    @Override
    public boolean equals(Object other){
        if(other instanceof ArrayDeque61B obj ){
            if(obj.size != this.size){
                return false;
            }
            for(int i = 0; i < this.size; i++){
                if(obj.get(i)!=this.get(i)){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override

    public String toString(){
        if(size == 0){
            return "[]";
        }
        else {
            String returnString = "[";
            for (int i = 0; i < size - 1; i++) {
                returnString += this.get(i);
                returnString += ", ";
            }
            returnString += this.get(size - 1);
            returnString += "]";
            return returnString;
        }
    }


}
