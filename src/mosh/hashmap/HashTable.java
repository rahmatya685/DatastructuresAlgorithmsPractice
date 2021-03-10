package mosh.hashmap;

import java.util.LinkedList;

public class HashTable {

    private int capacity = 5;

    private LinkedList<Pair>[] array = new LinkedList[capacity];

    public void put(int key, String value) {
        var index = hash(key);
        if (array[index] == null)
            array[index] = new LinkedList<>();
        for (Pair pair : array[index]) {
            if (pair.key == key) {
                pair.value = value;
                return;
            }
        }
        array[index].push(new Pair(key, value));
    }

    public String get(int key) {
        var index = hash(key);
        var bucket = array[index];
        if (bucket != null)
            for (Pair pair : bucket) {
                if (pair.key == key)
                    return pair.value;
            }
        return null;
    }

    private int hash(int key) {
        return key % capacity;
    }

    private class Pair {
        int key;
        String value;

        public Pair(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" +
                    "" + key +
                    "=" + value +
                    '}';
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (LinkedList<Pair> pairs : array) {
            if (pairs != null)
                for (Pair pair : pairs) {
                    stringBuilder.append(pair.toString());
                }
        }

        return stringBuilder.toString();
    }
}
