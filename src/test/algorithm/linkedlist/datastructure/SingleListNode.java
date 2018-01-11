package test.algorithm.linkedlist.datastructure;

public class SingleListNode{
	public int value;
	public SingleListNode next;
	
	public SingleListNode(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "[value=" + value + ", next=" + next + "]";
	}
	
}
