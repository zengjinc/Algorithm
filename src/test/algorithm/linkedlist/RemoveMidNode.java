package test.algorithm.linkedlist;

import java.util.LinkedList;

/**
 * 
 * @author zengjinc
 *
 * ɾ��������м�ڵ�
 * 
 * 1	��ɾ��
 * 1 --> 2	ɾ��1
 * 1 --> 2 --> 3	ɾ��2
 * 1 --> 2 --> 3 --> 4	ɾ��2
 * 1 --> 2 --> 3 --> 4 --> 5	ɾ��3
 * 1 --> 2 --> 3 --> 4 --> 5 --> 6	ɾ��3
 * 1 --> 2 --> 3 --> 4 --> 5 --> 6 --> 7	ɾ��4
 * 
 * �������Ϊ�գ����߳���Ϊ1������ɾ����ֱ�ӷ��ء�
 * �������п��Կ�����������ÿ���� 2�� Ҫɾ���Ľڵ�������ƶ� 1 λ��
 * ���ԣ�incrementNode ����ʾ�����ȵ����ӣ��� preNode ��¼Ҫɾ���ڵ��ǰһ���ڵ㡣
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
		
		SingleListNode preNode = head;	//Ҫɾ���Ľڵ��ǰһ���ڵ�
		SingleListNode incrementNode = head.next.next;	//�ƶ��еĽڵ㣬ÿ�����ƶ�2�� preNode�������ƶ�1
		
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


