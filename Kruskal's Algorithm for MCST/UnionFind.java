public class UnionFind{
    // array to hold all the subset
    protected int[] parent;

    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int Find(int x) {
        if (parent[x] != x) {
            parent[x] = Find(parent[x]);
        }
        return parent[x];
    }

    public void Union(int x, int y) {
        int rootX = Find(x);
        int rootY = Find(y);
        parent[rootX] = rootY;
    }


    public int Size() {
        // counting the roots found in the parent[] and return it
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i) {
                count++;
            }
        }
        return count;
    }
}
