import java.util.*;
//Implementing Breadth First Traversal using Adajacency Matrix
//class for performing BFS
class BFT{
    int v;
    int[][] adj;
    BFT(int v){
        this.v=v;
        adj=new int[v][v];
    }
    void traversing(int start){
        boolean[] visited=new boolean[v];
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        visited[start]=true;
        while(!q.isEmpty()){
            int vis=q.poll();
            System.out.print(vis+" ");
            for(int i=0;i<v;i++){
                if(adj[vis][i]==1 && !visited[i]){
                    q.add(i);
                    visited[i]=true;
                 }
             }
         }
    } 
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no.of vertices in graph:");
        int v=sc.nextInt();
        BFT graph=new BFT(v);
        System.out.println("Enter the Adajacency matrix:");
        //creating adajacency matrix
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                graph.adj[i][j]=sc.nextInt();
            }
        }
        System.out.println("Enter Starting vertex:");
        int start=sc.nextInt();
        System.out.println("Traversal order is:");
        //calling BFTDemo
        graph.traversing(start);
    }
}
           
        
