import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;


class Subject{
	
	int code,group;
	String name,type;
	
	
	public Subject(int code,String name,String type,int group) {
		this.code = code;
		this.name = name;
		this.type = type;
		this.group = group;
	}

	
	
	
}

public class TimeTable {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Map <Integer,Subject> sub_data = new Hashtable<Integer,Subject>();		// First all subjects entered for a HashTable
		
		Subject s1 = new Subject(200,"subject1","core",1);
		Subject s2 = new Subject(300,"subject2","core",1);
		Subject s3 = new Subject(400,"subject3","teq",1);
		Subject s4 = new Subject(500,"subject4","teq",1);
		
		Subject s5 = new Subject(250,"subject5","core",2);
		Subject s6 = new Subject(350,"subject6","core",2);
		Subject s7 = new Subject(400,"subject3","teq",2);
		Subject s8 = new Subject(550,"subject7","teq",2);
		
		sub_data.put(1, s1);
		sub_data.put(2, s2);
		sub_data.put(3, s3);
		sub_data.put(4, s4);
		
		sub_data.put(5, s5);
		sub_data.put(6, s6);
		sub_data.put(7, s7);
		sub_data.put(8, s8);
		
		
		
//	    Hashtable <Integer,Subject> sub_data2 = new Hashtable<Integer,Subject>();  // Second Subject group(block)
//		
//		
//		
//		sub_data2.put(1, s5);
//		sub_data2.put(2, s6);
//		sub_data2.put(3, s7);
//		sub_data2.put(4, s8);
		
		
		
	
		Subject s = sub_data.get(1);
		
		int i,j,group_number=1,k=1;
		
		
		
		ArrayList ab [][] = new ArrayList[5][8];		//subject entered for 8 time slots per five days
		ArrayList<Subject> b  = new ArrayList<Subject>();
		
		
		Iterator itr;
		
		
		
		i=-1;
		int group_num =2;
		int check=0;
		
		int code_check [][]= new int [8][5]; 
		
		for(k=0;k<8;k++) {
			ArrayList<Subject> a  = new ArrayList<Subject>();
			ab[0][k]=a;	
		}
		
		//subjects enter for ArrayList
		/*Below loop implement to avoid schedule subjects in same group and common subjects 
		 * to two or more groups to different time slots*/
		
		for(Map.Entry<Integer, Subject> entry:sub_data.entrySet()){ //loop for assign values for the slot without making same group subject assign for the same slot
				
				int key=entry.getKey();
				Subject ss = entry.getValue();
				
				System.out.println(ss.code);
				
				if(ss.group==group_num) {
					
						i++;
						
				}
				else {
					i=0;
									
					group_num--;
				}
				
				for(int l =0;l<5;l++) {
					
					if(code_check[i][l]==ss.code) {
						
						i++;
						
						check=1;
					}
					if(code_check[i][l]==0) {
						code_check[i][l]=ss.code;
					}
					
				}
				

				
				System.out.println(i);
				ab[0][i].add(ss);
				
		}
		
		
		
		//Printing ArrayList with subjects and their time slots
		for(j=0;j<8;j++) {
			
			itr = ab[0][j].iterator();
		
			System.out.println((j+1)+"Slot");
			
			while(itr.hasNext()){
			
				
				Subject st = (Subject)itr.next();
				System.out.println(st.code);
				
			}
		
		}
	

	}

}
