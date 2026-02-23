//program to implement Single source shortest path(Dijkstra's) using Adjacency matrix
import java.util.*;
//class to implement Dijkstra's algorithm
class ShortestPath{
	//Method to find minimum distance
	static final int INF=Integer.MAX_VALUE;
	static int minDistance(int[] dist,boolean[] visited){
		int min=INF;
		int minIndex=-1;
		for(int i=0;i<dist.length;i++){
			if(!visited[i] && min>dist[i]){
				min=dist[i];
				minIndex=i;
			}
		}
		return minIndex;
	}
	//Method to implement Dijkstra's algorithm
	static int[] dijkstra(int[][] graph,int src){
		int V=graph.length;
		boolean[] visited=new boolean[V];
		int[] dist=new int[V];
		Arrays.fill(dist,INF);
		dist[src]=0;
		for(int i=0;i<V-1;i++){
			int u=minDistance(dist,visited);
			visited[u]=true;
			for(int v=0;v<V;v++){
				if(!visited[v] && graph[u][v]!=INF && dist[u]!=INF){
					if(dist[u]+graph[u][v]<dist[v]){	
						dist[v]=dist[u]+graph[u][v];
					}
				}
			}
		}
		return dist;
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no.of	vertices:");
		int n=sc.nextInt();
		int[][] graph=new int[n][n];
		System.out.println("Enter cost matrix:");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				int value=sc.nextInt();
				if(value==-1){
					graph[i][j]=INF;
				}else{
					graph[i][j]=value;
				}
			}
		}
		System.out.println("enter source to start:");
		int src=sc.nextInt();
		int[] result=dijkstra(graph,src);
		for(int i=0;i<result.length;i++){
			if(result[i]==INF){
				System.out.print(-1+" ");
			}else{
				System.out.print(result[i]+" ");
			}
		}
	}
}
