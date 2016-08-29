package binarytree;

import java.util.Stack;

//Authors: Brian Servia, Luke Dickerson

public class BinaryTree {
	private Node root;
	private Stack<Node> pathStack = new Stack<Node>();
	
	/*
	 * Constructor
	 */
	public BinaryTree() {
		//TODO
		root = null;
	}
	
	private class Node {
		private int key;
		private Node left, right;
		
		/*
		 * Constructor
		 */
		
		public Node (int key) {
			//TODO
			this.key = key;
		}
	}
	
	/*
	 * Add nodes to the binary tree. The first key should be the root.
	 * The key of one node should larger than all keys on its left, and smaller than all keys on its right.
	 * Examples: keys = [6, 5, 1, 0, 10, 8, 9, 4, 2]
	 * Tree should look like this:
	 *          6
	 *         / \
	 *        5  10
	 *       /   /
	 *      1   8
	 *     / \   \
	 *    0   4   9
	 *       /
	 *      2
	 */
	
	public void addNodes(int[] keys){
		  
		// for every key in the list
		for (int i = 0; i < keys.length; i++) {

			// if its the first key
			if (i == 0) {

				// set the root equal to it
				root = new Node(keys[i]);

				// otherwise its not the first key
			} else {

				// and add it elsewhere in the tree
				addNodesHelper1(keys[i], root);
			}
		}
	}

	private void addNodesHelper1(int k, Node n) {

		// if k is less than Node n
		if (k < n.key) {

			// if Node n has no left branch
			if (n.left == null) {

				// grow a left branch off of node n with the key
				n.left = new Node(k);

				// otherwise, Node n does have a left branch
			} else {

				// so check Node n's left branch now
				addNodesHelper1(k, n.left);
			}

			// otherwise, if k is greater than Node n
		} else if (k > n.key) {

			// if Node n has no right branch
			if (n.right == null) {

				// grow a right branch off of node n with the key
				n.right = new Node(k);

				// otherwise, Node n does have a right branch
			} else {

				// so check Node n's right branch now
				addNodesHelper1(k, n.right);
			}
		}
	}
	
//	public void addNodes(int[] keys){
//		//TODO
//		Node auxRoot = root;
//		if(auxRoot == null){
//			root = add(keys, root);
//			int[] newKeys = new int[keys.length-1];
//			for(int i =  0; i < keys.length-1; i++){
//				newKeys[i] = keys[i+1];
//			}
//			addNodes(newKeys);
//		
//		} else if(auxRoot != null && keys[0] < auxRoot.key){
//			System.out.println("Left " + keys[0]);
//			if(auxRoot.left == null){
//				root.left = add(keys, root);
//			}
//		}
//		
//	}
//	
//	private Node add(int[] keys, Node auxRoot){
//		if(auxRoot == null){
//			System.out.println("Root " + keys[0]);
//			auxRoot = new Node(keys[0]);
//			int[] newKeys = new int[keys.length-1];
//			for(int i =  0; i < keys.length-1; i++){
//				newKeys[i] = keys[i+1];
//			}
//			return auxRoot;
//			//add(newKeys, auxRoot);
//		} else if(auxRoot != null && keys[0] < auxRoot.key){
//			System.out.println("Left " + keys[0]);
//			if(auxRoot.left == null){
//				auxRoot.left = new Node(keys[0]);
//				return auxRoot.left;
////				if (keys.length > 1) {
////					int[] newKeys = new int[keys.length - 1];
////					for (int i = 0; i < keys.length - 1; i++) {
////						newKeys[i] = keys[i + 1];
////					}
////					add(newKeys, auxRoot);
////				}
//			} else if(auxRoot.left != null){
//				add(keys, auxRoot.left);
//			}
//			
//		} else if(auxRoot != null && keys[0] > auxRoot.key){
//			System.out.println("Right " + keys[0]);
//			if(auxRoot.right == null){
//				auxRoot.right = new Node(keys[0]);
//				if (keys.length > 1) {
//					int[] newKeys = new int[keys.length - 1];
//					for (int i = 0; i < keys.length - 1; i++) {
//						newKeys[i] = keys[i + 1];
//					}
//					add(newKeys, auxRoot);
//				}
//			} else if(auxRoot.right != null){
//				System.out.println("keep going");
//				add(keys, auxRoot.right);
//			}
//		} 
//		return null;
//	}
	
	/*
	 * For tree of the previous example, the output of preOrder method should be:
	 * 6 5 1 0 4 2 10 8 9
	 */
	public String preOrder() {
		//TODO
		
		StringBuilder num = new StringBuilder();
		num.append(root.key + " ");
		preOrd(root, num);
		return num.substring(0, num.length()-1);
	}
	
	private void preOrd(Node auxRoot, StringBuilder string){
		if(auxRoot.left != null){
			//string.append(" ");
			string = string.append(auxRoot.left.key + " ");
			preOrd(auxRoot.left, string);
		}
		if(auxRoot.right != null){
			//string.append(" ");
			string = string.append(auxRoot.right.key + " ");
			preOrd(auxRoot.right, string);
		}
	}
	
	
	/*
	 * For tree of the previous example, the output of inOrder method should be:
	 * 0 1 2 4 5 6 8 9 10
	 */
	
	
	public String inOrder() {
		//TODO
		StringBuilder num = new StringBuilder();
		if(root != null){
			inOrd(root, num);
		}
		return num.substring(0, num.length()-1);
	}
	
	private void inOrd(Node auxRoot, StringBuilder string){
		if(auxRoot.left != null){
			inOrd(auxRoot.left, string);
		}
		string = string.append(auxRoot.key + " ");
		
		if(auxRoot.right != null){
			inOrd(auxRoot.right, string);
		}
	}
	/*
	 * For tree of the previous example, the output of postOrder method should be:
	 * 0 2 4 1 5 9 8 10 6
	 *
	 */
	public String postOrder() {
		//TODO
		StringBuilder num = new StringBuilder();
		if(root != null){
			postOrd(root, num);
		}
		return num.substring(0, num.length()-1);
	}
	
	private void postOrd(Node auxRoot, StringBuilder string){
		if(auxRoot.left !=  null){
			postOrd(auxRoot.left, string);
		}
		
		if(auxRoot.right != null){
			postOrd(auxRoot.right, string);
		}
		string = string.append(auxRoot.key + " ");
	}
	/*
	 * For tree of the previous example, the output of levelOrder method should be:
	 * 6 5 10 1 8 0 4 9 2
	 */
	/* Add nodes to the binary tree. The first key should be the root.
	 * The key of one node should larger than all keys on its left, and smaller than all keys on its right.
	 * Examples: keys = [6, 5, 1, 0, 10, 8, 9, 4, 2]
	 * Tree should look like this:
	 *          6
	 *         / \
	 *        5  10
	 *       /   /
	 *      1   8
	 *     / \   \
	 *    0   4   9
	 *       /
	 *      2
	 */
	 public String levelOrder() {
		//TODO
		StringBuilder num = new StringBuilder();
		int levels = numOfLevels();
		if(root != null){
			for(int i = 1; i <= levels; i++){
				levelOrd(root, num, i);
			}
		}
		return num.substring(0, num.length()-1);
	}
	
	private void levelOrd(Node auxRoot, StringBuilder string, int level){
		if(auxRoot == null){
			return;
		}
		if(level == 1){
			string = string.append(auxRoot.key + " ");
		} else if(level > 1) {
			levelOrd(auxRoot.left, string, level-1);
			levelOrd(auxRoot.right, string, level-1);
		}
		
		
		
	}
	
	/*
	 * Return number of tree levels. For the tree of the previous example, the result should be 5. 
	 */
	public int numOfLevels() {
		//TODO
		return numLevels(root);
	}
	
	private int numLevels(Node auxRoot){
		if(auxRoot == null)
			return 0;
		return 1 + Math.max(numLevels(auxRoot.left), numLevels(auxRoot.right));
		
	}
	/*
	 * Return all nodes in the given level. The root is level 1.
	 * For the tree of the previous example, given 4, should return:
	 * 0 4 9
	 */
	public String nodesInLevel(int level) {
		//TODO
		StringBuilder num = new StringBuilder();
		if(root != null){
			levelOrd(root, num, level);
		}
		return num.substring(0, num.length()-1);
	}
	/*
	 * Return all nodes in the given level. The root is level 1.
	 * For the tree of the previous example, given 4, should return: 3
	 */
	public int numOfNodesInLevel(int level) {
		//TODO
		if(level == 1){
			return 1;
		}
		StringBuilder num = new StringBuilder();
		int number = 0;
		if(root != null){
			nodeLevelAux(root, num, level);
			for(int i = 0; i < num.length(); i++){
				if(num.charAt(i) == ' '){
					number++;
				}
			}
		}
		return number;
	}
	
	private void nodeLevelAux(Node auxRoot, StringBuilder string, int level){
		if(auxRoot == null){
			return;
		}
		if(level == 1){
			string = string.append(auxRoot.key + " ");
		} else if(level > 1) {
			nodeLevelAux(auxRoot.left, string, level-1);
			nodeLevelAux(auxRoot.right, string, level-1);
			
		}
	}
	
	/*
	 * Given a value, return the tree node with the key of that value. 
	 * Return null if cannot find such node.
	 */
	public Node findNode (int value) {
		//TODO
		Node found = null;
		if(root != null){
			found = findAux(value, root);
		}
		
		return found;
	}
	
	private Node findAux(int value, Node auxRoot){
		if (auxRoot != null) {
			if (auxRoot.key > value) {
				findAux(value, auxRoot.left);
			} else if (auxRoot.key < value) {
				findAux(value, auxRoot.right);
			} else if (auxRoot.key == value) {
				return auxRoot;
			}
		}
		return null;
	}
	/*
	 * Return the path from the given node to the node with key of the given value. 
	 * Return empty string if cannot find such path.
	 */
	public String path(Node node, int value) {
		String s = "";
		if(node == null){
			return "";
		}
		pathStack.push(node);
		if(node.key == (value)) {
			for(Node tt: pathStack){
				s+= tt.key + " ";
			}

		}
		s+= path(node.left,value);
		s+= path(node.right,value);
		pathStack.pop();

		return s.trim();
	}
}
