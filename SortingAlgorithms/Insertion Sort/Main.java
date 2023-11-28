class Main {
    public static void main(String[] args) {
        InsertionSort is = new InsertionSort();
        int arr[] = {10, 3, 2, 5, 8, 4, 3, 1};
        is.insertionSort(arr);
        is.printArray(arr);
    }
}
