public class myDigraph {

    int [ ][ ] matrix; // this is the actual adjacency matrix
    boolean [] visited; // array of Booleans to indicate if vertex has been previously visited
    myQueue Q;


    //initializing the matrix of size V*V
    public myDigraph(int numV){
        matrix = new int[numV][numV];

        for(int i =0; i< numV; i++){
            for(int j = 0; j< numV; j++){
                matrix[i][j] = -1;
            }
        }

        visited = new boolean[numV];
        for(int i = 0; i<numV; i++){
            visited[i]= false;
        }


        Q = new myQueue(numV);

    }

    //creating the edges of the graph
    public void addEdges(int x, int y, int w){
        matrix[x][y]=w;
    }

    //setting all the values to False at first
    public void clearVisited(){

        for(int i = 0; i<visited.length; i++){
            visited[i] = false;
        }
    }

    //returns if the element is visited or not
    public boolean getVisited(int v){
        return visited[v];
    }

    //Depth First Search
    public void DFS(int v){
        if (visited[v]) {return;}

        visited[v]=true;
        System.out.println("Vertex: "+ v);
        for(int i = 0; i<matrix.length;i++ ){
            if (matrix[v][i]!= -1 && !visited[i]){
                DFS(i);
            }
        }


    }

    //Breadth First Search
    public void BFS(int v){
        if (visited[v]) return;

        int len = matrix.length;
        visited[v]= true;
        System.out.println("Vertex: "+v);

        //adding the element
        for(int y = 0; y<len; y++) {
            if (matrix[v][y] != -1) {
                Q.enqueue(y);
            }
        }
            //deleting the element
            if(!Q.isEmpty()){
               BFS(Q.dequeue());
            }else {
                return;


        }

    }


}
