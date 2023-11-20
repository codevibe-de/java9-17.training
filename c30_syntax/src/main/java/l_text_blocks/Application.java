package l_text_blocks;

import static utils.MethodLogger.logMethodCall;

public class Application {

    public static void main(String[] args) {
        demo1();
        demo2();
        demo3();
        demo4();
        demo5();
        demo6();
    }

    static void demo1() {
        logMethodCall();
        String sql = "" +
                "select\n" +
                "    isbn, title, author\n" +
                "from\n" +
                "    book\n" +
                "where\n" +
                "    title = 'Pascal'";
        System.out.println(sql);
    }

    //@SuppressWarnings("preview")
    static void demo2() {
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

    static void demo3() {
        logMethodCall();
        String json = "" +
                "{\n" +
                "    isbn : \"1111\",\n" +
                "    title : \"Pascal\",\n" +
                "    author : \"Wirth\",\n" +
                "    year : 1970\n" +
                "}";
        System.out.println(json);
    }

    // @SuppressWarnings("preview")
    static void demo4() {
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

    //@SuppressWarnings("preview")
    static void demo5() {
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

    //@SuppressWarnings("preview")
    static void demo6() {
        logMethodCall();
        String json = String.format("""
                        {
                            isbn : "%s",
                            title : "%s",
                            author : "%s",
                            year : %d
                        }
                        """,
                "1111", "Pascal", "Wirth", 1970);
        System.out.println(json);
    }
}

