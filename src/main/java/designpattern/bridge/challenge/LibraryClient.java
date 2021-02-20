package designpattern.bridge.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class LibraryClient {
    private static final List<Book> books = new ArrayList<>();
    private static final Logger logger;

    static {
        logger = Logger.getLogger(LibraryClient.class.getName());
        System.setProperty("java.util.logging.SimpleFormatter.format",
                //"[%1$tF %1$tT] [%4$-7s] %5$s %n");
                "[%1$tF %1$tl:%1$tM:%1$tS.%1$tL] [%4$-7s] %5$s %n");
    }

    public static void main(String... args) {
        Book fiction1 = new Fiction("Fic1");
        Book fiction2 = new Fiction("Fic2");
        Book nonFiction1 = new NonFiction("NFic1");
        books.add(fiction1);
        books.add(fiction2);
        books.add(nonFiction1);

        Thread user1 = new Thread(() -> {
            checkout("Fic1");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                logger.log(Level.WARNING, "Error in Thread -" + Thread.currentThread().getName(), e);
            }
            returnBook("Fic2");
        });
        Thread user2 = new Thread(() -> {
            checkout("Fic1");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                logger.log(Level.WARNING, "Error in Thread -" + Thread.currentThread().getName(), e);
            }
            returnBook("Fic1");
        });
        Thread user3 = new Thread(() -> {
            checkout("Fic2");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                logger.log(Level.WARNING, "Error in Thread -" + Thread.currentThread().getName());
            }
            returnBook("Fic2");
            checkout("NFic1");
        });
        user1.setName("USER1");
        user2.setName("USER2");
        user3.setName("USER3");
        user1.start();
        user2.start();
        user3.start();

        logger.log(Level.INFO, printAvailability("Fic1"));
        logger.log(Level.INFO, printAvailability("Fic2"));
        logger.log(Level.INFO, printAvailability("NFic1"));
    }

    public synchronized static void checkout(String bookName) {
        List<Book> selected = books.parallelStream()
                .filter(item -> item.getName().equals(bookName))
                .collect(Collectors.toList());
        selected.get(0).checkout();
    }

    public synchronized static void returnBook(String bookName) {
        List<Book> selected = books.parallelStream()
                .filter(item -> item.getName().equals(bookName))
                .collect(Collectors.toList());
        selected.get(0).returnBook();
    }

    public synchronized static boolean isAvailable(String bookName) {
        List<Book> selected = books.parallelStream()
                .filter(item -> item.getName().equals(bookName))
                .collect(Collectors.toList());
        return selected.get(0).getAvailability() == Book.Status.AVAILABLE;
    }

    public synchronized static String printAvailability(String bookName) {
        List<Book> selected = books.parallelStream()
                .filter(item -> item.getName().equals(bookName))
                .collect(Collectors.toList());
        return Thread.currentThread().getName()
                + "<> " + bookName + " is "
                + selected.get(0).getAvailability().name();
    }
}
