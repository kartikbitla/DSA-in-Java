class Main{
    public static void main(String[] args){
        LinearProbing linearProbing = new LinearProbing(15);
        linearProbing.insertInHashTable("The");
        linearProbing.insertInHashTable("quick");
        linearProbing.insertInHashTable("brown");
        linearProbing.insertInHashTable("fox");
        linearProbing.insertInHashTable("over");    
        linearProbing.insertInHashTable("kartik");   
        linearProbing.insertInHashTable("kartiks");   
        linearProbing.insertInHashTable("bitla");   
        linearProbing.insertInHashTable("hello");   
        linearProbing.insertInHashTable("world");   
        linearProbing.insertInHashTable("javacoding");   
        linearProbing.displayHashTable();   
        linearProbing.deleteKeyHashTable("javacoding");
        linearProbing.displayHashTable();
        linearProbing.searchInHashTable("brown");
        linearProbing.searchInHashTable("hello");  
    }
}