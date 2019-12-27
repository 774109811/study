package day1803;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Runner {
	public static void launch(Class<?>c) throws Exception, Exception {
		Object obj = c.newInstance();
		
		
		Method[] a = c.getMethods();
		
		ArrayList<Method> list =new ArrayList<>();
		for(Method m:a) {
			Text text = m.getAnnotation(Text.class);//´Ó
			
			if(text != null) {
				list.add(m);
				
//				int id = text.id();
//				String value = text.value();
//				System.out.println("\n\n-----id:"+id+",value:"+value);
//				
//				m.invoke(obj);
				
			}
			
		}
		Collections.sort(list,new Comparator<Method>() {

			@Override
			public int compare(Method o1, Method o2) {
				Text t1 = o1.getAnnotation(Text.class);
				Text t2 = o2.getAnnotation(Text.class);
				return t1.id() -t2.id();
				
				
			}
			
			
		});
		for(Method m:list) {
			Text text = m.getAnnotation(Text.class);
			int id = text.id();
			String value = text.value();
			System.out.println("\n\n-----id:"+id+",value:"+value);
			
			m.invoke(obj);
		}
		
	}
	}
