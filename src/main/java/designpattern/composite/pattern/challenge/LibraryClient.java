package designpattern.composite.pattern.challenge;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LibraryClient {
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
        Book bookCollection = new BookCollection(List.of(fiction1, fiction2, nonFiction1));

        Thread user1 = new Thread(() -> {
            checkout(fiction1);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                logger.log(Level.WARNING, "Error in Thread -" + Thread.currentThread().getName(), e);
            }
            returnBook(fiction1);
        });
        Thread user2 = new Thread(() -> {
            checkout(fiction1);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                logger.log(Level.WARNING, "Error in Thread -" + Thread.currentThread().getName(), e);
            }
            returnBook(fiction1);
        });
        Thread user3 = new Thread(() -> {
            checkout(fiction2);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                logger.log(Level.WARNING, "Error in Thread -" + Thread.currentThread().getName());
            }
            returnBook(fiction2);
            checkout(nonFiction1);
        });
        Thread user4 = new Thread(() -> {
            checkout(bookCollection);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                logger.log(Level.WARNING, "Error in Thread -" + Thread.currentThread().getName());
            }
            returnBook(bookCollection);
        });
        user1.setName("USER1");
        user2.setName("USER2");
        user3.setName("USER3");
        user4.setName("USER4");
        user1.start();
        user2.start();
        user3.start();
        user4.start();

        logger.log(Level.INFO, printAvailability(fiction1));
        logger.log(Level.INFO, printAvailability(fiction2));
        logger.log(Level.INFO, printAvailability(nonFiction1));
    }

    public synchronized static void checkout(Book book) {
        book.checkout();
    }

    public synchronized static void returnBook(Book book) {
        book.returnBook();
    }

    public synchronized static boolean isAvailable(Book book) {
        return book.getAvailability() == Book.Status.AVAILABLE;
    }

    public synchronized static String printAvailability(Book book) {
        return Thread.currentThread().getName()
                + "<> " + book.getName() + " is "
                + book.getAvailability().name();
    }
}
