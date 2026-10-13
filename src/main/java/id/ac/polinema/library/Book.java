package id.ac.polinema.library;

/**
 * Bagian 2 dan 3: buku perpustakaan.
 *
 * Jangan ubah nama kelas, nama method, atau signature-nya. Autograder
 * memanggilnya persis seperti yang tertulis di sini.
 *
 * Field tidak dideklarasikan di sini: baca diagram kelas di README.
 * Method untuk bagian berikutnya (setAuthor, getAuthor, dan seterusnya) kamu
 * tambahkan sendiri sesuai diagram di bagian tersebut.
 *
 * Kerangka field (lengkapi tipe dan nama dari diagram), letakkan di atas constructor:
 *   public String isbn;
 *   public ____ title;
 *   public ____ year;
 *   public ____ available;
 */
public class Book extends LibraryItem{
    private String isbn;
    private Author author;

    /**
     * Membuat buku baru yang masih tersedia (belum dipinjam).
     * Bagian 3: isbn tidak boleh kosong; title dan year divalidasi seperti setter-nya.
     */
    public Book(String isbn, String title, int year) {
        super(title, year);
        if (isbn == null || isbn.trim().isEmpty()){
            throw new IllegalArgumentException("ISBN cannot be empty");
        }
        this.isbn = isbn;
    }

    public Book(String isbn, String title, int year,Author author){
        this(isbn,title,year);
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public Author getAuthor(){
        return author;
    }

    public void setAuthor(Author author){
        this.author = author;
    }

        @Override
    public int loanDays() {
        return 14;
    }

    @Override
    public String describe() {
        String authorName = (author != null && author.getName() != null) ? author.getName() : "Unknown";
        return super.describe() + " by " + authorName;
    }
}
