package halfEdge;

public class Face {//  123分别代表 XYZ
	Point p1;
	Point p2;
	Point p3;
	HalfEdge e1;
	HalfEdge e2;
	HalfEdge e3;
	public Face(Point p1, Point p2, Point p3) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		
		e1 = new HalfEdge();
		e2 = new HalfEdge();
		e3 = new HalfEdge();
		
		this.e1.start=p1;
		p1.connectedHE.add(e1);		/**在Point对象里面添加halfedge信息*/
		this.e1.end=p2;
		this.e1.nextEdge=e2;
		this.e1.previousEdge=e3;

		this.e2.start=p2;
		p2.connectedHE.add(e2);		/**在Point对象里面添加halfedge信息*/
		this.e2.end=p3;
		this.e2.nextEdge=e3;
		this.e2.previousEdge=e1;

		this.e3.start=p3;
		p3.connectedHE.add(e3);		/**在Point对象里面添加halfedge信息*/
		this.e3.end=p1;
		this.e3.nextEdge=e1;
		this.e3.previousEdge=e2;
	}
	@Override
	public String toString() {
		return "Points: [p1:" + p1 + " || p2:" + p2 + " || p3:" + p3 + "]\n"
				+ " Edges: [e1->" + e1 + "\n         e2->" + e2 + "\n         e3->" + e3 + "]"
				;
	}
	
	
}
