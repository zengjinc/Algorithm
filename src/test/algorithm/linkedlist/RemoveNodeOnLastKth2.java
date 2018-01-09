package test.algorithm.linkedlist;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 
 * @author zengjinc
 *
 * 实现删除双链表倒数第 K 个节点
 * 
 * 实现：
 * 从头到尾遍历链表，每走一步 K 减一
 * ① K > 0, 该链表不存在倒数第 K 个节点
 * ② K = 0, 倒数第 K 个节点就是链表的头结点
 * ③ K < 0, 重新从头遍历链表，每走一步 K 加一，直到 K = 0，此时的节点为要删除节点的前一个节点
 * 
 * 理解：
 * 链表长度为 N，要删除倒数第 K 个节点，则倒数第 K 个节点的前一个节点为 N - K 个节点。
 * 第一次遍历之后， K 的值变为 K - N。
 * 第二次遍历之后，K 的值不断增加，会停在第 N - K 个节点的位置。
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


