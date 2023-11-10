import java.util.ArrayList;

public class LinearProbing{
    String[] hashTable;
    int usedCellNumber;

    LinearProbing(int size){
        hashTable = new String[size];
        usedCellNumber = 0;
    }


    //through below function we are finding the hash code for any given key
    public int modASCIIHashFunction(String word, int cellNum){
        char ch[];
        ch = word.toCharArray();
        int sum = 0;

        for(int i=0; i<word.length(); i++){
            sum+=ch[i];
        }

        return sum%cellNum;
    }


    public double getLoadFactor(){
        double loadFactor = usedCellNumber * 1.0/hashTable.length;
        return loadFactor;
    }


    //Rehash
    public void rehashKeys(String word){
        usedCellNumber = 0;
        ArrayList<String> data = new ArrayList<String>();

        //first moving all data in temp arraylist i.e data
        for(String s : hashTable){
            if(s != null){
                data.add(s);
            }
        }
        data.add(word);   //then adding the new word at the last of the arraylist
        hashTable = new String[hashTable.length * 2];  //then creating a doubld size of array


        //data inserting back into the new size hashTable
        for(String s: data){
            insertInHashTable(s);
        }
    }


    //insert in hashTable
    public void insertInHashTable(String word){
        double loadFactor = getLoadFactor();
        if(loadFactor >= 0.75){
            rehashKeys(word);
        }else{
            int index = modASCIIHashFunction(word, hashTable.length);
            for(int i=index; i<index+hashTable.length; i++){
                int newIndex = i % hashTable.length;

                if(hashTable[newIndex] == null){
                    hashTable[newIndex] = word;
                    System.out.println("The word " + word + " Successfully inserted at location: " + newIndex);
                    break;
                }else{
                    System.out.println(newIndex + " Index is already Occupied, Trying next empty cell");
                }
            }
        }
        usedCellNumber++;        
    }

    //printing whole hashtable
    public void displayHashTable(){
        if(hashTable == null){
            System.out.println("\nHashTable does not exists");
            return;
        }else{
            System.out.println("\n----------HashTable----------");
            for(int i=0; i<hashTable.length; i++){
                System.out.println("Index " + i + ", key " + hashTable[i]);
            }
        }
    }
}

