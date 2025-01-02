# Σχεδιασμός Βιβλιοθήκης (Library)

## Βήματα Υλοποίησης

1. Node.java - Υλοποίηση κόμβου δυαδικού δέντρου
2. BinarySearchTree.java - Υλοποίηση δυαδικού δέντρου αναζήτησης
3. Person.java - Υλοποίηση κλάσης ατόμου
4. GenealogicalTree.java - Υλοποίηση γενεαλογικού δέντρου

````markdown
# Τεκμηρίωση Βιβλιοθήκης

## 1. Κλάση Node

### Περιγραφή

- Βασική κλάση κόμβου δυαδικού δέντρου

### Ιδιότητες

- τιμή (int)
- αριστερός κόμβος (Node)
- δεξιός κόμβος (Node)

## 2. Κλάση BinarySearchTree

### Λειτουργίες

- Εισαγωγή στοιχείου
- Διάσχιση preorder
- Διάσχιση inorder
- Διάσχιση postorder

## 3. Κλάση Person

### Ιδιότητες

- όνομα (String)
- φύλο (String)
- συγγενικές σχέσεις (Map)

## 4. Κλάση GenealogicalTree

### Βασικές Λειτουργίες

- Ανάγνωση CSV
- Αποθήκευση σχέσεων
- Αναζήτηση σχέσεων

### Τύποι Σχέσεων

1. Γονέας/Παιδί
2. Αδέρφια
3. Ξαδέρφια
4. Σύζυγοι
5. Παππούς-Γιαγιά/Εγγόνι
6. Θείος-Θεία
7. Ανίψι

## Παραδείγματα Χρήσης

### Δυαδικό Δέντρο

```java
BinarySearchTree bst = new BinarySearchTree();
bst.insert(6);
bst.insert(4);
bst.inorder(); // Εκτύπωση: 4 6
```
````

### Γενεαλογικό Δέντρο

```java
GenealogicalTree family = new GenealogicalTree();
family.loadFromCSV("input.csv");
String relation = family.findRelation("Robert", "Joffrey");
```

## Εκτέλεση Δοκιμών

```bash
# Μεταγλώττιση και εκτέλεση tests
javac -cp .:junit-4.13.2.jar tests/*.java
java -cp .:junit-4.13.2.jar org.junit.runner.JUnitCore tests.LibTests
```
