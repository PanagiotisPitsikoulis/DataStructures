package tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Κλάση εκτέλεσης δοκιμών για όλα τα unit tests του project.
 * 
 * @author Panagiotis Pitsikoulis
 */
public class TestRunner {
    public static void main(String[] args) {
        System.out.println("\n🧪 Εκτέλεση όλων των δοκιμών...\n");

        Result result = JUnitCore.runClasses(
                NodeTest.class,
                BinarySearchTreeTest.class,
                PersonTest.class,
                GenealogicalTreeTest.class);

        int totalTests = result.getRunCount();
        int failedTests = result.getFailureCount();
        int successfulTests = totalTests - failedTests;

        System.out.println("\n📊 Αποτελέσματα Δοκιμών:");
        System.out.println("-------------------");
        System.out.println("✅ Επιτυχημένες: " + successfulTests);
        System.out.println("❌ Αποτυχημένες: " + failedTests);
        System.out.println("📝 Σύνολο: " + totalTests);

        if (!result.getFailures().isEmpty()) {
            System.out.println("\n⚠️ Λεπτομέρειες Αποτυχιών:");
            for (Failure failure : result.getFailures()) {
                System.out.println("-------------------");
                System.out.println("🔍 Δοκιμή: " + failure.getTestHeader());
                System.out.println("❌ Σφάλμα: " + failure.getMessage());
                System.out.println("📍 Τοποθεσία: " + failure.getTrace());
            }
        }

        System.out.println("\n" + (result.wasSuccessful() ? "✨ Όλες οι δοκιμές πέρασαν επιτυχώς! 🎉"
                : "⚠️ Κάποιες δοκιμές απέτυχαν! 😢"));
    }
}