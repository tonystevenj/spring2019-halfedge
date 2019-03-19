package halfEdge;

import java.util.ArrayList;

public class Point {
	public float x;
	public float y;
	public float z;
	ArrayList<HalfEdge> connectedHE= new ArrayList<>();
	
	public String toString() {
		return "X="+x+" Y="+y+" Z="+z;
	}
	public boolean equal(Point p) {
		if(p.x==this.x&&p.y==this.y&&p.z==this.z) return true;
		return false;
		
	}
	public Point(float x, float y, float z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public Point() {
	}
}
