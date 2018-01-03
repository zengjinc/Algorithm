package test.algorithm.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author zengjinc
 * 猫狗队列
 * 实现一种猫狗队列的结构，要求如下：
 * 用户可以调用 add 方法将 cat 或 dog 的实例放入队列中
 * 用户可以调用 pollAll 方法，将队列中所有的实例按进队列的先后顺序依次弹出
 * 用户可以调用 pollDog 方法，将队列中 dog 类的实例按照进队列的先后顺序依次弹出
 * 用户可以调用 pollCat 方法，将队列中 cat 类的实例按照进队列的先后顺序依次弹出
 * 用户可以调用 isEmpty 方法，检查队列中是否还有 dog 或者 cat 的实例
 * 用户可以调用 isDogEmpty 方法，检查队列中是否还有 dog 类的实例
 * 用户可以调用 isCatEmpty 方法，检查队列中是否还有 cat 类的实例
 * 
 * 方法：
 * 在不改变原有类的情况下，定义新的类 PetEnterQueue ，添加时间戳,用来表示添加的顺序
 */
public class CatDogQueue{
	private Queue<PetQueue> catQueue;
	private Queue<PetQueue> dogQueue;
	private Long count;
	
	public CatDogQueue() {
		this.catQueue = new LinkedList<>();
		this.dogQueue = new LinkedList<>();
		this.count = 0L;
	}
	
	public void add(Pet pet) {
		if(pet.getPetType().equals("cat")) {
			catQueue.add(new PetQueue(pet, this.count++));
		}else if(pet.getPetType().equals("dog")){
			dogQueue.add(new PetQueue(pet, this.count++));
			
		}else {
			throw new RuntimeException(pet + " is not a cat or dog");
		}
	}
	
	public Pet pollAll() {
		if(catQueue.isEmpty() && dogQueue.isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}else if(!catQueue.isEmpty() && !dogQueue.isEmpty()) {
			if(dogQueue.peek().getCount() < catQueue.peek().getCount()) {
				return dogQueue.poll().getPet();
			}else {
				return catQueue.poll().getPet();
			}
		}else if (!catQueue.isEmpty()) {
			return catQueue.poll().getPet();
		}else {
			return dogQueue.poll().getPet();
		}
	}
	
	public Pet pollDog() {
		if(dogQueue.isEmpty()) {
			throw new RuntimeException("dog queue is empty.");
		}else {
			return dogQueue.poll().getPet();
		}
	}
	
	public Pet pollCat() {
		if(catQueue.isEmpty()) {
			throw new RuntimeException("cat queue is empty");
		}else {
			return catQueue.poll().getPet();
		}
	}
	
	public Boolean isEmpty() {
		return catQueue.isEmpty() && dogQueue.isEmpty();
	}
	
	public Boolean isDogEmpty() {
		return dogQueue.isEmpty();
	}
	
	public Boolean isCatEmpty() {
		return catQueue.isEmpty();
	}
	
	public static void main(String[] args) {
		CatDogQueue catDogQueue = new CatDogQueue();
		
		Pet pet1 = new Cat();
		Pet pet2 = new Dog();
		Pet pet3 = new Cat();
		
		catDogQueue.add(pet1);
		catDogQueue.add(pet2);
		catDogQueue.add(pet3);
		
		System.out.println("catDogQueue is empty : " + catDogQueue.isEmpty());
		System.out.println("catQueue is empty : " + catDogQueue.isCatEmpty());
		System.out.println("dogQueue is empty : " + catDogQueue.isDogEmpty());
		
//		System.out.println("poll dog : " + catDogQueue.pollDog().getPetType());
		
//		System.out.println("poll cat : " + catDogQueue.pollCat().getPetType());
//		System.out.println("poll cat : " + catDogQueue.pollCat().getPetType());
		
//		System.out.println("poll pet : " + catDogQueue.pollAll().getPetType());
//		System.out.println("poll pet : " + catDogQueue.pollAll().getPetType());
//		System.out.println("poll pet : " + catDogQueue.pollAll().getPetType());
//		System.out.println("catDogQueue is empty : " + catDogQueue.isEmpty());
//		System.out.println("catQueue is empty : " + catDogQueue.isCatEmpty());
//		System.out.println("dogQueue is empty : " + catDogQueue.isDogEmpty());
		
	}
	
}

class PetQueue{
	private Pet pet;
	private Long count;
	
	public PetQueue(Pet pet,Long count) {
		this.pet = pet;
		this.count = count;
	}

	public Pet getPet() {
		return pet;
	}

	public Long getCount() {
		return count;
	}

}

class Pet {
	private String type;
	
	public Pet(String type) {
		this.type = type;
	}
	
	public String getPetType() {
		return type;
	}
	
}

class Dog extends Pet{
	public Dog() {
		super("dog");
	}
	
}

class Cat extends Pet{
	public Cat() {
		super("cat");
	}
	
}
