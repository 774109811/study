package day1504_��ҵĿ¼�ܴ�С;
import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("�ļ���");
		String s= new Scanner(System.in).nextLine();
		File dir = new File(s);//�����ļ���������s�ַ�
		if(!dir.isDirectory()){//����ļ��в�����
			System.out.println("����Ĳ����ļ���");
			return;
		}
		long size = dirlength(dir);//�ļ����ֽڳ���
		System.out.println(size);
	}

	private static long dirlength(File dir) {
		//˫�������½�L
		LinkedList<File> list = new LinkedList<>();
		//��ʼ״̬dir��ӵ�list
		list.add(dir);
		//�ļ���С�ۼӱ���
		long sum =0;
		//�����ϲ��ǿռ���
		while(list.size()!=0){
			File f = list.removeFirst();
			if(f.isFile()){
				sum+=f.length();
			}else{//f���ļ���,չ���б�ȫ������listͷ��
				File[] files = f.listFiles();
				for(File f2:files){
					list.addFirst(f2);
				}
				
			}
		}
		return sum;
		
	}

}
