package com.algorithm.linkedlist;

import com.algorithm.linkedlist.datastructure.SingleListNode;

/**
 * 
 * @author zengjinc
 *
 * 给定两个有序链表的头指针 head1 和 head2，打印两个链表的公共部分
 */
public class ListCommonPart {
	public static void main(String[] args) {
		ListCommonPart listCommonPart = new ListCommonPart();
		
		SingleListNode node1 = new SingleListNode(1);
		SingleListNode node2 = new SingleListNode(2);
		SingleListNode node3 = new SingleListNode(3);
		
		node1.next = node2;
		node2.next = node3;
		
		SingleListNode node4 = new SingleListNode(3);
		SingleListNode node5 = new SingleListNode(4);
		SingleListNode node6 = new SingleListNode(5);
		
		node4.next = node5;
		node5.next = node6;
		
		listCommonPart.printCommonPart(node1, node4);
		
	}
	
	public void printCommonPart(SingleListNode head1, SingleListNode head2) {
		System.out.print("common part : ");
		while(head1 != null && head2 != null) {
			if(head1.value > head2.value) {
				head2 = head2.next;
			}else if(head1.value < head2.value) {
				head1 = head1.next;
			}else {
				System.out.print(head1.value + " ");
				head1 = head1.next;
				head2 = head2.next;
			}
		}
		System.out.println();
	}
	
}


