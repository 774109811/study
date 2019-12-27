package day1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.activation.URLDataSource;

//�����������ļ�
//
public class Runner {
	private static   List<String> list  = new ArrayList<String>();
	static {
		
		try {
			//���runner���ȡ����ļ���Ȼ���ٻ������·��
			String path = Runner.class.getResource("/config.txt").getPath();
			//��������ģ�Ȼ����URLDecoder.decode(path��·����,���ֽ��룩"UTF-8");�������·��
			path =URLDecoder.decode(path,"UTF-8");
			//��ȡ���·��һ��һ�еĶ�+Ȼ�����ַ�����ת����ת����GBK��+�ļ�����ȡ���·��
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(path),"GBK"));
			
			
			String line;
			while((line=in.readLine() )!=null) {
				line = line.trim();
				if(line.length()==0) {
					continue;
				}
				list.add(line);//��ȡ���ļ��������������
			}
			System.out.println(list);//��ӡ�������
			in.close();//�رն�ȡ
		} catch (Exception e) {
			System.out.println("���������ļ�config,txt ʧ��");
			e.printStackTrace();
		}
		
	}
	
	public static void launch() throws Exception {//����������������
		for(String  s: list){
			String [] a= s.split(";"); //�ָ��ַ���
			Class<?> c = Class.forName(a[0].trim());//��ȡ��
			
			Object obj = c.newInstance();//������޲ι���
			
			Method m = c.getMethod(a[1].trim());//��ȡ���ķ���
			//��������
			m.invoke(obj);
			
		}
		
		
	}
	
	public static void main(String[] args) {
		System.out.println("---------------");
	}
}
