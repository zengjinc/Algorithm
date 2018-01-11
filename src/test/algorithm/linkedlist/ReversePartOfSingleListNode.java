package test.algorithm.linkedlist;

import test.algorithm.linkedlist.datastructure.SingleListNode;

/**
 * 
 * @author zengjinc
 *
 * 反转部分单链表
 * 给定一个单向链表的头结点 head，以及两个整数 from 和 to，在单链表上把 from 到 to 节点部分进行反转。
 * 
 * 要求时间复杂度为 O（n），空间复杂度为 O（1）
 * 
 * 找到 from 的前一个节点 fPre 和 to 的后一个节点 tPos。fPre 然后对链表进行反转，正确连接 fPre 和 tPos。
 * 如果不满足 1 <= from < to <= N，则不用调整
 * 如果 fPre 为空，说明反转部分包含头结点，需要返回新的头结点。即没有反转之前，反转部分的最后一个节点，也是反转之后，反转部分的第一个节点。
 * 如果 fPre 不为空，则返回旧的头结点。
 */
public class ReversePartOfSingleListNode {
	public static void main(String[] args) {
		SingleListNode head = new SingleListNode(1);
		SingleListNode node2 = new SingleListNode(2);
		SingleListNode node3 = new SingleListNode(3);
		SingleListNode node4 = new SingleListNode(4);
		
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		System.out.println("single list node : " + head);
		
		ReversePartOfSingleListNode reversePartSingleListNode = new ReversePartOfSingleListNode();
		int from = 1;
		int to = 3;
		SingleListNode newHead = reversePartSingleListNode.reverseNode(head, from, to);
		
		System.out.println("reverse part(" + from + "," + to + ") of single list node : " + newHead);
	}
	
	public SingleListNode reverseNode(SingleListNode head, int from, int to) {
		int len = 0;
		SingleListNode node1 = head;
		SingleListNode fPre = null;
		SingleListNode tPos = null;
		
		while(node1 != null) {
			len++;
			fPre = len == from - 1 ? node1 : fPre;
			tPos = len == to + 1 ? node1 : tPos;
			node1 = node1.next;
		}
		
		if(from >= to || from < 1 || to > len) {
			System.out.println("(" + from + ","+ to +") not match rules.");
			return null;
		}
		
		node1 = fPre == null ? head : fPre.next;	//找到要反转部分的头结点，若果 fPre 为空，则头结点是第一个节点
		SingleListNode node2 = node1.next;
		node1.next = tPos;	//node1是反转之后的最后一个节点，连接 tPos
		SingleListNode next = null;
		
		//进行反转
		while(node2 != tPos) {
			next = node2.next;
			node2.next = node1;
			node1 = node2;
			node2 = next;
		}
		
		//连接 fPre
		if(fPre != null) {
			fPre.next = node1;
			return head;
		}
		
		return node1;
	}
}
