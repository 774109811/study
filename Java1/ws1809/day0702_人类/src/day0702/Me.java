package day0702;

public class Me extends Student{
       int time;
//   	重写toString()方法
//   	对继承的方法，进行改写
    public String toString() {
    	   return name+","+gender+","+age+","+school+""+time;
    }
}
