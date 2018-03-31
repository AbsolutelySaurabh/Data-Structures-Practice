package AVLtrees;

public class Insert {
	
	//height
	private static int _height(Node<Integer> node) {
		
		if(node == null || node.left == null && node.right == null) {
			return 0;
		}
		return Math.max(_height(node.left), _height(node.right)) + 1;
	}
	
	private static Node<Integer> _rotate_right(Node<Integer> root) {
		Node<Integer> new_root = root.left;
		root.left = root.left.right;
		new_root.right = root;
		return new_root;
	}
	
	private static Node<Integer> _rotate_left(Node<Integer> root){
		Node<Integer> new_root = root.right;
		root.right = root.right.left;
		new_root.left = root;
		return new_root;		
	}
	
	private static Node<Integer> _insert(Node<Integer> root, int data) {
		
		if(root == null) {
			root = new Node<Integer>(data);
			return root;
		}
		
		if(data >= root.data) {
			root.right = _insert(root.right, data);
		}else
			if(data < root.data) {
				root.left = _insert(root.left, data);
			}
		
		//insertion in BST completes here
		
		//now, need to see the balancing
		int balancing = _height(root.left) - _height(root.right);
		System.out.println( "root.data: " + root.data + " " + _height(root));
		System.out.println("data: " + root.data + "balancing: " + balancing);
		//check the balancing
		if(balancing > 1) {
			//i.e. the left height is greater then the right by 1
			
			//check either to LL, LR, RL, RR rotate
			
			System.out.println("It's an AVL tree:  with balancing condition: " + balancing);
			
			if(_height(root.left.left) >= _height(root.left.right)) {
				//rotate RR
				root = _rotate_right(root);
				System.out.println("after returning ROOT: " + root.data );
			}else {
				//rotate LR
				root.left = _rotate_left(root.left);
				root = _rotate_right(root);
			}			
		}else
			if(balancing < -1) {
				//i.e. the left height is greater then the right by 1
				
				//check either to LL, LR, RL, RR rotate
				if(_height(root.right.left) >= _height(root.right.right)) {
					//rotate RR
					root = _rotate_right(root);
				}else {
					//rotate LR
					root.right = _rotate_left(root.right);
					root = _rotate_right(root);
				}			
			}
		return root;
			
	}
	
	private static void _pre_order(Node<Integer> root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		_pre_order(root.left);
		_pre_order(root.right);
	}

	public static void main(String[] args) {
		
		Node<Integer> root = _insert(null,4 );
		root = _insert(root, 3);
		root = _insert(root, 2);
		root = _insert(root, 1);	
		
		System.out.println("root data MAIN: " + root.data);
		_pre_order(root);
	}
}