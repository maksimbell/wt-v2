package task12;

public class ISBN implements Comparable<ISBN>, Cloneable {
    private final int bookNumber;

    public ISBN(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    @Override
    public int compareTo(ISBN isbn) {
        return bookNumber - isbn.bookNumber;
    }

    @Override
    public ISBN clone() throws CloneNotSupportedException {
        return (ISBN) super.clone();
    }
}
