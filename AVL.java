//Program to implement AVL tree.
import java.util.Scanner;
//Class to create nodes.
class Node {
    int data, h;
    Node leftChild, rightChild;

    Node() {
        data = 0;
        h = 0;
        leftChild = null;
        rightChild = null;
    }

    Node(int value) {
        data = value;
        h = 0;
        leftChild = null;
        rightChild = null;
    }
}
//Class to constructAVLTree
class ConstructAVLTree {
    private Node root;

    public ConstructAVLTree() {
        root = null;
    }

    /* ---------------- HEIGHT UTILITIES ---------------- */

    private int getHeight(Node node) {
        return node == null ? -1 : node.h;
    }

    private int max(int l, int r) {
        return l > r ? l : r;
    }

    /* ---------------- INSERT OPERATION ---------------- */

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node node, int key) {
        if (node == null)
            return new Node(key);

        if (key < node.data)
            node.leftChild = insertRec(node.leftChild, key);
        else if (key > node.data)
            node.rightChild = insertRec(node.rightChild, key);
        else
            return node; // duplicates not allowed

        node.h = max(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;

        int balance = getHeight(node.leftChild) - getHeight(node.rightChild);

        // LL
        if (balance == 2 && key < node.leftChild.data)
            return rotateWithLeftChild(node);

        // LR
        if (balance == 2 && key > node.leftChild.data)
            return doubleRotateWithLeftChild(node);

        // RR
        if (balance == -2 && key > node.rightChild.data)
            return rotateWithRightChild(node);

        // RL
        if (balance == -2 && key < node.rightChild.data)
            return doubleRotateWithRightChild(node);

        return node;
    }

    /* ---------------- ROTATIONS ---------------- */

    private Node rotateWithLeftChild(Node k2) {
        Node k1 = k2.leftChild;
        k2.leftChild = k1.rightChild;
        k1.rightChild = k2;

        k2.h = max(getHeight(k2.leftChild), getHeight(k2.rightChild)) + 1;
        k1.h = max(getHeight(k1.leftChild), k2.h) + 1;

        return k1;
    }

    private Node rotateWithRightChild(Node k2) {
        Node k1 = k2.rightChild;
        k2.rightChild = k1.leftChild;
        k1.leftChild = k2;

        k2.h = max(getHeight(k2.leftChild), getHeight(k2.rightChild)) + 1;
        k1.h = max(getHeight(k1.rightChild), k2.h) + 1;

        return k1;
    }

    private Node doubleRotateWithLeftChild(Node k3) {
        k3.leftChild = rotateWithRightChild(k3.leftChild);
        return rotateWithLeftChild(k3);
    }

    private Node doubleRotateWithRightChild(Node k3) {
        k3.rightChild = rotateWithLeftChild(k3.rightChild);
        return rotateWithRightChild(k3);
    }

    /* ---------------- SEARCH ---------------- */

    public void search(int key) {
        Node result = search(root, key);
        if (result == null)
            System.out.println("Key not found");
        else
            System.out.println("Key found");
    }

    private Node search(Node node, int key) {
        if (node == null || node.data == key)
            return node;
        else if (key < node.data)
            return search(node.leftChild, key);
        else
            return search(node.rightChild, key);
    }

    /* ---------------- DELETE ---------------- */

    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node node, int key) {
        if (node == null)
            return node;

        if (key < node.data)
            node.leftChild = deleteRec(node.leftChild, key);
        else if (key > node.data)
            node.rightChild = deleteRec(node.rightChild, key);
        else {
            if (node.leftChild == null || node.rightChild == null) {
                Node temp = (node.leftChild != null) ? node.leftChild : node.rightChild;
                node = temp;
            } else {
                Node temp = minValueNode(node.rightChild);
                node.data = temp.data;
                node.rightChild = deleteRec(node.rightChild, temp.data);
            }
        }

        if (node == null)
            return node;

        node.h = max(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;

        int balance = getHeight(node.leftChild) - getHeight(node.rightChild);

        if (balance == 2 && getHeight(node.leftChild.leftChild) >= getHeight(node.leftChild.rightChild))
            return rotateWithLeftChild(node);

        if (balance == 2 && getHeight(node.leftChild.leftChild) < getHeight(node.leftChild.rightChild))
            return doubleRotateWithLeftChild(node);

        if (balance == -2 && getHeight(node.rightChild.rightChild) >= getHeight(node.rightChild.leftChild))
            return rotateWithRightChild(node);

        if (balance == -2 && getHeight(node.rightChild.rightChild) < getHeight(node.rightChild.leftChild))
            return doubleRotateWithRightChild(node);

        return node;
    }

    private Node minValueNode(Node node) {
        Node current = node;
        while (current.leftChild != null)
            current = current.leftChild;
        return current;
    }

    /* ---------------- TRAVERSALS ---------------- */

    public void inorderTraversal() {
        inorderTraversal(root);
        System.out.println();
    }

    private void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.leftChild);
            System.out.print(node.data + " ");
            inorderTraversal(node.rightChild);
        }
    }

    public void preorderTraversal() {
        preorderTraversal(root);
        System.out.println();
    }

    private void preorderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderTraversal(node.leftChild);
            preorderTraversal(node.rightChild);
        }
    }

    public void postorderTraversal() {
        postorderTraversal(root);
        System.out.println();
    }

    private void postorderTraversal(Node node) {
        if (node != null) {
            postorderTraversal(node.leftChild);
            postorderTraversal(node.rightChild);
            System.out.print(node.data + " ");
        }
    }
}

/* ---------------- MAIN CLASS ---------------- */

public class AVL{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConstructAVLTree avl = new ConstructAVLTree();

        while (true) {
            System.out.println("\n1.Insert  2.Search  3.Delete  4.Inorder  5.Preorder  6.Postorder  7.Exit");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter value: ");
                    avl.insert(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter key: ");
                    avl.search(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter key: ");
                    avl.delete(sc.nextInt());
                    break;
                case 4:
                    avl.inorderTraversal();
                    break;
                case 5:
                    avl.preorderTraversal();
                    break;
                case 6:
                    avl.postorderTraversal();
                    break;
                case 7:
                    System.exit(0);
            }
        }
    }
}

