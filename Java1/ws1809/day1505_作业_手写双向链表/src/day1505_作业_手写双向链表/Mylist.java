package day1505_��ҵ_��д˫������;

public class Mylist {
	private Node head;//�ڵ�ͷ
	private Node tail;//β
	private int size;//����
	
	public void add(Object value) {
		if(head==null){//��û�������½��ڵ㼴ʹͷҲ��β
			head =new Node();
			head.value = value;//ֵ
			tail = head;//����ͷ
			//�Լ�ǰ�������Լ�
			head.prev = head;
			head.next = head;
		}else{//������
			 Node n= new Node();
			 n.value = value;
		     tail.next =n;//���
		     n.prev= tail;//��ǰ
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
	//�ڵ���
	public class Node{
		Node prev;
		Node next;
		Object value;
			
	}

}
