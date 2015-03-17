import java.awt.FlowLayout;
import javax.swing.JLabel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class second extends JFrame{
	
		private JLabel item;
		private JTextField searchbox;
		private JButton search;
		
		public second(){
			super("Search box");
			setLayout(new FlowLayout());
			
			item = new JLabel("Enter The Word You Want to Search");
			add(item);
			
			searchbox = new JTextField(25);
			add(searchbox);
			
			search = new JButton("Search !!");
			add(search);
		}
		
}
