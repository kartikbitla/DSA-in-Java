
public class TwoDimensionArray {
    int[][] arr;

    public TwoDimensionArray(int numberOfRows, int numberOfCols){
        this.arr = new int[numberOfRows][numberOfCols];
        
        for(int i=0; i<numberOfRows; i++){
            for(int j=0; j<numberOfCols; j++){
                arr[i][j] = Integer.MIN_VALUE;            
            }
        }
    }

    //insert value in the Array
    public void insertValueInTheArray(int row, int col, int value){
        try{
            if(arr[row][col] == Integer.MIN_VALUE){
                arr[row][col] = value;
                System.out.println("Value is succesfully inserted");
            }else{
                System.out.println("This cell is already occupied");
            }

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid index for 2D array");
        }
    }

    public void accessCell(int row, int col){
        System.out.println("\nAccessing Row# " + row + " ,Col# " + col);
        try{
            System.out.println("Cell Value is: " + arr[row][col]);

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid index of 2D array");
        }
    }

    public void traverse2DArray(){
        for(int row=0; row<arr.length; row++){
            for(int col=0; col<arr[row].length; col++){
                System.out.print(arr[row][col] + " ");    
            }
            System.out.println();
        }
    }

    public void searching(int valueToSearch){
        for(int row=0; row<arr.length; row++){
            for(int col=0; col<arr[row].length; col++){
                if(arr[row][col] == valueToSearch){
                    System.out.println("Value found at row index " + row + " and col index " + col);
                    return;
                }    
            }            
        }
        System.out.println("value is not found");
    }

    public void deleteValueFromArray(int row, int col){
        try{
            System.out.println("Successfully Deleted: " + arr[row][col]);
            arr[row][col] = Integer.MIN_VALUE;

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("This index is not valid for Array");
        }
    }

}
