package demo1.ds;

public class RearrangeLL {

	public static void main(String[] args) {

		Node node0 = new Node(0, null);
		Node node1 = new Node(1, null);
		Node node2 = new Node(2, null);
		Node node3 = new Node(3, null);
		Node node4 = new Node(4, null);
		Node node5 = new Node(5, null);
		Node node6 = new Node(6, null);
		Node node7 = new Node(7, null);
		Node node8 = new Node(8, null);
		Node node9 = new Node(9, null);
		Node node10 = new Node(10, null);
		node0.addNode(node1);
		node0.addNode(node2);
		node0.addNode(node3);
		node0.addNode(node4);
		node0.addNode(node5);
		node0.addNode(node6);
		node0.addNode(node7);
		node0.addNode(node8);
		node0.addNode(node9);
		node0.addNode(node10);

		RearrangeLL rearrangeLL = new RearrangeLL();
		rearrangeLL.printLL(node0);
		/*rearrangeLL.printLL(rearrangeLL.reverseLL(node0));
		rearrangeLL.printLL(node0);*/
		rearrangeLL.rearrangeLL(node0);
	}

	public void rearrangeLL(Node node) {
		Node x, y, temp;
		x = y = node;

		while (x.getLink() != null && y.getLink() != null && y.getLink().getLink() != null) {
			x = x.getLink();
			y = y.getLink().getLink();
		}
		System.out.println(x.getValue());
		System.out.println(y.getValue());
		Node list2 = reverseLL(x.getLink());
		x.setLink(null);
		Node list1 = node;

		node = new Node(0, null);
		temp = node;
		while (list1 != null || list2 != null) {
			if (list1 != null) {
				temp.setLink(list1);
				temp = temp.getLink();
				list1 = list1.getLink();
			}
			if (list2 != null) {
				temp.setLink(list2);
				temp = temp.getLink();
				list2 = list2.getLink();
			}
		}
		node = node.getLink();
		printLL(node);

	}

	public Node reverseLL(Node node) {

		Node pre = null, next = node.getLink(), current = node;
		while (current.getLink() != null) {
			current.setLink(pre);
			pre = current;
			current = next;
			next = next.getLink();
		}
		current.setLink(pre);
		return current;
	}

	public void printLL(Node node) {
		Node temp = node;
		while (temp.getLink() != null) {
			System.out.print(temp.getValue());
			temp = temp.getLink();
		}
		System.out.println(temp.getValue());
	}

}

class Node {
	private int value;
	private Node link;

	public Node(int value, Node link) {
		this.value = value;
		this.link = link;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLink() {
		return link;
	}

	public void setLink(Node link) {
		this.link = link;
	}

	public void addNode(Node node) {
		Node temp = this;
		while (temp.getLink() != null)
			temp = temp.getLink();
		temp.setLink(node);
	}

}