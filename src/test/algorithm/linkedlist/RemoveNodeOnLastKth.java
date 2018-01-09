package test.algorithm.linkedlist;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 
 * @author zengjinc
 *
 * 实现删除单链表倒数第 K 个节点
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

