package day1404_Buffered�ļ��ϲ�;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("����ļ����Ŀ¼��");
		String s1 = new Scanner(System.in).nextLine();
		File dir = new File(s1);//��s1���ִ浽�ļ���dir
		if(! dir.isDirectory()) {//�����ļ��У�ֱ�ӷ���
			System.out.println("�����ļ���");
			return;
		}
		
		
		System.out.println("�ϲ���Ŀ���ļ���");
		String s2 = new Scanner(System.in).nextLine();
		File to = new File(s2);//����Ҫ�ϲ���Ŀ���ļ�
		if(to.isDirectory()) {//�������ļ��У��������ļ�
			System.out.println("�������ļ���");
			return;
		}
		
		try {
			heBing(dir, to);//����һ����������to�ļ��ϲ���dir�ļ�����
			System.out.println("���");
		} catch (Exception e) {
			System.out.println("ʧ��");
			e.printStackTrace();
		}
		
		
	}

	private static void heBing(
			File dir, File to) throws Exception{
		//��dir�ļ���Ŀ¼�б����Ȼ���������һ������
		File[] files = list(dir);//
		//���ļ�����ϲ�����Ҫ�ȶ�ȡ������������
		FileOutputStream out = new FileOutputStream(to);
		FileInputStream in;//��ȡ
		byte[] buff = new byte[8192];//����������ȡ
		int n;//ÿһ��������
		
		//�����ļ��б�
		for (File f : files) {
			in = new FileInputStream(f);//������ȡ�ļ�������
			while((n = in.read(buff)) != -1) {//����������-1ʱ
				out.write(buff,0,n);//д���ȡ�������ļ� ����0��ʼ��n
			}
			in.close();//�����Ȼ��رն�ȡ
		}
		out.close();//���ر�д�������
	}

	private static File[] list(File dir) {//���ļ�������ļ��б�
		File[] files = dir.listFiles();//��dir����ļ��б��������浽files
		Arrays.sort(files, new Comparator<File>() {//Ȼ��Ƚ�Fileĩβ��.���������
			@Override
			public int compare(File o1, File o2) {
				String n1 = o1.getName();//��ȡ�ļ�������
				String n2 = o2.getName();
				// xxx.xx.23 --> 23
				//substring��ȡ�ַ����е��ִ� .+1���±�λ��                                                  
				n1 = n1.substring(n1.lastIndexOf(".")+1);
				n2 = n2.substring(n2.lastIndexOf(".")+1);
				int a = Integer.parseInt(n1);//���ַ���������int����
				int b = Integer.parseInt(n2);
				return a-b;			//�Ƚϴ�С	
			}
		});
		return files;//������һ���ļ�
	}

}
