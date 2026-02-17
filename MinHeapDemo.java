class MinHeap{
    int[] h;
    int size,capacity;
    MinHeap(int capacity){
        this.capacity=capacity;
        h=new int[capacity+1];
        size=0;
    }
    public void insert(int item){
        if(size==capacity){
            System.out.println("Heap is full");
            return;
        }
        int i=++size;
        while(i>1 && h[i/2]>=item){
            h[i]=h[i/2];
            i=i/2;
        }
        h[i]=item;
    }
    public int delete(){
        if(size==0){
            System.out.println("Heap is empty");
            return 0;
        }
        int min=h[1];
        h[1]=h[size];
        size--;
        adjust(1);
        return min;
    }
    public void adjust(int i){
        int item=h[1];
        int j=2*i;
        while(j<=size){
            if(j<size && h[j]>h[j+1]){
                j+=1;
            }
            if(item<=h[j]){
                break;
            }
            h[j/2]=h[j];
            j=2*j;
        }
        h[j/2]=item;
    }
    public void display(){
        for(int i=1;i<=size;i++){
            System.out.print(h[i]+" ");
        }
        System.out.println();
    }
}
public class MinHeapDemo {
    public static void main(String[] args){
        MinHeap h=new MinHeap(7);
        h.insert(70);
        h.insert(60);
    h.insert(50);
    h.insert(40);
    h.insert(30);
    h.insert(20);
    h.insert(10);
    h.display();
    }
}
