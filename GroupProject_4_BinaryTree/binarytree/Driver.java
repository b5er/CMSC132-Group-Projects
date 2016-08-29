package binarytree;

public class Driver {

	public static void main(String[] args){
		BinaryTree binary = new BinaryTree();
		int[] numbs = {3, 2, 4, 6, 9};
		binary.addNodes(numbs);
		System.out.println(binary.numOfLevels());
		System.out.println(binary.preOrder());
//		System.out.println(binary.addNodes(numbs));
		
	}
}
