package c_cursor;

import org.junit.jupiter.api.Test;

public class EditorPositionTest {

    @Test
    void demoUsage() {
        System.out.println(
                performInsert("Hello", '!', EndOfLine.INSTANCE)
        );
        System.out.println(
                performInsert("Helo", 'l', new AtColumn(2))
        );
    }

    private static String performInsert(String text, char charToInsert, EditorPosition pos) {
        return switch (pos) {
            case AtColumn atPos -> {
                atPos.checkForString(text);
                yield text.substring(0, atPos.col()) + charToInsert + text.substring(atPos.col() + 1);
            }
            case EndOfLine ignored -> text + charToInsert;
        };
    }

}
