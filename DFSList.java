import java.util.*;
public class DFSList {
    int v;
    boolean[] vis;
    List<List<Integer>> adj;
    DFSList(int v){
        this.v=v;
        adj=new ArrayList<>(v);
        for(int i=0;i<v;i++){
            adj.add(new LinkedList<>());
        }
        vis=new boolean[v];
    }
    void addEdge(int src,int des){
        adj.get(src).add(des);
        adj.get(des).add(src);
    }
    void dfs(int start){
        vis[start]=true;
        System.out.print(start+" ");
            for(int i:adj.get(start)){
                if(!vis[i]){
                    dfs(i);
                }
            }
    }
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter no.of vertices");
    int v=sc.nextInt();
    DFSList graph=new DFSList(v);
    System.out.println("Enter no.of edges");
    int e=sc.nextInt();
    System.out.println("enter source and destination");
    for(int i=0;i<e;i++){
        int src=sc.nextInt();
        int des=sc.nextInt();
        graph.addEdge(src,des);
    }
    System.out.println("enter start node");
    int start=sc.nextInt();
    graph.dfs(start);
    sc.close();
  }  
}
