package parts;

import lib.GenealogicalTree;
import java.io.IOException;
import java.util.Scanner;

/**
 * Θέμα 2: Υλοποίηση Γενεαλογικού Δέντρου
 * 
 * 2.1 Αναπαράσταση δέντρου σε CSV
 * 2.2 Φόρτωση και εμφάνιση μελών
 * 2.3 Εύρεση σχέσεων μεταξύ ατόμων
 * 2.4 Επίδειξη λειτουργίας
 * 
 * @author Panagiotis Pitsikoulis
 */
public class Part2 {
    /**
     * Κύρια μέθοδος που φορτώνει το γενεαλογικό δέντρο και βρίσκει σχέσεις
     */
    public static void main(String[] args) {
        GenealogicalTree family = new GenealogicalTree();

        try {
            // Χρήση του absolute path για το αρχείο
            String projectRoot = System.getProperty("user.dir");
            String csvPath = projectRoot + "/public/input.csv";

            family.loadFromCSV(csvPath);
            System.out.println("\n👥 Μέλη Οικογενειακού Δέντρου:");
            System.out.println("----------------------------");
            family.displayAll();

            // Use the provided Scanner or create a new one if none provided
            Scanner scanner = args.length > 0 && args[0].equals("useExisting") ? new Scanner(System.in)
                    : new Scanner(System.in);

            System.out.print("\nEnter first person's name: ");
            String person1 = scanner.nextLine();
            System.out.print("Enter second person's name: ");
            String person2 = scanner.nextLine();

            String relationship = family.findRelationship(person1, person2);
            System.out.println("\n" + person1 + " is " + relationship + " of " + person2 + "\n");

            // Only close the scanner if we created it here
            if (args.length == 0) {
                scanner.close();
            }
        } catch (IOException e) {
            System.err.println("⚠️ Σφάλμα ανάγνωσης αρχείου: " + e.getMessage());
            System.err.println("💡 Συμβουλή: Βεβαιωθείτε ότι το αρχείο υπάρχει στο: public/input.csv");
            System.err.println("📍 Τρέχων φάκελος: " + System.getProperty("user.dir"));
        }
    }
}
