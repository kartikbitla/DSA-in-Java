class Main{
    public static void main(String[] args){
        sorting sort = new sorting();
        //int arr[] = {10,5,30,15,50,6};
        //sort.bubbleSort(arr);
        //sort.selectionSort(arr);
        //sort.insertionSort(arr);
        //sort.printArray(arr);

        int arr[] = {9,7,5,4,2,1,3,6,8};
        Bucket_sort bucket_sort = new Bucket_sort(arr);
        bucket_sort.printArray(arr);
        bucket_sort.bucketSort();
        System.out.println();
        bucket_sort.printArray(arr);
    }

}