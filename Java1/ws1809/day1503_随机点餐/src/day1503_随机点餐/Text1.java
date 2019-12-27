package day1503_������;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Text1 {
private static List<Food>list;//����һ��Food���ϵĳ�Ա����

	
	public static void main(String[] args) throws Exception {
		//���ȶ�ȡ�ļ�food-list.txt���ɼ��ϣ���һ����װfood
		System.out.println("���س�");
		while(true){
			new Scanner(System.in).nextLine();
			list =load();//�������ط��������浽���������
//		System.out.println(list);//��ӡ�������
			
			int index =list.size()/3*2;
			//��������ѡ��ʳ�������
			Food[] a = new Food[3];
			a[0] = list.get(new Random().nextInt(index));
			//��ѭ��ѡ��ڶ���
			while(true){
				Food f = list.get(
						new Random().nextInt(index));
				//�ظ���ѡ����ͬһ������
				if(f == a[0]){
					continue;
				}
				a[1]= f;
				break;
			}
			//������
			//index+[0,size()-index)
			a[2] = list.get(index+new Random().nextInt(list.size()-index));
			//����ʳ���ѡ���������
			for(Food f:a){
				f.setTimes(f.getTimes()+1);
			}
			//list�����������д����
			Collections.sort(list);
			//list�����ݣ����浽�ļ�
			save(list);
			
			//��ʾѡ����
			for(Food f:a){
				System.out.println(f.getName());
			}
			
			
		}
		}

	private static void save(List<Food> list) throws Exception {
		//�Ȼ��·��
		String path =getPath();
		//PW--OSW--FOS--path,���path·����ת����GBK
		PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(path),"GBK"));
		for(Food f:list){ //��������ļ�·�������
			out.println(f);
		}
		out.close();//������ر������
	}

	private static List<Food> load() throws Exception {
		String path =getPath();//��ȡfood�ļ���·��
//		System.out.println(path);
		//BR-ISR--FIS--path
		List<Food> list = new ArrayList<>();//����һ������
		//��ȡ���path���·��Ȼ��ת��GBK��ʽ
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(path),"GBK"));
		String line;//����һ������
		while((line=in.readLine())!=null){//����ȡ�����·�����ǿ�ֵ
			line = line.trim();//�Ѷ�ȡ���ַ���ǰ��ո����
			if("".equals(line)){//���һ���ǿյ�ֱ������
				continue;
			}
			String[]a =line.split(";");//�ӣ��Ͽ��ַ�
			Food f=new Food(a[0].trim(),Integer.parseInt(a[1].trim()));
			list.add(f);//
		}
		
		return list;
	}

	private static String getPath() throws Exception {
		/*
		 * Test1.class�������
		 * D:\lesson\1809\ws1809\day1503_������\bin
		 * ��Test1.class�����һ����ļ���
		 * ���������binĿ¼������
		 * 
		 * "/" ���������Ŀ¼,binĿ¼
		 * "/food-list.txt"
		 * "/day1503/food-list.txt"
		 */
		//����URL�����ʽ
		//���ı����UTF-8�ֽ�ֵ
		//%e9%9a%8f

		//����URL�����ʽ
		//���ı����UTF-8�ֽ�ֵ                                                                      //��ȡfood�ļ�·��������д������/��+�ļ���
		String path = Text1.class.getResource("/food-list.txt").getPath();//��ȡfood�ļ�·��
		//URL���������������
		path = URLDecoder.decode(path, "UTF-8");
		
		return path;
	}

}
