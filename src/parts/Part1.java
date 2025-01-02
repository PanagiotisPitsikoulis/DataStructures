package parts;

import lib.BinarySearchTree;

public class Part1 {
    public static void main(String[] args) {
        System.out.println("\n🌳 Binary Search Tree Demo\n");

        // Create and populate BST
        BinarySearchTree bst = new BinarySearchTree();
        int[] values = { 6, 4, 3, 5, 8, 7, 9 };

        System.out.println("📥 Inserting values: ");
        for (int value : values) {
            System.out.print(value + " ");
            bst.insert(value);
        }

        // Display traversals
        System.out.println("\n\n📊 Traversals:");
        System.out.print("Inorder:   ");
        bst.inorder();
        System.out.print("\nPreorder:  ");
        bst.preorder();
        System.out.print("\nPostorder: ");
        bst.postorder();
        System.out.println("\n");
    }
}