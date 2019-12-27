package day1403_BufferedÁ÷;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Text1 {
	public static void main(String[] args) throws Exception {
		//BOS--FOS--f2
//		FileOutputStream out = new FileOutputStream("d:/abc/f2");
		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream("d:/abc/f2"));
		bos.write(97);
		bos.write(98);
		bos.write(99);
//		bos.flush();
		bos.close();
	}

}
