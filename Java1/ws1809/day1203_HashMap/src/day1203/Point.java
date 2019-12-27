package day1203;

public class Point {
	private int x;
	private double y;
	
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public Point() {
		super();
	}
	
	public Point(int x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
	
		return "("+x+","+y+")";
	}
	@Override
	public int hashCode() {
		
		int p = 31;
		int r = 1;
		r = r*p + x;
		r = r*p + (int)y;
		return r;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj==null) return false;
		if(obj==this) return true;
		if(!(obj instanceof Point)) return false;
		Point p =(Point) obj;
		return x == p.x && y == p.y;
	
	}
}
