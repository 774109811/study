package day06;

import java.util.Arrays;

public class Text {
	public static void main(String[] args) {
		int[]a={2,1,3};
//		��0λ�ÿ�ʼ������ֵȫ����
		f(a,0);
	}

	private static void f(int[] a, int start) {
//		  start
		/* |
		 * 123
		 * i
		 * 
		 * ��startλ�ã��̶�һ��ֵ
		 * /��start+1�����ֵȫ����
		 * �������
		 * start��ĩβλ�ã�ֻ��ĩβһ��ֵ����
		 */
		if(start==a.length-1){
			System.out.println(Arrays.toString(a));
			return;
		}
		for(int i=start;i<a.length;i++){
//			i��startλ�ý���
			swap(a,i,start);
			f(a,start+1);
//			�ݹ��start+1֮���ֵȫ����
			//�ڽ���������������������ݻ���
			swap(a,i,start);
		}
	}
	private static void swap(
			int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

}
