package com.algorithm.interview.producerandconsumer.version1;

import java.util.ArrayList;
import java.util.List;

public class Product {
	
	public List<Integer> queue;
	public int capacity;
	
	public Product(int capacity){
		this.capacity = capacity;
		queue = new ArrayList<>(capacity);
	}
	
	public int addProduct(){
		int temp = queue.size();
		queue.add(temp);
		return temp + 1;
	}
	
	public int consumeProduct(){
		int temp = queue.remove(0);
		return temp + 1;
	}
	
}
