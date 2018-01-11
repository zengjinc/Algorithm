package test.algorithm.linkedlist;

import test.algorithm.linkedlist.datastructure.SingleListNode;

/**
 * 
 * @author zengjinc
 *
 * ��ת���ֵ�����
 * ����һ�����������ͷ��� head���Լ��������� from �� to���ڵ������ϰ� from �� to �ڵ㲿�ֽ��з�ת��
 * 
 * Ҫ��ʱ�临�Ӷ�Ϊ O��n�����ռ临�Ӷ�Ϊ O��1��
 * 
 * �ҵ� from ��ǰһ���ڵ� fPre �� to �ĺ�һ���ڵ� tPos��fPre Ȼ���������з�ת����ȷ���� fPre �� tPos��
 * ��������� 1 <= from < to <= N�����õ���
 * ��� fPre Ϊ�գ�˵����ת���ְ���ͷ��㣬��Ҫ�����µ�ͷ��㡣��û�з�ת֮ǰ����ת���ֵ����һ���ڵ㣬Ҳ�Ƿ�ת֮�󣬷�ת���ֵĵ�һ���ڵ㡣
 * ��� fPre ��Ϊ�գ��򷵻ؾɵ�ͷ��㡣
 */
public class ReversePartOfSingleListNode {
	public static void main(String[] args) {
		SingleListNode head = new SingleListNode(1);
		SingleListNode node2 = new SingleListNode(2);
		SingleListNode node3 = new SingleListNode(3);
		SingleListNode node4 = new SingleListNode(4);
		
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		System.out.println("single list node : " + head);
		
		ReversePartOfSingleListNode reversePartSingleListNode = new ReversePartOfSingleListNode();
		int from = 1;
		int to = 3;
		SingleListNode newHead = reversePartSingleListNode.reverseNode(head, from, to);
		
		System.out.println("reverse part(" + from + "," + to + ") of single list node : " + newHead);
	}
	
	public SingleListNode reverseNode(SingleListNode head, int from, int to) {
		int len = 0;
		SingleListNode node1 = head;
		SingleListNode fPre = null;
		SingleListNode tPos = null;
		
		while(node1 != null) {
			len++;
			fPre = len == from - 1 ? node1 : fPre;
			tPos = len == to + 1 ? node1 : tPos;
			node1 = node1.next;
		}
		
		if(from >= to || from < 1 || to > len) {
			System.out.println("(" + from + ","+ to +") not match rules.");
			return null;
		}
		
		node1 = fPre == null ? head : fPre.next;	//�ҵ�Ҫ��ת���ֵ�ͷ��㣬���� fPre Ϊ�գ���ͷ����ǵ�һ���ڵ�
		SingleListNode node2 = node1.next;
		node1.next = tPos;	//node1�Ƿ�ת֮������һ���ڵ㣬���� tPos
		SingleListNode next = null;
		
		//���з�ת
		while(node2 != tPos) {
			next = node2.next;
			node2.next = node1;
			node1 = node2;
			node2 = next;
		}
		
		//���� fPre
		if(fPre != null) {
			fPre.next = node1;
			return head;
		}
		
		return node1;
	}
}
