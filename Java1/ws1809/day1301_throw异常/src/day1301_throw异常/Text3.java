package day1301_throw异常;

import java.util.Scanner;

public class Text3 {
	public static void main(String[] args)  {
		System.out.println("用户名");
		String n= new Scanner(System.in).nextLine();
		System.out.println("密码：");
		String p= new Scanner(System.in).nextLine();
		try{
			login(n,p);
			System.out.println("欢迎登陆");
		}catch(UsernameNotFoundException e){
			System.out.println("用户名错误");
		}catch(WrongPasswordException e){
			System.out.println("密码错误");
		}
	}

	private static void login(String n, String p) throws UsernameNotFoundException, WrongPasswordException   {
		if(!"abc".equals(n)){
			throw new UsernameNotFoundException();
		}
		if(!"123".equals(p)){
			throw new WrongPasswordException();
		}
	}
}
