package test.algorithm.stackandqueue;

import java.util.LinkedList;

/**
 * 
 * @author zengjinc
 *
 * �������� arr ������ num�������ж��ٸ��������������������
 * max(arr[i..j]) - min(arr[i..j]) <= num
 * 
 * ��⣺
 * ���� MaxWindow ���õ���˫�˶�����ά�����������/Сֵ�ĸ��¡�ʱ�临�ӶȺͿռ临�Ӷȶ�Ϊ O(N)
 * 
 * ���ۣ�
 * ����������� arr[i..j] ������������ô arr[i..j] �е�ÿһ�������鶼��������
 * ����������� arr[i..j] ��������������ô���а���arr[i..j]�������飬������������
 */
public class NumOfSubArray {
	public static void main(String[] args) {
		NumOfSubArray numOfSubArray = new NumOfSubArray();
		
		int[] arr = new int[] {1,2,3};
//		int[] arr = new int[] {1,2,3,4};
		int num = 2;
		
		int res = numOfSubArray.getNum(arr, num);
		
		System.out.println("���������ֵ��ȥ��СֵС�ڵ��� " + num + " ������������ �� " + res);
		
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
