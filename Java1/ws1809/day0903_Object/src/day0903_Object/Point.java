package day0903_Object;

public class Point {
	private int x;
	private int y;
	
	
	public Point() {
		super();
	}
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public String toString() {	
		return "("+x+","+y+")";
	}
	@Override
	public boolean equals(Object obj) {	
//		a=null
		// a=new int a();
		if(obj == null)return false;
		if(obj == this)return true;
//		类型参数识别不想等
		if(!(obj instanceof Point)) return false;
		//当前对象的x,y
	    //与参数对象的x,y  
	    //参数对象，向下转回成Point类型
		Point p= (Point)obj;
	
		return x== p.x &&y == p.y;
	}
}
