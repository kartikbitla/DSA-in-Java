import java.util.Arrays;
class Main{
    public static void main(String[] agrs){        
        SingleDimensionArray sda = new SingleDimensionArray(10);
        sda.insert(0,0);
        sda.insert(1,10);
        sda.insert(2,20);              
        //sda.searchInArray(20);
        sda.deleteValue(1);
        System.out.println(Arrays.toString(sda.arr));
    }
} 
