import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Driver4 {
public static Scanner input;
public static File f;
public static String fname;

    public static void main(String[] args) throws IOException {
        System.out.print("Please enter a path or name of input file: ");
        input = new Scanner(System.in);
        //taking filename from user
        fname = input.nextLine();
        //reading file the user provided
        f = new File(fname);

        try{
            input = new Scanner(f);
        }catch (Exception E){
            System.out.println("File not found!");
        }

        //reading the vertices and edges from the first line of file
//        FileReader fr = new FileReader(f);
//        BufferedReader br = new BufferedReader(fr);
//        String line = br.readLine();
//        String[] parts = line.split(" ");
//        int numV = Integer.parseInt(parts[0]);
//        int edges = Integer.parseInt(parts[1]);
//
//
//        //instantiating myDigraph object
//        myDigraph graph = new myDigraph(numV) ;
//
//        //iterating the file to find out the edges
//        for(int i=0; i<edges; i++){
//            String[] li =br.readLine().split(" ");
//            int v = Integer.parseInt(li[0]);
//            int edge = Integer.parseInt(li[1]);
//            int weight = Integer.parseInt(li[2]);
//
//            graph.addEdges(v, edge, weight);
//        }
//
//        br.close();

        int numV = input.nextInt();
        int numE= input.nextInt();

        myDigraph graph = new myDigraph(numV);

        for(int i=0; i<numE; i++){
            int v = input.nextInt();
            int e = input.nextInt();
            int w = input.nextInt();

            graph.addEdges(v, e, w);
        }

        input.close();


        //performing DFS and BFS

        System.out.println("*** DEPTH FIRST SEARCH ***");
        for(int x=0; x<numV; x++){
            if(graph.visited[x]) continue;

            graph.DFS(x);
        }

        graph.clearVisited();


        System.out.println("### BREADTH FIRST SEARCH ###");
        for(int x=0; x<numV; x++){

            if(graph.visited[x])  continue;
            graph.BFS(x);
        }

//        System.out.println("Visited Vertices: ");
//        for(int i=0; i<numV; i++){
//            if (graph.visited[i]){
//                System.out.println("Vertex: "+ i);
//            }
//        }







    }
}
