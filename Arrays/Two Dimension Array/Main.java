import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        // int[][] twoDimArr = new int[2][2];
        
        // twoDimArr[0][0] = 1;
        // twoDimArr[0][1] = 2;
        // twoDimArr[1][0] = 3;
        // twoDimArr[1][1] = 4;

        // System.out.println(Arrays.deepToString(twoDimArr));


        // String s2DArray[][] = {{"a","b"}, {"c","d"}};
        // System.out.println(Arrays.deepToString(s2DArray));

        TwoDimensionArray sda = new TwoDimensionArray(3,3);
        
        sda.insertValueInTheArray(0,0,25); 
        sda.insertValueInTheArray(0,1,26);
        sda.insertValueInTheArray(0,2,27);
        sda.insertValueInTheArray(1,0,28);
        sda.insertValueInTheArray(1,1,29);
        sda.insertValueInTheArray(1,2,30);
        sda.insertValueInTheArray(2,0,31);
        sda.insertValueInTheArray(2,1,32);
        sda.insertValueInTheArray(2,2,33); 
        System.out.println(Arrays.deepToString(sda.arr));

        sda.accessCell(2,2);
        sda.traverse2DArray();
        sda.searching(50);
        sda.deleteValueFromArray(0,2);
    }
}
