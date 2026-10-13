package id.ac.polinema.library;

public class Librarian {
    public boolean lend(Member member, Book book){
        if (member == null || book == null) return false;
        if (member.canBorrow() && book.isAvailable()){
            if (book.checkOut()){
                member.addLoan();
                return true;
            }
        }
        return false;
    }

    public boolean receive(Member member, Book book) {
        if (member == null || book == null) return false;
        if (!book.isAvailable() && member.getLoanCount() > 0) {
            book.returnItem();
            member.returnLoan();
            return true;
        }
        return false;
    }
}
