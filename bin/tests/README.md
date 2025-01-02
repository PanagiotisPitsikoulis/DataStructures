# Δοκιμαστικές Μονάδες (Unit Tests)

## Εγκατάσταση JUnit

1. Προσθήκη βιβλιοθηκών στον φάκελο `lib/`:
   - junit-4.13.2.jar
   - hamcrest-core-1.3.jar

## Δομή Δοκιμών

```

tests/
├── NodeTest.java # Δοκιμές κόμβου BST
├── BinarySearchTreeTest.java # Δοκιμές δυαδικού δέντρου
├── PersonTest.java # Δοκιμές κλάσης ατόμου
├── GenealogicalTreeTest.java # Δοκιμές γενεαλογικού δέντρου
└── TestRunner.java # Εκτέλεση όλων των δοκιμών

```

## Εκτέλεση Δοκιμών

### Μέσω Terminal

```bash
# Μεταγλώττιση
javac -d bin -cp "lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:src" src/tests/*.java src/lib/*.java

# Εκτέλεση
java -cp "bin:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar" tests.TestRunner
```

### Μέσω VSCode

1. Εγκατάσταση "Java Test Runner"
2. Επιλογή εικονιδίου Test
3. "Run All Tests"

## Δοκιμαστικές Περιπτώσεις

### 1. NodeTest

- Δημιουργία κόμβου
- Σύνδεση κόμβων

### 2. BinarySearchTreeTest

- Εισαγωγή στοιχείων
- Διασχίσεις (preorder, inorder, postorder)

### 3. PersonTest

- Δημιουργία ατόμου
- Προσθήκη σχέσεων

### 4. GenealogicalTreeTest

- Φόρτωση CSV
- Εύρεση σχέσεων
- Εμφάνιση δεδομένων
