package eqList;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class EqList {
	public static void main(String[] args) {
		
		/*
		 * long currentTimeMillis = System.currentTimeMillis(); List<Integer> asList =
		 * Arrays.asList(3,2,1,4,5); List<Integer> asList1 = Arrays.asList(1,2,3,4);
		 * asList.sort(null); asList1.sort(null);
		 * System.out.println(asList.toString().equals(asList1.toString())); long
		 * currentTimeMillis2 = System.currentTimeMillis();
		 * System.out.println(currentTimeMillis2-currentTimeMillis);
		 */
		
		  Calendar calendar = Calendar.getInstance();  //得到日历
		/*
		 * calendar.setTime(new Date(System.currentTimeMillis()));//把当前时间赋给日历
		 * calendar.add(Calendar.DAY_OF_MONTH, 7); //设置为7天前 Date before7days =
		 * calendar.getTime(); //得到7天前的时间 System.out.println(before7days.getTime());
		 * if(1569756998000L<before7days.getTime()){ System.out.println("true"); }else{
		 * System.out.println("false"); }
		 */
          calendar.setTimeInMillis(1569756998000L);
          calendar.set(Calendar.SECOND, 0);
          //calendar.set(Calendar.MINUTE, 0);
          calendar.set(Calendar.MILLISECOND, 0);
          System.out.println(calendar.getTimeInMillis());
	}
}
