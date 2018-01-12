package com.algorithm.linkedlist;

import com.algorithm.linkedlist.datastructure.DoubleListNode;

/**
 * 
 * @author zengjinc
 *
 * 反转单链表
 * 
 * 时间复杂度为 O（n），空间复杂度为 O（1）
 */
public class ReverseDoubleListNode {
	public static void main(String[] args) {
		DoubleListNode head = new DoubleListNode(1,null);
		DoubleListNode node2 = new DoubleListNode(2,head);
		DoubleListNode node3 = new DoubleListNode(3,node2);
		
		head.next = node2;
		node2.next = node3;
		
		System.out.println("double list node : " + head);
		
		ReverseDoubleListNode reverseDoubleListNode = new ReverseDoubleListNode();
		
		DoubleListNode newHead = reverseDoubleListNode.reverseNode(head);
		System.out.println("reverse double list node : " + newHead);
	}
	
	public DoubleListNode reverseNode(DoubleListNode head) {
		DoubleListNode pre = null;
		DoubleListNode next = null;
		while(head != null) {
			next = head.next;
			head.next = pre;
			head.last = next;
			pre = head;
			head = next;
		}
//		System.out.println("pre : " + pre);
//		System.out.println("head : " + head);
//		System.out.println("next : " + next);
		return pre;
	}
}
