

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
 
public class TreeExample extends JFrame
{
    private JTree tree;
    public TreeExample()
    {
        //my root node
        DefaultMutableTreeNode word = new DefaultMutableTreeNode("Word");
        
        
        //child nodes
        DefaultMutableTreeNode leftNode = new DefaultMutableTreeNode("Left");
        DefaultMutableTreeNode rightNode = new DefaultMutableTreeNode("Right");
        DefaultMutableTreeNode left1 = new DefaultMutableTreeNode("Left");
        DefaultMutableTreeNode right1 = new DefaultMutableTreeNode("Right");
        DefaultMutableTreeNode left2 = new DefaultMutableTreeNode("Left");
        DefaultMutableTreeNode right2 = new DefaultMutableTreeNode("Right");
        DefaultMutableTreeNode left3 = new DefaultMutableTreeNode("Left");
        DefaultMutableTreeNode right3 = new DefaultMutableTreeNode("Right");
        DefaultMutableTreeNode left4 = new DefaultMutableTreeNode("Left");
        DefaultMutableTreeNode right4 = new DefaultMutableTreeNode("Right");
        DefaultMutableTreeNode left5 = new DefaultMutableTreeNode("Left");
        DefaultMutableTreeNode right5 = new DefaultMutableTreeNode("Right");
        
        
        //concting child to root
        word.add(leftNode);
        word.add(rightNode);
        rightNode.add(left1);
        rightNode.add(right1);
        leftNode.add(left2);
        leftNode.add(right2);
        left2.add(left3);
        left2.add(right3);
        right2.add(left4);
        right2.add(right4);
        right4.add(left5);
        right4.add(right5);
        
        
         
        //create the tree by passing in the root node
        tree = new JTree(word);
        add(tree);
         
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("MY_TREE");       
        this.pack();
        this.setSize(400,250);
        this.setVisible(true);
    }
     
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TreeExample();
            }
        });
    }       
}