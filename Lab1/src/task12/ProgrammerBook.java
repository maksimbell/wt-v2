package task12;

public class ProgrammerBook extends Book {
    private String language;
    private int level;

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
        return "programmerBook: { language:" + this.language +
                ", level: " + this.level +
                " }";
    }
}
