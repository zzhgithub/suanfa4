package org.example.suanfa4.pq;

/**
 * 有限队列
 * [1 2 3]
 * 二叉堆！
 * 找一个节点的子节点
 * k -> (2k,2k+1)
 * <p>
 * 找一个节点的父节点
 * k -> k/2
 *
 * @param <Key>
 */
public class MaxPQ<Key extends Comparable<Key>> {

    /**
     * pq[0] 是一个没有使用的位置,如果保存的对象是 int 可以做队大小
     * 原因是使用角标关系做了指针
     */
    private Key[] pq;

    private int N = 0;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        //todo 动态调整数据大小
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;//防止对象游离？
        // 下沉
        sink(1);
        return max;
    }

    private void exch(int i, int j) {
        Key tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    /**
     * 对特定节点进行上浮操作 从而保证堆有序
     *
     * @param k
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    /**
     * 下沉操作 保证堆有序
     *
     * @param k
     */
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
}
