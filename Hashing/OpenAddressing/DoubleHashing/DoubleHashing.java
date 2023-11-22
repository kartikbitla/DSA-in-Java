import java.util.ArrayList;

public class DoubleHashing{
    String[] hashTable;
    int noOfCellsUsedInHashTable;


    //Constructor
    DoubleHashing(int size){
        hashTable = new String[size];
        noOfCellsUsedInHashTable = 0;
    }

    //HashFunction to be used on Keys
    public int modASCIIHashFunction(String word, int cellNum){
        char ch[];
        ch = word.toCharArray();
        int sum = 0;

        for(int i=0; i<word.length(); i++){
            sum+=ch[i];
        }

        return sum%cellNum;
    }

    
    //Rehash keys
    public void rehashKeys(String word){
        noOfCellsUsedInHashTable = 0;
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



    private int addAllDigitsTogether(int sum){
        int value = 0;
        while(sum > 0){
            value = sum % 10;
            sum = sum / 10;
        }

        return value;
    }

    public int secondHashFunction(String x,  int M){
        char ch[];
        ch = x.toCharArray();
        int i,sum;

        for(sum=0, i=0; i<x.length(); i++){
            sum+=ch[i];
        }
        while(sum>hashTable.length){
            sum = addAllDigitsTogether(sum);
        }

        return sum%M;        
    }

    
    public double getLoadFactor(){
        return noOfCellsUsedInHashTable * 1.0/hashTable.length;
    }

    public void insertKeyInHashTable(String value){
        double loadFactor = getLoadFactor();
        if(loadFactor >= 0.75){
            rehashKeys(value);
        }else{
            int x = modASCIIHashFunction(value, hashTable.length);
            int y = secondHashFunction(value, hashTable.length);

            for(int i=0; i<hashTable.length; i++){
                int newIndex = (x + i*y) % hashTable.length;
                if(hashTable[newIndex] == null){
                    hashTable[newIndex] = value;
                    System.out.println(value + " inserted at location " + newIndex);
                    break;
                }else{
                    System.out.println(newIndex + " is occupied. Trying next empty index...");
                }
            }
        }
        noOfCellsUsedInHashTable++;
    }

}