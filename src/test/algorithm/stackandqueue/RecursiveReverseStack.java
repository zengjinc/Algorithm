package test.algorithm.stackandqueue;

import java.util.Stack;
/**
 * 
 * @author zengjinc
 * ��ν��õݹ麯����ջ��������һ��ջ��
 */
public class RecursiveReverseStack {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		System.out.println("Stack : " + stack);
		reverseStack(stack);
		System.out.println("Reverse Stack : " + stack);
	}
	
	public static void reverseStack(Stack<Integer> stack) {
		if(stack.empty()) {
			return;
		}else {
			int lastElement = getAndRemoveLastElement(stack);
			reverseStack(stack);
			stack.push(lastElement);
		}
	}
	
	public static int getAndRemoveLastElement(Stack<Integer> stack) {
		int result = stack.pop();
		if(stack.empty()) {
			return result;
		}else {
			int lastElement = getAndRemoveLastElement(stack);
			stack.push(result);
			return lastElement;
		}
	}
	
}
