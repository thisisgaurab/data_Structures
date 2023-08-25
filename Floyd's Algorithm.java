import java.io.*;
import java.util.*;

class Driver6 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a file name/path : ");
        String fileName = input.nextLine();
        File file = new File(fileName);
        Scanner inputFile = new Scanner(file);
        int V = inputFile.nextInt();
        int E = inputFile.nextInt();
        int[][] w = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i != j) {
                    w[i][j] = 100000;
                }
            }
        }
        for (int i = 0; i < E; i++) {
            int u = inputFile.nextInt();
            int v = inputFile.nextInt();
            int weight = inputFile.nextInt();
            w[u][v] = weight;
        }
        inputFile.close();
        int[][] dist = new int[V][V];
        int[][] prev = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = w[i][j];
                if (w[i][j] != 100000 && i != j) {
                    prev[i][j] = i;
                } else {
                    prev[i][j] = -1;
                }
            }
        }

        //Floyd's algorithm
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        prev[i][j] = prev[k][j];
                    }
                }
            }
        }
        while (true) {
            System.out.print("Please enter a pair of vertices for shortest path or -1 -1 to end : ");
            int x = input.nextInt();
            int y = input.nextInt();
            if (x == -1 && y == -1) {
                break;
            }
            if (dist[x][y] == 100000) {
                System.out.println("There is no path from " + x + " to " + y);
            } else {
                System.out.println("Shortest path from " + x + " to " + y + " is distance " + dist[x][y]);
                System.out.print(x);
                Stack<Integer> stack = new Stack<Integer>();
                int z = y;
                while (x != z) {
                    stack.push(z);
                    z = prev[x][z];
                }
                while (!stack.isEmpty()) {
                    System.out.print(" --> " + stack.pop());
                }
                System.out.println();
            }
        }
        input.close();
    }
}
