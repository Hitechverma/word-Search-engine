import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;


class TreeOutput extends fileScanner{
	
	public JTree tree;
	static DefaultMutableTreeNode word = new DefaultMutableTreeNode(keywords);
	static DefaultMutableTreeNode leftNode[];
	static DefaultMutableTreeNode hisChild[];
	static int r=0;
	public String val1 = null;
	public int val2;
	
	public void TreeFetch(Object key, Object value) {
//		System.out.println(key);
//		System.out.println(value);
		val1 = (String) key;
		System.out.println(val1);
		leftNode[r] = new DefaultMutableTreeNode(val1);
		word.add(leftNode[r]);
		val2 = (int) value;
		System.out.println(val2);
		hisChild[r] = new DefaultMutableTreeNode(val2);
		leftNode[r].add(hisChild[r]);
		r++;
	}
	public void showTree(){
		JFrame frame = new JFrame();
	    //frame.add(newWord);
	    tree = new JTree(word);
	    frame.add(tree);
	    
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("MY_TREE");       
        frame.pack();
        frame.setSize(400,250);
        frame.setVisible(true);
	}
}
		
		// TODO Auto-generated constructor stub
		/*
		public JTree tree;
		private JLabel newWord = new JLabel("Root Stem Word");
	    public TreeOutput(){
	    			    	
	    	//my root node
	        DefaultMutableTreeNode word = new DefaultMutableTreeNode (passWord);
	        //System.out.println(passWord);
	        
	        
		    			        
		        DefaultMutableTreeNode leftNode1 = new DefaultMutableTreeNode("2.txt");
		        DefaultMutableTreeNode hisChild1= new DefaultMutableTreeNode("38");
		        
		        DefaultMutableTreeNode leftNode2 = new DefaultMutableTreeNode("6.txt");
		        DefaultMutableTreeNode hisChild2= new DefaultMutableTreeNode("7");
		        
		        DefaultMutableTreeNode leftNode3 = new DefaultMutableTreeNode("4.txt");
		        DefaultMutableTreeNode hisChild3= new DefaultMutableTreeNode("25");
		        			        
		      //create the tree by passing in the root node
		        word.add(leftNode1);
		        word.add(leftNode2);
		        word.add(leftNode3);
		        leftNode1.add(hisChild1);
		        leftNode2.add(hisChild2);
		        leftNode3.add(hisChild3);
		        
			    JFrame frame = new JFrame();
			    frame.add(newWord);
			    tree = new JTree(word);
			    frame.add(tree);
			    
			    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.setTitle("MY_TREE");       
		        frame.pack();
		        frame.setSize(400,250);
		        frame.setVisible(true);
	}*/
