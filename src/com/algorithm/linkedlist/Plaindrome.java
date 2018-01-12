package com.algorithm.linkedlist;

import java.util.Stack;

import com.algorithm.linkedlist.datastructure.SingleListNode;

/**
 * 
 * @author zengjinc
 *
 * ����һ���������ͷ��㣬�жϸ������Ƿ�Ϊ���Ľṹ
 *
 * ���ף����������ΪN,Ҫ��ʱ�临�ӶȴﵽO(N)���ռ临�ӶȴﵽO(1)
 * 
 * �磺1-->2-->3-->2-->1 �ǻ��Ľṹ
 *     1-->2-->3-->3-->2-->1 �ǻ��Ľṹ
 *     1-->2-->3-->1 ���ǻ��Ľṹ
 */
public class Plaindrome {
	public static void main(String[] args) {
		SingleListNode head = new SingleListNode(1);
		SingleListNode node2 = new SingleListNode(2);
		SingleListNode node3 = new SingleListNode(3);
		SingleListNode node4 = new SingleListNode(2);
		SingleListNode node5 = new SingleListNode(1);
		
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		Plaindrome plaindrome = new Plaindrome();
		
		System.out.println(head);
//		System.out.println("is plaindrome1 : " + plaindrome.isPlaindrome1(head));
//		System.out.println("is plaindrome2 : " + plaindrome.isPlaindrome2(head));
		System.out.println("is plaindrome3 : " + plaindrome.isPlaindrome3(head));
	}
	
	/*
	 * ������Ԫ�ص�ֵѹ��ջ�С��ٴ�ջ��Ԫ�ؿ�ʼ������Ԫ�ص�ֵһһ�Աȣ�ȫ����ͬ����Ϊ���Ľṹ��
	 * �磺 ����                   1-->2-->3-->2-->1
	 * ��ջ����ջ����ջ�ף�1-->2-->3-->2-->1
	 * 
	 * ʱ�临�Ӷ� O(N)�� �ռ临�Ӷ�O(N)
	 */
	public boolean isPlaindrome1(SingleListNode head) {
		if(head == null || head.next == null) {
			return true;
		}
		
		SingleListNode temp = head;
		Stack<Integer> stack = new Stack<>();
		while(temp != null) {
			stack.push(temp.value);
			temp = temp.next;
		}
		while(head != null) {
			if(head.value != stack.pop()){
				return false;
			}
			head = head.next;
		}
		return true;
	}
	
	/*
	 * �ҵ������Ұ�������㣬���Ұ�����Ԫ��ѹ��ջ�С���������Ԫ�ؽ��жԱȡ�ֱ��ջ��Ԫ��Ϊ�ա�
	 * �磺 ����                    1-->2-->3-->2-->1
	 * ��ջ����ջ����ջ�ף� 1-->2
	 * 
	 *     ����                     1-->2-->3-->3-->2-->1
	 * ��ջ����ջ����ջ�ף� 1-->2-->3
	 * 
	 * ʱ�临�Ӷ� O(N)�� �ռ临�Ӷ�O(N)
	 */
	public boolean isPlaindrome2(SingleListNode head) {
		if(head == null || head.next == null) {
			return true;
		}
		
		SingleListNode cur = head;
		SingleListNode right = head.next;
		
		while(cur.next != null && cur.next.next != null) {
			right = right.next;
			cur = cur.next.next;
		}
		
		Stack<Integer> stack = new Stack<>();
		while(right != null) {
			stack.push(right.value);
			right = right.next;
		}
		
		while(!stack.isEmpty()) {
			if(stack.pop() != head.value) {
				return false;
			}
			head = head.next;
		}
		return true;
	}
	
	/*
	 * �������Ұ�����ת���ٴ���ͷ��ʼ�ԱȽڵ��ֵ��
	 * ��:1-->2-->3-->2-->1    ��ת֮��Ϊ: 1-->2-->3(-->null)<--2<--1
	 *    1-->2-->3-->3-->2-->1  ��ת֮��Ϊ: 1-->2-->3(-->null)<--3<--2<--1
	 *    
	 *    �����������ʱ�临�Ӷ�ΪO(N)���ռ临�Ӷ�ΪO(1)
	 */
	public boolean isPlaindrome3(SingleListNode head) {
		if(head == null || head.next == null) {
			return true;
		}
		
		SingleListNode cur = head;
//		SingleListNode temp = head;
		SingleListNode pre = head;
		SingleListNode right = null;
		
		while(cur.next != null && cur.next.next != null) {
			pre = pre.next;
			cur = cur.next.next;
		}
		right = pre.next;
		pre.next = null;
		
//		SingleListNode pre = temp;
		SingleListNode next = null;
		
		while(right != null) {
			next = right.next;
			right.next = pre;
			pre = right;
			right = next;
		}
		
		while(head != null && pre != null) {
			if(head.value != pre.value) {
				return false;
			}
			head = head.next;
			pre = pre.next;
		}
		
		return true;
	}
}
