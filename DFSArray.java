import java.util.*;
public class DFSArray {
    int v;
    boolean[] vis;
    int[][] adj;
    DFSArray(int v){
        this.v=v;
        adj=new int[v][v];
        vis=new boolean[v];
        Arrays.fill(vis,false);
    }
    void dfs(int start){
        vis[start]=true;
        System.out.print(start+"  ");
        for(int i=0;i<v;i++){       
            if(adj[start][i]==1 && !vis[i]){
                dfs(i);
            }
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no.of vertices");
        int v=sc.nextInt();
        DFSArray graph=new DFSArray(v);
        System.out.println("Enter Adjacency matrix");
        for (int i = 0; i < v; i++) {
            for(int j=0;j<v;j++){
                graph.adj[i][j]=sc.nextInt();
            }            
        }
        System.out.println("Enter start node");
        int start=sc.nextInt();
        graph.dfs(start);
        sc.close();
    }
}
