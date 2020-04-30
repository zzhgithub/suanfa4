package org.example.suanfa4.uf;

public abstract class UF {

    protected int[] id;
    protected int count;

    /**
     * init n UF node
     *
     * @param n int
     */
    public UF(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    /**
     * connect node p and q
     *
     * @param p int
     * @param q int
     */
    public abstract void union(int p, int q);

    /**
     * find node p in which group
     *
     * @param p int
     * @return int
     */
    public int find(int p) {
        return id[p];
    }

    /**
     * figure out weather node p,q in the same group or not
     *
     * @param p int
     * @param q int
     * @return boolean
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * total group nums
     *
     * @return int
     */
    public int count() {
        return count;
    }
}
