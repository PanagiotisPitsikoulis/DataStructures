package lib;

/**
 * Κλάση που αναπαριστά έναν κόμβο σε ένα δυαδικό δέντρο αναζήτησης
 * 
 * @author Panagiotis Pitsikoulis
 */
public class Node {
    /** Η τιμή που αποθηκεύεται στον κόμβο */
    public int value;
    /** Αναφορά στο αριστερό παιδί */
    public Node left;
    /** Αναφορά στο δεξί παιδί */
    public Node right;

    /**
     * Δημιουργεί έναν νέο κόμβο με την δοθείσα τιμή
     * 
     * @param value η τιμή που θα αποθηκευτεί στον κόμβο
     */
    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}