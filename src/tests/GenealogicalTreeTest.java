package tests;

import lib.GenealogicalTree;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GenealogicalTreeTest {
    private GenealogicalTree tree;
    private String testCsvPath;

    @Before
    public void setUp() throws IOException {
        System.out.println("\n📋 Προετοιμασία δοκιμών γενεαλογικού δέντρου");
        tree = new GenealogicalTree();
        testCsvPath = "public/test_family.csv";

        System.out.println("➡️ Δημιουργία δοκιμαστικού αρχείου CSV");
        FileWriter writer = new FileWriter(testCsvPath);
        writer.write("name,gender,relation,relatedTo\n");
        writer.write("John,man,father,Mary\n");
        writer.write("Anna,woman,mother,Mary\n");
        writer.write("Mary,woman,daughter,John\n");
        writer.write("Bob,man,spouse,Mary\n");
        writer.write("Tom,man,father,Bob\n");
        writer.write("Lisa,woman,sister,Mary\n");
        writer.close();
        System.out.println("✅ Προετοιμασία ολοκληρώθηκε");
    }

    @Test
    public void testLoadFromCSV() throws IOException {
        System.out.println("\n📋 Εκτέλεση δοκιμής: Φόρτωση από CSV");
        tree.loadFromCSV(testCsvPath);

        System.out.println("➡️ Έλεγχος σχέσεων:");
        checkAndPrintRelationship("John", "Mary", "father");
        checkAndPrintRelationship("Anna", "Mary", "mother");
        checkAndPrintRelationship("Mary", "John", "daughter");
        checkAndPrintRelationship("Mary", "Bob", "wife");
        checkAndPrintRelationship("Lisa", "Mary", "sister");

        System.out.println("✅ Η δοκιμή ολοκληρώθηκε επιτυχώς!");
    }

    private void checkAndPrintRelationship(String person1, String person2, String expectedRelation) {
        String actualRelation = tree.findRelationship(person1, person2);
        System.out.println("   🔍 " + person1 + " είναι " + actualRelation + " του/της " + person2);
        assertEquals(expectedRelation, actualRelation);
    }

    @Test
    public void testRelationships() throws IOException {
        tree.loadFromCSV(testCsvPath);
        assertEquals("father", tree.findRelationship("John", "Mary"));
        assertEquals("daughter", tree.findRelationship("Mary", "Anna"));
        assertEquals("husband", tree.findRelationship("Bob", "Mary"));
        assertEquals("sister", tree.findRelationship("Lisa", "Mary"));
    }

    @Test
    public void testExtendedRelationships() throws IOException {
        tree.loadFromCSV(testCsvPath);
        assertEquals("father-in-law", tree.findRelationship("Tom", "Mary"));
        assertEquals("brother-in-law", tree.findRelationship("Bob", "Lisa"));
    }

    public void tearDown() {
        File testFile = new File(testCsvPath);
        if (testFile.exists()) {
            testFile.delete();
        }
    }
}
