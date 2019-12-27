package cgb.java.nio;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.Test;

public class TestNIOFileChanel01 {
	//同步阻塞
	@Test
	public void testFileChannel()throws Exception{
		//构建一个Buffer对象(缓冲区)：JVM内存
		ByteBuffer buf=ByteBuffer.allocate(1024);
		//构建一个文件通道对象(可以读写数据)
		FileChannel fChannel=
		FileChannel.open(Paths.get("data.txt"),//文件路径
		StandardOpenOption.READ);//读模式
		//将文件内容读到缓冲区(ByteBuffer) 
		fChannel.read(buf);
		//缓冲区有多少数据
		System.out.println(buf.position());
		//从Buffer中取数据
		System.out.println("切换buf模式，开始从buf读数据");
		//切换模式
		buf.flip();
		System.out.println(buf.limit()); 
		System.out.println(buf.position());
		System.out.println(new String(buf.array()));//取出文件信息
		//释放资源
		fChannel.close();
	}
}
