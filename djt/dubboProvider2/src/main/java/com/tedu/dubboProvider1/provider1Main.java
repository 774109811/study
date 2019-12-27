package com.tedu.dubboProvider1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class provider1Main 
{
	public static void main( String[] args )
	{

		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext("applicationContext-provider.xml");
		context.start();
		System.out.println("提供者2启动");
		while(true)
		{
		}
	}
}
