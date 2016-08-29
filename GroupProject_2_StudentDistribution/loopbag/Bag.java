package loopbag;

import java.util.Iterator;

public class Bag<E> implements LoopBag<E>{
	private int capacity, num;
	private Node prev, first; //previous goes before the first node(first)
	
	
	private class Node{
		private E data;
		private Node next;
		Node(E item){
			data = item;
		}
	}
	/**
	 * 
	 * @param capacity Fixed size bag capacity
	 */
	public Bag(int capacity){
		this.capacity = capacity;
		num = 0;
	}
	@Override
	public void insert(E item) {
		// TODO Auto-generated method stub
		//if its empty just make a new node
		//both prev and first will be pointing at the same node
		if(isEmpty()){
			first = new Node(item);
			prev = first;
			num++;
			//if size of the list is less than capacity, 
			//keep adding and nodes behind the first
		} else if(size() < capacity){
			Node newFirst = first;
			first = new Node(item);
			newFirst.next = first;
			num++;
			//iterate and make previous point to the right
			//node
		} else{
			Node newFirst = first;
			first = new Node(item);
			newFirst.next = first;
			prev = prev.next;
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.num;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(num == 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(E item) {
		// TODO Auto-generated method stub
		Node curr = prev;
		while(curr != null){
			if(curr.data.equals(item)){
				return true;
			}
			curr = curr.next;  //iterate by incrementing current node
		}
		
		return false;
	}

	@Override
	public void union(LoopBag<E> lb) {
		// TODO Auto-generated method stub
		for(E items : lb){
			if(!this.contains(items) && items != null){
				this.insert(items);
			}
		}
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<E>(){
			private Node left = prev;
			
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return left != null;  // if the next one is null 
									//than it doesn't have another node
			}

			@Override
			public E next() {
				// TODO Auto-generated method stub
				if(!hasNext()){
					return null;
				}
				E item = left.data;
				left = left.next;
				return item;
			}
			
		};
	}
	
	@Override
	public String toString(){
		StringBuffer buff = new StringBuffer();
		Node curr = prev;
		while(curr != null){
			buff.append(curr.data + ",");
			curr = curr.next;
		}
		
		return buff.toString();
	}


}
