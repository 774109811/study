package day1801;

import java.lang.reflect.Field;

public class Text3 {
	public static void main(String[] args) throws Exception {
	   Class<Student> c = Student.class;//����һ�������
	   
	   Student s = new Student(5,"zhang��","��",16);
	   //���ʷ������
	   Field id = c.getDeclaredField("id");//��ȡ��Ա����id
	   id.setAccessible(true);//����������Է���˽�б���
	   Object v  =id.get(s);//������ʱ�����ֵ
	   System.out.println(v);
	   id.set(s, 999);//����λ��������
	   System.out.println(s.getId());
	   
}
}