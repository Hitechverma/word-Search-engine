import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class two extends JFrame{
	
	private JButton btn;
	
		public two(){
			super("The Browser BOx");
			setLayout(new FlowLayout());
			
			JLabel jb = new JLabel("Browse to Open the File");
			add(jb);
			
			btn = new JButton("Browse");
			btn.setLocation(150, 45);
			add(btn);
			
			btn.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent arg0){
					 JFileChooser openFile = new JFileChooser();
		                openFile.showSaveDialog(null);
		                
				}
			});
		}
		
			
	
	     
	     
}
