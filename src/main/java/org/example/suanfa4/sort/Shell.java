package org.example.suanfa4.sort;

import edu.princeton.cs.algs4.StdIn;

/**
 * 希尔排序
 */
public abstract class Shell {

    /**
     * 排序实现
     *
     * @param a
     */
    static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N/3){
            //选择递增数列
            //1 4 13 40 121 364 1093
            h = 3*h + 1;
        }
        while (h >= 1){
            for (int i=h;i<N;i++){
                for (int j=i;j >=h && less(a[j],a[j-h]) ;j-=h){
                    exch(a,j,j-h);
                }
            }
            h = h/3;
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
