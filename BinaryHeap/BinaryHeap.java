public class BinaryHeap{
    int arr[];
    int sizeOfTree;

    public BinaryHeap(int size){
        arr = new int[size+1];
        this.sizeOfTree = 0;
        System.out.println("Binary Heap has been created");
    }


    //empty method
    public boolean isEmpty(){
        return sizeOfTree == 0;        
    }    


    //peek method
    public Integer peek(){
        if(isEmpty()){
            System.out.println("Binary Heap is empty");
            return null;
        }
        return arr[1];
    }


    //size
    public int sizeOfBinaryHeap(){
        return sizeOfTree;
    }


    //level order traversal
    public void levelOrderTraversal(){
        for(int i=1; i<=sizeOfTree; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }


    //heapify for insert
    public void heapifyBottomToTop(int index, String heapType){        
        int parentIndex = index/2;
        if(index <= 1){
            return;
        }
        
        
        if(heapType == "Min"){
            if(arr[index] < arr[parentIndex]){
                int temp = arr[index];
                arr[index] = arr[parentIndex];
                arr[parentIndex] = temp;
        }else if(heapType == "Max"){
            if(arr[index] > arr[parentIndex]){
                int temp = arr[index];
                arr[index] = arr[parentIndex];
                arr[parentIndex] = temp;
            }
        }
        }

        heapifyBottomToTop(parentIndex, heapType);

    }


    public void insert(int value, String typeHeap){
        arr[sizeOfTree+1] = value;
        sizeOfTree++;
        heapifyBottomToTop(sizeOfTree, typeHeap);
        System.out.println("Inserted " + value + " Successfully in Heap");
    }




    // heapify Top to Bottom
    public void  heapifyTopToBottom(int index, String heapType){
        int left = index*2;
        int right = index*2+1;
        int swapChild = 0;

        if(sizeOfTree < left){
            return;
        }

        if(heapType == "Max"){
            if(sizeOfTree == left){
                if(arr[index]<arr[left]){
                    int temp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
                return;
            }else{
                if(arr[left]>arr[right]){
                    swapChild = left;
                }else{
                    swapChild = right;
                }

                if(arr[index]<arr[swapChild]){
                    int temp = arr[index];
                    arr[index] = arr[swapChild];
                    arr[swapChild] = temp;
                }
            }
        }else if(heapType == "Min"){
            if(sizeOfTree == left){
                if(arr[index]>arr[left]){
                    int temp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
                return;
            }else{
                if(arr[left]<arr[right]){
                    swapChild = left;
                }else{
                    swapChild = right;
                }

                if(arr[index]>arr[swapChild]){
                    int temp = arr[index];
                    arr[index] = arr[swapChild];
                    arr[swapChild] = temp;
                }
            }
        }

        heapifyTopToBottom(swapChild, heapType);
    }



    public int extractHeadOfBP(String heapType){
        if(isEmpty()){
            return -1;
        }else{
            int extractedValue = arr[1];
            arr[1] = arr[sizeOfTree];
            sizeOfTree--;
            heapifyTopToBottom(1, heapType);
            return extractedValue;
        }
    }



    
    //delete entire binary heap
    public void deleteBH(){
        arr = null;
        System.out.println("Binary Heap has been successfully Deleted");
    }
    
}