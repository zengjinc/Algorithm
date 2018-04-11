package com.algorithm.sort;

import java.util.Arrays;

/*
 * 冒泡排序
 */
public class BubbleSort {
	public static void bubbleSort(DataWrap[] data){
		int arrayLength = data.length;
		System.out.println("开始排序");
		for (int i = 0; i < arrayLength - 1; i++) {
			boolean flag = false;
			for (int j = 0; j < arrayLength - i - 1; j++) {
				if(data[j].compareTo(data[j + 1]) > 0){
					DataWrap temp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = temp;
					flag = true;
				}
			}
			System.out.println(Arrays.toString(data));
			if(!flag){
				break;
			}
		}
	}
	public static void main(String[] args) {
		DataWrap[] data = { new DataWrap(9, ""), new DataWrap(-16, ""),
				new DataWrap(21, "*"), new DataWrap(23, ""),
				new DataWrap(-30, ""), new DataWrap(-49, ""),
				new DataWrap(21, ""), new DataWrap(30, "*"),
				new DataWrap(30, "")};
		System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
		bubbleSort(data);
		System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
	}
}
