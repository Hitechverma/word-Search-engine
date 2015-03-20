import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;


class TreeOutput{
	
	public JTree tree;
	static DefaultMutableTreeNode word;
	static DefaultMutableTreeNode leftNode;
	static DefaultMutableTreeNode hisChild;
	static int r;
	public String val1;
	public int val2;
		
	public TreeOutput(String trueRoot){
//		System.out.println(trueRoot + " this is also a value of word");
		word = new DefaultMutableTreeNode(trueRoot);
		}
	/*public void setWord(String rootWord){
		
		word = new DefaultMutableTreeNode(rootWord);
	}*/
	/*public void TreeFetch(String key, int value) {
//	System.out.println(key);
//	System.out.println(value);
	try {
		val1 = key;
		System.out.println(val1);
		leftNode[r] = new DefaultMutableTreeNode(val1);
		word.add(leftNode[r]);
		val2 = value;
		System.out.println(val2);
		hisChild[r] = new DefaultMutableTreeNode(val2);
		leftNode[r].add(hisChild[r]);
		r++;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}*/
	public void TreeFetch(String key, int value) {
		leftNode = new DefaultMutableTreeNode(key);
		word.add(leftNode);
		hisChild = new DefaultMutableTreeNode(value);
		leftNode.add(hisChild);
	}
	

	public void showTree(){
		JFrame frame = new JFrame();
	    //frame.add(newWord);
	    tree = new JTree(word);
	    frame.add(tree);
	    for (int i = 0; i < tree.getRowCount(); i++) {
	         tree.expandRow(i);
	     }
	    
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("MY_TREE");       
        frame.pack();
        frame.setSize(400,400);
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
