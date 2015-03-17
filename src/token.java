import java.util.*;
import java.io.*;

//import sun.applet.Main;


public class token {
	public static ArrayList<String> stemWordsAfterCheck = new ArrayList<String>();
	public HashSet finalStemWords = new HashSet();
	public ArrayList<String> al = new ArrayList<String>();

	public void QuerytoToken(String query){
		StringTokenizer st = new StringTokenizer(query, " ");
		while(st.hasMoreTokens()){
			al.add(st.nextToken());
		}
	}
	public ArrayList TokentoStem(){
		
		for(int c=0; c<al.size();c++){
			
			String tmp = al.get(c);
			Stemmer(tmp);	
		}
		return stemWordsAfterCheck;
	}
	public void Stemmer(String tmp){
		
		String stem = tmp.toLowerCase();
		int stemLength = stem.length();
		FileInputStream fis = null;
		DataInputStream dis = null;
		BufferedReader br= null;
		
		ArrayList<String> suffixList = new ArrayList<String>();
		try {
			fis = new FileInputStream("suffix.txt");
			dis = new DataInputStream(fis);
			br = new BufferedReader(new InputStreamReader(dis));
			String line = null;
		while((line = br.readLine()) != null){
			StringTokenizer st= new StringTokenizer(line, " ");
			while(st.hasMoreTokens()){
				String suffixTerm = st.nextToken().toLowerCase();
				if(stem.endsWith(suffixTerm)){
					//removing the suffix from the tokens
					String StemforDictionary = stem.substring(0, stem.length()-suffixTerm.length());
					
					DictionaryCheck(StemforDictionary);
				}
			}
		}
		}catch (Exception e) {}
	}
	public void DictionaryCheck(String StemforDictionary){
		
		FileInputStream fis= null;
		DataInputStream dis = null;
		BufferedReader br = null;
		
		
		try{
			
			fis = new FileInputStream("wordlist.txt");
			dis = new DataInputStream(fis);
			br= new BufferedReader(new InputStreamReader(dis));
			String line = null;
			while((line = br.readLine()) != null){
				StringTokenizer st = new StringTokenizer(line, " ");
				while(st.hasMoreTokens()){
					String Dictionarywords= st.nextToken().toLowerCase();
					if(Dictionarywords.equalsIgnoreCase(StemforDictionary)){
						stemWordsAfterCheck.add(Dictionarywords);
					}
				}
			}
		}catch (Exception e){}
		
		
		
		//this is just to remove duplicity of stem words from arraylist
		/*finalStemWords.addAll(stemWordsAfterCheck);
		stemWordsAfterCheck.clear();
		stemWordsAfterCheck.addAll(finalStemWords);
		String duplicateTerm = null;
		
		for(int x=0; x<stemWordsAfterCheck.size();x++){
			duplicateTerm=stemWordsAfterCheck.get(x);
			for( x=0; x<stemWordsAfterCheck.size();x++){
			
		
			}
		}*/

	}
	/*public void sender(){
		first firstObject = new first();
		first.TokenSenderToFileScanner(stemWordsAfterCheck);
	}*/
	
	
	
}


	       

