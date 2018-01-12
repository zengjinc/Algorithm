package com.algorithm.stackandqueue;

import java.util.Stack;
/**
 * 
 * @author zengjinc
 * 给栈排序，可以申请新的变量，但不能申请额外的数据结构
 */
public class SortStackByStack {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(2);
		stack.push(5);
		stack.push(1);
		stack.push(3);
		stack.push(4);
		
		System.out.println("stack : " + stack);
		
		sortStackByStack(stack);
		
		System.out.println("sorted stack : " + stack);
		
	}
	
	public static void sortStackByStack(Stack<Integer> stack) {
		Stack<Integer> help = new Stack<>();
		
		while(!stack.isEmpty()) {
			Integer cur = stack.pop();
			while(!help.isEmpty() && help.peek() < cur) {
				stack.push(help.pop());
			}
			help.push(cur);
		}
		
		while(!help.isEmpty()) {
			stack.push(help.pop());
		}
	}
	
}
