class Main{
    public static void main(String[] args){
        BubbleSort bs = new BubbleSort();
        int arr[] = {10, 5, 30, 15, 50, 6};
        bs.bubbleSort(arr);
        bs.printArray(arr);
    }
}