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
	
	ResultSetMetaData meta;
	Hashtable<String,Hashtable<Integer,String>> columns;
	Hashtable<Integer,String> propset;
	char[] l_able;
	int j, k, tagnum, colnum;
	boolean isParsAble;
	String prefix, property, tag, label;
	
	public Packer (ResultSet rs){
		super();
		Entity entity = null;
//		Entity mainAccount = new Account();
//		Entity mainMovie = new Movie();
//		Entity mainComment = new Comment();
		
		try {
				
//			System.out.println("findColumn: "+rs.findColumn("TAG"));
			
			meta = rs.getMetaData();
			columns = new Hashtable<String,Hashtable<Integer,String>>(5);
			//Hashtable<"prefix(tag)", Hashtable<"column index related to tag","colimn's prorperty name">>
			propset = new Hashtable<Integer,String>();
			tagnum = 1;
			prefix=null; property=null; tag=null;
			
			for (colnum = 1; meta.getColumnCount() >= colnum ; colnum++ ) {	//sort column's number by prefix
				
					label = meta.getColumnLabel(colnum);
					
					if("TAG".matches(label)) {
						tagnum=colnum;
//						System.err.println("tagnum i = " +i);//----test code
						continue;
					}
					
					l_able = label.toCharArray();
					isParsAble = false;
					for(j = l_able.length-1; j>=0 ;j--) {//parsing.. j: property name locater
						if(l_able[j]=='_') {
							isParsAble=true;
							break;
						}
					}//got post fix(property name)//////////////////what if there's no '_'!!
					
					if(isParsAble) {
						try {
							property = label.substring(j+1);
							prefix = label.substring(0, j);
//							System.out.print("i: "+i +"  prefix: "+prefix+"  property: "+property+"\r");//---------test
							
							cartographer();
							
						}catch(IndexOutOfBoundsException e) {
							e.printStackTrace();
						}
					} else {
						//when label is not parsable
					}//if else end
					
				}// sorting for end.
			
			while(rs.next()) {//packaging start.	
//				System.out.println("tegnum: "+tagnum);//test
				tag = rs.getString(tagnum);//-------------------TAG shouldn't be NULL!!!!!!!
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
		}//SQL try-catch end
		
	}
	
	
	private void cartographer(){
		
		String keyFrag = null;
		boolean hasMatchPrefix = false;
		
		for (String key: columns.keySet()) {
			
			if(key.contentEquals(prefix)) {
				
				columns.get(key).put(colnum, property);
				hasMatchPrefix = true;
				
			}else if(key.length()>=prefix.length()){
				
				char[] k_ey = key.toCharArray();
				
				for(int i = prefix.length()-1; i<k_ey.length; i++) {
					
					if(k_ey[i]=='_') {
						
						keyFrag = key.substring(0,i);
						
						if(keyFrag.contentEquals(prefix)) {
							columns.get(key).put(colnum, property);
							hasMatchPrefix = true;
							break;
						}//prefixFragcheck ends
					}// '_' checker ends
				}//char sequence checker ends 
			}//key=prefix checker ends
		}//for ends
		
		if(!hasMatchPrefix) {
			Hashtable<Integer,String> temp = new Hashtable<Integer,String>();
			temp.put(colnum, property);
			columns.put(prefix, temp);
			//columns.put(prefix, ((new Hashtable<Integer,String>()).put(i, property) ));
		}
		
	}
}
