import java.util.*;
//Implementing Depth First Traversal using Adjacency Matrix
class DFT{
    int v;
    int[][] adj;
    boolean[] visited;
    //constructor for class DFT
    DFT(int v){
        this.v=v;
        adj=new int[v][v];
        visited=new boolean[v];
    }
    //Recurrsive function call for traversing all nodes
    void traversing(int start){
        visited[start]=true;
        System.out.print(start+" ");
        for(int i=0;i<v;i++){
            if(adj[v][i]==1 && !visited[i]){
                traversing(i);
             }
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no.of vertices:");
        int v=sc.nextInt();
        DFT graph=new DFT(v);
        System.out.println("Enter adajacency matrix:");
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                graph.adj[i][j]=sc.nextInt();
             }
        }
        System.out.println("Enter starting node for traversal:");
        int start=sc.nextInt();
        System.out.println("Traversal order of the graph:");
        graph.traversing(start);
     }
}
          
