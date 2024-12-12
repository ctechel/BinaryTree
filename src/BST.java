import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        return helpSearch(val, root);
    }

    // Helper for Search
    public boolean helpSearch(int val, BSTNode node)
    {
        if (node == null)
        {
            return false;
        }
        if (val == node.getVal())
        {
            return true;
        }
        if (val < node.getVal())
        {
            return helpSearch(val, node.getLeft());
        }
        else
        {
            return helpSearch(val, node.getRight());
        }
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        ArrayList<BSTNode> done = new ArrayList<BSTNode>();
        getInorderHelper(root, done);
        return done;
    }

    // Helper for Inorder
    public void getInorderHelper(BSTNode root, ArrayList<BSTNode> done)
    {
        if (root == null)
        {
            return;
        }
        // Left, Root, Right
        getInorderHelper(root.getLeft(), done);
        done.add(root);
        getInorderHelper(root.getRight(), done);
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        ArrayList<BSTNode> done = new ArrayList<BSTNode>();
        getPreorderHelper(root, done);
        return done;
    }

    // Helper for Preorder
    public void getPreorderHelper(BSTNode root, ArrayList<BSTNode> done)
    {
        if (root == null)
        {
            return;
        }
        // Root, Left, Right
        done.add(root);
        getPreorderHelper(root.getLeft(), done);
        getPreorderHelper(root.getRight(), done);
    }


    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        ArrayList<BSTNode> done = new ArrayList<BSTNode>();
        getPostorderHelper(root, done);
        return done;
    }

    // Helper for Postorder
    public void getPostorderHelper(BSTNode root, ArrayList<BSTNode> done)
    {
        if (root == null)
        {
            return;
        }
        // Left, Right, Root
        getPostorderHelper(root.getLeft(), done);
        getPostorderHelper(root.getRight(), done);
        done.add(root);
    }
    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        insertHelper(val, root);
    }

    // Helper for Insert
    public void insertHelper(int val, BSTNode node)
    {
        if (val == node.getVal())
        {
            return;
        }
        if (val < node.getVal())
        {
            if (node.getLeft() == null)
            {
                node.setLeft(node);
            }
            else
            {
                insertHelper(val, node.getLeft());
            }
        }
        else
        {
            if (node.getRight() == null)
            {
                node.setRight(node);
            }
            else
            {
                insertHelper(val, node.getRight());
            }
        }
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
