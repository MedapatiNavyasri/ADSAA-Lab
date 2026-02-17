import java.util.*;
public class BFSArray {
    int v;
    int[][] adj;
    BFSArray(int v){
        this.v=v;
        adj=new int[v][v];
    }
    public void BFS(int start){
        boolean[] vis=new boolean[v];
        Arrays.fill(vis,false);
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        vis[start]=true;
        while(!q.isEmpty()){
            int r=q.poll();
            System.out.print(r+" ");
            for(int i=0;i<v;i++){
                if(adj[r][i]==1 && !vis[i]){
                    vis[i]=true;
                    q.add(i);
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no.of vertices:");
        int v=sc.nextInt();
        BFSArray graph=new BFSArray(v);
        System.out.println("Enter adjacency matrix:");
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                graph.adj[i][j]=sc.nextInt();
            }
        }
        System.out.println("Enter starting vertex:");
        int start=sc.nextInt();
        graph.BFS(start);
        sc.close();
    }
}
