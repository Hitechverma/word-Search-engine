import java.util.*;
import java.io.*;

public class TokenHandler {
	
	private ArrayList<String> al = new ArrayList<String>();
	private ArrayList<String> suffixList = new ArrayList<String>();
	public static ArrayList<String> stemWordsAfterCheck = new ArrayList<String>();
	public String rootWord;
	public static String trueRoot;
	public static ArrayList<String> getStemWordsAfterCheck() {
		return stemWordsAfterCheck;
	}

	public static void setStemWordsAfterCheck(ArrayList<String> stemWordsAfterCheck) {
		TokenHandler.stemWordsAfterCheck = stemWordsAfterCheck;
	}
	private String query;
public ArrayList<String> getSuffixList() {
		return suffixList;
	}

	public void setSuffixList(ArrayList<String> suffixList) {
		this.suffixList = suffixList;
	}
public String getQuery() {
	return query;
}

public void setQuery(String query) {
	this.query = query;
}
public ArrayList<String> getAl() {
	return al;
}

public void setAl(ArrayList<String> al) {
	this.al = al;
}

public void QueryToToken(){
	StringTokenizer st = new StringTokenizer(getQuery(), " ");
	while(st.hasMoreTokens()){
		String temp = st.nextToken();
		if(temp.equalsIgnoreCase("is") || temp.equalsIgnoreCase("this") || temp.equalsIgnoreCase("the") || temp.equalsIgnoreCase("are")
				|| temp.equalsIgnoreCase("because") || temp.equalsIgnoreCase("of") || temp.equalsIgnoreCase("if") 
				|| temp.equalsIgnoreCase("there") || temp.equalsIgnoreCase("their") || temp.equalsIgnoreCase("how") 
				|| temp.equalsIgnoreCase("what") || temp.equalsIgnoreCase("where") || temp.equalsIgnoreCase("would") 
				|| temp.equalsIgnoreCase("shall") || temp.equalsIgnoreCase("should") || temp.equalsIgnoreCase("could") 
				|| temp.equalsIgnoreCase("can") || temp.equalsIgnoreCase("not") || temp.equalsIgnoreCase("we") || temp.equalsIgnoreCase("i") 
				|| temp.equalsIgnoreCase("be") || temp.equalsIgnoreCase("cannot") || temp.equalsIgnoreCase("you") || temp.equalsIgnoreCase("your")
				|| temp.equalsIgnoreCase("he") || temp.equalsIgnoreCase("she"))
		{}
		else{
		al.add(temp.toLowerCase());
	}
		}
}

public void TokenToStem(){
	for(int z= 0 ; z<al.size(); z++){
		stemWordsAfterCheck.add(al.get(z));
		SuffixCheck(al.get(z));
		}
}
/*public void SuffixCheck(String temp){
	int lengthOfTemp = temp.length();
	char a = temp.charAt(lengthOfTemp-1);
	char lastCHar = temp.charAt(lengthOfTemp);
	if(temp.endsWith("s")){
		if(temp.endsWith("sses")){
			temp= temp.substring(0,temp.length()-2);
			DictionaryCheck(temp);
		}
			else if(temp.endsWith("ies")){
				temp= temp.substring(0,temp.length()-2);
				DictionaryCheck(temp);
			}
			else if(temp.endsWith("s")){
				temp = temp.substring(0, temp.length()-1);
				DictionaryCheck(temp);
			}
		}else if(temp.endsWith("ed") || temp.endsWith("ing")){
			if(temp.endsWith("ed")){
				temp= temp.substring(0,temp.length()-2);
				DictionaryCheck(temp);
				if(temp.endsWith("at")){
					temp.concat("ate");
					DictionaryCheck(temp);
				}else if(temp.endsWith("bl")){
					temp.concat("ble");
					DictionaryCheck(temp);
				}else if(temp.endsWith("iz")){
					temp.concat("ize");
					DictionaryCheck(temp);
				}
			}
			else if(temp.endsWith("ing")){
				temp= temp.substring(0,temp.length()-3);
				DictionaryCheck(temp);
				if(temp.endsWith("at")){
					temp.concat("ate");
					DictionaryCheck(temp);
				}else if(temp.endsWith("bl")){
					temp.concat("ble");
					DictionaryCheck(temp);
				}else if(temp.endsWith("iz")){
					temp.concat("ize");
					DictionaryCheck(temp);
				}
			}else if(temp.endsWith("y")){
				temp = temp.substring(0, temp.length()-1);
				DictionaryCheck(temp);
				temp = temp.concat("i");
				DictionaryCheck(temp);
				}else if (a == 'a' || a == 'c' || a == 'e' || a == 'l' || a == 'o' || a == 's' ||  a == 't' ||  a == 'g'){
					switch (a) {
					case 'a':
						if (temp.endsWith("ational")){
							temp = temp.substring(0, temp.length()-7);
							temp = temp.concat("ate");
							DictionaryCheck(temp);
						}else if(temp.endsWith("tional")){
							temp = temp.substring(0, temp.length()-6);
							temp = temp.concat("tion");
							DictionaryCheck(temp);
						}else{}
						break;
					case 'c':
						if (temp.endsWith("enci")){
							temp = temp.substring(0, temp.length()-4);
							temp = temp.concat("ence");
							DictionaryCheck(temp);
						}else if(temp.endsWith("anci")){
							temp = temp.substring(0, temp.length()-4);
							temp = temp.concat("ance");
							DictionaryCheck(temp);
						}else{}
						break;
					case 'e':
						if (temp.endsWith("izer")){
							temp = temp.substring(0, temp.length()-4);
							temp = temp.concat("ize");
							DictionaryCheck(temp);
						}else{}
						break;
					case 'l':
						if (temp.endsWith("bli")){
							temp = temp.substring(0, temp.length()-3);
							temp = temp.concat("ble");
							DictionaryCheck(temp);
						}else if(temp.endsWith("alli")){
							temp = temp.substring(0, temp.length()-4);
							temp = temp.concat("al");
							DictionaryCheck(temp);
						}else if(temp.endsWith("entli")){
							temp = temp.substring(0, temp.length()-5);
							temp = temp.concat("ent");
							DictionaryCheck(temp);
						}else if(temp.endsWith("eli")){
							temp = temp.substring(0, temp.length()-3);
							temp = temp.concat("e");
							DictionaryCheck(temp);
						}else if(temp.endsWith("ousli")){
							temp = temp.substring(0, temp.length()-5);
							temp = temp.concat("ous");
							DictionaryCheck(temp);
						}else{}
						break;
					case 'o':
						if (temp.endsWith("ization")){
							temp = temp.substring(0, temp.length()-7);
							temp = temp.concat("ize");
							DictionaryCheck(temp);
						}else if(temp.endsWith("ation")){
							temp = temp.substring(0, temp.length()-5);
							temp = temp.concat("ate");
							DictionaryCheck(temp);
						}else if(temp.endsWith("ator")){
							temp = temp.substring(0, temp.length()-5);
							temp = temp.concat("ate");
							DictionaryCheck(temp);
						}else{}
						break;
					case 's':
						if (temp.endsWith("alism")){
							temp = temp.substring(0, temp.length()-5);
							temp = temp.concat("al");
							DictionaryCheck(temp);
						}else if(temp.endsWith("iveness")){
							temp = temp.substring(0, temp.length()-7);
							temp = temp.concat("ive");
							DictionaryCheck(temp);
						}else if(temp.endsWith("fulness")){
							temp = temp.substring(0, temp.length()-7);
							temp = temp.concat("ful");
							DictionaryCheck(temp);
						}else if(temp.endsWith("ousness")){
							temp = temp.substring(0, temp.length()-7);
							temp = temp.concat("ous");
							DictionaryCheck(temp);
						}else{}
						break;
					case 't':
						if (temp.endsWith("aliti")){
							temp = temp.substring(0, temp.length()-5);
							temp = temp.concat("al");
							DictionaryCheck(temp);
						}else if(temp.endsWith("iviti")){
							temp = temp.substring(0, temp.length()-5);
							temp = temp.concat("ive");
							DictionaryCheck(temp);
						}else if(temp.endsWith("biliti")){
							temp = temp.substring(0, temp.length()-6);
							temp = temp.concat("ble");
							DictionaryCheck(temp);
						}else{}
						break;
					case 'g':
						if (temp.endsWith("logi")){
							temp = temp.substring(0, temp.length()-4);
							temp = temp.concat("log");
							DictionaryCheck(temp);
						}else{}
						break;
					default:
						break;
						}
				}else if (lastCHar == 'e' || lastCHar == 'i' || lastCHar == 'l' || lastCHar == 's'){
					switch (lastCHar) {
					case 'e':
						if (temp.endsWith("icate")){
							temp = temp.substring(0, temp.length()-5);
							temp = temp.concat("ic");
							DictionaryCheck(temp);
						}else if(temp.endsWith("ative")){
							temp = temp.substring(0, temp.length()-5);
							temp = temp.concat("");
							DictionaryCheck(temp);
						}else if(temp.endsWith("alize")){
							temp = temp.substring(0, temp.length()-5);
							temp = temp.concat("al");
							DictionaryCheck(temp);
						}else{}
						break;
					case 'i':
						if (temp.endsWith("iciti")){
							temp = temp.substring(0, temp.length()-5);
							temp = temp.concat("ic");
							DictionaryCheck(temp);
						}else{}
						break;
					case 'l':
						if (temp.endsWith("ical")){
							temp = temp.substring(0, temp.length()-4);
							temp = temp.concat("ic");
							DictionaryCheck(temp);
						}else if(temp.endsWith("ful")){
							temp = temp.substring(0, temp.length()-3);
							temp = temp.concat("");
							DictionaryCheck(temp);
						}else{}
						break;
					case 's':
						if (temp.endsWith("ness")){
							temp = temp.substring(0, temp.length()-4);
							temp = temp.concat("");
							DictionaryCheck(temp);
						}else{}
						break;
					default:
						break;
					}
				}
		}
	}
*/

public void SuffixCheck(String temp){
	int stemLength = temp.length();
	FileInputStream fis = null;
	DataInputStream dis = null;
	BufferedReader br= null;
	
	try {
		fis = new FileInputStream("suffix.txt");
		dis = new DataInputStream(fis);
		br = new BufferedReader(new InputStreamReader(dis));
		String line = null;
	while((line = br.readLine()) != null){
		StringTokenizer st= new StringTokenizer(line, " ");
		while(st.hasMoreTokens()){
			String suffixTerm = st.nextToken().toLowerCase();
			if(temp.endsWith(suffixTerm)){
				String StemforDictionary = temp.substring(0, temp.length()-suffixTerm.length());
				// if you want to use a custom porter algo this would your workspace
				DictionaryStemWords(StemforDictionary);
				DictionaryCheck(StemforDictionary);
//				System.out.println("Rootword: "+ StemforDictionary);
				trueRoot = StemforDictionary;
			}
		}
	}
	}catch (Exception e) {}
}
public void DictionaryStemWords(String temp){
	FileInputStream fis = null;
	DataInputStream dis = null;
	BufferedReader br= null;	
	try{
		
		fis = new FileInputStream("wordlist.txt");
		dis = new DataInputStream(fis);
		br= new BufferedReader(new InputStreamReader(dis));
		String line = null;
		while((line = br.readLine()) != null){
			StringTokenizer st = new StringTokenizer(line, " ");
			while(st.hasMoreTokens()){
				String Dictionarywords= st.nextToken().toLowerCase();
				if(Dictionarywords.contains(temp)){
					stemWordsAfterCheck.add(Dictionarywords);
					
				}else{}
			}
		}
	}catch (Exception e){}	

}
public void DictionaryCheck(String temp){
	
	FileInputStream fis = null;
	DataInputStream dis = null;
	BufferedReader br= null;	
	try{
		
		fis = new FileInputStream("wordlist.txt");
		dis = new DataInputStream(fis);
		br= new BufferedReader(new InputStreamReader(dis));
		String line = null;
		while((line = br.readLine()) != null){
			StringTokenizer st = new StringTokenizer(line, " ");
			while(st.hasMoreTokens()){
				String Dictionarywords= st.nextToken().toLowerCase();
				if(Dictionarywords.equalsIgnoreCase(temp)){
					stemWordsAfterCheck.add(temp);
					rootWord = temp;
				}else if(Dictionarywords.contains(temp)){
					stemWordsAfterCheck.add(temp);
				}else{}
			}
		}
	}catch (Exception e){}	
}

public String getRootWord() {
	return rootWord;
}

public void setRootWord(String rootWord) {
	this.rootWord = rootWord;
}
}
