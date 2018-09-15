class Node {
	Node next;
	int data;
}
class LinkedInsert {
	public Node insert(int data, Node start) {
		Node prev = null;
		Node cur = start;
		while (cur != null && cur.data > data) {
			prev = cur;
			cur = cur.next;
		}
		Node newN = null;
		if (prev == null) {
			newN.data = data;
			newN.next = start;
			return newN;
		}
		newN.data = data;
		prev.next =newN;
		newN.next = cur;
		return start;
	}
}
