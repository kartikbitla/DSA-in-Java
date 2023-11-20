import java.util.ArrayList;

public class QuadraticProbing{
    String[] hashTable;
    int usedCellNumber;

    //Constructor
    QuadraticProbing(int size){
        hashTable = new String[size];
        usedCellNumber = 0;
    }


    //HashFunction to be used on keys
    public int modASCIIHashFunction(String word, int cellNum){
        char ch[];
        ch = word.toCharArray();
        int sum = 0;

        for(int i=0; i<word.length(); i++){
            sum+=ch[i];
        }

        return sum%cellNum;
    }

    //Returns Load Factor of HashTable
    public double getLoadFactor(){
        double loadFactor = usedCellNumber * 1.0/hashTable.length;
        return loadFactor;
    }

    //Rehash keys
    public void rehashKeys(String word){
        usedCellNumber = 0;
        ArrayList<String> data = new ArrayList<String>();

        //First moving all data in temp arraylist i.e data 
        for(String s: hashTable){
            if(s != null){
                data.add(s);
            }
        }

        data.add(word); //then adding the new word at last of the arrayList
        hashTable = new String[hashTable.length * 2]; //Then creating a double size of array

        //Data inserting back into the new size hashTable
        for(String s: data){
            insertKeyInHashTable(s);
        }
    }


    //Insert key in HashTable
    public void insertKeyInHashTable(String word){
        double loadFactor = getLoadFactor();
        if(loadFactor >= 0.75){
            rehashKeys(word);
        }else{
            int index = modASCIIHashFunction(word, hashTable.length);
            int counter = 0;

            for(int i=index; i<index+hashTable.length; i++){
                int newIndex = (index + (counter*counter)) % hashTable.length;

                if(hashTable[newIndex] == null){
                    hashTable[newIndex] = word;
                    System.out.println(word + " has been inserted successfully");
                    break;
                }else{
                    System.out.println(newIndex + " is already occupied. Trying next one...");
                }
                counter++;
            }
        }
        usedCellNumber++;

    }



    //Pinting whole hashTable
    public void displayHashTable(){
        if(hashTable == null){
            System.out.println("\nHashTable does not exists");
            return;
        }else{
            System.out.println("\n-------HashTable-------");
            for(int i=0; i<hashTable.length; i++){
                System.out.println("Index " + i + " ,key " + hashTable[i]);
            }
        }
    }


    public boolean searchHashTable(String word){
        int index = modASCIIHashFunction(word, hashTable.length);

        for(int i=index; i<index+hashTable.length; i++){
            int newIndex = i % hashTable.length;

            if(hashTable[newIndex] != null && hashTable[newIndex].equals(word)){
                System.out.println(word + " found at location: " + newIndex);
                return true;
            }
        }
        System.out.println(word + " not found in hashTable");
        return false;
    }


    public void deleteKeyHashTable(String word){
        int index = modASCIIHashFunction(word, hashTable.length);
        for(int i=index; i<index+hashTable.length; i++){
            int newIndex = i%hashTable.length;

            if(hashTable[newIndex] != null && hashTable[newIndex].equals(word)){
                hashTable[newIndex] = null;
                System.out.println(word + " word has been deleted successfully from HashTable");
                return;
            }
        }
        System.out.println(word + " not found in HashTable");
    }
}