package main.cczq.zrh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：

答案中不可以包含重复的四元组。

示例：

给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
*/
public class Solutions18 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length<4) return result;
		Arrays.sort(nums);
        
		for(int i=0;i<nums.length-3;i++) {
			if(i>0&&nums[i]==nums[i-1]) continue;
			for(int j=i+1;j<nums.length-2;j++) {
				if(j>i+1&&nums[j]==nums[j-1]) continue;
				int left = j+1;
				int right = nums.length-1;
				while(left<right) {
					int sum = nums[i]+nums[j]+nums[left]+nums[right];
					if(sum==target) {
						result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
						while(left<right && nums[left]==nums[left+1]) left+=1;
						while(left<right && nums[right]==nums[right-1]) right-=1;
						left+=1;
						right-=1;
					}else if(sum>target) {
						right-=1;
					}else {
						left+=1;
					}
				}
			}
		}
		return result;
    }
	
	public static void main(String[] args) {
		Solutions18 solutions18 = new Solutions18();
		int[] nums = {-1,0,0,1,2,-1,-4};
		int target = -1;
		System.out.println(solutions18.fourSum(nums, target));
	}
}
