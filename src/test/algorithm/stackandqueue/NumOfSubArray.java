package test.algorithm.stackandqueue;

import java.util.LinkedList;

/**
 * 
 * @author zengjinc
 *
 * 给定数组 arr 和整数 num，返回有多少个子数组满足如下情况：
 * max(arr[i..j]) - min(arr[i..j]) <= num
 * 
 * 理解：
 * 运用 MaxWindow 中用到的双端队列来维护子数组最大/小值的更新。时间复杂度和空间复杂度都为 O(N)
 * 
 * 结论：
 * ①如果子数组 arr[i..j] 满足条件，那么 arr[i..j] 中的每一个子数组都满足条件
 * ②如果子数组 arr[i..j] 不满足条件，那么所有包含arr[i..j]的子数组，都不满足条件
 */
public class NumOfSubArray {
	public static void main(String[] args) {
		NumOfSubArray numOfSubArray = new NumOfSubArray();
		
		int[] arr = new int[] {1,2,3};
//		int[] arr = new int[] {1,2,3,4};
		int num = 2;
		
		int res = numOfSubArray.getNum(arr, num);
		
		System.out.println("数组中最大值减去最小值小于等于 " + num + " 的子数组数量 ： " + res);
		
	}
	
	public int getNum(int[] arr, int num) {
		if(arr == null || arr.length == 0) {
			return 0;
		}
		
		LinkedList<Integer> qmin = new LinkedList<Integer>();
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		int i = 0;
		int j = 0;
		int res = 0;
		
		while(i < arr.length) {
			while(j < arr.length) {
				while(!qmin.isEmpty() && arr[qmin.peekFirst()] >= arr[j]) {
					qmin.pollFirst();
				}
				qmin.addLast(j);
				
				while(!qmax.isEmpty() && arr[qmax.peekFirst()] <= arr[j]) {
					qmax.pollFirst();
				}
				qmax.addLast(j);
				
				if(qmax.peekFirst() - qmin.peekFirst() > num) {
					break;
				}
				
				j++;
			}
			
			if(qmin.peekFirst() == i) {
				qmin.pollFirst();
			}
			
			if(qmax.peekFirst() == i) {
				qmax.pollFirst();
			}
			
//			System.out.println(i + " --> " + j);
			res += (j - i);
			
			i++;
		}
		return res;
	}
}
