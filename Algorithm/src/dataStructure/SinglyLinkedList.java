package dataStructure;
/**
 * 
 * 단순연결리스트 
 * 
 */
public class SinglyLinkedList {
	
	public static void main(String args[]) {
		
	}
	
	private static class LinkedList {
		private Node head;
		private Node tail;
		private int size = 0;
		
		private static class Node {
			public Object data;
			public Node next;
			
			public Node(Object data) {
				this.data = data;
				this.next = null;
			}
		}
	}
}
