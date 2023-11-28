public class SelectionSort{

    public void selectionSort(int[] a){
        for(int i=0; i<a.length; i++){
            int minimumIndex = i;
            
            for(int j=i+1; j<a.length; j++){
                if(a[j] < a[minimumIndex]){
                    minimumIndex = j;
                }
            }

            if(minimumIndex != i){
                int temp = a[i];
                a[i] = a[minimumIndex];
                a[minimumIndex] = temp;
            }
        }
    }


    public static void printArray(int []array){
        for(int i=0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}