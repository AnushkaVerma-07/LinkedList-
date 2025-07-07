public class BinarySearchTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // Insert nodes in binary search tree
    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data> val) {
            root.left = insert(root.left, val);
        }
        else{
            root.right = insert(root.right,val);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.println(root.data + " ");
        inorder(root.right);
    }

    //search in BST

    public static boolean search(Node root, int key){
        if(root == null){
            return false;
        }
        if(root.data>key){
            return search(root.left,key);
        }
        else if (root.data == key) {
            return true;
        }
        else{
            return search(root.right,key);
        }
    }

    //delete a node in binary search tree
    public static Node deleteNode(Node root, int key){
        if(root.data> key){
            root.left = deleteNode(root.left, key);
        }
        else if (root.data < key) {
            root.right = deleteNode(root.right, key);
        }
        else{
            //case 1
            if(root.left == null && root.right == null){
                return null;
            }
            //case 2
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }

            //case 3
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = deleteNode(root.right, IS.data);
        }
        return root;
    }

    public static Node inorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    //print the given range of nodes in binary search tree

    public static void printInRange(Node root, int X, int Y){
        if(root == null){
            return ;
        }
        if(root.data >= X && root.data <= Y){
            printInRange(root.left,X,Y);
            System.out.println(root.data+ " ");
            printInRange(root.right,X,Y);
        }
        else if (root.data >= Y) {
            printInRange(root.right,X,Y);
        }
        else{
            printInRange(root.left,X,Y);
        }
    }



    public static void main(String[] args) {
        int[] values = {5,1,3,4,2,7};
        Node root = null;
        for(int  i=0; i<values.length; i++){
            root = insert(root,values[i]);
        }
        inorder(root);
        System.out.println();

        if(search(root,7)){
            System.out.println("found");
        }
        else{
            System.out.println("Not found");
        }

        deleteNode(root, 5);
        inorder(root);
    }
}
