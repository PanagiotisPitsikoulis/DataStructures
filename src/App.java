import parts.Part1;
import parts.Part2;
import tests.TestRunner;
import java.io.PrintStream;
import java.util.Scanner;

public class App {
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String RED = "\u001B[31m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            running = handleUserChoice(scanner);
        }

        scanner.close();
        System.out.println(YELLOW + "👋 Αντίο!" + RESET);
    }

    private static void printMenu() {
        System.out.println("\n" + BLUE + "🌟 Μενού Εργασίας Δομών Δεδομένων 🌟" + RESET);
        System.out.println("1. " + GREEN + "🌳 Εκτέλεση Επίδειξης Δυαδικού Δέντρου Αναζήτησης (Μέρος 1)" + RESET);
        System.out.println("2. " + GREEN + "👨‍👩‍👧‍👦 Εκτέλεση Επίδειξης Γενεαλογικού Δέντρου (Μέρος 2)" + RESET);
        System.out.println("3. " + YELLOW + "🧪 Εκτέλεση Δοκιμών" + RESET);
        System.out.println("4. " + RED + "❌ Έξοδος" + RESET);
        System.out.print(BLUE + "Εισάγετε την επιλογή σας (1-4): " + RESET);
    }

    private static boolean handleUserChoice(Scanner scanner) {
        try {
            String input = scanner.nextLine();
            int choice;

            try {
                choice = Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.println(RED + "😵 Παρακαλώ εισάγετε έναν αριθμό!" + RESET);
                return true;
            }

            System.out.println();

            switch (choice) {
                case 1:
                    Part1.main(null);
                    break;
                case 2:
                    // Pass flag to indicate using existing Scanner
                    Part2.main(new String[] { "useExisting" });
                    break;
                case 3:
                    // Create a new thread for running tests
                    Thread testThread = new Thread(() -> {
                        PrintStream originalOut = System.out;
                        try {
                            TestRunner.main(null);
                        } finally {
                            System.setOut(originalOut);
                        }
                    });
                    testThread.start();
                    try {
                        testThread.join(); // Wait for tests to complete
                    } catch (InterruptedException e) {
                        System.out.println(RED + "❌ Η εκτέλεση των δοκιμών διακόπηκε" + RESET);
                    }
                    break;
                case 4:
                    return false;
                default:
                    System.out.println(RED + "😵 Μη έγκυρη επιλογή!" + RESET);
            }
        } catch (Exception e) {
            if (e.getMessage() != null && !e.getMessage().equals("No line found")) {
                System.out.println(RED + "😵 Σφάλμα: " + e.getMessage() + RESET);
            }
            return true;
        }
        return true;
    }
}