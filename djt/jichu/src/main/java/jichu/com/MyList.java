package jichu.com;

import org.junit.Test;

public class MyList {
	class Node{
		Node prev;
		Node next;
		Object value;
	}
	private Node head;
	private Node tail;
	private int size;
	public void add(Object value) {
		if(head==null) {
			head = new Node();
			head.value=value;
			tail=head;
			head.prev=head;
			head.next=head;
		}else {
			Node n = new Node();
			n.value=value;
			n.prev=tail;
			tail.next=n;
			n.next=head;
			head.prev=n;
			tail=n;		
		}
		size++;
	}
	
	public Object get(int i) {//0 1 2 3
		Node node=head;//0 1 1 2
		int count=0;//0 0 1 1
		while(count<i) {// 
			node=node.next;// 1 2 3
			count++;// 1 2 3
		}
		
		return node.value;//0 1 2 3
	}
	public int getSize() {
		return size;
	}
	@Test
	public void test() {
		MyList myList = new  MyList();
		myList.add(11);
		myList.add(12);
		myList.add(13);
		myList.add(14);
		myList.add(15);
		System.out.println(myList.get(0)); 
		System.out.println(myList.get(1)); 
		System.out.println(myList.get(2)); 
		System.out.println(myList.get(3)); 
		System.out.println(myList.get(4)); 
		System.out.println(myList.get(4)); 
		System.out.println(myList.get(4)); 
		System.out.println(myList.getSize());
	
	}
	
}
