package test.algorithm.stackandqueue;

import java.util.Stack;
/**
 * 
 * @author zengjinc
 * @param <T>
 * ������ջʵ�ֶ��еĹ���
 * ע�⣺ �� stackPush �� stackPop ��ѹ�����ݣ�����һ���԰� stackPush �е�����ȫ��ѹ��
 * 	     �� ��� stackPop ��Ϊ�գ���ô stackPush ������ stackPop ��ѹ������
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
