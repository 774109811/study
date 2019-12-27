package day1203;

import java.util.HashMap;

public class Text1 {
	public static void main(String[] args) {
		HashMap<Integer,String> map =new HashMap<>();
		map.put(9527, "唐伯虎");
		map.put(9528, "华夫人");
		map.put(9529, "祝枝山");
		map.put(9530, "旺财");
		map.put(9531, "小强");
		map.put(9532, "石榴姐");
		map.put(9533, "秋香");
		map.put(9533, "如花");
		System.out.println(map.size());
		System.out.println(map);
		System.out.println(map.get(9527));
		System.out.println(map.get(9999));
		System.out.println(map.remove(9530));
		System.out.println(map);
	}
}
