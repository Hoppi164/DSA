import java.util.*;
class TreeGraph {
	Node[] cities = new Node[6];
	public static void main(String[] args) {
		TreeGraph map = new TreeGraph();

		map.breadthSearch(map.cities[0]);
	}
	public TreeGraph() {
		//POPULATE OUR CITIES
		char letter = 'A';
		cities[0] = new Node('S');
		for (int i = 1; i <= 4; i++) {
			cities[i] = new Node(letter++);
		}
		cities[5] = new Node('G');
		//instantiate children
		cities[0].children = new Node[2];
		cities[1].children = new Node[2];
		cities[2].children = new Node[3];
		cities[3].children = new Node[0];
		cities[4].children = new Node[3];
		cities[5].children = new Node[0];
		//Populate children
		// S children
		cities[0].children[0] = cities[1];
		cities[0].children[1] = cities[2];
		// A Children
		cities[1].children[0] = cities[2];
		cities[1].children[1] = cities[4];
		// B Children
		cities[2].children[0] = cities[1];
		cities[2].children[1] = cities[3];
		cities[2].children[2] = cities[4];
		// C Children
		// D Children
		cities[4].children[0] = cities[1];
		cities[4].children[1] = cities[2];
		cities[4].children[2] = cities[5];
	}

	private void breadthSearch(Node root) {
		System.out.println();
		List <Node> visited = new ArrayList <Node>();
		Queue <Node> q = new LinkedList <Node>();
		q.add(root);
		visited.add(root);
		while (q.size() > 0) {
			Node currentNode = q.poll();
			System.out.print(currentNode.name);
			if (currentNode.name == 'G') {
				break;
			} else {
				for (int i = 0; i < currentNode.children.length; i++) {
					if (currentNode.children[i].name != currentNode.name ) {
						q.add(currentNode.children[i]);
					}
				}
			}
		}
		System.out.println();
		System.out.println();
	}

}

class Node {
	char name;
	Node[] children;
	public Node(char name) {
		this.name = name;
	}
}
