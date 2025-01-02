package lib;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Αναπαράσταση γενεαλογικού δέντρου με χρήση HashMap.
 * Υποστηρίζει διάφορους τύπους σχέσεων όπως γονείς, παιδιά, αδέρφια, κλπ.
 * 
 * @author Panagiotis Pitsikoulis
 */
public class GenealogicalTree {
    private Map<String, Person> persons;
    private Map<String, List<String>> children;
    private Map<String, List<String>> parents;
    private Map<String, String> spouses;

    public GenealogicalTree() {
        persons = new HashMap<>();
        children = new HashMap<>();
        parents = new HashMap<>();
        spouses = new HashMap<>();
    }

    /**
     * Φορτώνει τα δεδομένα του γενεαλογικού δέντρου από αρχείο CSV.
     * Το αρχείο πρέπει να έχει τη μορφή: όνομα,φύλο,σχέση,σχετιζόμενοΆτομο
     * 
     * @param filename το όνομα του αρχείου CSV
     * @throws IOException αν υπάρξει πρόβλημα με το άνοιγμα/διάβασμα του αρχείου
     */
    public void loadFromCSV(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        reader.readLine(); // Skip header

        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            String name = data[0];
            String gender = data[1];
            String relation = data[2];
            String relatedTo = data[3];

            persons.putIfAbsent(name, new Person(name, gender));

            switch (relation) {
                case "father":
                case "mother":
                    children.computeIfAbsent(name, k -> new ArrayList<>()).add(relatedTo);
                    parents.computeIfAbsent(relatedTo, k -> new ArrayList<>()).add(name);
                    break;
                case "spouse":
                    spouses.put(name, relatedTo);
                    spouses.put(relatedTo, name);
                    break;
            }
        }
        reader.close();
    }

    /**
     * Εμφανίζει όλα τα άτομα του δέντρου και το φύλο τους
     */
    public void displayAll() {
        for (Person person : persons.values()) {
            System.out.println(person.getName() + " - " + person.getGender());
        }
    }

    /**
     * Βρίσκει τη σχέση μεταξύ δύο ατόμων στο γενεαλογικό δέντρο
     * 
     * @param person1 το πρώτο άτομο
     * @param person2 το δεύτερο άτομο
     * @return η σχέση του person1 προς το person2 (π.χ. "father", "sister", κλπ)
     */
    public String findRelationship(String person1, String person2) {
        if (isParent(person1, person2))
            return getParentType(person1);
        if (isChild(person1, person2))
            return getChildType(person1);
        if (isSibling(person1, person2))
            return getSiblingType(person1);
        if (isCousin(person1, person2))
            return "cousin";
        if (isSpouse(person1, person2))
            return getSpouseType(person1);
        if (isGrandparent(person1, person2))
            return getGrandparentType(person1);
        if (isGrandchild(person1, person2))
            return getGrandchildType(person1);
        if (isNephewNiece(person1, person2))
            return getNephewNieceType(person1);
        if (isUncleAunt(person1, person2))
            return getUncleAuntType(person1);
        return "not related";
    }

    // Ελεγκτές σχέσεων (Relationship checkers)

    /**
     * Ελέγχει αν το person1 είναι γονιός του person2
     */
    private boolean isParent(String person1, String person2) {
        return children.containsKey(person1) && children.get(person1).contains(person2);
    }

    /**
     * Ελέγχει αν το person1 είναι παιδί του person2
     */
    private boolean isChild(String person1, String person2) {
        return parents.containsKey(person1) && parents.get(person1).contains(person2);
    }

    /**
     * Ελέγχει αν τα δύο άτομα είναι αδέρφια
     * Αδέρφια θεωρούνται όταν έχουν τουλάχιστον έναν κοινό γονιό
     */
    private boolean isSibling(String person1, String person2) {
        if (!parents.containsKey(person1) || !parents.containsKey(person2))
            return false;
        return !Collections.disjoint(parents.get(person1), parents.get(person2));
    }

    /**
     * Ελέγχει αν τα δύο άτομα είναι σύζυγοι
     */
    private boolean isSpouse(String person1, String person2) {
        return spouses.containsKey(person1) && spouses.get(person1).equals(person2);
    }

    /**
     * Ελέγχει αν το person1 είναι παππούς/γιαγιά του person2
     */
    private boolean isGrandparent(String person1, String person2) {
        if (!children.containsKey(person1))
            return false;
        for (String child : children.get(person1)) {
            if (isParent(child, person2))
                return true;
        }
        return false;
    }

    private boolean isGrandchild(String person1, String person2) {
        return isGrandparent(person2, person1);
    }

    private boolean isUncleAunt(String person1, String person2) {
        if (!parents.containsKey(person2))
            return false;
        for (String parent : parents.get(person2)) {
            if (isSibling(person1, parent))
                return true;
        }
        return false;
    }

    private boolean isNephewNiece(String person1, String person2) {
        return isUncleAunt(person2, person1);
    }

    private boolean isCousin(String person1, String person2) {
        if (!parents.containsKey(person1) || !parents.containsKey(person2))
            return false;
        for (String parent1 : parents.get(person1)) {
            for (String parent2 : parents.get(person2)) {
                if (isSibling(parent1, parent2))
                    return true;
            }
        }
        return false;
    }

    // Getters τύπων σχέσεων (με βάση το φύλο)

    /**
     * Επιστρέφει τον τύπο γονιού (πατέρας/μητέρα) με βάση το φύλο
     */
    private String getParentType(String person) {
        return persons.get(person).getGender().equals("man") ? "father" : "mother";
    }

    /**
     * Επιστρέφει τον τύπο παιδιού (γιος/κόρη) με βάση το φύλο
     */
    private String getChildType(String person) {
        return persons.get(person).getGender().equals("man") ? "son" : "daughter";
    }

    /**
     * Επιστρέφει τον τύπο αδερφού (αδερφός/αδερφή) με βάση το φύλο
     */
    private String getSiblingType(String person) {
        return persons.get(person).getGender().equals("man") ? "brother" : "sister";
    }

    /**
     * Επιστρέφει τον τύπο συζύγου (άντρας/γυναίκα) με βάση το φύλο
     */
    private String getSpouseType(String person) {
        return persons.get(person).getGender().equals("man") ? "husband" : "wife";
    }

    /**
     * Επιστρέφει τον τύπο παππού/γιαγιάς με βάση το φύλο
     */
    private String getGrandparentType(String person) {
        return persons.get(person).getGender().equals("man") ? "grandfather" : "grandmother";
    }

    /**
     * Επιστρέφει τον τύπο εγγονού/εγγονής με βάση το φύλο
     */
    private String getGrandchildType(String person) {
        return persons.get(person).getGender().equals("man") ? "grandson" : "granddaughter";
    }

    /**
     * Επιστρέφει τον τύπο θείου/θείας με βάση το φύλο
     */
    private String getUncleAuntType(String person) {
        return persons.get(person).getGender().equals("man") ? "uncle" : "aunt";
    }

    /**
     * Επιστρέφει τον τύπο ανιψιού/ανιψιάς με βάση το φύλο
     */
    private String getNephewNieceType(String person) {
        return persons.get(person).getGender().equals("man") ? "nephew" : "niece";
    }
}