/*
 * 	Implement the findWord and findPath method in the BoggleGame class.
 * 
 */

package boggle;

import java.util.Stack;

import utils.LetterGrid;

public class BoggleGame {
	
	/**
	 * The grid that contains all the letters. @see boggle.LetterGrid
	 */
	LetterGrid grid;
	
	/**
	 * The stack that stores the path when you search the word path
	 */
	Stack<String> path;
	
	/**
	 * A boolean array to mark any location (row,col) as visited
	 */
	boolean[][] visited;
	
	int there;
	
	public BoggleGame(LetterGrid g) {
		grid = g;
	}
	/*
	 * return true if "word" can be found in "grid". return false otherwise
	 * private member variable grid has the letter grid.
	 * 
	 */
	public boolean findWord(String word) {
		/**
		 * TODO: implement your method here (you may write helper method)
		 */
		//initialized to false
		boolean fOrT = false;
		
		//number of characters of the word, that have been processed,
		//at the very beginning
		int length = 0;
		
		//initializing to all false
		visited = new boolean[grid.getNumRows()][grid.getNumCols()];
		
		for(int i = 0; i < grid.getNumRows(); i++){
			for(int k = 0; k < grid.getNumCols(); k++){
				if(findAux(i, k, length, word)){
					return true;
				}
			}
		}
		
		return fOrT; // TODO: change this line according to your implementation
	}
	
	private boolean findAux(int row, int col, int characters, String word){
		boolean fOrT = false;
		
		//will be the last iteration. Will be the indicator that the recursion
		//should stop, since we have found all the characters
		if(characters == word.length()){
			return true;
		}
		
		//making sure that we don't get a out of bound exception 
		if(row < 0 || col < 0 || row >= grid.getNumRows() ||
				col >= grid.getNumCols() || visited[row][col]){
			return false;
		}
		
		//if letter is found on the grid, execute the recursion. The recursion
		//will make fOrT true or false, and will map out the visited location
		//on the visited 2d array. 
		if(grid.getLetter(row, col) == word.charAt(characters)){
			visited[row][col] = true;
			
			fOrT = this.findAux(row, col-1, characters+1, word)||
			this.findAux(row, col+1, characters+1, word)||
			this.findAux(row+1, col-1, characters+1, word)|| 
			this.findAux(row+1, col, characters+1, word)||
			this.findAux(row+1, col+1, characters+1, word)||
			this.findAux(row-1, col+1, characters+1, word)||
			this.findAux(row-1, col, characters+1, word)|| 
			this.findAux(row-1, col-1, characters+1, word); 
    		
		}
		if(!fOrT){
			visited[row][col] = false;
		}
		return fOrT;
	}
	
	/*
	 * return the path (cell index) of each letter
	 * 
	 */
	public String findWordPath(String word) {
		/**
		 * TODO: implement your method here (you may write helper method)
		 */
		//initialize all to false
		visited = new boolean[grid.getNumRows()][grid.getNumCols()];
		//initialize a stack that will hold strings. (the coordinates on grid)
		path = new Stack<String>();
		
		//keep track of how many letters we have found
		there = 0;
		//the number of characters that were process in path
		int length = 0;
		for (int i = 0; i < grid.getNumRows(); i++) {
			for (int k = 0; k < grid.getNumCols(); k++) {
				if (path(i, k, length, word)) {
					there++;
				}
			}

		}
		
		//if we found more than one letter, than we are going to pop the result
		//in order to print the coordinates where that letter was found
		if(there>0){
			StringBuffer pathing = new StringBuffer();
			while(!path.isEmpty()){
				pathing.append(path.pop() + "\n");
			}
			return pathing.toString();
		}
		
		//if no letter was found, just return an empty string
		return ""; // TODO: change this line according to your implementation
	}
	
	private boolean path(int row, int col, int length, String word){
		boolean found = false;
		
		//will stop the recursion if all of the letters were found
		if(length == word.length()){
			return true;
		}
		
		//making sure we don't go get an out of bound exception in the grid
		else if(row<0 || col<0 || row >= grid.getNumRows() || col>=grid.getNumCols()){
			return false;
		}
		
		//if letter not found
		else if(grid.getLetter(row, col) != word.charAt(length)){
			return false;
		}
		
		//will recursively go through the grid trying to find the letters that
		//are connected. At the same time incrementing there, each time its true.
		else{
			visited[row][col] = true;
			there++;
			
			found = path(row, col-1, length+1, word)||
					path(row, col+1, length+1, word)||
					path(row-1, col-1, length+1, word)||
					path(row-1, col, length+1, word)||
					path(row-1, col+1, length+1, word)||
					path(row+1, col-1, length+1, word)||
					path(row+1, col, length+1, word)||
					path(row+1, col+1, length+1, word);
		}
		
		//if the letter is found, we will push the location of the letter, 
		//based on the grid
		if(found){
			path.push("(" + row + "," + col + ")");
		}
		else{
			visited[row][col] = false;
		}
		
		return found;
	}
}
