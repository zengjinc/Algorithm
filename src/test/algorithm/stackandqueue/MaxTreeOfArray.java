package test.algorithm.stackandqueue;

import java.util.HashMap;
import java.util.Stack;

/**
 * 
 * @author zengjinc
 * 
 * 给定一个没有重复元素的数组 arr，生成该数组的 MaxTree
 * 
 * MaxTree的定义：
 *   数组没有重复元素
 *   MaxTree 是一颗二叉树，数组的每一个值对应一个二叉树节点
 *   包括 MaxTree 数在内且在其中的每一颗子数上，值最大的节点都是树的头
 *   
 * 建树原则：
 *   每一个数的父节点是它左边第一个比它大的数和它右边第一个比它大的数中，较小的那个
 *   如果一个数左边没有比它大的数，右边也没有。即这个数是 MaxTree 的根节点。
 *   
 * 理解：
 *   找每个数左边第一个比它大的数，从左到右遍历每个数，栈中保持递减序列，新来的数利用栈的 pop 出栈，直到栈顶比新数大或者栈为空
 *   同理，找每个数右边第一个比它大的数，从右到左遍历。
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
