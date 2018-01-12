package com.algorithm.linkedlist;

import java.util.Stack;

import com.algorithm.linkedlist.datastructure.SingleListNode;

/**
 * 
 * @author zengjinc
 *
 * 给出一个单链表的头结点，判断该链表是否为回文结构
 *
 * 进阶：如果链表长度为N,要求时间复杂度达到O(N)，空间复杂度达到O(1)
 * 
 * 如：1-->2-->3-->2-->1 是回文结构
 *     1-->2-->3-->3-->2-->1 是回文结构
 *     1-->2-->3-->1 不是回文结构
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
	 * 将链表元素的值压入栈中。再从栈顶元素开始与链表元素的值一一对比，全部相同，则为回文结构。
	 * 如： 链表                   1-->2-->3-->2-->1
	 * 入栈（从栈顶到栈底）1-->2-->3-->2-->1
	 * 
	 * 时间复杂度 O(N)， 空间复杂度O(N)
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
	 * 找到链表右半区的起点，将右半区的元素压入栈中。再与链表元素进行对比。直到栈中元素为空。
	 * 如： 链表                    1-->2-->3-->2-->1
	 * 入栈（从栈顶到栈底） 1-->2
	 * 
	 *     链表                     1-->2-->3-->3-->2-->1
	 * 入栈（从栈顶到栈底） 1-->2-->3
	 * 
	 * 时间复杂度 O(N)， 空间复杂度O(N)
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
	 * 将链表右半区逆转，再从两头开始对比节点的值。
	 * 如:1-->2-->3-->2-->1    逆转之后为: 1-->2-->3(-->null)<--2<--1
	 *    1-->2-->3-->3-->2-->1  逆转之后为: 1-->2-->3(-->null)<--3<--2<--1
	 *    
	 *    满足进阶需求，时间复杂度为O(N)，空间复杂度为O(1)
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
