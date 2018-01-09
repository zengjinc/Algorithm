package test.algorithm.linkedlist;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 
 * @author zengjinc
 *
 * ʵ��ɾ��˫�������� K ���ڵ�
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
public class RemoveNodeOnLastKth2 {
	public static void main(String[] args) {
		DoubleListNode head = new DoubleListNode(1,null);
		DoubleListNode DoubleListNode = new DoubleListNode(2,head);
		DoubleListNode node3 = new DoubleListNode(3,DoubleListNode);
		DoubleListNode node4 = new DoubleListNode(4,node3);
		DoubleListNode node5 = new DoubleListNode(5,node4);
		
		head.next = DoubleListNode;
		DoubleListNode.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		int lastKth = 3;
		
		System.out.println("Linked Node : " + head);
		
		RemoveNodeOnLastKth2 removeNodeOnLastKth = new RemoveNodeOnLastKth2();
		DoubleListNode newHead = removeNodeOnLastKth.removeLastKthNode(head, lastKth);
		
		System.out.println("Remove Last " + lastKth +"th Node : " + newHead);
		
	}
	
	public DoubleListNode removeLastKthNode(DoubleListNode head, int lastKth) {
		if(head == null || lastKth <= 0) {
			return head;
		}
		
		DoubleListNode currNode = head;
		while(currNode != null) {
			lastKth--;
			currNode = currNode.next;
		}
		
		if(lastKth == 0) {
			head = head.next;
		}else if(lastKth < 0){
			currNode = head;
			
			while(++lastKth != 0) {
				currNode = currNode.next;
			}
			
			currNode.next = currNode.next.next;
			currNode.next.next.last = currNode;

			while(currNode.last != null) {
				currNode = currNode.last;
			}
			return currNode;
		}
		
		return head;
	}
	
	
}


