package com.github.kurkov.disjointset;

/**
 * @author Aleksey Kurkov. Created on 07.12.2016
 */
public class DisjointSet {

    private static final int MAXN = 1000;

    private int[] p = new int[MAXN];
    private int[] rank = new int[MAXN];

    public void MakeSet(int x) {
        p[x] = x;
    }

    public int Find(int x) {
        if (p[x] == x) {
            return x;
        }

        return p[x] = Find(p[x]);
    }

    public void Unite(int x, int y) {
        x = Find(x);
        y = Find(y);

        if (rank[x] < rank[y]) {
            p[x] = y;

        } else {
            p[y] = x;
            if (rank[x] == rank[y]) {
                ++rank[x];
            }
        }
    }
}
