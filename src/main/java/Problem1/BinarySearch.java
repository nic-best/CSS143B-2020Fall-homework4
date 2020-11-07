package Problem1;
//referenced my homework 1 solution

public class BinarySearch {

    public static int binarySearch(int[] data, int target) {
        if(data==null || data.length==0){
            return -1;
        }
        return binarySearchHelper(data, target, 0, data.length);
    }

    private static int binarySearchHelper(int[] data, int target, int startIndex, int endIndex){
        int length = endIndex-startIndex;
        //if the part of the array we are looking at doesnt have any data, we should return the failure case
        if(length<0){
            return -1;
        }
        int mid = startIndex + (length/2);


        //Spec calls for first index of target
        //while loop keeps moving the index we are looking at to the left until we:
        //  find a value of data != target
        //  move to the front of the array
        //returns the index of the first instance of the target
        if(data[mid]==target){
            int leftChecker = mid;
            int newFoundIndex = mid;
            while(leftChecker-1>=0 && data[leftChecker]==target){
                leftChecker = leftChecker-1;
                if(data[leftChecker]==target){
                    newFoundIndex=leftChecker;
                }
            }
            return newFoundIndex;
        }

        //check the right half of the array
        else if (data[mid]<target){
            //recursively search the top half of the array
            //starts at the current midpoint+1, ends at the end of the array
            return binarySearchHelper(data, target, mid+1, endIndex);
        }
        else if (data[mid]>target){
            //recursively search the bottom half of the array
            //starts at the beginning of the array, ends before the current midpoint
            return binarySearchHelper(data, target, startIndex, mid-1);
        }

        return -1;
    }
}
