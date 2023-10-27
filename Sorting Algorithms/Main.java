class Main{
    public static void main(String[] args){
        sorting sort = new sorting();
        int arr[] = {10,5,30,15,50,6};
        //sort.bubbleSort(arr);
        //sort.selectionSort(arr);
        sort.insertionSort(arr);
        sort.printArray(arr);
    }
}