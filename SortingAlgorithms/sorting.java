public class sorting{
    
    //Bubble sort
    public void bubbleSort(int arr[]){
        int n = arr.length;
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }



    //Selection sort
    public void selectionSort(int arr[]){
        int n = arr.length;
        for(int i=0; i<n; i++){
            int minimumIndex = i;
            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[minimumIndex]){
                    minimumIndex = j;
                }
            }

            if(minimumIndex != i){
                int temp = arr[i];
                arr[i] = arr[minimumIndex];
                arr[minimumIndex] = temp;
            }
        }
    }


    //Insertion sort
    public void insertionSort(int arr[]){
        int n = arr.length;
        
        for(int i=1; i<n; i++){
            int temp = arr[i], j = i;

            while(j > 0 && arr[j-1] > temp){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;           
        }        
    }    

    

    //Printing array
    public void printArray(int arr[]){
        int n = arr.length;
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}