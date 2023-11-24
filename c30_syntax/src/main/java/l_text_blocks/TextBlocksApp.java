package l_text_blocks;

import org.junit.jupiter.api.Test;

import static utils.MethodLogger.logMethodCall;

@SuppressWarnings("TextBlockMigration")
public class TextBlocksApp {

    @Test
    void oldStyle() {
        logMethodCall();
        String sql = "select\n"
                + "    isbn, title, author\n"
                + "from\n"
                + "    book\n"
                + "where\n"
                + "    title = 'Pascal'";
        System.out.println(sql);
    }


    @Test
    void newStyle() {
        logMethodCall();
        String sql = """
                select
                    isbn, title, author
                from
                    book
                where
                    title = 'Pascal'
                """;
        System.out.println(sql);
    }


    @Test
    void oldStyleJson() {
        logMethodCall();
        String json = "{\n"
                + "    isbn : \"1111\",\n"
                + "    title : \"Pascal\",\n"
                + "    author : \"Wirth\",\n"
                + "    year : 1970\n"
                + "}";
        System.out.println(json);
    }


    @Test
    void newStyleJson() {
        logMethodCall();
        String json = """
                {
                    isbn : "1111",
                    title : "Pascal",
                    author : "Wirth",
                    year : 1970
                }
                """;
        System.out.println(json);
    }


    @Test
    void newStyleJsonWithIndent() {
        logMethodCall();
        String json = """
                    {
                        isbn : "1111",
                        title : "Pascal",
                        author : "Wirth",
                        year : 1970
                    }
                """;
        System.out.println(json);
    }


    @Test
    void usingPrintfPlaceholders() {
        logMethodCall();
        String json = String.format("""
                {
                    isbn : "%s",
                    title : "%s",
                    author : "%s",
                    year : %d
                }
                """, "1111", "Pascal", "Wirth", 1970);
        System.out.println(json);
    }
}

