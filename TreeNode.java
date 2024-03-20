//This program allows the user to store personal information 
//in key/value pairs using a binary search tree
// Name: Pierce Coyle
// Date: 3/15/2024  
// Class: CS 145
// Assignment:  lab #6 - Binary Search Tree.
public class TreeNode {
    int key;
    String[] value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int key, String[] value) { //TreeNode constructor
        this.key = key;
        this.value = value;
        left = null;
        right = null;
    }  //End of TreeNode
}
