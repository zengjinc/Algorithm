package test.algorithm.stackandqueue;

import java.util.Stack;
/**
 * 
 * @author zengjinc
 * @param <T>
 * 用两个栈实现队列的功能
 * 注意： ① stackPush 往 stackPop 中压入数据，必须一次性把 stackPush 中的数据全部压入
 * 	     ② 如果 stackPop 不为空，那么 stackPush 不能向 stackPop 中压入数据
 */
public class TwoStackQueue<T> {
	private Stack<T> stackPush;
	private Stack<T> stackPop;
	
	public TwoStackQueue(){
		stackPush = new Stack<T>();
		stackPop = new Stack<T>();
	}
	
	public void push(T t) {
		stackPush.push(t);		
	}
	
	public T pop() {
		if(stackPop.empty() && stackPush.empty()) {
			throw new RuntimeException("StackQueue is empty");
		}else if(stackPop.empty()) {
			while(!stackPush.empty()) {
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.pop();
	}
	
	public T peek() {
		if(stackPop.empty() && stackPush.empty()) {
			throw new RuntimeException("StackQueue is empty");
		}else if(stackPop.empty()) {
			while(!stackPush.empty()) {
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.peek();
	}
	
	@Override
	public String toString() {
		return "StackQueue [stackPush=" + stackPush + ", stackPop=" + stackPop + "]";
	}

	public static void main(String[] args) {
		TwoStackQueue<String> stackQueue = new TwoStackQueue<String>();
		stackQueue.push("1");
		stackQueue.push("2");
		stackQueue.push("3");
		
		System.out.println(stackQueue);
		
		System.out.println("peek : " + stackQueue.peek());
		System.out.println(stackQueue);
		
		System.out.println("pop : " + stackQueue.pop());
		System.out.println(stackQueue);
		
	}
}
