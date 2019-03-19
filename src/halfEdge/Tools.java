package halfEdge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Tools {
	static void LoadObjToArrayTZ(String path, ArrayList<Float> point, ArrayList<Integer> index){
		FileReader fr = null;
		try {
			
				fr=	new FileReader(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("文件找不到");
			e.printStackTrace();
		}
		BufferedReader reader = new BufferedReader(fr);
		String line;
		try {
			while((line = reader.readLine())!=null) {	
				if(line.startsWith("v ")) {
					//是vertex数据
					String[] currentLine = line.split(" ");//通过每个space分隔该字符串，若里面有一个space则返回两个字符串，2个space则返回三个字符串
					point.add(Float.valueOf(currentLine[1]));
					point.add(Float.valueOf(currentLine[2]));
					point.add(Float.valueOf(currentLine[3]));
				}else if(line.startsWith("f ")) {
					//是index数据
					String[] currentLine = line.split(" ");//通过每个space分隔该字符串，若里面有一个space则返回两个字符串，2个space则返回三个字符串
					index.add(Integer.valueOf(currentLine[1]));
					index.add(Integer.valueOf(currentLine[2]));
					index.add(Integer.valueOf(currentLine[3]));
				}
			}
		}catch(Exception e){
			System.out.println("啊啊啊啊");
			e.printStackTrace();
		}
	}

	//根据输入整数，按顺序返回该点周围的点，0是自己，目前只支持10个备胎
	static Point Next(Point p,int i) {
		
		switch(i) {
			case 0: 
				return p; 
			case 1: 
				return p.connectedHE.get(0).end; 
			case 2: 
				return p.connectedHE.get(0).nextEdge.nextEdge.twinEdge.end; 
			case 3: 
				return p.connectedHE.get(0).nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.end; 
			case 4: 
				return p.connectedHE.get(0).nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.end; 
			case 5: 
				return p.connectedHE.get(0).nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.
						nextEdge.nextEdge.twinEdge.end; 
			case 6: 
				return p.connectedHE.get(0).nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.
						nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.end; 
			case 7: 
				return p.connectedHE.get(0).nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.
						nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.end; 
			case 8: 
				return p.connectedHE.get(0).nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.
						nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.end; 
			case 9: 
				return p.connectedHE.get(0).nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.
						nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge
						.nextEdge.nextEdge.twinEdge.end; 
			case 10: 
				return p.connectedHE.get(0).nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.
						nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge
						.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.end; 
			case 11: 
				return p.connectedHE.get(0).nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.
						nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge
						.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.end;
			case 12: 
				return p.connectedHE.get(0).nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.
						nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge
						.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.end;
			case 13: 
				return p.connectedHE.get(0).nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.
						nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge
						.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.end;
			case 14: 
				return p.connectedHE.get(0).nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.
						nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge
						.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.end;
			case 15: 
				return p.connectedHE.get(0).nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.
						nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge
						.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.end;
			case 16: 
				return p.connectedHE.get(0).nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.
						nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge
						.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.end;
			case 17: 
				return p.connectedHE.get(0).nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.
						nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge
						.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.end;
			case 18: 
				return p.connectedHE.get(0).nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.
						nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge
						.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.nextEdge.nextEdge.twinEdge.end;
				
			default: 
				System.out.println("你备胎太多了");
				return null;
		} 
		
		
		
		
	}
}
