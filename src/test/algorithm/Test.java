package test.algorithm;

import java.util.Stack;

public class Test {
	public static void main(String[] args) {
//		System.out.println("main method of test class");
		Stack<String> stack = new Stack<>();
		stack.push("1");
		stack.push("2");
		stack.push("3");
		System.out.println(stack.peek());
		System.out.println(stack);
//		System.out.println(stack.firstElement());
//		System.out.println(stack.lastElement());
//		System.out.println(stack);
//		System.out.println(stack.pop());
//		System.out.println(stack);
	}
//	public void method1(){
//		System.out.println("method1 of test class");
//	}
	
	public void method1(){
		System.out.println("method1 of test class");
		System.out.println("test");
	}
	
	public void method2(){
		System.out.println("methdo2 of test class");
	}
	
}
