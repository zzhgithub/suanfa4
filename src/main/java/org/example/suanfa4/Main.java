package org.example.suanfa4;

import edu.princeton.cs.algs4.StdIn;
import org.example.suanfa4.uf.FastFind;
import org.example.suanfa4.uf.UF;

public class Main {
    public static void main(String[] args) {
        System.out.println("testing!");
        int N = StdIn.readInt();
        UF uf = new FastFind(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            System.out.println(p + " " + q);
        }
        System.out.println(uf.count()+" group");
    }
}
