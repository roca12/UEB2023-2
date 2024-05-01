package simple;

public class MainLinkedList {
	public static void main(String[] args) {

		MyLinkedList<Integer> linkedlist = new MyLinkedList<>();

		linkedlist.addLast(11);
		linkedlist.addLast(12);
		linkedlist.addLast(13);
		linkedlist.addLast(20);
		linkedlist.addLast(15);
		linkedlist.add(16);
		linkedlist.addLast(15);
		System.out.println(linkedlist.print());
	}
}
