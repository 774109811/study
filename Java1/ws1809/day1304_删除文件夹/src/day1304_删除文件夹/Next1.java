package day1304_ɾ���ļ���;

import java.io.File;
import java.util.Scanner;

public class Next1 {
	public static void main(String[] args) {
		System.out.println("����Ҫɾ�����ļ��У����ɻָ�����");
		String s= new Scanner(System.in).nextLine();
		File dir = new File(s);
		if(!dir.isDirectory()){
			System.out.println("����Ĳ����ļ���");
			return;
		}
		
		boolean b = deleteDir(dir);
		if(b){
			System.out.println("ɾ���ɹ�");
		}else{
			System.out.println("ɾ��ʧ��");
		}
	}
	private static boolean deleteDir(File dir) {
		File[] files = dir.listFiles();//���ļ����ļ��зŵ�������
		if(files==null ){//������ǿյ�
			return dir.delete();//�б��в���������ɾ��Ŀ¼
		}
		for(File f:files){//�������������ļ������ļ���
			if(f.isFile()){//��������ļ�
				if(!f.delete()){//���û��ɾ���ļ�
					return false;//���ش���
				}
			}
		else{
			if(!deleteDir(f)){//������ļ�
				return false;
			}
		}	
	}
		return dir.delete();//ɾ��dir�ļ���
	}
}
