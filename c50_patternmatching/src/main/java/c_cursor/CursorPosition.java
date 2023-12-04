package c_cursor;

public sealed interface CursorPosition permits StartOfLine, EndOfLine, AtColumn {
    String getIdentifier();
}

final class StartOfLine implements CursorPosition {
    @Override
    public String getIdentifier() {
        return "^";
    }
}

final class EndOfLine implements CursorPosition {
    @Override
    public String getIdentifier() {
        return "$";
    }
}

record AtColumn(int col) implements CursorPosition {
    @Override
    public String getIdentifier() {
        return Integer.toString(col);
    }
}



