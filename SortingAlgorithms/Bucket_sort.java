import java.util.ArrayList;
import java.util.Collections;

public class Bucket_sort {
    int arr[];

    public Bucket_sort(int arr[]){
        this.arr = arr;
    }


    //printing whole array
    public void printArray(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //print buckets
    public void printBuckets(ArrayList<Integer>[] buckets){
        for(int i=0; i<buckets.length; i++){
            System.out.println("\nBucket" + i + ":");

            for(int j=0; j<buckets[i].size(); j++){
                System.out.print(buckets[i].get(j) + " ");
            }
        }
    }


    //bucket sort
    public void bucketSort(){
        int numberOfBuckets = (int) Math.ceil(Math.sqrt(arr.length));
        int maxValue = Integer.MIN_VALUE;

        for(int value : arr){
            if(value > maxValue){
                maxValue = value;
            }
        }

        ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets];
        for(int i=0; i<buckets.length; i++){
            buckets[i] = new ArrayList<Integer>();
        }

        for(int value: arr){
            int bucketNumber = (int) Math.ceil((float)value* numberOfBuckets/(float)maxValue);
            buckets[bucketNumber-1].add(value);
        }
        

        
        System.out.println("\n\nPrinting buckets before sorting...");
        printBuckets(buckets);

        for(ArrayList<Integer> bucket : buckets){
            Collections.sort(bucket);
        }

        System.out.println("\n\nPrinting buckets after sorting...");
        printBuckets(buckets);


        int index = 0;
        for(ArrayList<Integer> bucket: buckets){
            for(int value:bucket){
                arr[index] = value;
                index++;
            }
        }
    }
}
