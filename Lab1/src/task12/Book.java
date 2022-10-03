package task12;

public class Book implements Comparable<Book>, Cloneable {
    private String title;
    private String author;
    private int price;
    private static int edition;
    private ISBN isbn;

    @Override
    public int hashCode() {
        return (31 * title.hashCode() + 31 * author.hashCode() + 31 * price);
    }

    @Override
    public boolean equals(Object obj) {
        Book book = (Book) obj;
        return price == book.price && title.equals(book.title) &&
                author.equals(book.author);
    }

    @Override
    public String toString() {
        return "book: { title:" + this.title +
                ", author: " + this.author +
                ", price: " + this.price +
                " }";
    }

    @Override
    protected Book clone() throws CloneNotSupportedException{
        Book clonedBook = (Book) super.clone();
        return clonedBook;
    }

    @Override
    public int compareTo(Book book) {
        return isbn.compareTo(book.isbn);
    }
}
