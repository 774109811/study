package stream;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Test;

public class TestList {
	//map集合封装
	@Test
	public void testList() {
		HashMap<String, HashMap<String, ArrayList<Person>>> hm = new HashMap<>();

		HashMap<String, ArrayList<Person>> hm1 = new HashMap<>();
		ArrayList<Person> a1 = new ArrayList<>();
		Person p1 = new Person("孙猴子",50);
		Person p2 = new Person("猪八戒",60);
		a1.add(p1);
		a1.add(p2);
		ArrayList<Person> a2 = new ArrayList<>();
		Person p3 = new Person("白骨精",15);
		Person p4 = new Person("黑熊精",14);
		a2.add(p3);
		a2.add(p4);
		hm1.put("神仙", a1);
		hm1.put("妖怪", a2);
		hm.put("西游记", hm1);

		HashMap<String, ArrayList<Person>> hm2 = new HashMap<>();
		ArrayList<Person> a3 = new ArrayList<>();
		Person p5 = new Person("刘备",50);
		Person p6 = new Person("诸葛亮",60);
		a3.add(p5);
		a3.add(p6);
		ArrayList<Person> a4 = new ArrayList<>();
		Person p7 = new Person("曹操",15);
		Person p8 = new Person("司马懿",14);
		a4.add(p7);
		a4.add(p8);
		hm2.put("蜀国", a3);
		hm2.put("魏国", a4);
		hm.put("三国演义", hm2);





		Set<String> keySet = hm.keySet();
		//System.out.println(keySet);
		System.out.println("-------------------");
		for (String key : keySet) {
			System.out.println(key);
			HashMap<String, ArrayList<Person>> map = hm.get(key);
			Set<String> keySet2 = map.keySet();
			for (String key2 : keySet2) {
				System.out.println("\t" + key2);
				ArrayList<Person> list = map.get(key2);
				for (Person p : list) {
					System.out.println("\t\t" + p.getName() + "---"+ p.getAge());
				}
			}

		}
		System.out.println("-------------------");
	}
	//集合排序
	@Test
	public void sList() {
		ArrayList<Integer> l1 = new ArrayList<>();
		l1.add(11);
		l1.add(12);
		l1.add(1);
		l1.add(110);
		l1.add(120);
		l1.sort((a,b) -> a-b);
		System.out.println(l1);
	}
	//集合排序
	@Test 
	public void s1List() {
		ArrayList<Person> a1 = new ArrayList<>();
		Person p5 = new Person("刘备",50);
		Person p6 = new Person("诸葛亮",60);
		Person p7 = new Person("刘备",111);
		Person p8 = new Person("诸葛亮",15);
		a1.add(p5);
		a1.add(p6);
		a1.add(p7);
		a1.add(p8);
		a1.sort((a,b) ->b.getAge()-a.getAge() );
		//int green = Color.GREEN.getGreen();
		//System.out.println(green);
		System.out.println(a1);

	}
	//map遍历
	@Test
	public void testLambda() {

		Map<String, Integer> items = new HashMap<>();
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		items.put("E", 50);
		items.put("F", 60);
		long start=System.currentTimeMillis();
		for (Map.Entry<String, Integer> entry : items.entrySet()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
		}
		long end =System.currentTimeMillis();
		System.out.println("普通时间:"+(end-start));
		System.out.println("+++++++++++++++++++++++++++");
		Map<String, Integer> items1 = new HashMap<>();
		items1.put("A", 10);
		items1.put("B", 20);
		items1.put("C", 30);
		items1.put("D", 40);
		items1.put("E", 50);
		items1.put("F", 60);
		long start1=System.currentTimeMillis();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		items1.forEach(
				(k,v)->
		
		System.out.println("Item : " + k + " Count : " + v));
		long end1 =System.currentTimeMillis();
		System.out.println("lambda时间:"+(end1-start1));
		/*
		 * items1.forEach((k,v)->{ System.out.println("Item : " + k + " Count : " + v);
		 * if("E".equals(k)){ System.out.println("Hello E"); } });
		 */

	}
	//集合过滤并把集合中某个元素全部取出放入集合
	@Test
	public void teList() {
		List<Person> asList = Arrays.asList(new Person("name",11),new Person("name1",12),new Person("name2",13));
		List<Person> collect = asList.stream().filter(s-> s.getAge()==11||s.getName()=="name1").collect(Collectors.toList());
		System.out.println(collect);
		System.out.println("-----------------------");
		List<Integer> l1 = new ArrayList<>();
		asList.forEach(l->{
			l1.add(l.getAge());
		}
		);
		System.out.println(l1);
	}
	//集合对象转map
	@Test
	public void testArray() {
		List<Person> asList = Arrays.asList(new Person("name",11),new Person("name1",12),new Person("name2",13));
		System.out.println(asList);
		Map<String, Integer> collect = asList.stream().collect(Collectors.toMap(Person::getName, Person::getAge));
		Integer integer = collect.get("name");
		System.out.println(collect);
	}
	//创建集合修改集合下表值
	@Test
	public void test1() {
		List<Integer> list = Arrays.asList(1, 2, 4);
		list.set(1, 10); // OK
		//list.set(1,2,3);
		System.out.println(list);
	}
	//字符串转成set集合
	@Test 
	public void test2() {
		String r="1,2,3";
		Set<String> singleton = Collections.singleton(r);
		System.out.println(singleton);
	}
	//集合对象用逗号隔开
	@Test
	public void TestP() {
		List<Person> asList = Arrays.asList(new Person("name",11),new Person("name1",12),new Person("name2",13));
		String collect = asList.stream().map(Person::toString).collect(Collectors.joining(", "));
		System.out.println(collect);
	}
	@Test
	public void TestBean() {
		new Person("name",11);
	}
}
