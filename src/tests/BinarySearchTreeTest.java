package tests;

import lib.BinarySearchTree;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    @Test
    public void testInorderTraversal() {
        System.out.println("\n📋 Εκτέλεση δοκιμής: Ενδοδιατεταγμένη διάσχιση");
        BinarySearchTree bst = new BinarySearchTree();

        System.out.println("➡️ Εισαγωγή τιμών: 5, 3, 7, 1, 9");
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        bst.insert(9);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        bst.inorder();
        System.setOut(originalOut);

        System.out.println("➡️ Αναμενόμενη σειρά: 1 3 5 7 9");
        System.out.println("➡️ Πραγματική σειρά: " + outContent.toString().trim());
        assertEquals("1 3 5 7 9 ", outContent.toString());
        System.out.println("✅ Η δοκιμή ολοκληρώθηκε επιτυχώς!");
    }

    @Test
    public void testPreorderTraversal() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bst.preorder();
        assertEquals("5 3 7 ", outContent.toString());
    }

    @Test
    public void testPostorderTraversal() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bst.postorder();
        assertEquals("3 7 5 ", outContent.toString());
    }
}
