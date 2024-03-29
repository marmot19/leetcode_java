package main.cczq.zrh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/*
 * 给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
*/
public class Solutions56 {
	public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<int[]>();
        if(intervals.length < 2) return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0]-o2[0];
			}
        });
        int i = 0;
        while(i<intervals.length) {
        	int left = intervals[i][0];
        	int right = intervals[i][1];
        	while(i<intervals.length-1 && right>=intervals[i+1][0]) {
        		i++;
        		right = Math.max(right, intervals[i][1]);
        	}
        	res.add(new int[]{left, right});
        	i++;
        }
        return res.toArray(new int[0][]);
	}
	public static void main(String[] args) {
		Solutions56 s = new Solutions56();
		int[][] nums = {{1,3},{2,6},{8,10},{15,18}};
		System.out.println(s.merge(nums));
	}
}
