package tests;

import lib.Person;
import org.junit.Test;
import static org.junit.Assert.*;

public class PersonTest {
    @Test
    public void testPersonCreation() {
        System.out.println("\n📋 Εκτέλεση δοκιμής: Δημιουργία ατόμου (άνδρας)");
        Person person = new Person("John", "man");
        System.out.println("➡️ Δημιουργήθηκε άτομο με όνομα: " + person.getName());
        System.out.println("➡️ Φύλο ατόμου: " + person.getGender());
        assertEquals("John", person.getName());
        assertEquals("man", person.getGender());
        System.out.println("✅ Η δοκιμή ολοκληρώθηκε επιτυχώς!");
    }

    @Test
    public void testPersonWithFemaleGender() {
        System.out.println("\n📋 Εκτέλεση δοκιμής: Δημιουργία ατόμου (γυναίκα)");
        Person person = new Person("Maria", "woman");
        System.out.println("➡️ Δημιουργήθηκε άτομο με όνομα: " + person.getName());
        System.out.println("➡️ Φύλο ατόμου: " + person.getGender());
        assertEquals("Maria", person.getName());
        assertEquals("woman", person.getGender());
        System.out.println("✅ Η δοκιμή ολοκληρώθηκε επιτυχώς!");
    }
}
