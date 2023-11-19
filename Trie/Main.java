class Main{
    public static void main(String[] args){
        Trie newTrie = new Trie();
        newTrie.insert("Kartik");
        newTrie.insert("Kartiks");
        newTrie.insert("KartikBitla");
        newTrie.search("Kar");
        newTrie.delete("Kartik");
        newTrie.search("Kartik");        
        newTrie.search("hello");      
    }
}