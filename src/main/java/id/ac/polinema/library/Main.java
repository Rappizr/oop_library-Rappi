package id.ac.polinema.library;

/**
 * Titik awal program (satu-satunya method main di proyek ini).
 *
 * Bagian 1: baris PERTAMA output harus persis "Welcome to Polinema Library".
 * Setelah itu kamu bebas menambah baris lain untuk bereksperimen.
 *
 * Bagian 7: di bawah baris sapaan, kamu akan membuat Library, mengisi data
 * contoh, lalu menjalankan LibraryApp. Kerangkanya ada di README.
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Polinema Library");

        Library library = new Library("Polinema Library");

        Author author = new Author("Robert Martin", "USA");
        Book book = new Book("978-0132350884", "Clean Code", 2008, author);
        Dvd dvd = new Dvd("Inception", 2010, 148);
        Magazine magazine = new Magazine("Tempo", 2024, 7);
        Member member = new Member("M001", "Budi");

        library.addItem(book);
        library.addItem(dvd);
        library.addItem(magazine);
        library.addMember(member);

        LibraryApp app = new LibraryApp(library, new Scanner(System.in), System.out);
        app.run();
    }
}

