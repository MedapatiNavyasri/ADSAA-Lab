//Program to implement 0/1 KnapSack using Dynamic Programming
import java.util.Scanner;
//Main class
class KnapSack{
	//Method to find Maximum profit of the Knapsack
	public static int doKnapSack(int m,int[] profits,int[] weights){
		int[] dp=new int[m+1];
		//Using bottom-up approach to find max profits
		for(int i=0;i<weights.length;i++){
			for(int j=m;j>=weights[i];j--){
				dp[j]=Math.max(dp[j],dp[j-weights[i]]+profits[i]);
			}
		}
		return dp[m];
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no.of weights");
		int n=sc.nextInt();
		int[] weights=new int[n];
		int[] profits=new int[n];
		System.out.println("Enter weights:");
		for(int i=0;i<n;i++){
			weights[i]=sc.nextInt();
		}
		System.out.println("Enter profits for each weights:");
		for(int i=0;i<n;i++){
			profits[i]=sc.nextInt();
		}
		System.out.println("Enter Maximum capacity of KnapSack:");
		int m=sc.nextInt();
		int result=doKnapSack(m,profits,weights);
		System.out.println("Maximum profit that can be obtained from Knapsack is: "+result);
	}
}
