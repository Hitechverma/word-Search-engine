import java.util.*;
import java.awt.Dimension;
import java.io.*;
import java.lang.*;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
/**
 * @author 
 * 
 *
 */
public class first {
/** 
 * @param args
 */
	
public static void main(String args[])
	{	
	//Scanner input = new Scanner(System.in);
	token tokenObject = new token();
	fileScanner fileScannerObject = new fileScanner();
	fileScannerObject.fileLister();
	//System.out.print("Enter your query: ");
	//String query = input.nextLine();
	
	//Simple code of UI
		UIManager.put("OptionPane.cancelButtonText", "Quit");
		UIManager.put("OptionPane.okButtonText", "Search");
		UIManager.put("OptionPane.minimumSize",new Dimension(400,200)); 
		String query = JOptionPane.showInputDialog("Enter Your Search query");
		System.out.println(query);
	
	tokenObject.QuerytoToken(query);
	tokenObject.TokentoStem();
	fileScannerObject.StemCounter();
	}



// public ArrayList al= new ArrayList<String>();
/*public static void TokenSenderToFileScanner(ArrayList al){
	fileScanner fileObject1 = new fileScanner();
	fileObject1.check(al);
}*/
}
