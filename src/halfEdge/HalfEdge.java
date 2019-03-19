package halfEdge;

public class HalfEdge {
	Point start;
	Point end;
	HalfEdge twinEdge;
	HalfEdge previousEdge;
	HalfEdge nextEdge;
	public boolean IsTwin(HalfEdge e) {
		//if(this.start.equal(e.end)&&this.end.equal(e.start)) return true;
		if(this.start==e.end&&this.end==e.start) return true;
		return false;
	}
	
	
	public String toString() {
		return "start:" + start + " || end:" + end;
	}
}
