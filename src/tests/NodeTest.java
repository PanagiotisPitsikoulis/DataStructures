package tests;

import lib.Node;
import org.junit.Test;
import static org.junit.Assert.*;

public class NodeTest {
    @Test
    public void testNodeCreation() {
        System.out.println("\n📋 Εκτέλεση δοκιμής: Δημιουργία κόμβου");
        Node node = new Node(5);
        System.out.println("➡️ Δημιουργήθηκε κόμβος με τιμή: " + node.value);
        System.out.println("➡️ Έλεγχος αριστερού παιδιού: " + (node.left == null ? "null" : node.left.value));
        System.out.println("➡️ Έλεγχος δεξιού παιδιού: " + (node.right == null ? "null" : node.right.value));
        assertEquals(5, node.value);
        assertNull(node.left);
        assertNull(node.right);
        System.out.println("✅ Η δοκιμή ολοκληρώθηκε επιτυχώς!");
    }

    @Test
    public void testNodeConnections() {
        System.out.println("\n📋 Εκτέλεση δοκιμής: Συνδέσεις κόμβων");
        Node root = new Node(5);
        Node left = new Node(3);
        Node right = new Node(7);

        System.out.println("➡️ Δημιουργία κόμβων:");
        System.out.println("   🌳 Ρίζα: " + root.value);
        System.out.println("   🌿 Αριστερό παιδί: " + left.value);
        System.out.println("   🌿 Δεξί παιδί: " + right.value);

        root.left = left;
        root.right = right;

        System.out.println("\n➡️ Έλεγχος συνδέσεων:");
        System.out.println("   🔍 Αριστερό παιδί της ρίζας: " + root.left.value);
        System.out.println("   🔍 Δεξί παιδί της ρίζας: " + root.right.value);

        assertEquals(left, root.left);
        assertEquals(right, root.right);
        assertEquals(3, root.left.value);
        assertEquals(7, root.right.value);
        System.out.println("✅ Η δοκιμή ολοκληρώθηκε επιτυχώς!");
    }
}