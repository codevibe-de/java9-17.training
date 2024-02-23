module x22_jpms.books_core {
    exports book.api;
    opens book.api;

    requires org.apache.commons.lang3;
}