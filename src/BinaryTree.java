

public class BinaryTree {
	// Node -> key(data)
	//	-> 2 children(lChild and rchild)
	Node root;
	public void add(int data, String term){
		Node nodeToAdd = new Node(data, term);
		if(root == null)
			root = nodeToAdd;
		//if data < node traverse left child, else traverse right child
		//until we get to a node that we cannot traverse...insert new node
		traverseAndAddNode(root, nodeToAdd);
	}
	private void traverseAndAddNode(Node node, Node nodeToAdd){
		if(nodeToAdd.data < node.data )
		{
			if(node.leftChild == null){
				node.leftChild = nodeToAdd;
			}
			else {
				traverseAndAddNode(node.leftChild, nodeToAdd);
			}
		}
			else if(nodeToAdd.data > node.data){
				if(node.rightChild == null){
					node.rightChild = nodeToAdd;
				}
				else{
					traverseAndAddNode(node.rightChild, nodeToAdd);
				}
			}
		}
	
	public void traverse()
	{
		if(root != null)
		{
			Node nodeToTraverse = root;
			if(nodeToTraverse.leftChild == null && nodeToTraverse.rightChild == null)
			{
				System.out.println(nodeToTraverse.data);
				System.out.println(nodeToTraverse.term);
			}
			else
			{
				System.out.println(nodeToTraverse.data);
				System.out.println(nodeToTraverse.term);
				if(nodeToTraverse.leftChild != null)
				{
					preOrderTraversal(nodeToTraverse.leftChild);
				}
				if(nodeToTraverse.rightChild != null)
				{
					preOrderTraversal(nodeToTraverse.rightChild);
				}
			}
		}
	}
//	private void inOrderTraversal(Node node)
//	{
//		if(node.leftChild !=null)
//		{
//			inOrderTraversal(node.leftChild);
//		}
//		System.out.println(node.data);
//		System.out.println(node.term);
//		if(node.rightChild != null)
//		{
//			inOrderTraversal(node.rightChild);
//		}
//	}
	private void preOrderTraversal(Node node)
	{

		System.out.println(node.data);
		System.out.println(node.term);
		if(node.leftChild !=null)
		{
			preOrderTraversal(node.leftChild);
		}
		if(node.rightChild != null)
		{
			preOrderTraversal(node.rightChild);
		}
	}
	
	
}
