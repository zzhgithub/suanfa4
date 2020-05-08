package org.example.suanfa4.st;

/**
 * 符号表数据类型
 *
 * @param <Key>
 * @param <Value>
 */
public class ST<Key extends Comparable<Key>, Value> {
    public ST() {
    }

    void put(Key key, Value value) {

    }

    Value get(Key key) {
        return null;
    }

    void delete(Key key) {
        put(key, null);
    }

    boolean contains(Key key) {
        return get(key) != null;
    }

    boolean isEmpty() {
        return size() == 0;
    }

    int size() {
        return 0;
    }

    Key min() {
        return null;
    }

    Key max() {
        return null;
    }

    Key floor(Key key) {
        return null;
    }

    Key ceiling(Key key) {
        return null;
    }

    int rank(Key key) {
        return 0;
    }

    Key select(int k) {
        return null;
    }

    void deleteMin() {
        delete(min());
    }

    void deleteMax() {
        delete(max());
    }

    int size(Key lo, Key hi) {
        if (hi.compareTo(lo) < 0) {
            return 0;
        } else if (contains(hi)) {
            return rank(hi) - rank(lo) + 1;
        } else {
            return rank(hi) - rank(lo);
        }
    }

    Iterable<Key> Keys(Key lo, Key hi) {
        return null;
    }

    Iterable<Key> Keys() {
        return Keys(min(), max());
    }

    public static void main(String[] args) {
        //
    }
}
