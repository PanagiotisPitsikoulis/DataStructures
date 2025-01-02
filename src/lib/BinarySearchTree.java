package lib;

/**
 * Υλοποίηση Δυαδικού Δέντρου Αναζήτησης (Binary Search Tree)
 * Υποστηρίζει βασικές λειτουργίες εισαγωγής και διάσχισης
 * 
 * @author Panagiotis Pitsikoulis
 */
public class BinarySearchTree {
    /** Η ρίζα του δέντρου */
    private Node root;

    /**
     * Εισάγει μια νέα τιμή στο δέντρο διατηρώντας την ιδιότητα BST
     * 
     * @param value η τιμή που θα εισαχθεί στο δέντρο
     */
    public void insert(int value) {
        root = insertRec(root, value);
    }

    /**
     * Αναδρομική βοηθητική μέθοδος για την εισαγωγή στοιχείου
     * 
     * @param root  η τρέχουσα ρίζα του υποδέντρου
     * @param value η τιμή προς εισαγωγή
     * @return ο νέος κόμβος ή το ενημερωμένο υποδέντρο
     */
    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    /**
     * Εκτελεί ενδοδιατεταγμένη διάσχιση (inorder traversal)
     * Επισκέπτεται τους κόμβους με σειρά: αριστερό παιδί -> ρίζα -> δεξί παιδί
     */
    public void inorder() {
        inorderRec(root);
    }

    /**
     * Αναδρομική βοηθητική μέθοδος για την ενδοδιατεταγμένη διάσχιση
     * 
     * @param root η ρίζα του τρέχοντος υποδέντρου
     */
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }

    /**
     * Εκτελεί προδιατεταγμένη διάσχιση (preorder traversal)
     * Επισκέπτεται τους κόμβους με σειρά: ρίζα -> αριστερό παιδί -> δεξί παιδί
     */
    public void preorder() {
        preorderRec(root);
    }

    /**
     * Αναδρομική βοηθητική μέθοδος για την προδιατεταγμένη διάσχιση
     * 
     * @param root η ρίζα του τρέχοντος υποδέντρου
     */
    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    /**
     * Εκτελεί μεταδιατεταγμένη διάσχιση (postorder traversal)
     * Επισκέπτεται τους κόμβους με σειρά: αριστερό παιδί -> δεξί παιδί -> ρίζα
     */
    public void postorder() {
        postorderRec(root);
    }

    /**
     * Αναδρομική βοηθητική μέθοδος για την μεταδιατεταγμένη διάσχιση
     * 
     * @param root η ρίζα του τρέχοντος υποδέντρου
     */
    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.value + " ");
        }
    }
}