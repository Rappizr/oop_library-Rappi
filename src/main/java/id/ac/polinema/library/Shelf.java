package id.ac.polinema.library;

public class Shelf {
    private Book[] books;
    private int count;

    public Shelf(){
        this.books = new Book[5];
        this.count = 0;
    }

    public boolean addBook(Book book){
        if (book == null || count >= books.length){
            return false;
        }
        books[count++] = book;
        return true;
    }

    public Book findByIsbn(String isbn){
        if (isbn == null) return null;
            for (int i = 0; i < count; i++){
                if (books[i].getIsbn().equals(isbn)){
                    return books[i];
                }
            }
        return null;
    }

    public int countAvailable(){
        int availableCount = 0;
        for (int i = 0; i < count; i++){
            if (books[i].isAvailable()){
                availableCount++;
            }
        }
        return availableCount;
    }
}
