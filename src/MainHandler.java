import java.awt.Dimension;
import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.UIManager;


public class MainHandler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner input = new Scanner(System.in);
		FileHandler fileHandler = new FileHandler();
		fileHandler.FileLister();

		FirstEvent();
		// rest of the code goes over here
		
		SearchAgain();		
	}
	public static void FirstEvent(){
//		Scanner input = new Scanner(System.in);
		TokenHandler tokenHandler = new TokenHandler();
		FileHandler fileHandler = new FileHandler();
		fileHandler.EmptyTreeMap();
		System.out.println("Enter your Query : ");
//		String query = input.nextLine();
		
		//Simple code of UI
		UIManager.put("OptionPane.cancelButtonText", "Quit");
		UIManager.put("OptionPane.okButtonText", "Search");
		UIManager.put("OptionPane.minimumSize",new Dimension(400,200)); 
		String query = JOptionPane.showInputDialog("Enter Your Search query");
		System.out.println(query);
		
		// if check condition for empty query 
		tokenHandler.setQuery(query);
		tokenHandler.QueryToToken();
		tokenHandler.TokenToStem();
		fileHandler.StemCounterInFile();
		fileHandler.PrintResult();
		
	}
	static int searchAgain;
	public static void SearchAgain(){
		
		//alternative GUi
		
		int response = JOptionPane.showConfirmDialog(null, "Do you want to Search Again?", "Confirm",
		        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(response == JOptionPane.YES_OPTION){
			searchAgain = 1;
		}else{
			searchAgain = 0;
		}
		
		/*Scanner input = new Scanner(System.in);
		System.out.println("Do you want to search again? 1 or 0");
		int searchAgain = input.nextInt();*/
		if (searchAgain == 1) {
		main(null);
		}else if(searchAgain == 0){
			System.out.println("Thank you for using the Search Engine");
		}else{}
	}
	
	

}
