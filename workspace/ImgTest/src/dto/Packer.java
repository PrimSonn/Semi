package dto;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Stack;
import java.util.stream.Stream;

import dto.entities.Entity;
//import dto.entities.Account;
//import dto.entities.Comment;
//import dto.entities.Movie;


public class Packer extends Pack{
	
//	ResultSetMetaData meta;
//	Hashtable<String,Hashtable<Integer,String>> columMap;
//	Hashtable<Integer,String> propset;
//	char[] l_able;
//	int j, k, tagnum, colnum;
//	boolean isParsAble;
//	String prefix, property, tag, label;
	
	
//	public Packer() {
//	}
	
	public Packer (ResultSet rs){
		super();
		Entity entity = null;
//		Entity mainAccount = new Account();
//		Entity mainMovie = new Movie();
//		Entity mainComment = new Comment();
		
		try {
				
//			System.out.println("findColumn: "+rs.findColumn("TAG"));
			
			ResultSetMetaData meta = rs.getMetaData();
			Hashtable<String,Hashtable<Integer,String>> columMap = new Hashtable<String,Hashtable<Integer,String>>(9);
			//Hashtable<"prefix(tag)", Hashtable<"column index related to tag","colimn's prorperty name">>
			Hashtable<Integer,String> propset = new Hashtable<Integer,String>();
			int j;
			int tagnum = 1;
			String prefix=null, property=null, tag=null;
			
			
			for (int colnum = 1; meta.getColumnCount() >= colnum ; colnum++ ) {	//sort column's number by prefix
				
				String label = meta.getColumnLabel(colnum);
				
					if("TAG".matches(label)) {
						tagnum=colnum;
//						System.err.println("tagnum i = " +i);//----test code
						continue;
					}
					
				char[] l_able = label.toCharArray();
				boolean isParsAble = false;
				for(j = l_able.length-1; j>=0 ;j--) {//parsing.. j: property name locater
					if('_'==l_able[j]) {
						isParsAble=true;
						break;
					}
				}//got post fix(property name)//////////////////what if there's no '_'!!
					
				if(isParsAble) {
					try {
						property = label.substring(j+1);
						prefix = label.substring(0, j);
//							System.out.print("i: "+i +"  prefix: "+prefix+"  property: "+property+"\r");//---------test
						
						cartographer(columMap, colnum, prefix, property);
						
					}catch(IndexOutOfBoundsException e) {
						e.printStackTrace();
					}
				} else {
					//when label is not parsable
				}//if else ends
					
			}// sorting for ends.
			
			char[] t_ag;
			while(rs.next()) {//packaging start.	
//				System.out.println("tegnum: "+tagnum);//test
				tag = rs.getString(tagnum);//-------------------TAG shouldn't be NULL!!!!!!!
//				System.out.println("tag: " + tag);//---test--ok
//				switch(tag) {
//					case "": break;
//				}
				entity = new Entity();
				propset = columMap.get(tag);
//				System.out.println("propset: " +propset);//-----test
				for(Integer i : propset.keySet() ) {
					entity.setProperty(propset.get(i), rs.getString(i) );
				}
				entity.setIdx();
				
				t_ag = tag.toCharArray();
				for(int i = 0; t_ag.length>i ;i++) {//cut subtag;
					if(t_ag[i]=='_') {
						tag=tag.substring(0, i);
					}
				}
				
				String dummyContextPath = null;
				curator(tag , entity, dummyContextPath); //+need to solve contextPath !!!!!!!!
				
				super.putList(tag, entity);
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}//SQL try-catch ends
		
	}//Packer() ends
	
	
	private void cartographer(Hashtable<String,Hashtable<Integer,String>> columMap, int colnum, String  prefix, String property){
		
		String keyFrag = null;
		boolean hasMatchPrefix = false;
		
		for (String key: columMap.keySet()) {
			
			if(key.contentEquals(prefix)) {
				
				columMap.get(key).put(colnum, property);
				hasMatchPrefix = true;
				
			}else if(key.length()>=prefix.length()){
				
				char[] k_ey = key.toCharArray();
				
				for(int i = prefix.length()-1; i<k_ey.length; i++) {
					
					if(k_ey[i]=='_') {
						
						keyFrag = key.substring(0,i);
						
						if(keyFrag.contentEquals(prefix)) {
							columMap.get(key).put(colnum, property);
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
			columMap.put(prefix, temp);
			//columMap.put(prefix, ((new Hashtable<Integer,String>()).put(i, property) ));
		}
	}//cartographer() ends
	
	
	private void curator(String tag,String realPath, String contextPath, Entity entity) {
		
		Stack<File> stack = new Stack<File>();
		String idx = entity.getIdx();
		File file = new File(realPath+"\\"+"img\\");
		
		for(File f : file.listFiles()) {
			stack.push(f);
		}
		
		for(;;) {
			if(stack.isEmpty())break;
			file=stack.pop();
			if(file.isFile()) {
				//add
			}else if(file.isDirectory()) {
				for(File f : file.listFiles()) {
					stack.push(f);
				}
			}else {
				System.err.println("somethings wrong here..");
			}
		
		
		}
		
		
		
	}
	
}
