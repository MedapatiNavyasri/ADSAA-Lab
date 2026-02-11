import java.util.Scanner;
//class for performing QuickSort
class QuickSortDemo{
    //Recurrsive function call for partioning and combining the array
    void doQuickSort(int arr[],int low,int high){
        if(low<high){
            int p=partition(arr,low,high);
            doQuickSort(arr,low,p-1);
            doQuickSort(arr,p+1,high);
        }
    }
    //Partition function returing partition index
    int partition(int arr[],int low,int high){
        int pivot=arr[low];
        int i=low+1;
        int j=high;
        while(i<=j){
            while((i<=high) && (arr[i]<=pivot)){
                i+=1;
             }
             while(arr[j]>pivot){
                j-=1;
             }
             if(i<j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
             }
         }
         arr[low]=arr[j];
         arr[j]=pivot;
         return j;
      }
}
//Main Class
class QuickSort{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        QuickSortDemo q=new QuickSortDemo();
        System.out.println("Enter no.of elements in array:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter elements in the array:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
         }
         //calling Quicksort function
         q.doQuickSort(arr,0,n-1);
         System.out.println("Array in sorted order is:");
         for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
         }
    }
}
        
