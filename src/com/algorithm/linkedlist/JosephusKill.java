package com.algorithm.linkedlist;

import com.algorithm.linkedlist.datastructure.SingleListNode;

/**
 * 
 * @author zengjinc
 *
 * ��˵������̫��ʷѧ�� Josephus�й����µĹ��£���������ռ���������غ�39 ����̫����Josephus���������Ѷ㵽һ�����У�39����̫�˾�����Ը��Ҳ��Ҫ������ץ����
 * ���Ǿ�����һ����ɱ��ʽ��41�����ų�һ��ԲȦ���ɵ�1���˿�ʼ������ÿ��������3�˸��˾ͱ�����ɱ��Ȼ��������һ�����±���������3��������ɱ��֪��ʣ�����һ���ˣ�
 * �Ǹ��˿�������ѡ���Լ������ˡ������������Լɪ�����⡣�������õ��������������ýṹ������������ɱ���̡�
 * 
 * ���룺һ�����ε���������ͷ��� head �ͱ�����ֵ m
 * ���أ�������������Ľڵ㣬������ڵ��Լ���ɻ��ε��������������ڵ㶼ɾ������
 * 
 * ���ף�Ҫ��ʱ�临�Ӷ�Ϊ O(N)
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
 * @param i : Num(i),����������Ϊ i ��ʱ������ڵ�Ľڵ���
 * @return : ����ڵ��ڵ�ǰ�����еı��	
 */
public int getLive(int i, int m) {
	if(i == 1) {
		return 1;
	}
	return(getLive(i - 1, m) + m - 1) % i + 1;
}

}