package org.example.suanfa4.uf;

public class RightQuickUnion extends QuickUnion {

    /**
     * 树权重
     */
    private int[] zs;

    public RightQuickUnion(int n) {
        super(n);
        zs = new int[n];
        for (int i = 0; i < n; i++) {
            zs[i] = 1;
        }
    }


    @Override
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        // 小树 指向大树
        if(zs[rootP] < zs[rootQ]){
            id[rootP] = rootQ;
            zs[rootQ] += zs[rootP];
        }else {
            id[rootQ] = rootP;
            zs[rootP] += zs[rootQ];
        }
        count--;
    }
}
