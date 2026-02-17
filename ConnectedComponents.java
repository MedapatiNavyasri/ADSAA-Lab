//Program to implement Biconnected Components using DFS
import java.util.Scanner;
//Class to find Connected Components
class ConnectedComponents{
        int[][] adj;
        int v;
        boolean[] visited;
        //Constructor
        ConnectedComponents(int v){
            this.v=v;
            adj=new int[v][v];
            visited=new boolean[v];
        }
        //Performing Depth First Traversal
        void dfs(int i){
            visited[i]=true;
            System.out.print(i+" ");
            for(int j=0;j<v;j++){
                if((adj[i][j]==1) && !visited[j]){
                    dfs(j);
                }
            }
        }
        //Method to find Connected Components
        void findConnectedComponents(){
            int count=0;
            for (int i=0;i<v;i++){
                if(!visited[i]){
                    count++;
                    System.out.print("Components "+ count+":");
                    dfs(i);
                    System.out.println();
                }
            }
        }
        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter no.of vertices");
            int v=sc.nextInt();
             ConnectedComponents graph=new ConnectedComponents(v);
            System.out.println("Enter Adjacency matrix");
            for (int i = 0; i < v; i++) {
                for(int j=0;j<v;j++){
                    graph.adj[i][j]=sc.nextInt();
            }            
        }
        graph.findConnectedComponents();
        sc.close();
    }
}

