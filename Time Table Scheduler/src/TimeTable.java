import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;


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
		
		Hashtable <Integer,Subject> sub_data = new Hashtable<Integer,Subject>();
		
		Subject s1 = new Subject(200,"subject1","core",1);
		Subject s2 = new Subject(300,"subject2","core",1);
		Subject s3 = new Subject(400,"subject3","teq",1);
		Subject s4 = new Subject(500,"subject4","teq",1);
		
		sub_data.put(1, s1);
		sub_data.put(2, s2);
		sub_data.put(3, s3);
		sub_data.put(4, s4);
		
		
		
	    Hashtable <Integer,Subject> sub_data2 = new Hashtable<Integer,Subject>();
		
		Subject s5 = new Subject(250,"subject5","core",2);
		Subject s6 = new Subject(350,"subject6","core",2);
		Subject s7 = new Subject(400,"subject3","teq",2);
		Subject s8 = new Subject(550,"subject7","teq",2);
		
		sub_data2.put(1, s5);
		sub_data2.put(2, s6);
		sub_data2.put(3, s7);
		sub_data2.put(4, s8);
		
		Subject s = sub_data.get(1);
		
		int i,j,group1=0,group2=0,k=1;
		
		ArrayList<Subject> a = new ArrayList<Subject>();
		
		ArrayList ab [][] = new ArrayList[5][8];
		
		
		
		ab[0][0] = a;
		
//		Iterator itr=ab[0][0].iterator();  
//		  //traversing elements of ArrayList object  
//		  while(itr.hasNext()){  
//		    Subject st=(Subject)itr.next();  
//		    System.out.println(st.code+" "+st.name);  
//		  }  
		
		 
		
		
		
		
		Iterator itr;
		
		s= sub_data.get(1);
		
		
		ab[0][0].add(s);
		s= sub_data.get(2);
		ab[0][0].add(s);
		
		for(i=0;i<4;i++) {
			
			
		}
		
		itr = ab[0][0].iterator();
		
		 while(itr.hasNext()){  
			    Subject st=(Subject)itr.next();  
			    System.out.println(st.code+" "+st.name);  
			  }  
		
		
		
	
		
		

	}

}
