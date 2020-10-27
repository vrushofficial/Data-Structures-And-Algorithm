package graph;

class Prims {

    private static final int size = 5;

    public static void main(String[] args) {

        int[][] graph = new int[][]{{0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}};

        new Prims().primMST(graph);
    }

    int getMin(int[] adjacent, Boolean[] mstSet) {
        int min = Integer.MAX_VALUE, result = -1;

        for (int i = 0; i < size; i++)
            if (mstSet[i] == false && adjacent[i] < min) {
                min = adjacent[i];
                result = i;
            }
        return result;
    }

   int[] primMST(int[][] graph) {
        int[] parent = new int[size];
        int[] adjacent = new int[size];

        Boolean[] mstSet = new Boolean[size];

        for (int i = 0; i < size; i++) {
            adjacent[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

       adjacent[0] = 0;
        parent[0] = -1;
        for (int count = 0; count < size - 1; count++) {

            int min = getMin(adjacent, mstSet);
            mstSet[min] = true;
            for (int v = 0; v < size; v++)

                if (graph[min][v] != 0 && mstSet[v] == false && graph[min][v] < adjacent[v]) {
                    parent[v] = min;
                    adjacent[v] = graph[min][v];
                }
        }
        return parent;
    }
}
