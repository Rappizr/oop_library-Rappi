package id.ac.polinema.library;

/**
 * Bagian 3: anggota perpustakaan.
 *
 * Jangan ubah nama kelas, nama method, atau signature-nya. Autograder
 * memanggilnya persis seperti yang tertulis di sini.
 *
 * Field tidak dideklarasikan di sini: baca diagram kelas di README
 * (semua field harus private).
 *
 * Kerangka field (lengkapi dari diagram), letakkan di atas constructor:
 *   private ____ memberId;
 *   private ____ name;
 *   private int loanCount;   // nilai awal 0
 */
public class Member {

    private String memberId;
    private String name;
    private int loanCount;
    private LibraryCard card;
    /**
     * Membuat anggota yang belum punya pinjaman.
     * memberId dan name tidak boleh null atau kosong: lempar
     * IllegalArgumentException jika tidak valid.
     */
    public Member(String memberId, String name) {
        if (memberId == null || memberId.isEmpty()){
            throw new IllegalArgumentException("Member ID cannot be empty");
        }
        this.memberId = memberId;
        setName(name);
        this.loanCount = 0;
        this.card = new LibraryCard("Card-" + memberId);
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
       return name;
    }

    /** Nama tidak boleh null atau kosong: lempar IllegalArgumentException dan biarkan nama lama. */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Member name cannot be empty");
        }
        this.name = name;
    }

    public int getLoanCount() {
        return loanCount;
    }

    /** True jika anggota masih boleh meminjam (batasnya 3 pinjaman). */
    public boolean canBorrow() {
        return loanCount < 3;
    }

    /** Menambah jumlah pinjaman. Jika sudah di batas, tidak berubah dan hasilnya false. */
    public boolean addLoan() {
        if(canBorrow()){
            loanCount++;
            return true;
        }
        return false;
    }

    /** Mengurangi jumlah pinjaman. Jika sudah tidak ada pinjaman, tidak berubah dan hasilnya false. */
    public boolean returnLoan() {
        if(loanCount > 0){
            loanCount--;
            return true;
        }
        return false;
    }
}
