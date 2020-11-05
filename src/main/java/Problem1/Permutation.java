package Problem1;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static List<List<Integer>> permute(int[] nums) {

        //put a number in the front, check how many permutations are left
        //put the next number onto it, check how many permutations are left
        //loop through each permutation for each number in the array
        //we will have as many outer lists as nums in nums

        //be checking the permutations of all the other numbers that arent the number we are looking at

        //be creating new lists when we check the next permutations

        //lecture code 11/2/2020
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null || nums.length==0){
            return result;
        }
        permute(nums, 0, result);
        return result;
    }

    // [1, 2, 3]
    // [2, 1, 3]
    // [3, 2, 1]


    //lecture code 11/2/2020
    private static void permute(int[] nums, int position, List<List<Integer>> result){

        //lecture code 11/2/2020
        if(position==nums.length-1) {
            List<Integer> oneResult = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                oneResult.add(nums[i]);
            }
        }
        // put number at position in the front
        swap(nums, position);
        // call the same private permute with position+1
        permute(nums, position+1, result);
        // put the number back to its original position
        swap(nums, position);
    }

    private static void swap(int[] nums, int pos) {
        int temp = nums[0];
        nums[0] = nums[pos];
        nums[pos] = temp;
    }
}
