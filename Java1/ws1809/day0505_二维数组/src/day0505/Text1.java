package day0505;

import java.util.Arrays;

public class Text1 {
	public static void main(String[] args) {
		char[][]a={
				{'μ','��','��','��','��','��','��'},
				{'��','��','��','��','��','ɫ','��'},
				{'Ȱ','��','��','��','һ','��','��'},
				{'��','��','��','��','��','��','��'}								
		};
		for(int i=0;i<a[0].length;i++){
			for(int j=a.length-1;j>=0;j--){
				System.out.print(a[j][i]);
			}
   
			System.out.println();
		}
		int[][]b=new int[3][2];
		b[0]= new int[] {1,2,3,4};
		System.out.println(Arrays.toString(b[0]));
		int[][] c = {
				{4,3,6,8},
				{2,6},
				{7,4,9}
				};
		System.out.println(Arrays.toString(c[1]));
		
		
	}
	
}
