package c_cursor;

public sealed interface EditorPosition permits AtColumn, EndOfLine {
}

final class EndOfLine implements EditorPosition {
    public static final EndOfLine INSTANCE = new EndOfLine();
}

record AtColumn(int col) implements EditorPosition {
    void checkForString(String s) {
        if (col < 0 || col > s.length()) {
            throw new IllegalArgumentException();
        }
    }
}



