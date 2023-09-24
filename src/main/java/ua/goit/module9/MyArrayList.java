package ua.goit.module9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private T[] array;
    private int size;

    public MyArrayList() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            array = (T[]) new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            array = (T[]) EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+  initialCapacity);
        }
    }

    public void add(T value) {
        if (size >= array.length) {
            int newCapacity = (array.length * 3) / 2 + 1;
            T[] newData = (T[]) new Object[newCapacity];

            for (int i = 0; i < size; i++) {
                newData[i] = array[i];
            }

            array = newData;
        }
        array[size] = value;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        array[--size] = null;

    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int index) {
        return array[index];
    }

    private void ensureCapacity() {
        if (size == array.length) {
            int newCapacity = (array.length * 3) / 2 + 1;
            array = Arrays.copyOf(array, newCapacity);
        }
    }
}

class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayList<>(1);
        myArrayList.add("piski");
        myArrayList.add("popki");
        myArrayList.add("Bobki");
        myArrayList.add("Loli");
        System.out.println("myArrayList size: " + myArrayList.size());
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i));
        }

        System.out.println("\n");
        myArrayList.remove(0);
        myArrayList.remove(0);
        System.out.println("myArrayList size: " + myArrayList.size());
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i));
        }
        myArrayList.clear();

        List<String> list = new ArrayList<>();
    }
}

