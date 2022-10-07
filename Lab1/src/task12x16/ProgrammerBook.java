package task12x16;

public class ProgrammerBook extends Book {
    private String language;
    private int level;

    public ProgrammerBook(String title, String author, int price, ISBN isbn, String language, int level) {
        super(title, author, price, isbn);
        this.language = language;
        this.level = level;
    }

    @Override
    public int hashCode() {
        return (31 * language.hashCode() + 31 * level + super.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        ProgrammerBook programmerBook = (ProgrammerBook) obj;
        return level == programmerBook.level && language.equals(programmerBook.language) && super.equals(obj);
    }

    @Override
    public String toString() {
        return "programmerBook: { language:" + this.language + ", level: " + this.level + " }";
    }
}
