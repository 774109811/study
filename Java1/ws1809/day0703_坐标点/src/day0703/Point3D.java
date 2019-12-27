package day0703;

public class Point3D extends Point {
      int z;
      public Point3D(int x, int y,int z) {
//		调用父类的构造方法
    	  super(x,y);
		this.z=z;
    	  
	}

    public String toString() {
    	  return"("+x+","+y+","+z+")";
    }
    public double distance() {
		
    	  return Math.sqrt(x*x+y*y+z*z);
	}
}
