package org.example.suanfa4.uf;

/**
 * 每个id中的值变量表示一个指向同类别的下一个节点
 * 当找到自己指向自己的节点时  为根节点
 * 并且一开始大家都是根节点
 * 链接操作是 一个根指向另外一个根
 */
public class QuickUnion extends UF {

    public QuickUnion(int n) {
        super(n);
    }

    /**
     * 寻找根节点
     * 妈的 真他么 优雅！
     * @param p int
     * @return
     */
    @Override
    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    @Override
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) return;
        id[rootP] = rootQ;
        count--;
    }
}
