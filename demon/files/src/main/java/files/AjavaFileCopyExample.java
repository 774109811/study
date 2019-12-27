package files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class AjavaFileCopyExample {
	public static void main(String[] args) throws IOException
	{
		// 源File对象
		File source = new File("c:/a.txt");
		FileInputStream fileInputStream = new FileInputStream(source);
		// 备份的File对象
		File target = new File("c:/abc-a.txt");
		FileUtils.copyToFile(fileInputStream, target);
	}

}
