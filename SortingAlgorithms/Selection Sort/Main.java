class Main{
    public static void main(String[] args){
        SelectionSort ss = new SelectionSort();
        int arr[] = {10,5,30,25,36,24,21,16};
        ss.selectionSort(arr);
        ss.printArray(arr);
    }
}