package task12x16;

public class ISBN implements Comparable<ISBN>, Cloneable {
    private final int bookNumber;

    public ISBN(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    @Override
    public ISBN clone() throws CloneNotSupportedException {
        return (ISBN) super.clone();
    }

    @Override
    public int compareTo(ISBN isbn) {
        return bookNumber - isbn.bookNumber;
    }

}
