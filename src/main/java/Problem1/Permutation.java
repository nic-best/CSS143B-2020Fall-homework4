package Problem1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null||nums.length==0){
            result.add(new ArrayList<Integer>());
        }
        else{
            permute(nums, 0,  result);
        }

        return result;
    }


    //https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/?ref=rp
    //used monday lecture for basic algorithm
    private static void permute(int[] nums, int position, List<List<Integer>> result){


        if(position==nums.length-1) {
            List<Integer> oneResult = new ArrayList<Integer>();
            //copy the array to a new list
            for (int i = 0; i < nums.length; i++) {
                oneResult.add(nums[i]);
            }
            //add the list to our result and stop this method
            result.add(oneResult);
            return;
        }

        //if we arent at the end of the method array, swap
        //geeksforgeeks fixed my loop problem here, was accidentally looping too far
        //loops from our current pos to the end
        //swaps the index with the pos and runs another recursive call
        //      (which will also keep doing the same to finish a "branch")
        //swaps back once the branch is done
        for (int i = position; i <= nums.length-1; i++) {
            // put number at position in the front
            swap(nums, position, i);
            // call the same private permute with position+1
            permute(nums, position+1, result);
            // put the number back to its original position
            swap(nums, position, i);
        }

    }

    private static void swap(int[] nums, int pos, int instance) {
        int temp = nums[instance];
        nums[instance] = nums[pos];
        nums[pos] = temp;
    }
}
