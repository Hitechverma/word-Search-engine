import java.io.*;
import java.util.*;

public class fileScanner extends token{
	public static File[] files= null;
	
	public static Map<String,Integer> wordMap = new TreeMap<String, Integer>();
	public static ArrayList<String> keywords;
	//creating object
	static TreeOutput to = new TreeOutput();

	public String fileLister(){
		File file = new File("folder/");
			files= file.listFiles(new FilenameFilter(){
			
			@Override
			public boolean accept(File dir, String name){
				if(name.toLowerCase().endsWith(".txt")){
					return true;
				}else{
					return false;
				}
			}
		});
		return null;
	}	
	public void StemCounter() {
		 HashSet<String> set = new HashSet<>(stemWordsAfterCheck);
		 keywords = new ArrayList<>(set);
		for(File f: files){
			String rfile= f.getName();
			example(rfile);			
			}
		PrintMap();
		
	}
	public void example(String rfile){
		
	// TODO Auto-generated method stub
		FileInputStream fis =null;
		 DataInputStream dis= null;
		 BufferedReader br= null;
			try{
				fis = new FileInputStream("folder/"+ rfile);
				dis = new DataInputStream(fis);
				br= new BufferedReader(new InputStreamReader(dis));
				String line = null;
				while((line =br.readLine()) !=null){
					
					StringTokenizer st= new StringTokenizer(line, " ");
					 while(st.hasMoreTokens()){
						 
						 String fileWord = st.nextToken().toLowerCase();
						 for(int a=0; a<keywords.size();a++){
							 String queryStem = keywords.get(a);
							 if(fileWord.contains(queryStem)){
								 if(wordMap.containsKey(rfile)){
				                     wordMap.put(rfile, wordMap.get(rfile)+1);
				                 } else {
				                     wordMap.put(rfile, 1);
				                 }
							 }else{}
						 }
					 }
				}
			}catch (FileNotFoundException e) {
		         e.printStackTrace();
		     } catch (IOException e) {
		         e.printStackTrace();
		     } finally{
		         try{if(br != null) br.close();}catch(Exception ex){}
		     }
			
	
//		printMap(wordMap);

	}
	public static void PrintMap() {
		
		
		
		if(keywords.isEmpty()){
			System.out.println("Entered Keyword/s is not present in the folder.");
		}
		
		
//			System.out.println(rfile+ " : "+ wordMap.get(rfile));
			
		
	
	    Iterator it = wordMap.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pairs = (Map.Entry)it.next();	        
	        System.out.println(pairs.getKey() + " = " + pairs.getValue());
//	        to.TreeFetch(pairs.getKey(),pairs.getValue());
	        it.remove(); // avoids a ConcurrentModificationException
	       // System.out.println(once.fileName);
	    }
	    to.showTree();
	    }
	}
	
