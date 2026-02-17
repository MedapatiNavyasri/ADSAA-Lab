//Program to implement Maximum Heap using arrays.
class MaxHeap{
    int[] heap;
    int size,capacity;
    //constructor
    MaxHeap(int capacity){
        this.capacity=capacity;
        heap=new int[capacity+1];
        size=0;
    }
    //Inserting item in max heap.
    public void insert(int item){
        if(size==capacity){
            System.out.println("Heap is full");
            return;
        }
        int i=++size;
        while(i>1 && heap[i/2]<=item){
            heap[i]=heap[i/2];
            i=i/2;
        }    
        heap[i]=item;
    }
    //Deleting max element from heap(root).
    public int delete(){
        if(size==0){
            System.out.println("Heap is empty");
            return 0;
        }
        int max=heap[1];
        heap[1]=heap[size];
        size--;
        adjust(1);
        return max;
    }
    //Performing heapify operation.
    public void adjust(int i){
        int item=heap[1];
        int j=2*i;
        while(j<=size){
            if(j<size && heap[j]<heap[j+1]){
                j+=1;
            }
            if(item>=heap[j]){
                break;
            }
            heap[j/2]=heap[j];
            j=2*j;
        }
        heap[j/2]=item;
    }
    //Printing elements in Max heap
    public void display(){
        for(int i=1;i<=size;i++){
            System.out.print(heap[i]+" ");
        }
        System.out.println();
    }
}
//Main class to perform Max Heap operation.
class MaxHeapDemo1{
    public static void main(String[] args) {
        MaxHeap h=new MaxHeap(7);
        h.insert(10);
        h.insert(20);
        h.insert(30);
        h.insert(40);
        h.insert(50);
        h.insert(60);
        h.insert(70);
        h.display();
        h.delete();
        h.display();
    }

}
