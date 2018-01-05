package test.algorithm.stackandqueue;

import java.util.HashMap;
import java.util.Stack;

/**
 * 
 * @author zengjinc
 * 
 * ����һ��û���ظ�Ԫ�ص����� arr�����ɸ������ MaxTree
 * 
 * MaxTree�Ķ��壺
 *   ����û���ظ�Ԫ��
 *   MaxTree ��һ�Ŷ������������ÿһ��ֵ��Ӧһ���������ڵ�
 *   ���� MaxTree �������������е�ÿһ�������ϣ�ֵ���Ľڵ㶼������ͷ
 *   
 * ����ԭ��
 *   ÿһ�����ĸ��ڵ�������ߵ�һ����������������ұߵ�һ������������У���С���Ǹ�
 *   ���һ�������û�б�����������ұ�Ҳû�С���������� MaxTree �ĸ��ڵ㡣
 *   
 * ��⣺
 *   ��ÿ������ߵ�һ������������������ұ���ÿ������ջ�б��ֵݼ����У�������������ջ�� pop ��ջ��ֱ��ջ�������������ջΪ��
 *   ͬ����ÿ�����ұߵ�һ����������������ҵ��������
 */
public class MaxTreeOfArray {
	public static void main(String[] args) {
		MaxTreeOfArray maxTreeOfArray = new MaxTreeOfArray();
		int[] arr = new int[] {3,4,5,1,2};
		
		Node maxTree = maxTreeOfArray.getMaxTree(arr);
		
		System.out.println(maxTree);
	}
	
	public Node getMaxTree(int[] arr) {
		Node[] nodes = new Node[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			nodes[i] = new Node(arr[i]);
		}
		
		Stack<Node> stack = new Stack<Node>();
		HashMap<Node, Node> lBigMap = new HashMap<Node,Node>();
		HashMap<Node, Node> rBigMap = new HashMap<Node,Node>();

		for (int i = 0; i < nodes.length; i++) {
			Node currNode = nodes[i];
			while((!stack.isEmpty()) && stack.peek().value < currNode.value) {
				popStackSetMap(stack, lBigMap);
			}
			stack.push(currNode);
		}
		
		while(!stack.isEmpty()) {
			popStackSetMap(stack, lBigMap);
		}
		
		for (int i = nodes.length - 1; i >= 0; i--) {
			Node currNode = nodes[i];
			while((!stack.isEmpty()) && stack.peek().value < currNode.value) {
				popStackSetMap(stack, rBigMap);
			}
			stack.push(currNode);
		}
			
		while(!stack.isEmpty()) {
			popStackSetMap(stack, rBigMap);
		}
			
		Node head = null;
		
		for (int i = 0; i < nodes.length; i++) {
			Node currNode = nodes[i];
			Node left = lBigMap.get(currNode);
			Node right = rBigMap.get(currNode);
			
			if(left == null && right == null) {
				head = currNode;
			}else if(left == null) {
				if(right.left == null) {
					right.left = currNode;
				}else {
					right.right = currNode;
				}
			}else if(right == null) {
				if(left.left == null) {
					left.left = currNode;
				}else {
					left.right = currNode;
				}
			}else {
				Node parent = left.value > right.value ? right : left ;
				if(parent.left == null) {
					parent.left = currNode;
				}else {
					parent.right = currNode;
				}
			}
			
		}
		
		return head;
	}
	
	public void popStackSetMap(Stack<Node> stack, HashMap<Node,Node> map) {
		Node currNode = stack.pop();
		if(stack.isEmpty()) {
			map.put(currNode, null);
		}else {
			map.put(currNode, stack.peek());
		}
	}
	
	class Node{
		public int value;
		public Node left;
		public Node right;
		
		public Node(int value) {
			this.value = value;
		}
	}
}
