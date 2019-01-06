public class BST {

    Node root = null;

    public void insert(int data) {
        root = insertNode(root , data);
    }

    public Node insertNode(Node root , int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insertNode(root.left , data);
        } else if(data > root.data) {
            root.right = insertNode(root.right , data);
        }
        return root;
    }

    public void delete(int data) {
        root = deleteNode(root , data);
    }

    public Node deleteNode(Node root , int data) {
        if (root == null) return root;

        if (data < root.data) {
            root.left = deleteNode(root.left , data);
        } else if(data > root.data) {
            root.right = deleteNode(root.right , data);
        }
        else {
            if (root.left == null) {
                return  root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = min(root.right);
            root.right = deleteNode(root.right , root.data);
        }
        return root;
    }

    public int min(Node root) {
        int mins = root.data;
        while (root.left != null) {
            mins = root.left.data;
            root = root.left;
        }
        return mins;
    }


    public void printNode(Node root) {
        if (root != null) {
            printNode(root.left);
            System.out.println(root.data);
            printNode(root.right);
        }
    }

    public void print() {
        printNode(root);
    }

    public static void main(String[] args) {
        BST bst = new BST();

        bst.insert(6);
        bst.insert(5);
        bst.insert(4);
        bst.insert(3);
        bst.insert(2);
        bst.insert(1);

        bst.print();

        System.out.println("\nAFTER DELETE\n");

        bst.delete(1);
        bst.delete(2);
        bst.delete(3);

        bst.print();
    }

}
