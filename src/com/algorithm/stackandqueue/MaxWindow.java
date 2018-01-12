package com.algorithm.stackandqueue;

import java.util.LinkedList;
/**
 * 
 * @author zengjinc
 * 
 * ���ɴ������ֵ����
 * 
 * ����һ���������� arr ��һ����СΪ w �Ĵ��ڣ������������߿�ʼ�������ұߣ�����ÿ�����һ���һ��λ��
 * 
 * ����˫�˶�����ʵ�ִ������ֵ�ĸ��¡�	�����д����ֵ�Ĺ��򣺶����б���������±꣬�±��ʾ������ֵ�Ӷ�ͷ����β���μ�С
 *  
 * ��ӹ��������ǰ��ֵС�ڶ�βԪ�أ�ֱ����ӣ���ǰ��ֵ���ڶ�βԪ�أ�������βԪ�أ�ֱ����βԪ�ش��ڵ�ǰԪ�ػ����Ϊ��
 * 
 * ���ӹ��������ͷԪ���Ѿ����ڴ����ڣ����ӡ�������ͷԪ�ص��� i - w ��ʱ��
 * 
 * �����У��� res ���鱣�洰�ڵ����ֵ���� i == w ʱ������ǰ����λ�õ��ڴ���ֵ��ʱ��ÿ�ƶ�һ�񣬽���ͷԪ����Ϊ���ֵ��ӵ� res �����С�
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
