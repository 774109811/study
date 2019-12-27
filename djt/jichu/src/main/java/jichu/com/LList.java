package jichu.com;

import org.junit.Test;

public class LList {
	class Node{
		Node pre;
		Node nex;
		Object value;
	}
	private Node head;
	private Node tail;
	private int size;
	public void add(Object value) {
		if(head==null) {
			head= new Node();
			head.value=value;
			tail=head;
			head.pre=head;
			head.nex=head;
		}else {
			Node n = new Node();
			n.value=value;
			
			n.nex=head;
			head.pre=n;
			
			n.pre=tail;
			tail.nex=n;
			tail=n;			
		}
		size++;
	}
	public Object get(int i) {
		Node node=head;
		int count=0;
		while(count<i) {
			node=node.nex;
			count++;
		}
		return node.value;
	}
	public int getSize() {
		return size;
	}
	@Test
	public void test() {
		LList lList = new LList();
		lList.add("adsa");
		lList.add("ads1");
		lList.add("ads2");
		lList.add("ads3");
		System.out.println(lList.get(0));
		System.out.println(lList.get(1));
		System.out.println(lList.get(1));
		System.out.println(lList.get(2));
		System.out.println(lList.get(3));
		System.out.println(lList.get(1));
		System.out.println(lList.getSize());
		
	}
}
