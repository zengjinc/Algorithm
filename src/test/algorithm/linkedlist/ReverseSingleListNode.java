package test.algorithm.linkedlist;

public class ReverseSingleListNode {
	public static void main(String[] args) {
		SingleListNode head = new SingleListNode(1);
		SingleListNode node2 = new SingleListNode(2);
		SingleListNode node3 = new SingleListNode(3);
		
		head.next = node2;
		node2.next = node3;
		
		ReverseSingleListNode reverseSingleListNode = new ReverseSingleListNode();
		
		reverseSingleListNode.reverseNode(head);
	}
	
	public SingleListNode reverseNode(SingleListNode head) {
		SingleListNode pre = null;
		SingleListNode next = null;
		while(head != null) {
			next = head.next;
			head.next = pre;
			next.next = head;
			pre = head;
			head = next;
		}
		System.out.println("pre : " + pre);
		System.out.println("head : " + head);
		System.out.println("next : " + next);
		return head;
	}
}
