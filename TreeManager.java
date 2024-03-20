//This program allows the user to store personal information 
//in key/value pairs using a binary search tree
// Name: Pierce Coyle
// Date: 3/15/2024  
// Class: CS 145
// Assignment:  lab #6 - Binary Search Tree.
public class TreeManager {
    TreeNode root;

    public TreeManager() { //TreeManager constructor
        root = null;
    } //End of TreeManager

    public void add(int key, String[] value) { //calls the recursive version and sets the root
        root = add(root, key, value);
    } //End of add

    private TreeNode add(TreeNode root, int key, String[] value) {//adds a node to the tree
        if (root == null) { //Base case  
            return new TreeNode(key, value);
        }

        if (key < root.key)
            root.left = add(root.left, key, value);
        else if (key > root.key)
            root.right = add(root.right, key, value);
        else
            root.value = value;

        return root;
    } //End of add

    public void delete(int key) { //Calls the recursive version and sets root
        root = delete(root, key);
    }//End of delete

    private TreeNode delete(TreeNode root, int key) { //deletes the required node
        if (root == null) { //base case
            System.out.println("Node with key " + key + " not found");
            return root;
        }
        if (key < root.key)
            root.left = delete(root.left, key);
        else if (key > root.key)
            root.right = delete(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = minValue(root.right);
            root.value = search(root.right, root.key);
            root.right = delete(root.right, root.key);
        }
        return root;
    } //End of delete

    public void modify(int key, String[] newValue) { //calls the recursive version and sets root
        root = modify(root, key, newValue);
    } //End of modify

    private TreeNode modify(TreeNode root, int key, String[] newValue) { //modifies the node
        if (root == null) { //base case
            System.out.println("Node with key " + key + " not found");
            return null;
        }
        if (key < root.key) {
            root.left = modify(root.left, key, newValue);
        } else if (key > root.key) {
            root.right = modify(root.right, key, newValue);
        } else {
            root.value = newValue;
            System.out.println("Node updated");
        }

        return root;
    } //End of modify
    


    public void traversal(int userInt) { //calls the requested traversal method
        switch (userInt) {
            case 1:
                    System.out.println("In-Order");
                    inOrder(root);
                break;
            case 2:
                    System.out.println("Post-Order");
                    postOrder(root);
                break;
            case 3:
                    System.out.println("Pre-Order");
                    preOrder(root);
                break;
        }
    } //End of traversal


    public void inOrder(TreeNode root) {//traverses in order
        if (root != null) {
            inOrder(root.left);
            printNode(root);
            inOrder(root.right);
        }
    } //End of inOrder

    public void postOrder(TreeNode root) {//traverses post order
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            printNode(root);
        }
    } //End of postOrder

    public void preOrder(TreeNode root) {//traverses pre order
        if (root != null) {
            printNode(root);
            preOrder(root.left);
            preOrder(root.right);
        }
    } //End of preOrder

    private void printNode(TreeNode node) { //prints the desired node
        System.out.println("Key: " + node.key + ", Values: ");
        for (String value : node.value) {
            System.out.println(value);
        }
    } //End of printNode

    public int list() { //calls the recursive function and passes root, returns count of nodes
            return list(root);
        } //End of list
    
        private int list(TreeNode node) { //lists the count of nodes
            if (node == null) {
                return 0;
            }
            // Count the current node and recursively count nodes in left and right subtrees
            return 1 + list(node.left) + list(node.right);
        } //End of list Overloaded
    
    //searches the tree for a given key, returns the associated value
    private String[] search(TreeNode root, int key) {
        if (root == null || root.key == key) { //base case
            return root == null ? null : root.value; //conditional for return value
        }
        if (key < root.key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    } //End of search

    private int minValue(TreeNode root) { //Finds the mininum key-value'd node for replacement
        int minVal = root.key;
        while (root.left != null) {
            minVal = root.left.key;
            root = root.left;
        }
        return minVal;
    } //End of minValue
}