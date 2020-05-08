package org.example.suanfa4.st;

/**
 * 符号表数据类型
 *
 * @param <Key>
 * @param <Value>
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    void put(Key key, Value value) {
        // 查找建 存在 更新 没有 新建
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = value;
            return;
        }
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = value;
        N++;
    }

    Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return vals[i];
        } else {
            return null;
        }
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
        return N;
    }

    Key min() {
        return keys[0];
    }

    Key max() {
        return keys[N - 1];
    }    Key floor(Key key) {
        return null;
    }

    Key ceiling(Key key) {
        int k = rank(key);
        return keys[k];
    }

    // 使用迭代的方法
    int rank(Key key) {
        int lo = 0;
        int hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (lo + hi) / 2;
            int cap = key.compareTo(keys[mid]);
            if (cap < 0) hi = mid - 1;
            else if (cap > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    /**
     * 获取key小的元素的个数
     *
     * @param key
     * @param lo
     * @param hi
     * @return
     */
    int rank(Key key, int lo, int hi) {
        if (lo >= hi) {
            return lo;
        }
        int mid = lo + (lo + hi) / 2;
        int cmp = key.compareTo(keys[mid]);
        if (cmp < 0) {
            return rank(key, lo, mid - 1);
        } else if (cmp > 0) {
            return rank(key, mid + 1, hi);
        } else {
            return mid;
        }
    }


    Key select(int k) {
        return keys[k];
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
