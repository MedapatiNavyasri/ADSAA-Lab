//TSPB using Branch and Bound approach
import java.util.*;
public class TSPB{
	static int N;
	static int finalres=Integer.MAX_VALUE;
	static int[][] cost;
	static boolean[] visited;
	static void tsp(int curpos,int count,int curcost){
		if(count==N && cost[curpos][0]>0){
			int total=curcost+cost[curpos][0];
			finalres=Math.min(finalres,total);
			return;
		}
		for(int i=0;i<N;i++){
			if(!visited[i] && cost[curpos][i]>0){
				int newcost=curcost+cost[curpos][i];
				if(newcost<finalres){
					visited[i]=true;
					tsp(i,count+1,newcost);
					visited[i]=false;
				}
			}
		}
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no.of cities:");
		N=sc.nextInt();
		cost=new int[N][N];
		visited=new boolean[N];
		System.out.println("Enter cost matrix:");
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				cost[i][j]=sc.nextInt();
			}
		}
		visited[0]=true;
		tsp(0,1,0);
		System.out.println("Minimum cost"+finalres);
	}
}
