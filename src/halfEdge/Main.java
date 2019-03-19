package halfEdge;

import java.util.ArrayList;

/**
 * 这个版本是HalfEdge
 * Face类里面去掉了Edge成员，改为HalfEdge成员
 * */
public class Main {
	public static void main(String[] args) {
		/**从path读取obj文件到两个数组中去：vertices和 indices*/
		ArrayList<Float> point = new ArrayList<>();
		ArrayList<Integer> index = new ArrayList<>();
		Float[] vertices;
		Integer[] indices;
		String path = "objFile/bunny.nf25k.obj";
		
		Tools.LoadObjToArrayTZ(path, point, index);

		vertices = new Float[point.size()];
		indices = new Integer[index.size()];
		point.toArray(vertices);
		index.toArray(indices);
		/**得到了2个数组：
		 * Float[] vertices;  装的点坐标， 0-37505
		 * Integer[] indices; 装的点索引     0-74999
		 * */
		

		
		/**Main：
		 * 创建 点 对象组
		 * Point[] points
		 */
		Point[] points= new Point[point.size()/3];
		int count=0;
		for(int j=0;j<point.size()/3;j++) {
			
			 
			points[j] = new Point(vertices[count++],vertices[count++],vertices[count++]);

		}

		/**Main:
		 * 创建 面 对象组
		 * Face[] faces
		 */
		Face[] faces= new Face[indices.length/3];

		int count2=0;

		for(int j=0;j<indices.length/3;j++) {
				faces[j] = new Face(points[indices[count2++]-1],points[indices[count2++]-1],points[indices[count2++]-1]);
		}
		/**
		 * 可用数据：
		 * float[] vertices
		 * int[] indices
		 * Point[] points
		 * Face[] faces
		 */
		
		/**链接各个面（链接twinEdge）*/
			for(int i=0; i<faces.length; i++) {
			
				for(int j=0;j<faces.length;j++) {
					if(faces[i].e1.IsTwin(faces[j].e1)) {
						faces[i].e1.twinEdge=faces[j].e1;
					}
					if(faces[i].e1.IsTwin(faces[j].e2)) {
						faces[i].e1.twinEdge=faces[j].e2;
					}
					if(faces[i].e1.IsTwin(faces[j].e3)) {
						faces[i].e1.twinEdge=faces[j].e3;
					}
					/***/
					if(faces[i].e2.IsTwin(faces[j].e1)) {
						faces[i].e2.twinEdge=faces[j].e1;
					}
					if(faces[i].e2.IsTwin(faces[j].e2)) {
						faces[i].e2.twinEdge=faces[j].e2;
					}
					if(faces[i].e2.IsTwin(faces[j].e3)) {
						faces[i].e2.twinEdge=faces[j].e3;
					}
					/***/
					if(faces[i].e3.IsTwin(faces[j].e1)) {
						faces[i].e3.twinEdge=faces[j].e1;
					}
					if(faces[i].e3.IsTwin(faces[j].e2)) {
						faces[i].e3.twinEdge=faces[j].e2;
					}
					if(faces[i].e3.IsTwin(faces[j].e3)) {
						faces[i].e3.twinEdge=faces[j].e3;
					}
				}
			}
		/**装载HalfEdge[]数组*/
		HalfEdge[] halfEdges= new HalfEdge[faces.length*3];
		
		ArrayList<HalfEdge> halfEdgesArray = new ArrayList<>();
		for(int i=0; i<faces.length; i++) {
			halfEdgesArray.add(faces[i].e1);
			halfEdgesArray.add(faces[i].e2);
			halfEdgesArray.add(faces[i].e3);
		}
		halfEdges = new HalfEdge [halfEdgesArray.size()];
		halfEdgesArray.toArray(halfEdges); 
		/**计算伽马（X）*/
		int EulerNum;
		EulerNum = points.length+ faces.length - halfEdges.length/2;
		/**计算高斯曲率*/
		double totalK=0; //储存所有点的K的总和
		double[] GaussBonnet = new double[points.length];//存储每个点的K
		for(int i=0;i<points.length;i++ ) {
				int PointsAmount = points[i].connectedHE.size();
				double[] angles = new double[PointsAmount];//用来存储这个点周围所有面的角度
				double merge=0;
				for(int j=0;j<PointsAmount;j++) {
					Tools.Next(points[i], j+1);
					Tools.Next(points[i], j+2);
					Point v1= new Point();
					Point v2= new Point();
					v1.x=Tools.Next(points[i], j+1).x-points[i].x;
					v1.y=Tools.Next(points[i], j+1).y-points[i].y;
					v1.z=Tools.Next(points[i], j+1).z-points[i].z;
					v2.x=Tools.Next(points[i], j+2).x-points[i].x;
					v2.y=Tools.Next(points[i], j+2).y-points[i].y;
					v2.z=Tools.Next(points[i], j+2).z-points[i].z;
					angles[j]=Math.acos(//计算单个面的角度
							(v1.x*v2.x+v1.y*v2.y+v1.z*v2.z)/
							(   Math.sqrt(v1.x*v1.x+v1.y*v1.y+v1.z*v1.z) * Math.sqrt(v2.x*v2.x+v2.y*v2.y+v2.z*v2.z)  )
							);
					merge+=angles[j];//计算该店周围面角度之和
				}
				//计算该点的K
				GaussBonnet[i]=Math.PI*2-merge;
				totalK+=GaussBonnet[i];
		}
		System.out.println("Euler Number is: "+EulerNum);
		System.out.println("高斯曲率："+totalK);
		System.out.println("公式右边："+2*Math.PI*EulerNum);
	}
	
}
