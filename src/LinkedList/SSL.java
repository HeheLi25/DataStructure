package LinkedList;

public class SSL<E> {
	private Node<E> first;
	public SSL() {
		first = null;
	}
	public Node<E> getFirst(){
		return first;
	}
	private static class Node<E> {
		protected E element;
		protected Node<E> next;
		public Node(E element, Node<E> next) {
			this.element = element;
			this.next = next;
		}
	}
	
	public void traversal() {
		Node<E> curr = first;
		while(curr != null) {
			System.out.print(curr.element+"->");
			curr = curr.next;
		}
		System.out.println();
	}
	public void deleteFirst() {
		first = first.next;
	}
	public void insert(E elem, Node<E> pred) {
		Node<E> ins = new Node(elem, null);
		if(pred == null) {//empty linkedlist
			ins.next = first;
			first = ins;
		}else {
			ins.next = pred.next;
			pred.next = ins;
		}
	}
	public void delete(Node<E> del) {//O(n)
		Node<E> next = del.next;
		if(del == first) first = next;
		else {
			Node<E> pred = first;
			while(pred.next != del) {
				pred = pred.next;
			}
			pred.next = next;
		}
	}
	
	
	public static void main(String[] args) {
		SSL ll = new SSL();
		Node<String> n = new Node<String>("Yeah", null);
		Node<String> n1 = new Node<String>("Chentao",n);
		n = new Node<String>("Yirong",n1);
		n1 = new Node<String>("Zhou",n);
		ll.first = n1;
		ll.traversal();
		ll.insert("Insert!", ll.first.next);
		ll.traversal();

	}
	

}
