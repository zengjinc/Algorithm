package test.algorithm.linkedlist;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 
 * @author zengjinc
 *
 * ʵ��ɾ������������ K ���ڵ�
 * 
 * ʵ�֣�
 * ��ͷ��β��������ÿ��һ�� K ��һ
 * �� K > 0, ���������ڵ����� K ���ڵ�
 * �� K = 0, ������ K ���ڵ���������ͷ���
 * �� K < 0, ���´�ͷ��������ÿ��һ�� K ��һ��ֱ�� K = 0����ʱ�Ľڵ�ΪҪɾ���ڵ��ǰһ���ڵ�
 * 
 * ��⣺
 * ������Ϊ N��Ҫɾ�������� K ���ڵ㣬������ K ���ڵ��ǰһ���ڵ�Ϊ N - K ���ڵ㡣
 * ��һ�α���֮�� K ��ֵ��Ϊ K - N��
 * �ڶ��α���֮��K ��ֵ�������ӣ���ͣ�ڵ� N - K ���ڵ��λ�á�
 */
public class RemoveNodeOnLastKth {
	public static void main(String[] args) {
		SingleListNode head = new SingleListNode(1);
		SingleListNode node2 = new SingleListNode(2);
		SingleListNode node3 = new SingleListNode(3);
		SingleListNode node4 = new SingleListNode(4);
		SingleListNode node5 = new SingleListNode(5);
		
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		int lastKth = 3;
		
		System.out.println("Linked Node : " + head);
		
		RemoveNodeOnLastKth removeNodeOnLastKth = new RemoveNodeOnLastKth();
		SingleListNode newHead = removeNodeOnLastKth.removeLastKthNode(head, lastKth);
		
		System.out.println("Remove Last " + lastKth +"th Node : " + newHead);
	}
	
	public SingleListNode removeLastKthNode(SingleListNode head, int lastKth) {
		if(head == null || lastKth <= 0) {
			return head;
		}
		
		SingleListNode currNode = head;
		while(currNode != null) {
			lastKth--;
			currNode = currNode.next;
		}
		
		if(lastKth == 0) {
			head = head.next;
		}else if(lastKth < 0){
			currNode = head;
			LinkedList<SingleListNode> nodes = new LinkedList<>();
			
			while(++lastKth != 0) {
				nodes.addLast(currNode);
				currNode = currNode.next;
			}
			
			currNode.next = currNode.next.next;
			
			while(currNode != null) {
				nodes.addLast(currNode);
				currNode = currNode.next;
			}
			
//			System.out.println("nodes : " + nodes);
			SingleListNode newHead = getNewHead(nodes);
			
			return newHead;
		}
		
		return head;
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

