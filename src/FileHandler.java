import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class FileHandler extends TokenHandler {
	
	private int count = 0;
	private ArrayList<String> stemWordsFinal;
	private static Map<String,Integer> wordMap = new TreeMap<String,Integer>();
	private Object[][] arr = new Object[wordMap.size()][wordMap.size()];
	public Object[][] getArr() {
		return arr;
	}
	public void setArr(Object[][] arr) {
		this.arr = arr;
	}
	public static Map<String, Integer> getWordMap() {
		return wordMap;
	}
	public static void setWordMap(Map<String, Integer> wordMap) {
		FileHandler.wordMap = wordMap;
	}
	public static File[] files= null;
	public String FileLister(){
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

	public void StemCounterInFile(){
		 TokenHandler tokenHandler = new TokenHandler();
		 HashSet<String> set = new HashSet<>(tokenHandler.getStemWordsAfterCheck());
		 stemWordsFinal = new ArrayList<String>(set);
		for(File f: files){
			//String file= f.getName();
				FileInputStream fis =null;
				 DataInputStream dis= null;
				 BufferedReader br= null;
				 try{
						fis = new FileInputStream(f);
						dis = new DataInputStream(fis);
						br= new BufferedReader(new InputStreamReader(dis));
						String line = null;
						while((line =br.readLine()) !=null){
							StringTokenizer st= new StringTokenizer(line, " ");
							 while(st.hasMoreTokens()){
								 String fileWord = st.nextToken().toLowerCase();
								 for(int a=0; a<stemWordsFinal.size();a++){
									 
									 if(fileWord.equals(stemWordsFinal.get(a))){
										 if(wordMap.containsKey(f.getName())){
						                     wordMap.put(f.getName(), wordMap.get(f.getName())+1);
						                 } else {
						                     wordMap.put(f.getName(), 1);
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
		}		
			}
	
	

public void PrintResult(){
	TokenHandler tokenHandler = new TokenHandler();
	TreeOutput to = new TreeOutput(trueRoot);
	int sum = 0, avg;
	
	for (Entry<String, Integer> entry1 : wordMap.entrySet()) {
		
	    String key = entry1.getKey();
	    Integer value = entry1.getValue();
	    
	    		key = key.substring(0, key.length() - 4);
//	    		ResultClass key1 = new ResultClass();
	    		if(key.equals(null)){
	    			System.out.println("No file found please enter a new query");
	    		}else{
	    			sum = sum + value;
	    			to.TreeFetch(key, value);
	    			System.out.println(key + " : " + value);
	    		}
	    		
	    }
	//tree Call
	to.showTree();
	
	avg = sum / wordMap.size();
	System.out.println("Result After BST application: ");
	for (Entry<String, Integer> entry1 : wordMap.entrySet()){
		 String key = entry1.getKey();
		 Integer value = entry1.getValue();
		 if(value>=avg){
			 System.out.println(key + " : " + value);
		 }
	}
}

public void EmptyTreeMap(){
	wordMap.clear();
}
	}
	
