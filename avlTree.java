	//A practice example of an AVL tree data structure
	// basic tree structure looks like this
	//				 [Root]
	//			[L]			[R]
	//		[L]		[R]	[L]		[R]
class AVLTree {
	Node root;// base node that leads to all other nodes
	public static void main(String[] args) {
		AVLTree test = new AVLTree();//Testing instantiation
		printTree(root);//Prints tree to console (for testing)
	}
	private int height(Node n){//Method structure works RECURSIVLY -- returns height from bottom to given node $n (usually root)
		if (n == null) {//if node is NULL, it does not exist
			return -1;
		} // uses process of elimination to determine which node has children
		else if (n.left == null && n.right == null) {// If node has no children, it does not add to height
			return 0;
		}
		else if (n.left == null) {//If node has no left child (NOTE WE KNOW IT HAS AT LEAST ONE CHILD)
			return 1 + height(n.right);//We add one to the height of the right children
		}
		else if (n.right == null) {//f node has no Right child (NOTE WE KNOW IT HAS AT LEAST ONE CHILD)
			reutrn 1 + height(n.left);//We therefore know that it is the left child that we have to count
		}
		else{// If both children exist  
			return 1+ max(height(n.left), height(n.right));//return 1 + whatever one i higher
		}
	}
	private int max(int a, int b){//Return the higher of two numbers
		return (a >= b) ? a:b;// Ternary argument, if $a is higher: return $a; if $b is higher: return $b.
	}
	public void insert(int v){//Access setter, for integer value -- lazy mans insert
		Node n = new Node(v);//create a node from the integer
		insert( this.root, n );//call the insert method as if user wasn't a lazy-bum.
	}
	public void insert(Node check, Node n){//Actual Insert method; Puts a Node $n in it's correct place in the tree -- $check usually starts as root
		if (check == null) {// If root does not exist
			this.root = n;// make $n the new root
		}
		else{
			if (check.value < n.value) {//Does $n belong on the left?
				if (check.left == null) {//If left does not exist
					check.left = n;// insert $n into empty slot on the left
					n.parent = check;// "who's your daddy?"
					//TODO autobalance
				}
				else{// If the $n should go to the left, but there's already a node there
					insert(check.left, n);// Recursively check where we can insert it (check.left becomes the new check)
				}
			}
			else if(check.value > n.value){//Does node belong on the right?
				if (check.right == null) {//If there is no right node
					check.right = n;//make $n the new right node
					n.parent = check;// "I'm your daddy"
					//TODO autobalance
				}
				else{// If $n should go to the right, but there's already a node there
					insert(check.right, n);// Recursivly check where where we can insert $n
				}
			}
			else{//If n == check -- they are the same value -- so we follow our governments example and..
				//Do Nothing
			}
		}
	}
	public void printTree(){
		int height = height(this.root);
		for (int i =0; i< height; i++) {
			System.out.print(" ");//Print Begginning spaces
		}

	}
}

class Node {
	int value;
	Node left;
	Node right;
	Node parent;
	public Node(int v){
		left = right = parent = null;
		value = v;
	}
	public toString(){
		return "" + value;
	}
}