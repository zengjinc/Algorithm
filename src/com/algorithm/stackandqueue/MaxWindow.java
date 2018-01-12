package com.algorithm.stackandqueue;

import java.util.LinkedList;
/**
 * 
 * @author zengjinc
 * 
 * 生成窗口最大值数组
 * 
 * 给定一个整形数组 arr 和一个大小为 w 的窗口，从数组的最左边开始滑到最右边，窗口每次向右滑动一个位置
 * 
 * 利用双端队列来实现窗口最大值的更新。	队列中存放数值的规则：队列中保存数组的下标，下标表示的数组值从队头到队尾依次减小
 *  
 * 入队规则：如果当前数值小于队尾元素，直接入队；当前数值大于队尾元素，弹出队尾元素，直到队尾元素大于当前元素或队列为空
 * 
 * 出队规则：如果队头元素已经不在窗口内，出队。即当队头元素等于 i - w 的时候。
 * 
 * 过程中，用 res 数组保存窗口的最大值，当 i == w 时，（当前遍历位置等于窗口值的时候）每移动一格，将队头元素作为最大值添加到 res 数组中。
 */
public class MaxWindow {
	public static void main(String[] args) {
		MaxWindow maxWindow = new MaxWindow();
		int[] arr = new int[] {4,3,5,4,3,3,6,7};
		int window = 3;
		
		int[] res = maxWindow.getMaxWindow(arr, window);
		
		StringBuffer sb = new StringBuffer();
		for(Integer i : res) {
			sb.append(i + ",");
		}
		
		System.out.println(sb.toString().substring(0,sb.toString().lastIndexOf(",")));
	}
	
	public int[] getMaxWindow(int[] arr, int w) {
		if(arr == null || w < 1 || arr.length < w) {
			return null;
		}
		
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		int[] res = new int[arr.length - w + 1];
		int index = 0;
		
		for(int i = 0; i < arr.length; i++) {
			while(!qmax.isEmpty() && arr[qmax.peekLast()] < arr[i]) {
				qmax.pollLast();
			}
			
			qmax.add(i);
			
			if(qmax.peekFirst() == i - w) {
				qmax.pollFirst();
			}
			
			if(i >= w - 1) {
				res[index++] = arr[qmax.peekFirst()];
			}
		}
		
		return res;
	}
	
}
