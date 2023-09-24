package ua.goit.module9;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack <T> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};

    private int size;
     private T[] array;
     private T top;

    public MyStack() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public MyStack(int initialCapacity) {
        if (initialCapacity > 0) {
            array = (T[]) new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            array = (T[]) EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+  initialCapacity);
        }
    }

    public void push(T value) {
        ensureCapacity();

        array[size] = value;
        size++;
    }

    public void remove(int index) {
        if (size < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        array[size] = null;
    }

    public void clear() {
        Arrays.fill(array, 0, size, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) array[size - 1];
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        @SuppressWarnings("unchecked")
        T value = (T) array[size - 1];
        array[size - 1] = null; // Set the top element to null
        size--;

        return value;
    }

    private void ensureCapacity() {
        if (size == array.length) {
            int newCapacity = (array.length * 3) / 2 + 1;
            array = Arrays.copyOf(array, newCapacity);
        }
    }
}
