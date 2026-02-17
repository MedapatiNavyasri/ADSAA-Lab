import java.util.*;
public class BFSList {
    int v;
    List<List<Integer>> adj;
    BFSList(int v){
        this.v=v;
        adj=new ArrayList<>(v);
        for(int i=0;i<v;i++){
        adj.add(new LinkedList<>());
        }
    }
    void addEdge(int src,int des){
        adj.get(src).add(des);
        adj.get(des).add(src);
    }
    void bfs(int start){
        boolean[] vis=new boolean[v];
        Arrays.fill(vis,false);
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        vis[start]=true;
        while(!q.isEmpty()){
            int r=q.poll();
            System.out.print(r+" ");
            for (int n:adj.get(r)) {
                if(!vis[n]){
                    q.add(n);
                    vis[n]=true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no.of vertices:");
        int v=sc.nextInt();
        BFSList graph=new BFSList(v);
        System.out.println("enter no.of edges:");
        int e=sc.nextInt();
        System.out.println("Enter source and destination:");
        for (int i=0;i<e;i++) {
            int src=sc.nextInt();
            int des=sc.nextInt();
            graph.addEdge(src,des);
        }
        System.out.println("Enter start node:");
        int start=sc.nextInt();
        graph.bfs(start);
        sc.close();
    }
}
