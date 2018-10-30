
import java.util.ArrayList;
import java.util.Random;

public class MinHeap {

    static  class minHeap{
    ArrayList<Integer> arr;
    int heap_size ;
    
    
    public minHeap(ArrayList arr){
      this.arr = arr ; 
      heap_size = arr.size();
    }
    
    void Heapify(int i){
      int l = Left(i);
      int r = Right(i);
      int minimum;
      if( (l <= heap_size-1) && (arr.get(l) < arr.get(i))){
          minimum = l ;
      
      }else{
          minimum = i ;
      }
      if((r <= heap_size-1) && (arr.get(r) < arr.get(minimum))){
          minimum = r;      
      }
      if(minimum != i){
         swap(i, minimum);
         Heapify(minimum);
      }
      
    }
    
    void buildHeap(){
        
        for(int j= heap_size/2+1 ; j>=0 ;j--){
           Heapify(j);
        }
    }
    
    void  HeapSort(){

        buildHeap();
        int k = arr.size()-1;
        for(int j = k ; j >=1 ; j--){
            swap(0, j);
            heap_size = heap_size - 1 ;
            //System.out.println(heap_size);
            Heapify(0);
        }
        
        
    }
    
    void insert(int item){
           heap_size = heap_size + 1;
           arr.add(item);
           int last = arr.size()-1;
//         int parent = parent(last);
//         while(parent != last && arr.get(last) > arr.get(parent)){
//            swap(last,parent);
//            last = parent;
//            parent = parent(last);
//         }
           Heapify(last);

    }
    
    void swap(int j , int k){
      int c = arr.get(j);
      arr.set(j, arr.get(k));
      arr.set(k , c);
    
    }

    int parent(int i){
      return i/2;
    }

    int Left(int i){
      return 2*i +1;
    }

    int Right(int i){
      return 2*i + 2;
    }

  }
    public static void main(String[] args) {
        
        ArrayList arr;       
        arr = new ArrayList<>();
        
        //======= random array generation================
        for(int j = 0; j < 15 ; j++){
            Random ran = new Random();
            int x = ran.nextInt(101)+ 100 ;
            arr.add(x);
        }
        
        //======= array before heapify==================
        for(int i =0 ; i<= arr.size()-1;i++){
            System.out.print(arr.get(i));
            System.out.print(",");
        }
        System.out.println("   Before heapify");
        

        minHeap v = new minHeap(arr);
        
        v.buildHeap();
        //======= array after heapify  ==================
        for(int i = 0 ; i<= arr.size()-1;i++){
            System.out.print(arr.get(i));
            System.out.print(",");
        }
        System.out.println("   after build Heap");
        
        
        
//     ====== Insert Function works ;-) =================        
//        v.insert(230);
//        v.insert(222);
//        v.insert(247);
//        v.insert(10);
//        v.insert(-1);
        
        
        for(int i = 0 ; i<= arr.size()-1 ;i++){
            System.out.print(arr.get(i));
            System.out.print(",");
        }
        System.out.println("   After inserting");
        
        
        v.HeapSort();
        
        for(int i = arr.size()-1 ; i>=0 ;i--){
            System.out.print(arr.get(i));
            System.out.print(",");
        }
        System.out.println("   After heapSort");
        
    }
    
}
