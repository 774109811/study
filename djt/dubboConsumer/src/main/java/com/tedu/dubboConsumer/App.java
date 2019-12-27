package com.tedu.dubboConsumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tedu.dubboInterface.CartService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-consumer.xml");
    	//通过id查找对象		
    	CartService cartService = (CartService) context.getBean("cartService");
    			while (true) {
    				//调用提供者
    				String string = cartService.findCartByUserId(18L);
    				System.out.println("服务消费者收到的结果:" + string);
    				Thread.currentThread().sleep(1000);
    			}
    }
}
