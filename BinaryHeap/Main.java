class Main{
    public static void main(String[] args){
        BinaryHeap newBH = new BinaryHeap(6);
        newBH.insert(10, "Max");
        newBH.insert(5, "Max");
        newBH.insert(15, "Max");
        newBH.insert(1, "Max");
        newBH.insert(40, "Max"); 
        newBH.levelOrderTraversal();
        newBH.extractHeadOfBP("Max");
               
        newBH.levelOrderTraversal();
        newBH.deleteBH();
    }
}


