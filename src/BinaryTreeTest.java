



public class BinaryTreeTest {
public void test(){
	BinaryTree tree = new BinaryTree();
	
	tree.add(50, "bring");
	tree.add(25, "bringing");
	tree.add(75, "brought");
	tree.add(10, "broughted");
	tree.add(30,"bro");
	
	tree.traverse();
	
}
}
