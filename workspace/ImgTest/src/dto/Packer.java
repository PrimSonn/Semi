package dto;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Hashtable;

import dto.entities.Entity;
//import dto.entities.Account;
//import dto.entities.Comment;
//import dto.entities.Movie;

public class Packer extends Pack{
	
	public Packer (ResultSet rs){
		super();
		Entity entity = null;
//		Entity mainAccount = new Account();
//		Entity mainMovie = new Movie();
//		Entity mainComment = new Comment();
		
		try {
			
//			System.out.println("findColumn: "+rs.findColumn("TAG"));
			
			ResultSetMetaData meta = rs.getMetaData();
			Hashtable<String,Hashtable<Integer,String>> columns = new Hashtable<String,Hashtable<Integer,String>>(5);
			Hashtable<Integer,String> propset = new Hashtable<Integer,String>();
			//Hashtable<"prefix(tag)", Hashtable<"column index related to tag","colimn's prorperty name">>
			
			char[] l_able;
			int j, tagnum = 1;
			boolean flag;
			String prefix=null,property=null,tag=null;
			
			for (int i = 1; meta.getColumnCount() >= i ; i++ ) {	//sort column's number by prefix
				
					String label = meta.getColumnLabel(i);
					
					if("TAG".matches(label)) {
						tagnum=i;
//						System.err.println("tagnum i = " +i);//----testcode--BUG FOUND!!!!!!!!!!
						continue;
					}
					
					l_able = label.toCharArray();
					flag = false;
					for(j = 0; l_able.length>j ;j++) {//parsing..
						if(l_able[j]=='_') {
							flag=true;
							break;
						}
					}
					if(flag) {
						try {
							prefix = label.substring(0, j);
							property = label.substring(j+1);
//							System.out.print("i: "+i +"  prefix: "+prefix+"  property: "+property+"\r");//---------test
						}catch(IndexOutOfBoundsException e) {
							e.printStackTrace();
						}
						if(columns.containsKey(prefix)) {
							columns.get(prefix).put(i, property);
						} else {
							Hashtable<Integer,String> temp = new Hashtable<Integer,String>();
							temp.put(i, property);
							columns.put(prefix, temp);
							//columns.put(prefix, ((new Hashtable<Integer,String>()).put(i, property) ));
						}
					}
				}// sorting for end
			
			while(rs.next()) {//packaging start.	
//				System.out.println("tegnum: "+tagnum);//test
				tag = rs.getString(tagnum);
//				System.out.println("tag: " + tag);//---test--ok
//				switch(tag) {
//					case "": break;
//				}
				entity = new Entity();
				propset = columns.get(tag);
//				System.out.println("propset: " +propset);//-----test
				for(Integer i : propset.keySet() ) {
					entity.setProperty(propset.get(i), rs.getString(i) );
				}
				
				super.putList(tag, entity);
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
