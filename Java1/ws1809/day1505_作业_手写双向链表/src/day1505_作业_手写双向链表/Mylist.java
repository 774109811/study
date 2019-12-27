package day1505_作业_手写双向链表;

public class Mylist {
	private Node head;//节点头
	private Node tail;//尾
	private int size;//数量
	
	public void add(Object value) {
		if(head==null){//还没有数据新建节点即使头也是尾
			head =new Node();
			head.value = value;//值
			tail = head;//既是头
			//自己前后都引用自己
			head.prev = head;
			head.next = head;
		}else{//有数据
			 Node n= new Node();
			 n.value = value;
		     tail.next =n;//向后
		     n.prev= tail;//向前
		     head.prev=n;
		     n.next=head;
		     tail = n;
		    
		}
		size++;
	}
	public Object get(int i) {
		//
		Node n =head;
		int count = 0;
		while(count<i){
			n=n.next;
			count++;
		}
		return n.value;
	}
	public int size() {
		return size;
	}
	//节点类
	public class Node{
		Node prev;
		Node next;
		Object value;
			
	}

}
