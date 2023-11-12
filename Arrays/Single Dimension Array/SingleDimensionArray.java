public class SingleDimensionArray {
    int[] arr =  null;

    public SingleDimensionArray(int sizeOfArray){
        arr = new int[sizeOfArray];
        
        for(int i=0; i<sizeOfArray; i++){
            arr[i] = Integer.MIN_VALUE;
        }
    }

    public void insert(int location, int value){
        try{
            if(arr[location] == Integer.MIN_VALUE){
                arr[location] = value;
                System.out.println("Successfully Inserted");
            }else{
                System.out.println("This cell is already occupied");
            }

        }catch (ArrayIndexOutOfBoundsException e){
               System.out.println("Invalid index to access array!"); 
        }        
    }

    public void traverseArray(){
        try{
            for(int index=0; index<arr.length; index++){
                System.out.print(arr[index] + " ");    
            }
        }catch(Exception e){
            System.out.println("Array no longer exists!");
        }
    }


    public void searchInArray(int valueToSearch){
        for(int i=0; i<arr.length; i++){
            if(arr[i]==valueToSearch){
                System.out.println("Value is found at the Index of " + i);
                return;
            }
        }
        System.out.println(valueToSearch + " is not found");
    }

    public void deleteValue(int valueToDeleteIndex){
        try{
            arr[valueToDeleteIndex] = Integer.MIN_VALUE;
            System.out.println("The value has been deleted succesfully");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("The value that is provided is not in the range of array");
        }
    }

}
