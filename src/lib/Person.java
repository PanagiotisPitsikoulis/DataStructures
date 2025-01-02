package lib;

/**
 * Κλάση που αναπαριστά ένα άτομο στο γενεαλογικό δέντρο
 * 
 * @author Panagiotis Pitsikoulis
 */
public class Person {
    /** Το όνομα του ατόμου */
    private String name;
    /** Το φύλο του ατόμου (man/woman) */
    private String gender;

    /**
     * Δημιουργεί ένα νέο άτομο
     * 
     * @param name   το όνομα του ατόμου
     * @param gender το φύλο του ατόμου
     */
    public Person(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    /**
     * Επιστρέφει το όνομα του ατόμου
     * 
     * @return το όνομα
     */
    public String getName() {
        return name;
    }

    /**
     * Επιστρέφει το φύλο του ατόμου
     * 
     * @return το φύλο
     */
    public String getGender() {
        return gender;
    }
}