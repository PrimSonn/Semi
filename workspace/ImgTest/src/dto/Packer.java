package dto;

import java.io.File;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.EmptyStackException;
import java.util.Hashtable;
import java.util.Stack;

import dto.entities.Entity;
//import dto.entities.Account;
//import dto.entities.Comment;
//import dto.entities.Movie;


public class Packer extends Pack{
	
	private static final String ADDRESS = "http://192.168.30.52:8001";
//	ResultSetMetaData meta;
//	Hashtable<String,Hashtable<Integer,String>> columMap;
//	Hashtable<Integer,String> propset;
//	char[] l_able;
//	int j, k, tagnum, colnum;
//	boolean isParsAble;
//	String prefix, property, tag, label;
	
	
//	public Packer() {
//	}
	
	public Packer (ResultSet rs,String contextPath, String realPath){
		
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
			
			System.out.println("columMap: "+columMap);//----test
			
			char[] t_ag;
			while(rs.next()) {//packaging start.	
//				System.out.println("tegnum: "+tagnum);//test
				tag = rs.getString(tagnum);//-------------------TAG shouldn't be NULL!!!!!!!
//				System.out.println("tag: " + tag);//---test
				
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
				
				curator(tag ,realPath, contextPath, entity); //+need to solve contextPath !!!!!!!!
				
				super.putList(tag, entity);
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}//SQL try-catch ends
		
	}//Packer() ends
	
	
	
	private void cartographer(Hashtable<String,Hashtable<Integer,String>> columMap, int colnum, String prefix, String property){
		
//		System.out.println("prefix: "+prefix);//-------------test
		String keyFrag = null;
		boolean hasMatchPrefix = false;
		
		for (String key: columMap.keySet()) {
			
			Hashtable<Integer,String> keyMap = columMap.get(key);
			Hashtable<Integer,String> prefixMap =columMap.get(prefix) ;
			
			if(key.contentEquals(prefix)) {
//				System.out.println("match prefix: "+key);//-----------test
				keyMap.put(colnum, property);
				hasMatchPrefix = true;
				
			}else if(key.length()>prefix.length()){
//				System.out.println("keylength compare key: "+key+"  prefix: "+prefix);//--------------------test
				char[] k_ey = key.toCharArray();
				
				for(int i = prefix.length()-1; k_ey.length>i; i++) {
					if(k_ey[i]=='_') {
						keyFrag = key.substring(0,i);
//						System.out.println("keyFrag: "+ keyFrag);//---------------------------------test
						if(keyFrag.contentEquals(prefix)) {
//							System.out.println("keyFrag Equeals: "+keyFrag+"  key: "+key+"  colnum: "+colnum+"  property: "+property);//----------test
							keyMap.put(colnum, property);
//							if(!columMap.containsKey(key))System.out.println("No such key: " +key);//-------------------------test
							break;
						}//prefixFragcheck ends
					}// '_' checker ends
				}//char sequence checker ends 
			} else{//key=prefix checker ends. now prefix parsing..
//				System.out.println("prefix parsing..  prefix: "+prefix+"  key: "+key);//-------------------------test
				char[] p_refix = prefix.toCharArray();
				
				for(int i = key.length()-1; prefix.length()>i; i++) {
					
					if(p_refix[i]=='_' && prefix.substring(0,i).contentEquals(key)) {
//						System.out.println("in! prefix: "+ prefix +"  key: "+key);//---------------------------test
						if(!columMap.containsKey(prefix)) {
//							System.out.println("no prefix found but prefixFrag match. prefix: "+prefix+"  key: "+key);//---------------------------test
							Hashtable<Integer,String> temp = (Hashtable<Integer, String>) keyMap.clone();
							temp.put(colnum, property);
							columMap.put(prefix, temp);
						}
						hasMatchPrefix = true;
						break;
					}//prefix parsing '_' + compare to key if-else ends
				}//prefix parsing for ends
				
			}//columMap key set if-else ends
		}//for ends
		
		if(!hasMatchPrefix) {
//			System.out.println("no match: "+prefix);//------------------------------>test
			Hashtable<Integer,String> temp = new Hashtable<Integer,String>();
			temp.put(colnum, property);
			columMap.put(prefix, temp);
			//columMap.put(prefix, ((new Hashtable<Integer,String>()).put(i, property) ));
		}
	}//cartographer() ends
	
	
	private void curator(String tag,String realPath, String contextPath, Entity entity) {
		
		Stack<File> stack = new Stack<File>();
		String mask = realPath+"\\"+"Imgs\\"+tag+"\\"+ entity.getIdx()+"\\";
		File file = new File(mask);
		int cutter = realPath.length();
		
		for(;;) {
			
			if(file.isFile()) {
//				System.out.println("-----------"+ADDRESS+contextPath+"/"+file.toString());//-----------test code
//				System.out.println(ADDRESS+contextPath+file.toString().substring(cutter).replace('\\', '/'));----test code
				entity.setImgs ( file.getAbsoluteFile().getParentFile().getName()
						, ADDRESS+contextPath+file.toString().substring(cutter).replace('\\', '/') );
				
			}else if(file.isDirectory()) {
				for(File f : file.listFiles()) stack.push(f);
				
			} else {
//				System.out.println("Something's wrong here: "+ file);------test code
			}
			
			try { file=stack.pop(); }
			catch(EmptyStackException e) {break;}
		}
		
		
	}
	
}
