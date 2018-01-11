package test.algorithm.linkedlist;

import test.algorithm.linkedlist.datastructure.SingleListNode;

/**
 * 
 * @author zengjinc
 *
 * ��ת������
 * 
 * ʱ�临�Ӷ�Ϊ O��n�����ռ临�Ӷ�Ϊ O��1��
 */
public class ReverseSingleListNode {
	public static void main(String[] args) {
		SingleListNode head = new SingleListNode(1);
		SingleListNode node2 = new SingleListNode(2);
		SingleListNode node3 = new SingleListNode(3);
		
		head.next = node2;
		node2.next = node3;
		
		ReverseSingleListNode reverseSingleListNode = new ReverseSingleListNode();
		System.out.println("single list node : " + head);
		
		SingleListNode newHead = reverseSingleListNode.reverseNode(head);
		System.out.println("reverse single list node : " + newHead);
	}
	
	public SingleListNode reverseNode(SingleListNode head) {
		SingleListNode pre = null;
		SingleListNode next = null;
		while(head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
//		System.out.println("pre : " + pre);
//		System.out.println("head : " + head);
//		System.out.println("next : " + next);
		return pre;
	}
}
