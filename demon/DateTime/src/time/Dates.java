package time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Dates {
	public static void main(String[] args) {
		//2019-11-07
		LocalDate now = LocalDate.now();
		//当天的开始时间
		LocalDateTime atStartOfDay = now.atStartOfDay();
		System.out.println(atStartOfDay);
		System.out.println(now);
		LocalDateTime now2 = LocalDateTime.now();
		System.out.println(now2);
		LocalTime now3 = LocalTime.now();
		System.out.println(now3);
	}
}
