package poc.threads;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int counter = 0; counter < 10; counter++) {
            System.out.println(counter + " " + Thread.currentThread().getName());
        }
    }
}
