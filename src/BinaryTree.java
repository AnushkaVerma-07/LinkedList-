public class BinaryTree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTreeNode{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if( nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void preorder(Node root){  //(root , left subtree , right subtree)
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root){ //(left subtree , root , right subtree)
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+ " ");
        inorder(root.right);
    }

    public static void postorder(Node root){ //(left subtree , right subtree , root)
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+ " ");
    }

    public static int countOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftNodes = countOfNodes(root.left);
        int rightNodes = countOfNodes(root.right);

        return leftNodes + rightNodes + 1;
    }

    public static int sumOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftsum = sumOfNodes(root.left);
        int rightsum = sumOfNodes(root.right);

        return leftsum + rightsum + root.data;
    }

    public static int height(Node root){
        if(root == null){
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int myHeight = Math.max(leftHeight, rightHeight)+1;
        return myHeight;
    }


    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTreeNode tree = new BinaryTreeNode();
        Node root = tree.buildTree(nodes);
//        System.out.println("Root node is ");
//        System.out.println(root.data);
//        System.out.println("Preorder subtree is: ");
//        preorder(root);
//        System.out.println();
//        System.out.println("Inorder subtree is: ");
//        inorder(root);
//        System.out.println();
//        System.out.println("Postorder subtree is: ");
//        postorder(root);
        System.out.println("Count of Nodes is "+ countOfNodes(root));
        System.out.println("Sum of Nodes is "+ sumOfNodes(root));
        System.out.println("Height of tree is "+ height(root));



    }
}
