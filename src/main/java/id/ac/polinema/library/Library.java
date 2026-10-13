package id.ac.polinema.library;

import java.util.Arrays;

public class Library {
    private String name;
    private LibraryItem[] items;
    private int itemCount;
    private Member[] members;
    private int memberCount;

    public Library(String name) {
        this.name = name;
        this.items = new LibraryItem[20];
        this.itemCount = 0;
        this.members = new Member[10];
        this.memberCount = 0;
    }

    public String getName() {
        return name;
    }

    public boolean addItem(LibraryItem item) {
        if (item == null || itemCount >= items.length) {
            return false;
        }
        items[itemCount++] = item;
        return true;
    }

    public boolean addMember(Member member) {
        if (member == null || memberCount >= members.length) {
            return false;
        }
        if (findMember(member.getMemberId()) != null) {
            return false;
        }
        members[memberCount++] = member;
        return true;
    }

    public LibraryItem[] getItems() {
        return Arrays.copyOf(items, itemCount);
    }

    public Member[] getMembers() {
        return Arrays.copyOf(members, memberCount);
    }

    public LibraryItem findItemByTitle(String title) {
        if (title == null) return null;
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getTitle().equalsIgnoreCase(title)) {
                return items[i];
            }
        }
        return null;
    }

    public Member findMember(String memberId) {
        if (memberId == null) return null;
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getMemberId().equals(memberId)) {
                return members[i];
            }
        }
        return null;
    }

    public LibraryItem[] searchByKeyword(String keyword) {
        if (keyword == null) return new LibraryItem[0];
        LibraryItem[] temp = new LibraryItem[itemCount];
        int matches = 0;
        String kwLower = keyword.toLowerCase();
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getTitle().toLowerCase().contains(kwLower)) {
                temp[matches++] = items[i];
            }
        }
        return Arrays.copyOf(temp, matches);
    }

    public boolean lend(String memberId, String title) {
        Member m = findMember(memberId);
        LibraryItem item = findItemByTitle(title);
        if (m != null && item != null && m.canBorrow() && item.isAvailable()) {
            if (item.checkOut()) {
                m.addLoan();
                return true;
            }
        }
        return false;
    }

    public boolean receive(String memberId, String title) {
        Member m = findMember(memberId);
        LibraryItem item = findItemByTitle(title);
        if (m != null && item != null && !item.isAvailable() && m.getLoanCount() > 0) {
            item.returnItem();
            m.returnLoan();
            return true;
        }
        return false;
    }
}
