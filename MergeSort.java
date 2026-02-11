import java.util.Scanner;
//class MergeSortDemo to perform Merge Sort Operation
class MergeSortDemo{
    //Recurrsive function call for partioning the array
    void doMergeSort(int arr[],int low,int high){
        if(low<high){
            int mid=(low+high)/2;
            doMergeSort(arr,low,mid);
            doMergeSort(arr,mid+1,high);
            merge(arr,low,mid,high);
         }
     }
     //Function to merge two sub-arrays
     void merge(int arr[],int low,int mid,int high){
        int[] b=new int[arr.length];
        int i=low,j=mid+1,h=low;
        while((i<=mid) && (j<=high)){
            if(arr[i]<=arr[j]){
                b[h]=arr[i];
                i+=1;
            }
            else{
                b[h]=arr[j];
                j+=1;
            }
            h+=1;
        }
        if(i>mid){
            for(int k=j;k<=high;k++){
                b[h]=arr[k];
                h+=1;
            }
         }
         else{
            for(int k=i;k<=mid;k++){
                b[h]=arr[k];
                h+=1;
            }
         }
         for(int k=low;k<=high;k++){
            arr[k]=b[k];
          }
     }
}
//Main class MergeSort
class MergeSort{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        MergeSortDemo ms=new MergeSortDemo();
        System.out.println("enter no.of elements in array:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("enter elements in array:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        //calling function doMergeSort
        ms.doMergeSort(arr,0,n-1);
        System.out.println("Array after sorting:");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
         }
     }
} 
         
            
