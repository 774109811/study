package com.tedu.spi_springFramework;

import java.util.Iterator;
import java.util.ServiceLoader;

import com.tedu.Starter;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		ServiceLoader<Starter> serviceLoader = ServiceLoader.load(Starter.class);
		Iterator<Starter> iterator = serviceLoader.iterator();
		while (iterator.hasNext()) {
			Starter starter = iterator.next();
			starter.init();
		}
	}
}
