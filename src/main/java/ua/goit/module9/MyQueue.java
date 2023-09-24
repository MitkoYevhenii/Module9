package ua.goit.module9;

import java.util.LinkedList;

public class MyQueue {
    private LinkedList<Object> queue = new LinkedList<Object>();

    public void add(Object value) {
        queue.addLast(value);
    }

    public void clear() {
        queue.clear();
    }

    public int size() {
        return queue.size();
    }

    public Object peek() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.getFirst();
    }

    public Object poll() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.removeFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void printQueue() {
        System.out.println(queue);
    }
}
