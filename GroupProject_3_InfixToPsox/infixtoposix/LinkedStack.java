package infixtoposix;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<T> implements Stack<T> {
    private int N;
    private Node first;

    @Override
    public Iterator<T> iterator() {
        return null;
    }
    
    private class Node{
        private T data;
        private Node next;
        Node(T item){
            data = item;
            next = null;
        }
    }
    LinkedStack(){
        //TODO
    	N = 0;
    	first = null;
    }
    
	public void push(T item) {
		// TODO
		Node curr = new Node(item);
		curr.next = first;
		first = curr;
		N++;

	}
    
    public boolean isEmpty(){
        //TODO
    	if(N == 0 && first == null){
    		return true;
    	}
		return false;
    }
    public T pop(){
        //TODO
    	if(isEmpty()){
    		throw new EmptyStackException();
    	}
    	
    	T outcome = first.data;
    	first = first.next;
    	N--;
    	
    	return outcome;
    }
    public int size(){
        //TODO
    	return N;
    }
    
    public T peek(){
        //TODO
    	if(isEmpty()){
    		throw new EmptyStackException();
    	}
    	
    	return first.data;
    }
    public void printStack(){
    	System.out.println("**** stack ****");
    	Node c = first;
    	while (c != null){
    		System.out.println(c.data);
    		c = c.next;
    	}
    	System.out.println("***************");
    }
}