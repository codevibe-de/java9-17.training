package f_reactive_streams.x4_booksearch;

import javax.swing.*;
import java.awt.*;

public class BookFrame extends JFrame {

    private final BookDatabase bookDatabase;

    private final DefaultListModel<Book> bookListModel = new DefaultListModel<>();

    private final JLabel labelTitle = new JLabel("Title");
    private final JTextField textFieldTitle = new JTextField(10);
    private final JButton buttonFind = new JButton("Find");
    private final JList<Book> listBook = new JList<>(this.bookListModel);

    public BookFrame(BookDatabase bookDatabase) {
        super("Books");
        this.bookDatabase = bookDatabase;
        this.setLayout(new FlowLayout());
        this.add(this.labelTitle);
        this.add(this.textFieldTitle);
        this.add(this.buttonFind);
        this.add(this.listBook);
        this.listBook.setBorder(textFieldTitle.getBorder());
        this.listBook.setPreferredSize(new Dimension(300, 100));
        this.pack();
        this.setLocation(100, 100);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.textFieldTitle.requestFocus();
        this.buttonFind.addActionListener(e -> onFind());
    }

    private void onFind() {
        this.bookListModel.clear();
        final BookSubscriber subscriber = new BookSubscriber(this.bookListModel);
        final String title = this.textFieldTitle.getText();
        System.out.println("before find...");
        this.bookDatabase.find(subscriber, title);
        System.out.println("after find...");
    }
}
