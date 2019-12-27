package day0703;

public class QAasd {
	int x;
	int y;
	public QAasd(int x,int y) {
		this.x=x;
		this.y=y;
	};
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "("+x+","+"y+"+")";
	}
	private double destance() {
		// TODO Auto-generated method stub
		return x*x+y*y;
	}
}
