package com.algorithm.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 
 * @author zengjinc
 * 
 */
public class TestQueue {
	public static void main(String[] args) throws InterruptedException {
//		new AbstractQueue();
		Queue<String> queue = new LinkedList<String>();
		LinkedList<String> linkedList = new LinkedList<String>();
		System.out.println(linkedList instanceof Queue);
		
		linkedList.addLast("s2");
		linkedList.addFirst("s1");
		System.out.println(linkedList);
		System.out.println(linkedList.peekFirst());
		System.out.println(linkedList);
//		queue.enqueue("cat1");
//		queue.enqueue("dog1");
//		queue.enqueue("cat2");
//		printQueue(queue);
//		
//		System.out.println("dequeue : " + queue.dequeue());
//		printQueue(queue);
//		
//		queue.dump(null);
		
		
	}
	
//	public static void printQueue(Queue<String> queue) {
//		Enumeration<String> elements = queue.reverseElements();
//		System.out.print("Queue : ");
//		while(elements.hasMoreElements()) {
//			System.out.print(elements.nextElement() + "	");
//		}
//		System.out.println();
//	}
}
