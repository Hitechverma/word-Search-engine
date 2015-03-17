import java.io.File;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class browser {
	
	public static void main(String[]args){
		two sec = new two();
		sec.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sec.setSize(400,150);
		sec.setVisible(true);
		sec.setLocationByPlatform(true);
	}
}
