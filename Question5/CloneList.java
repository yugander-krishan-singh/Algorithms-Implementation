import java.util.HashMap;
import java.util.Map;

public class CloneList {

	public static class CloneListException extends RuntimeException {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public CloneListException() {

		}

		public CloneListException(String msg) {
			super(msg);
		}
	}

	public static class Node {
		int val;
		Node next;
		Node rand;

		public Node(int val) {
			this.val = val;
		}
	}

	private Node head;
	private Map<Integer, Node> randomMap;
	private static int counter = 0;

	public CloneList() {
		this.randomMap = new HashMap<>();
	}

	public void add(int val) {
		Node node = new Node(val);
		if (head == null)
			head = node;
		else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;
			temp.next = node;
		}
		randomMap.put(counter++, node);
	}

	public void addRandom(int source, int target) {
		if (!randomMap.containsKey(source) || !randomMap.containsKey(target))
			throw new CloneListException("source or target is incorrect");
		randomMap.get(source).rand = randomMap.get(target);
	}

	private static Map<Node, Node> storeNextInMap(CloneList list) {
		Map<Node, Node> map = new HashMap<>();
		Node temp = list.head;
		while (temp != null) {
			map.put(temp, temp.next);
			temp = temp.next;
		}

		return map;
	}

	private static CloneList createNewList(CloneList list) {
		CloneList newList = new CloneList();
		Node node = new Node(list.head.val);
		newList.head = node;
		Node temp = list.head.next;
		Node temp2 = newList.head;
		while (temp != null) {
			node = new Node(temp.val);
			temp2.next = node;
			temp = temp.next;
			temp2 = temp2.next;
		}
		return newList;
	}

	private static void modifyOrginalList(CloneList originalList, CloneList newList) {
		Node temp = originalList.head;
		Node temp2 = temp.next;
		Node temp3 = newList.head;
		while (temp != null) {
			temp.next = temp3;
			temp = temp2;
			if (temp == null)
				continue;
			temp2 = temp.next;
			temp3 = temp3.next;
		}
	}

	private static void createRandomPointersInClonedList(CloneList originalList, Map<Node, Node> map) {
		
		for (Map.Entry<Node, Node> entry : map.entrySet()) {
			if(entry.getKey().rand!=null) {
				entry.getKey().next.rand = entry.getKey().rand.next;
			}
		}
	}

	private static void fixOriginalList(CloneList originalList, Map<Node, Node> map) {
		Node temp = originalList.head;
		while (temp != null) {
			temp.next = map.get(temp);
			temp = temp.next;
		}
	}

	public static void cloneList(CloneList list) {

	}

	public static void main(String[] args) {
		CloneList cl = new CloneList();
		cl.add(1);
		cl.add(2);
		cl.add(3);
		cl.add(4);
		cl.add(5);

		cl.addRandom(0, 2);
		cl.addRandom(2, 4);

		Map<Node, Node> map = storeNextInMap(cl);
		CloneList newList = createNewList(cl);
		modifyOrginalList(cl, newList);
		createRandomPointersInClonedList(cl,map);
		fixOriginalList(cl, map);
		System.out.println(newList);
	}

}
