package test.algorithm.linkedlist;

import java.util.LinkedList;

/**
 * 
 * @author zengjinc
 *
 * 删除链表的中间节点
 * 
 * 1	不删除
 * 1 --> 2	删除1
 * 1 --> 2 --> 3	删除2
 * 1 --> 2 --> 3 --> 4	删除2
 * 1 --> 2 --> 3 --> 4 --> 5	删除3
 * 1 --> 2 --> 3 --> 4 --> 5 --> 6	删除3
 * 1 --> 2 --> 3 --> 4 --> 5 --> 6 --> 7	删除4
 * 
 * 如果链表为空，或者长度为1，不用删除，直接返回。
 * 从例子中可以看到，链表长度每增加 2， 要删除的节点就往后移动 1 位。
 * 所以，incrementNode 来表示链表长度的增加；用 preNode 记录要删除节点的前一个节点。
 */
public class RemoveMidNode {
	public static void main(String[] args) {
		RemoveMidNode removeMidNode = new RemoveMidNode();
		
		SingleListNode head = new SingleListNode(1);
		SingleListNode node2 = new SingleListNode(2);
		SingleListNode Node = new SingleListNode(3);
		SingleListNode node4 = new SingleListNode(4);
		
		head.next = node2;
		node2.next = Node;
		Node.next = node4;
		
		SingleListNode newHead = removeMidNode.removeMidNode(head);
		
		System.out.println(newHead);
	}
	
	public SingleListNode removeMidNode(SingleListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		if(head.next.next == null) {
			return head.next;
		}
		
		SingleListNode preNode = head;	//要删除的节点的前一个节点
		SingleListNode incrementNode = head.next.next;	//移动中的节点，每向右移动2， preNode就向右移动1
		
		LinkedList<SingleListNode> nodes = new LinkedList<>();
		nodes.addLast(preNode);
		
		while(incrementNode.next != null && incrementNode.next.next != null) {
			preNode = preNode.next;
			incrementNode = incrementNode.next.next;
			
			nodes.addLast(preNode);
		}
		
		preNode.next = preNode.next.next;
		
		preNode = preNode.next;
		while(preNode != null) {
			nodes.addLast(preNode);
			preNode = preNode.next;
		}
		
		SingleListNode newHead = getNewHead(nodes);
		
		return newHead;
	}
	
	public SingleListNode getNewHead(LinkedList<SingleListNode> nodes) {
		if(nodes.isEmpty()) {
			return null;
		}
		
		SingleListNode first = nodes.removeFirst();
		if(nodes.isEmpty()) {
			return new SingleListNode(first.value);
		}else {
			first.next = getNewHead(nodes);
			return first;
		}
		
	}
}


