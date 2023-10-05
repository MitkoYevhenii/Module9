package ua.goit.module9;

public class MyHashMap {
    private static final int DEFAULT_CAPACITY = 16;
    private Node[] table;
    private int size;

    public MyHashMap() {
        table = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public void put(Object key, Object value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        int hash = key.hashCode();
        int index = hash % table.length;

        Node newNode = new Node(key, value);

        if (table[index] == null) {
            table[index] = newNode;
            size++;
        } else {
            Node currentNode = table[index];
            Node prevNode = null;

            while (currentNode != null) {
                if (currentNode.key.equals(key)) {
                    currentNode.value = value;
                    return;
                }

                prevNode = currentNode;
                currentNode = currentNode.next;
            }

            prevNode.next = newNode;
            size++;
        }

        if ((double) size / table.length >= 0.75) {
            resize();
        }
    }

    public void remove(Object key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        int hash = key.hashCode();
        int index = hash % table.length;

        Node currentNode = table[index];
        Node prevNode = null;

        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                if (prevNode == null) {
                    table[index] = currentNode.next;
                } else {
                    prevNode.next = currentNode.next;
                }
                size--;
                return;
            }

            prevNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    public void clear() {
        table = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    private static class Node {
        Object key;
        Object value;
        Node next;

        public Node(Object key, Object value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private void resize() {
        int newCapacity = table.length * 2;
        Node[] newTable = new Node[newCapacity];

        for (Node node : table) {
            while (node != null) {
                int newIndex = node.key.hashCode() % newCapacity;

                Node newNode = new Node(node.key, node.value);
                newNode.next = newTable[newIndex];
                newTable[newIndex] = newNode;

                node = node.next;
            }
        }

        table = newTable;
    }
}

