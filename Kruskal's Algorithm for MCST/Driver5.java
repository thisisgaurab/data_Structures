import java.io.*;
import java.util.*;

public class Driver5 {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path of the input file: ");
        String inputFilePath = scanner.nextLine();

        try {
            // Creating and opening  file that contains graph data
            File inputFile = new File(inputFilePath);
            Scanner f = new Scanner(inputFile);

            //reading the number of vertices and edges from the graph
            int numVertices = f.nextInt();
            int numEdges = f.nextInt();

            // union find method
            UnionFind uf = new UnionFind(numVertices);

            // PriorityQueue object for storing all the edges
            PriorityQueue<EdgeNode> pq = new PriorityQueue<>();

            // loop to keep all the edge node in the priority queue
            for (int i = 0; i < numEdges; i++) {
                int vertex1 = f.nextInt();
                int vertex2 = f.nextInt();
                int weight = f.nextInt();
                EdgeNode edge = new EdgeNode(vertex1, vertex2, weight);
                pq.add(edge);
            }

            // variables to store MCST size and kruskal's cost
            int mcstSize = 0;
            int kruskalCost = 0;


            while (!pq.isEmpty() && uf.Size() > 1) {
                EdgeNode min = pq.poll();
                int x = min.getVertex1();
                int y = min.getVertex2();

                if (uf.Find(x) != uf.Find(y)) {
                    System.out.println(x + " " + y + " Weight: " + min.getWeight());
                    mcstSize++;
                    kruskalCost += min.getWeight();
                    uf.Union(x, y);
                }
            }
            if (mcstSize < numVertices - 1) {
                System.out.println("Graph is not connected");
            } else {
                System.out.println("Kruskal's Algorithm Cost : " + kruskalCost);
            }
            f.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input format");
        }

    }
}
