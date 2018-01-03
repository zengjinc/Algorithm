package test.algorithm.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author zengjinc
 * è������
 * ʵ��һ��è�����еĽṹ��Ҫ�����£�
 * �û����Ե��� add ������ cat �� dog ��ʵ�����������
 * �û����Ե��� pollAll �����������������е�ʵ���������е��Ⱥ�˳�����ε���
 * �û����Ե��� pollDog �������������� dog ���ʵ�����ս����е��Ⱥ�˳�����ε���
 * �û����Ե��� pollCat �������������� cat ���ʵ�����ս����е��Ⱥ�˳�����ε���
 * �û����Ե��� isEmpty ���������������Ƿ��� dog ���� cat ��ʵ��
 * �û����Ե��� isDogEmpty ���������������Ƿ��� dog ���ʵ��
 * �û����Ե��� isCatEmpty ���������������Ƿ��� cat ���ʵ��
 * 
 * ������
 * �ڲ��ı�ԭ���������£������µ��� PetEnterQueue �����ʱ���,������ʾ��ӵ�˳��
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
