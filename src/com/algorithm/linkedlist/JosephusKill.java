package com.algorithm.linkedlist;

import com.algorithm.linkedlist.datastructure.SingleListNode;

/**
 * 
 * @author zengjinc
 *
 * 据说著名犹太历史学家 Josephus有过以下的故事：在罗马人占领乔塔帕特后，39 个犹太人与Josephus及他的朋友躲到一个洞中，39个犹太人决定宁愿死也不要被敌人抓到，
 * 于是决定了一个自杀方式，41个人排成一个圆圈，由第1个人开始报数，每报数到第3人该人就必须自杀，然后再由下一个重新报数，报到3的人再自杀，知道剩下最后一个人，
 * 那个人可以自由选择自己的命运。这就是著名的约瑟夫问题。现在请用单向环形链表描述该结构并呈现整个自杀过程。
 * 
 * 输入：一个环形单向链表的头结点 head 和报数的值 m
 * 返回：最后生存下来的节点，且这个节点自己组成环形单向链表，其他节点都删除掉。
 * 
 * 进阶：要求时间复杂度为 O(N)
 * 
 * 
 * 
 */
public class JosephusKill {
	public static void main(String[] args) {
		SingleListNode head = new SingleListNode(1);
		SingleListNode node2 = new SingleListNode(2);
		SingleListNode node3 = new SingleListNode(3);
		SingleListNode node4 = new SingleListNode(4);
		
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = head;

		int m = 3;
		
		JosephusKill josephusKill = new JosephusKill();
//		SingleListNode newHead = josephusKill.josephusKill(head, m);
		SingleListNode newHead = josephusKill.josephusKill2(head, m);
		
		System.out.println();
		
	}
	
	public SingleListNode josephusKill(SingleListNode head, int m) {
		
		int kill = 0;
		
		if(m < 1 || head == null) {
			System.out.println("err : " + m + " illegal or SingleListNode is empty");
			return head;
		}
		
		while(head.next != head) {
			if(++kill == m - 1) {
				System.out.println("kill : " + head.next.value);
				head.next = head.next.next;
				kill = 0;
			}
			head = head.next;
		}
		System.out.println("survive : " + head.value);
		return head;
	}
	
public SingleListNode josephusKill2(SingleListNode head, int m) {
		int len = 1;
		
		if(m < 1 || head == null) {
			System.out.println("err : " + m + " illegal or SingleListNode is empty");
			return head;
		}
		
		SingleListNode cur = head;
		while(cur.next != head) {
			len++;
			cur = cur.next;
		}
		
		len = getLive(len, m);
		
		while(--len != 0) {
			head = head.next;
		}
		head.next = head;
		System.out.println("survive : " + head.value);
		
		return head;
	}

/*
 * @param i : Num(i),当链表长度为 i 的时候，生存节点的节点编号
 * @return : 生存节点在当前链表中的编号	
 */
public int getLive(int i, int m) {
	if(i == 1) {
		return 1;
	}
	return(getLive(i - 1, m) + m - 1) % i + 1;
}

}
