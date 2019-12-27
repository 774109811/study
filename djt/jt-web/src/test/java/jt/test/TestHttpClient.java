package jt.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import sun.net.www.http.HttpClient;

;

public class TestHttpClient {
	/**
	 * 1.导入jar包
	 * 2.定义请求连接url
	 * 3.获取工具API
	 * 4.定义请求方式get/post
	 * 5.利用客户端程序,发起请求,获取相应结果
	 * 6.判断请求状态码如果是200则表示请求成功
	 * 7.获取最终返回数据,进行业务处理
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 * 
	 */
	@Test
	public void testGet() throws ClientProtocolException, IOException {
		String url ="https://www.baidu.com/";
		//创建委托客户端连接对象
		CloseableHttpClient client = HttpClients.createDefault();
		//设置提交方式把url放入
		HttpGet httpGet = new HttpGet(url);
		//执行这个网页,获取想用对象response
		CloseableHttpResponse response = client.execute(httpGet);
		if(response.getStatusLine().getStatusCode()==200) {
			String string = EntityUtils.toString(response.getEntity());
			System.out.println(string);
		}
		
	}
}
