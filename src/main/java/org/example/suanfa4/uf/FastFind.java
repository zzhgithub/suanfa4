package org.example.suanfa4.uf;

/**
 * 快速查找法
 *
 * @author zhouzihao
 */
public class FastFind extends UF {

    public FastFind(int n) {
        super(n);
    }

    /**
     * @param p int
     * @param q int
     */
    @Override
    public void union(int p, int q) {
        int groupP = find(p);
        int groupQ = find(q);
        if (groupP == groupQ) return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == groupP) {
                id[i] = groupQ;
            }
        }
        count--;
    }
}
