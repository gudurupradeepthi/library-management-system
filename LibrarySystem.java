import java.util.Scanner;

class LibrarySystem {

    String[] books = new String[10];
    boolean[] issued = new boolean[10];
    int count = 0;

    // Add Book
    void addBook(String name) {
        if (count < 10) {
            books[count] = name;
            issued[count] = false;
            count++;
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Library is full.");
        }
    }

    // Show Books
    void showBooks() {
        if (count == 0) {
            System.out.println("No books in library.");
            return;
        }

        for (int i = 0; i < count; i++) {
            if (issued[i])
                System.out.println(books[i] + " - Issued");
            else
                System.out.println(books[i] + " - Available");
        }
    }

    // Issue Book
    void issueBook(String name) {
        for (int i = 0; i < count; i++) {
            if (books[i].equalsIgnoreCase(name) && !issued[i]) {
                issued[i] = true;
                System.out.println("Book issued successfully.");
                return;
            }
        }
        System.out.println("Book not available.");
    }

    // Return Book
    void returnBook(String name) {
        for (int i = 0; i < count; i++) {
            if (books[i].equalsIgnoreCase(name) && issued[i]) {
                issued[i] = false;
                System.out.println("Book returned successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LibrarySystem lib = new LibrarySystem();
        int choice;

        do {
            System.out.println("\n----- Library Menu -----");
            System.out.println("1. Add Book");
            System.out.println("2. Show Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter book name: ");
                    String book = sc.nextLine();
                    lib.addBook(book);
                    break;

                case 2:
                    lib.showBooks();
                    break;

                case 3:
                    System.out.print("Enter book name: ");
                    String issue = sc.nextLine();
                    lib.issueBook(issue);
                    break;

                case 4:
                    System.out.print("Enter book name: ");
                    String ret = sc.nextLine();
                    lib.returnBook(ret);
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}
