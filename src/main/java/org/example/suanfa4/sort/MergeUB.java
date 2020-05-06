package org.example.suanfa4.sort;

import edu.princeton.cs.algs4.StdIn;

/**
 * 归并排序
 */
public abstract class MergeUB {

    private static Comparable[] aux;

    /**
     * 数组局部归并
     *
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    /**
     * 排序实现
     *
     * @param a
     */
    static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        // lgN
        for (int sz = 1; sz < N; sz = sz + sz) { // sz子数据大小
            for (int lo = 0; lo < N - sz; lo += sz + sz) { // lo子数组索引
                // 注意每次调用的角标！
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
//                System.out.println(lo + ":" + (lo + sz - 1) + ":" + Math.min(lo + sz + sz + 1, N - 1));
            }
            show(a);
        }

    }

    static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
//        String[] a = {"S", "O", "P", "I", "K", "U", "G", "H", "Q", "A", "N", "G"};
        sort(a);
//        Integer[] a = {3, 5, 1, 2};
//        aux = new Comparable[a.length];

//        merge(a, 0, 1, 3);
//        show(a);
//        assert isSorted(a);
        System.out.println("+++++++++++++++++++");
        show(a);
    }
}
