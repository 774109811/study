package day1404_Buffered�ļ����;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.stream.FileImageOutputStream;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("����Ҫ��ֵ��ļ���");
		String s1= new Scanner(System.in).nextLine();
		 File from = new File("D:/abc/IMG_0076.JPG");//�½��ļ��ļ���λS1
		if(!from.isFile()){//��������ļ�ֱ�ӷ���
			System.out.println("�����ļ�");
			return;
		}
		 System.out.println("����ļ��Ĵ�С��kb��:");
		 long size= new Scanner(System.in).nextLong();//�ļ��Ĵ�С
		size*=1024;//kb---byte ��Сת���ֽڵ�λ
		
		try {
			split(from,size);//Ҫ��ֵ��ļ����Ͳ�ֺ�Ĵ�С������һ������
			System.out.println("���");
		} catch (Exception e) {
			System.out.println("ʧ��");
			e.printStackTrace();
		}
	}

	private static void split(File from, long size) throws Exception {
		//׼���ļ���
		File dir=zbwjj(from);//׼��һ���ļ��У�����һ�����������浽dir
		//�Ȼ��ԭ�ļ���
		String name=from.getName();
		
		long byteCount=0;//�ֽڼ���
		int fileCount=0;//�ļ�����
		FileInputStream in = new FileInputStream(from);//�ļ�������
		FileOutputStream out =null;//�ļ������
		int b;
		while((b=in.read())!=-1){//��������-1���b
			//û�������ʱ����Ҫ���������ļ�������Ҫ���������
			if(out==null||byteCount==size){//������λ�ջ���������ֽڵ���������ֽ�
				if(byteCount==size){//������ֽڵ���������ֽ�
					out.close();//�ر�ǰһ���� 
				}
				out = new FileOutputStream(new File(dir,name+"."+(++fileCount)));
				byteCount=0;//��д��ʼ��//�ļ�������ļ���new File���ļ��У��ļ�����
			//��������½����ļ����ļ�����
			}
			out.write(b);//���b
			byteCount++;//�ֽ�����
		}
		in.close();
		out.close();
		
	}

	private static File zbwjj(File from) {
		File dir = new File(from.getAbsoluteFile()+"_split");//��õ�·����׺����_split
		if(!dir.exists()){//������·��������
			dir.mkdir();//�½�һ���ļ���
		}else{//����������ļ�����һ������ķ���
			clean(dir);
		}
		return dir;
	}

	private static void clean(File dir) {
		
		File[] files = dir.listFiles();//�õ��ļ���������files
		for(File f:files){//�����������
			if(f.isFile()){//������ļ�
				f.delete();//ɾ���ļ�f
			}else{ 
				clean(f);//����ļ�������ļ�f
				f.delete();//ɾ���ļ���f
			}
		}
		
	}

}
