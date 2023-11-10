import java.util.LinkedList;
import java.util.ArrayList;

public class DirectChaining {
    LinkedList<String>[] hashTable;  // An array of LinkedLists to implement direct chaining
    int maxChainSize = 5;

    // Constructor to create a hash table of the specified size
    DirectChaining(int size) {
        hashTable = new LinkedList[size];
    }

    // Hash function: Calculates a hash code for a given word and table size
    public int modeASCIIFunction(String word, int m) {
        char chr[] = word.toCharArray();
        int sum = 0;

        // Sum the ASCII values of characters in the word
        for (int i = 0; i < word.length(); i++) {
            sum = sum + chr[i];
        }

        // Return the remainder when divided by the table size
        return sum % m;
    }

    // Insert a word into the hash table using direct chaining
    public void insertHashTable(String word) {
        int index = modeASCIIFunction(word, hashTable.length);

        // If the slot is empty, create a new LinkedList and add the word
        if (hashTable[index] == null) {
            hashTable[index] = new LinkedList<String>();
            hashTable[index].add(word);
        } else {
            // If the slot is not empty, add the word to the existing LinkedList
            hashTable[index].add(word);
        }
    }

    // Display the contents of the hash table
    public void displayHashTable() {
        if (hashTable == null) {
            System.out.println("Hash Table doesn't exist");
        } else {
            System.out.println("--------Hash Table----------");
            for (int i = 0; i < hashTable.length; i++) {
                System.out.println("Index " + i + "- keys: " + hashTable[i]);
            }
        }
    }



    //search en element in the Hash Table and return index and boolean value
    public boolean searchHashTable(String word){
        int index = modeASCIIFunction(word, hashTable.length);
        if(hashTable[index] != null && hashTable[index].contains(word)){
            System.out.println(word + " found in HashTable at location " + index);
            return true;
        }else{
            System.out.println(word + " not found in HashTable");
            return false;
        }
    }


    public void deleteKeyHashTable(String word){
        int index = modeASCIIFunction(word, hashTable.length);
        boolean isPresent = searchHashTable(word);
        
        if(isPresent){
            hashTable[index].remove(word);
            System.out.println(word + " has been successfully deleted from HashTable");
        }else{
            System.out.println(word + " not found in HashTable");
        }

    }

}
