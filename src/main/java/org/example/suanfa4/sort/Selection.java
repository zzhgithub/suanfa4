package org.example.suanfa4.sort;

import edu.princeton.cs.algs4.StdIn;

/**
 * 选择排序算法
 */
public class Selection {

    /**
     * 排序实现
     *
     * @param a
     */
    static void sort(Comparable[] a) {
        int N = a.length;
        for (int i=0;i<N;i++){
            int min = i;
            for (int j=i+1;j<N;j++){
                if (less(a[j],a[min])) {
                    min=j;
                }
            }
            exch(a,i,min);
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
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
