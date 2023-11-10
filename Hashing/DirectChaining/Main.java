class Main{
    public static void main(String[] args){
        DirectChaining newDirectChain = new DirectChaining(13);
        newDirectChain.insertHashTable("The");
        newDirectChain.insertHashTable("quick");        
        newDirectChain.insertHashTable("brown");
        newDirectChain.insertHashTable("fox");
        newDirectChain.insertHashTable("over");
        newDirectChain.displayHashTable();
        newDirectChain.searchHashTable("over");
        newDirectChain.searchHashTable("ver");
        newDirectChain.deleteKeyHashTable("over");
        newDirectChain.displayHashTable();
        
    }
}