package org.example.suanfa4.gp;

public interface Graph {

    /**
     * 顶点个数
     *
     * @return
     */
    int V();

    /**
     * 边个数
     *
     * @return
     */
    int E();

    /**
     * 添加边
     *
     * @param v
     * @param w
     */
    void addEdge(int v, int w);

    /**
     * 获取相邻顶点
     *
     * @param v
     * @return
     */
    Iterable<Integer> adj(int v);

    /**
     * 计算节点度数
     *
     * @param v
     * @return
     */
    default int degree(int v) {
        int degree = 0;
        for (int w : this.adj(v)) {
            degree++;
        }
        return degree;
    }

    /**
     * 获取最大的度数
     *
     * @return
     */
    default int MaxDegree() {
        int max = 0;
        for (int v = 0; v < this.V(); v++) {
            if (this.degree(v) > max) {
                max = this.degree(v);
            }
        }
        return max;
    }

    /**
     * 计算节点平均度数
     *
     * @return
     */
    default double avgDegree() {
        return 2.0 * this.E() / this.V();
    }

    /**
     * 统计自环个数
     *
     * @return
     */
    default int numberOfSelfLoop() {
        int count = 0;
        for (int v = 0; v < this.V(); v++) {
            for (int w : this.adj(v)) {
                if (v == w) count++;
            }
        }
        return count / 2;
    }
}
