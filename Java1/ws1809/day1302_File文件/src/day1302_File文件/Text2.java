package day1302_File�ļ�;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Text2 {
	public static void main(String[] args) throws IOException {
		System.out.println("���س�");
		 new Scanner(System.in).nextLine();
		File dir = new File("d:/abc/aa");
		dir.mkdirs();//�½��ļ���
		new Scanner(System.in).nextLine();
		 File f = new File("d:/abc/aa/a.txt");
		 f.createNewFile();//�½��ļ�
		new Scanner(System.in).nextLine();
		f.delete();//ɾ���ļ�
		new Scanner(System.in).nextLine();
		dir.delete();//ɾ���ļ���
		
	    new Scanner(System.in).nextLine();
	    File die = new File("d:/asdasd/asd");
	    die.mkdirs();//�½��ļ���
	    f.delete();//ɾ���ļ�
	    die.delete();//ɾ���ļ���
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	}
}
