package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/average-value-of-even-numbers-that-are-divisible-by-three/submissions/
 */
public class threeNum {
    public int averageValue(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i=0;i<nums.length;i++){
            if (nums[i]%3==0&&nums[i]%2==0){
                result.add(nums[i]);
            }
        }
        if (result.size()==0){
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < result.size(); i++) {
            sum = result.get(i)+sum;
        }
        return sum/result.size();
    }
}
